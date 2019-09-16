package data;

import java.util.Date;

/**Classe contenente i dati anagrafici di una Persona.
 * 
 * @author dimitrigalli
 *
 */
public class Persona {
	
	private String nome;
	private String cognome;
	private String cittadinanza;
	private Date dataDiNascita;
	private char sesso;
	private String luogoDiNascita;
	private String residenza;
	private byte[] codiceFiscale = new byte[16];
	
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
	public Date getDataDiNascita() {
		return dataDiNascita;
	}
	public void setDataDiNascita(Date dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
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
	public byte[] getCodiceFiscale() {
		return codiceFiscale;
	}
	public void setCodiceFiscale(byte[] codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}
	
}
