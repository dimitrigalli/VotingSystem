package data;

/**Classe contenente i dati relativi al numero di Schede Bianche (nessuna
 * preferenza espressa a Partito senza/con Candidato) inserite durante la
 * sessione di voto.
 * 
 * @author dimitrigalli
 *
 */
public class SchedaBianca {
	
	private int numeroSchedeBianche = 0;

	public int getNumeroSchedeBianche() {
		return numeroSchedeBianche;
	}

	public void setNumeroSchedeBianche(int numeroSchedeBianche) {
		this.numeroSchedeBianche = numeroSchedeBianche;
	}
	
	public void addSchedaBianca() {
		numeroSchedeBianche++;
	}
	
}
