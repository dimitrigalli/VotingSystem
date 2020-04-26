
public class App {

	public static void main(String[] args) {
		Elettore elettoreModena = new ElettoreModena("012345678", "Dimitri", "Galli");
		elettoreModena.login();
		elettoreModena.vote();
		
		Elettore adminModena = new ElettoreModena("123456789", "Francesco", "Guerra");
		adminModena = new AdminModena(adminModena, "francescoguerra", "francescoguerra");
		adminModena.login();
		adminModena.loginElettore();
		adminModena.voteElettore();
		adminModena.confirmAutodeactiveSession();
		adminModena.showResults();
		adminModena.closeApp();
	}

}
