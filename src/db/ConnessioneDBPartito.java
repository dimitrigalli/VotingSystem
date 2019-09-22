package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**Classe utilizzata per aggiornare il database dei partiti con il voto inserito dall'elettore.
 * Naturalmente verranno incrementati i contatori dei voti del partito scelto ed eventualmente
 * del candidato del medesimo partito, il tutto in maniera anonima senza salvare alcun dato sull'elettore.
 * 
 * @author Danilo Finizio
 *
 */

public class ConnessioneDBPartito {
	
	private boolean found=false;

	public ConnessioneDBPartito(String nome_partito, int numero_preferenze_partito, String nome_candidato, int num_voti_candidato) {

		int k=-1;
		char nomep[]=nome_partito.toCharArray();
		int i;
		
		for(i=0;i<nome_partito.length();i++) {
			if(nomep[i]=='\'') {
				k=i;
				break;
			}
		}


		if(k!=-1) {
			nome_partito=nome_partito.substring(0, k) + '\'' + nome_partito.substring(k);
		}

		Connection c = null;
		Statement statement = null;
		try {
			String url = "jdbc:sqlserver://thedailytesticle.servebeer.com:1433;databaseName=PARTITO;user=Danitri;password=Danitri-12";
			c = DriverManager.getConnection(url);
			System.out.println("Connesso (partito)!");
			statement = c.createStatement();
			String query1=" UPDATE PARTITI SET NUM_VOTI_COMPLESSIVI="+ numero_preferenze_partito+" where NOME_PARTITO='"+ nome_partito+"'";
			if(nome_candidato.equals("*nessuna preferenza*")==false) {

				int n=Integer.parseInt(nome_candidato.substring(0, 1));

				boolean rs1=statement.execute(query1);
				if(rs1==true)
					System.out.println("Errore: impossibile aggiornare i voti del partito!");
				String query2="UPDATE PARTITI SET VOTI_CAND_"+n+" = "+num_voti_candidato+" WHERE NOME_PARTITO='"+ nome_partito+"'";
				boolean rs2=statement.execute(query2);
				if(rs2==true)
					System.out.println("Errore: impossibile aggiornare i voti del candidato!");

			}
			else {

				boolean rs1=statement.execute(query1);
				if(rs1==true)
					System.out.println("Errore: impossibile aggiornare i voti del partito!");
			}
			found=true;
		}
		catch(Exception e) {
			System.out.println(e);
		}
		finally { 
			if (c != null)
			{  
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				try {
					c.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} 
			}
		}
	}

	public boolean isFound() {
		return found;
	}
}



