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
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://212.237.20.175:3306/DBDanilo?serverTimezone=GMT";
			String username = "Danilo";
			String password = "Beewolf98";
			Class.forName(driver);
			c = DriverManager.getConnection(url,username,password);
			System.out.println("Connesso (SetHasVotedDB)!");
			statement = c.createStatement();
			String query1="UPDATE ELETTORI_"+residenza+" SET VOTO=1 WHERE NUMERO_TESSERA_ELETTORALE='"+elettore.getNumeroTesseraElettorale()+"'";

			boolean rs1=statement.execute(query1);
			if(rs1==true) {
				System.out.println("Errore nel settaggio sulla colonna VOTO");
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
