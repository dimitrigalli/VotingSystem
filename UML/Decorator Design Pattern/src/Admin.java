
public abstract class Admin extends Elettore {
	
	Elettore elettore;
	
	String username;
	String password;
	String comuneSezioneElettorale;
	String numeroSezioneElettorale;
	
	public void login() {
		System.out.println("L'amministratore " + username + " " + password + " sta per avviare la sessione di voto!");
		//implementazione
		confirmData();
	}
	
	public void confirmData() {
		System.out.println("L'amministratore " + username + " " + password + " sta confermando l'avvio della sessione di voto!");
		//implementazione
		activeSession();
	}
	
	public void activeSession() {
		//implementazione
	}
	
	public void confirmAutodeactiveSession() {
		System.out.println("L'amministratore " + username + " " + password + " sta confermando la chiusura della sessione di voto!");
		//implementazione
	}
	
	public void showResults() {
		System.out.println("L'amministratore " + username + " " + password + " sta visualizzando i risultati della sessione di voto!");
		//implementazione
	}
	
	public void closeApp() {
		System.out.println("L'amministratore " + username + " " + password + " sta terminando l'esecuzione dell'applicazione!");
		//implementazione
	}
	
	public void loginElettore() {
		elettore.login();
	}
	
	public void confirmDataElettore() {
		elettore.confirmData();
	}
	
	public void voteElettore() {
		elettore.vote();
	}
	
	public void saveElettore() {
		elettore.save();
	}
	
}
