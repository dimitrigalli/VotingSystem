package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**Classe utilizzata per resettare il contatore dei voti di ogni partito e di ogni candidato
 *
 *@author Danilo Finizio
 *
 */

public class ResetDBPartito {

	private boolean found=false;

	public ResetDBPartito() throws SQLException {
		Connection c = null;
		Statement statement = null;
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://212.237.20.175:3306/DBDanilo?serverTimezone=GMT";
			String username = "Danilo";
			String password = "Beewolf98";
			Class.forName(driver);
			c = DriverManager.getConnection(url,username,password);
			System.out.println("Connesso per ResetDBPartito!");
			statement = c.createStatement();
			String query1 =" update PARTITI set NUM_VOTI_COMPLESSIVI=0, VOTI_CAND_0=0,VOTI_CAND_1=0, VOTI_CAND_2=0 ";
			boolean rs1=statement.execute(query1);
			if(rs1==true)
				System.out.println("Errore nel reset dei voti dei partiti e dei loro candidati!");

			found=true;
		}
		catch(Exception e) {
			System.out.println(e);
		}
		finally {
			if (c!=null) {
				statement.close();
				c.close();
			}
		}

	}
	public boolean isFound() {
		return found;
	}
	
	
}