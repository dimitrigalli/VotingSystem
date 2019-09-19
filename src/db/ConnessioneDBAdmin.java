package db;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.sql.Statement;

import data.Admin;

/**Classe utilizzata per controllare che le credenziali inserite dall'utente admin(nome_utente e password)
 * esistano effettivamente nel database.
 * 
 * @author Danilo Finizio
 *
 */

public class ConnessioneDBAdmin {

	private boolean found=false;

	public ConnessioneDBAdmin(Admin admin) throws SQLException {
		
		String nome_utente=admin.getUsername();
		String passwd_utente=admin.getPassword();
		
		Connection c = null;
		Statement statement = null;
		
		try {
			String url = "jdbc:sqlserver://thedailytesticle.servebeer.com:1433;databaseName=VOTO;user=Danitri;password=Danitri-12";
			c = DriverManager.getConnection(url);
			System.out.println("Connesso (amministratore)!");
			statement = c.createStatement();	
			String query1 = "SELECT * FROM PRESIDENTI where NOME_UTENTE='"+nome_utente+"'"+" AND PASSWORD ='"+passwd_utente+"'";
			ResultSet rs1 = statement.executeQuery(query1);
			while(rs1.next()) {
				if((rs1.getString(11).equals(nome_utente) && rs1.getString(12).equals(passwd_utente))) {
					
					admin.setNumeroSezioneElettorale(rs1.getInt(10));
					admin.setComuneSezioneElettorale(rs1.getString(7));
					admin.getPresidente().setNome(rs1.getString(1));
					admin.getPresidente().setCognome(rs1.getString(2));
					
					
					String res=admin.getComuneSezioneElettorale().substring(0,admin.getComuneSezioneElettorale().length()-4);

					found=true;

					String query2="SELECT * FROM ELETTORI_"+res+" where  RUOLO_AMMINISTRATORE='SEGRETARIO' and NUMERO_SEZIONE_LISTA_ELETTORALE ="+admin.getNumeroSezioneElettorale()+"" ;
					String query3="SELECT * FROM ELETTORI_"+res+" where  ruolo_amministratore='SCRUTATORE' and numero_sezione_lista_elettorale ='"+admin.getNumeroSezioneElettorale()+"'" ;
					ResultSet rs2=statement.executeQuery(query2);
					if(rs2.next()==true) {
						admin.getSegretario().setNome(rs2.getString(1));
						admin.getSegretario().setCognome(rs2.getString(2));
					}
					ResultSet rs3=statement.executeQuery(query3);
					if(rs3.next()==true) {
						admin.getScrutatore().setNome(rs3.getString(1));
						admin.getScrutatore().setCognome(rs3.getString(2));
					}

					break;
				}
			}


		} catch(Exception e) {
			System.out.println(e);
		}
		finally { 
			if (c != null)
			{  
				statement.close();
				c.close(); 
			}
		}

	}

	public boolean isFound() {
		return found;
	}
}
