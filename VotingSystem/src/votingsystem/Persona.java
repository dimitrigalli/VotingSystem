package votingsystem;

import java.util.Date;

public class Persona {
	
	private String nome;
	private String cognome;
	private String cittadinanza;
	private Date dataDiNascita;
	private char sesso;
	private String luogoDiNascita;
	private String residenza;
	
	private byte[] numeroCartaIdentità = new byte[9];
	private Date dataDiScadenzaCartaIdentità;
	
}
