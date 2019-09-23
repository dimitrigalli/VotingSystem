package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**Classe utilizzata per reinizializzare il voto di tutti gli elettori
 *
 *@author Danilo Finizio
 *
 */

public class ResetDBElettore {

	private boolean found=false;

	public ResetDBElettore() throws SQLException {
		Connection c = null;
		Statement statement = null;
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://212.237.20.175:3306/DBDanilo?serverTimezone=GMT";
			String username = "Danilo";
			String password = "Beewolf98";
			Class.forName(driver);
			c = DriverManager.getConnection(url,username,password);
			System.out.println("Connesso per ResetDBElettore!");
			statement = c.createStatement();
			String query1 =" update ELETTORI_MODENA SET VOTO=0";
			String query2 =" update ELETTORI_ORTONA SET VOTO=0";
			String query3 =" update ELETTORI_PIEVEPELAGO SET VOTO=0";
			boolean rs1=statement.execute(query1);
			if(rs1==true)
				System.out.println("Errore nel reset dei voti su ELETTORI_MODENA");
			boolean rs2=statement.execute(query2);
			if(rs2==true)
				System.out.println("Errore nel reset dei voti su ELETTORI_ORTONA");
			boolean rs3=statement.execute(query3);
			if(rs3 == true)
				System.out.println("Errore nel reset dei voti su ELETTORI_PIEVEPELAGO");
			
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
