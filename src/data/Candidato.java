package data;

public class Candidato {
	
	private int numeroCandidato;
	private String cognome;
	private String nome;
	private int numeroPreferenzeCandidato = 0;
	
	public Candidato(int numeroCandidato, String cognome, String nome) {
		super();
		this.numeroCandidato = numeroCandidato;
		this.cognome = cognome;
		this.nome = nome;
	}

	@Override
	public String toString() {
		return numeroCandidato + " - " + cognome + " " + nome;
	}
	
	
	
	public int getNumeroPreferenzeCandidato() {
		return numeroPreferenzeCandidato;
	}

	public void addVotoCandidato() {
		this.numeroPreferenzeCandidato = numeroPreferenzeCandidato + 1;
	}
	
}
