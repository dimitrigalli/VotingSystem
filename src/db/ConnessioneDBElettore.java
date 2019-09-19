package db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import data.Elettore;

/**Classe utillizata per controllare che il numero della tessera elettorale dell'elettore sia esistente
 * all'interno del database dello stesso comune dell'admin. Inoltre viene constrollato anche se l'elettore
 * in questione abbia già votato o meno: in caso affermativo il suo accesso viene respinto.
 * 
 * @author Danilo Finizio
 *
 */

public class ConnessioneDBElettore {

	private boolean found=false;

	public ConnessioneDBElettore(Elettore elettore, String res) throws SQLException {

		Connection c = null;
		Statement statement = null;
		try {
			String url = "jdbc:sqlserver://thedailytesticle.servebeer.com:1433;databaseName=VOTO;user=Danitri;password=Danitri-12";
			c = DriverManager.getConnection(url);
			System.out.println("Connesso (elettore)!");
			statement = c.createStatement();
			
			String query1="SELECT * FROM ELETTORI_"+res+" where numero_tessera_elettorale='"+elettore.getNumeroTesseraElettorale()+"' and VOTO=0";
			ResultSet rs1=statement.executeQuery(query1);

			while(rs1.next()) {
				elettore.setNome(rs1.getString(1));
				elettore.setCognome(rs1.getString(2));
				Date data=rs1.getDate(4);//data
				elettore.setResidenza(rs1.getString(7));
				elettore.setLuogoDiNascita(rs1.getString(6));
				int voto = rs1.getInt(12);
				if(voto==0)
					elettore.setHasVoted(false);
				found=true;
				
				DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
				elettore.setDataDiNascita(formatter.format(data)); 
				
				break;		
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

	public void setFound(boolean found) {
		this.found = found;
	}
}
