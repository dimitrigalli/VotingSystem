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
			String url = "jdbc:sqlserver://thedailytesticle.servebeer.com:1433;databaseName=VOTO;user=Danitri;password=Danitri-12";//votazione � il nome del db			c = DriverManager.getConnection(url);
			c = DriverManager.getConnection(url);
			System.out.println("Connesso per ResetDBElettore!");
			statement = c.createStatement();
			String query1 =" update ELETTORI_MODENA SET VOTO=0";
			String query2 =" update ELETTORI_ORTONA SET VOTO=0";
			String query3 =" update ELETTORI_PIEVEPELAGO SET VOTO=0";
			boolean rs1=statement.execute(query1);
			if(rs1==true)
				System.out.println("Errore nel reset dei voti su ELETTORI_MODENA!");
			boolean rs2=statement.execute(query2);
			if(rs2==true)
				System.out.println("Errore nel reset dei voti su ELETTORI_ORTONA!");
			boolean rs3=statement.execute(query3);
			if(rs3==true)
				System.out.println("Errore nel reset dei voti su ELETTORI_PIEVEPELAGO!");
			
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
