package data;

/**Classe contenente i dati utili per il login dell'Amministratore della sessione di voto: username,
 * password, numero, comune e membri (presidente, segretario e scrutatore) della sezione elettorale.
 * 
 * @author dimitrigalli
 *
 */
public class Admin {
	
	private String username;
	private String password;
	private int numeroSezioneElettorale;
	private String comuneSezioneElettorale;
	
	private Elettore presidente = new Elettore();
	private Elettore segretario = new Elettore();
	private Elettore scrutatore = new Elettore();
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getNumeroSezioneElettorale() {
		return numeroSezioneElettorale;
	}
	public void setNumeroSezioneElettorale(int numeroSezioneElettorale) {
		this.numeroSezioneElettorale = numeroSezioneElettorale;
	}
	public String getComuneSezioneElettorale() {
		return comuneSezioneElettorale;
	}
	public void setComuneSezioneElettorale(String comuneSezioneElettorale) {
		this.comuneSezioneElettorale = comuneSezioneElettorale;
	}
	public Elettore getPresidente() {
		return presidente;
	}
	public void setPresidente(Elettore presidente) {
		this.presidente = presidente;
	}
	public Elettore getSegretario() {
		return segretario;
	}
	public void setSegretario(Elettore segretario) {
		this.segretario = segretario;
	}
	public Elettore getScrutatore() {
		return scrutatore;
	}
	public void setScrutatore(Elettore scrutatore) {
		this.scrutatore = scrutatore;
	}
	
}
