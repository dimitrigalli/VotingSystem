package gui;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * 
 */

/**
 * @author Danilo Finizio
 *
 */
public class Connessione_database {

	public static boolean getConnection(String nome_utente, String passwd_utente) throws Exception{
		try{
			//PARTE FISSA. CONNESSIONE AL SERVER CON CREDENZIALI FISSE
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://192.168.1.130:3306/SCRUTATORI";
			String username = "DESKTOP-TOP";
			String password = "12345678";
			Class.forName(driver);

			Connection c = DriverManager.getConnection(url,username,password);
			System.out.println("Connected");
			//ricezione credenziali dello scrutatore

			Statement statement = c.createStatement();

			System.out.println(nome_utente +' '+ passwd_utente);	
			String query="SELECT * FROM Persona where nome_utente ='"+nome_utente+"'"+
					" and password ='"+passwd_utente+"'";

			ResultSet rs=statement.executeQuery(query);
			boolean counter=false;
			while(rs.next()!=false) {

				if((rs.getString(1).equals(nome_utente) && rs.getString(2).equals(passwd_utente))) {
					System.out.println("Identificato!");
					counter=true;
					break;
				}

			}
			if(counter==false)	{
				System.out.println("Credenziali errate!");
				return false;
			}

		}	catch(Exception e){
			System.out.println(e);
			return false;
		}

		return true;
	}
}

