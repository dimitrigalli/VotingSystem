
public class AdminModena extends Admin {
	
	public AdminModena(Elettore elettore, String username, String password) {
		super();
		this.elettore = elettore;
		this.username = username;
		this.password = password;
		this.comuneSezioneElettorale = "Modena";
		this.numeroSezioneElettorale = "1";
	}

}
