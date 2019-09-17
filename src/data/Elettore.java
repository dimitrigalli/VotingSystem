package data;

/**Classe contenente i dati di un Elettore: oltre ad i dati di Perona, per votare è necessario avere il
 * numero della propria tessera elettorale, recarsi alla propria sede della sezione elettorale (dipende
 * dal comune di residenza) e ovviamente non bisogna avere già votato.
 * 
 * @author dimitrigalli
 *
 */
public class Elettore {

	private String nome;
	private String cognome;
	private String cittadinanza;
	private String dataDiNascita;
	private char sesso;
	private String luogoDiNascita;
	private String residenza;
	private String codiceFiscale;
	
	private String numeroTesseraElettorale;
	private int numeroSezioneListaElettorale;
	private boolean hasVoted = false;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getCittadinanza() {
		return cittadinanza;
	}
	public void setCittadinanza(String cittadinanza) {
		this.cittadinanza = cittadinanza;
	}
	public String getDataDiNascita() {
		return dataDiNascita;
	}
	public void setDataDiNascita(String string) {
		this.dataDiNascita = string;
	}
	public char getSesso() {
		return sesso;
	}
	public void setSesso(char sesso) {
		this.sesso = sesso;
	}
	public String getLuogoDiNascita() {
		return luogoDiNascita;
	}
	public void setLuogoDiNascita(String luogoDiNascita) {
		this.luogoDiNascita = luogoDiNascita;
	}
	public String getResidenza() {
		return residenza;
	}
	public void setResidenza(String residenza) {
		this.residenza = residenza;
	}
	public String getCodiceFiscale() {
		return codiceFiscale;
	}
	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}
	public String getNumeroTesseraElettorale() {
		return numeroTesseraElettorale;
	}
	public void setNumeroTesseraElettorale(String numeroTesseraElettorale) {
		this.numeroTesseraElettorale = numeroTesseraElettorale;
	}
	public int getNumeroSezioneListaElettorale() {
		return numeroSezioneListaElettorale;
	}
	public void setNumeroSezioneListaElettorale(int numeroSezioneListaElettorale) {
		this.numeroSezioneListaElettorale = numeroSezioneListaElettorale;
	}
	public boolean isHasVoted() {
		return hasVoted;
	}
	public void setHasVoted(boolean hasVoted) {
		this.hasVoted = hasVoted;
	}
	
}
