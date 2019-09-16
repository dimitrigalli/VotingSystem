package data;

/**Classe contenente i dati di un Elettore: oltre ad i dati di Perona, per votare è necessario avere il
 * numero della propria tessera elettorale, recarsi alla propria sede della sezione elettorale (dipende
 * dal comune di residenza) e ovviamente non bisogna avere già votato.
 * 
 * @author dimitrigalli
 *
 */
public class Elettore extends Persona {

	private byte[] numeroTesseraElettorale = new byte[9];
	private int numeroSezioneListaElettorale;
	private boolean hasVoted = false;
	
	public byte[] getNumeroTesseraElettorale() {
		return numeroTesseraElettorale;
	}
	public void setNumeroTesseraElettorale(byte[] numeroTesseraElettorale) {
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
