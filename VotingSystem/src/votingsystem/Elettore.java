package votingsystem;

import java.util.ArrayList;
import java.util.Date;

public class Elettore extends Persona {

	private byte[] numeroTesseraElettorale = new byte[9];
	private int numeroSezioneListaElettorale;
	private ArrayList<Date> certificazioniVoto;
	
}
