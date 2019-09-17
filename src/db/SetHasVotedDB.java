package db;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;
import java.sql.Statement;

import data.Elettore;

/**Classe utilizzata per settare il flag del voto dell'elettore a 1 nel database degli elettori. In questo
 * modo un elettore che ha gia' votato non puo' farlo una seconda volta.
 * 
 * @author Danilo Finizio
 *
 */

public class SetHasVotedDB {
	
	private boolean found=false;

	public SetHasVotedDB(Elettore elettore,String residenza) throws SQLException {

		Connection c = null;
		Statement statement = null;
		try {
			String url = "jdbc:sqlserver://thedailytesticle.servebeer.com:1433;databaseName=VOTO;user=Danitri;password=Danitri-12";//votazione � il nome del db
			c = DriverManager.getConnection(url);
			System.out.println("Connesso (SetHasVotedDB)!");
			statement = c.createStatement();
			String query1="UPDATE ELETTORI_"+residenza+" SET VOTO=1 WHERE NUMERO_TESSERA_ELETTORALE='"+elettore.getNumeroTesseraElettorale()+"'";

			boolean rs1=statement.execute(query1);
			if(rs1==true) {
				System.out.println("Errore: impossibile aggiornare la colonna VOTO!");
			}
			found=true;
		}
		catch(Exception e) {
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
