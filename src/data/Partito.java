package data;

import java.util.ArrayList;

public class Partito {
	
	private String nome;
	private String simbolo;
	private ArrayList<Candidato> listaCandidati;
	private ArrayList<String> listaStringheCandidati;
	private int numeroPreferenzePartito = 0;
	
	

	public Partito(String nome, String simbolo, ArrayList<Candidato> listaCandidati) {
		super();
		this.nome = nome;
		this.simbolo = simbolo;
		this.listaCandidati = listaCandidati;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSimbolo() {
		return simbolo;
	}

	public void setSimbolo(String simbolo) {
		this.simbolo = simbolo;
	}
	
	public ArrayList<Candidato> getListaCandidati() {
		return listaCandidati;
	}

	public void setListaCandidati(ArrayList<Candidato> listaCandidati) {
		this.listaCandidati = listaCandidati;
	}

	public ArrayList<String> getListaStringheCandidati(ArrayList<Candidato> listaCandidati) {
		listaStringheCandidati = new ArrayList<String>();
		listaStringheCandidati.add(new String("*nessuna preferenza*"));
		listaStringheCandidati.add(listaCandidati.get(0).toString());
		listaStringheCandidati.add(listaCandidati.get(1).toString());
		listaStringheCandidati.add(listaCandidati.get(2).toString());
		return listaStringheCandidati;
	}
	
	public int getNumeroPreferenzePartito() {
		return numeroPreferenzePartito;
	}

	public void addVoto() {
		this.numeroPreferenzePartito = numeroPreferenzePartito + 1;
	}
}
