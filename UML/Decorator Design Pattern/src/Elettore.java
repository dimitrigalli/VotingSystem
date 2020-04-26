
public abstract class Elettore {
	
	String numeroTesseraElettorale;
	String nome;
	String cognome;
	String residenza;
	
	public void login() {
		System.out.println("L'elettore " + nome + " " + cognome + " sta effettuando il login!");
		//implementazione
		confirmData();
	}

	public void confirmData() {
		System.out.println("L'elettore " + nome + " " + cognome + " sta confermando i dati!");
		//implementazione
	}
	
	public void vote() {
		System.out.println("L'elettore " + nome + " " + cognome + " sta votando!");
		//implementazione
		save();
	}
	
	public void save() {
		System.out.println("Il voto è stato salvato!");
		//implementazione
	}
	
	public void activeSession() {
		
	}
	
	public void confirmAutodeactiveSession() {
		
	}
	
	public void showResults() {
		
	}
	
	public void closeApp() {
		
	}
	
	public void loginElettore() {
		
	}
	
	public void confirmDataElettore() {
		
	}
	
	public void voteElettore() {
		
	}
	
	public void saveElettore() {
		
	}
	
}
