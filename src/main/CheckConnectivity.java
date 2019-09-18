package main;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.swing.JOptionPane;

/**
 * @author dimitrigalli
 *
 */
public class CheckConnectivity {
	
	public CheckConnectivity() {
		try {
			URL url = new URL("http://www.google.com");
			URLConnection connection = url.openConnection();
			connection.connect();
			System.out.println("Internet is connected! You can use the application!");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			System.out.println("Internet is NOT connected! You can NOT use the application!");
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Impossibile avviare l'applicazione poiché la connessione internet NON è attiva! L'app sarà chiusa.", "Errore", JOptionPane.ERROR_MESSAGE);
			System.exit(1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Internet is NOT connected! You can NOT use the application!");
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Impossibile avviare l'applicazione poiché la connessione internet NON è attiva! L'app sarà chiusa.", "Errore", JOptionPane.ERROR_MESSAGE);
			System.exit(1);
		}
	}

}
