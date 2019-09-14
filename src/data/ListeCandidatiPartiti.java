package data;

import java.util.ArrayList;

public class ListeCandidatiPartiti {
	
	private ArrayList<Candidato> listaCandidati0 = new ArrayList<Candidato>();
	private ArrayList<Candidato> listaCandidati1 = new ArrayList<Candidato>();
	private ArrayList<Candidato> listaCandidati2 = new ArrayList<Candidato>();
	private ArrayList<Candidato> listaCandidati3 = new ArrayList<Candidato>();
	private ArrayList<Candidato> listaCandidati4 = new ArrayList<Candidato>();
	private ArrayList<Candidato> listaCandidati5 = new ArrayList<Candidato>();
	private ArrayList<Candidato> listaCandidati6 = new ArrayList<Candidato>();
	private ArrayList<Candidato> listaCandidati7 = new ArrayList<Candidato>();
	private ArrayList<Candidato> listaCandidati8 = new ArrayList<Candidato>();
	private ArrayList<Candidato> listaCandidati9 = new ArrayList<Candidato>();
	private ArrayList<Candidato> listaCandidati10 = new ArrayList<Candidato>();
	private ArrayList<Partito> listaPartiti = new ArrayList<Partito>();
	
	public ListeCandidatiPartiti() {
		listaCandidati0.add(new Candidato(0, "RIVA", "GIGI"));
		listaCandidati0.add(new Candidato(1, "MEAZZA", "GIUSEPPE"));
		listaCandidati0.add(new Candidato(2, "PIOLA", "SILVIO"));
		
		listaCandidati1.add(new Candidato(0, "BAGGIO", "ROBERTO"));
		listaCandidati1.add(new Candidato(1, "DEL PIERO", "ALESSANDRO"));
		listaCandidati1.add(new Candidato(2, "ALTOBELLI", "ALESSANDRO"));
		
		listaCandidati2.add(new Candidato(0, "BALONCIERI", "ADOLFO"));
		listaCandidati2.add(new Candidato(1, "INZAGHI", "FILIPPO"));
		listaCandidati2.add(new Candidato(2, "GRAZIANI", "FRANCESCO"));
		
		listaCandidati3.add(new Candidato(0, "VIERI", "CHRISTIAN"));
		listaCandidati3.add(new Candidato(1, "MAZZOLA", "SANDRO"));
		listaCandidati3.add(new Candidato(2, "DE ROSSI", "DANIELE"));
		
		listaCandidati4.add(new Candidato(0, "ROSSI", "PAOLO"));
		listaCandidati4.add(new Candidato(1, "BETTEGA", "ROBERTO"));
		listaCandidati4.add(new Candidato(2, "GILARDINO", "ALBERTO"));
		
		listaCandidati5.add(new Candidato(0, "TONI", "LUCA"));
		listaCandidati5.add(new Candidato(1, "VIALLI", "GIANLUCA"));
		listaCandidati5.add(new Candidato(2, "COLAUSSI", "GINO"));
		
		listaCandidati6.add(new Candidato(0, "LIBONATTI", "JULIO"));
		listaCandidati6.add(new Candidato(1, "SCHIAVIO", "ANGELO"));
		listaCandidati6.add(new Candidato(2, "FERRARI", "GIOVANNI"));
		
		listaCandidati7.add(new Candidato(0, "RIVERA", "GIANNI"));
		listaCandidati7.add(new Candidato(1, "BALOTELLI", "MARIO"));
		listaCandidati7.add(new Candidato(2, "CASIRAGHI", "PIERLUIGI"));
		
		listaCandidati8.add(new Candidato(0, "MAGNOZZI", "MARIO"));
		listaCandidati8.add(new Candidato(1, "ORSI", "RAIMUNDO"));
		listaCandidati8.add(new Candidato(2, "PIRLO", "ANDREA"));
		
		listaCandidati9.add(new Candidato(0, "CEVENINI", "LUIGI"));
		listaCandidati9.add(new Candidato(1, "DI NATALE", "ANTONIO"));
		listaCandidati9.add(new Candidato(2, "LEVRATTO", "VIRGILIO FELICE"));
		
		listaCandidati10.add(new Candidato(0, "CARAPELLESE", "RICCARDO"));
		listaCandidati10.add(new Candidato(1, "CASSANO", "ANTONIO"));
		listaCandidati10.add(new Candidato(2, "ZOLA", "GIANFRANCO"));
		
		listaPartiti.add(new Partito("Liga Veneta Repubblica", "SIMBOLO_0.jpg", listaCandidati0));
		listaPartiti.add(new Partito("Esseritari", "SIMBOLO_1.jpg", listaCandidati1));
		listaPartiti.add(new Partito("Stati Uniti d'Europa", "SIMBOLO_2.jpg", listaCandidati2));
		listaPartiti.add(new Partito("Gilet arancioni - Si cambia musica", "SIMBOLO_3.jpg", listaCandidati3));
		listaPartiti.add(new Partito("Fronte Verde", "SIMBOLO_4.jpg", listaCandidati4));
		listaPartiti.add(new Partito("PPA - Popolo delle Partite Iva", "SIMBOLO_5.jpg", listaCandidati5));
		listaPartiti.add(new Partito("Movimento Poeti d'Azione", "SIMBOLO_6.jpg", listaCandidati6));
		listaPartiti.add(new Partito("La Catena", "SIMBOLO_7.jpg", listaCandidati7));
		listaPartiti.add(new Partito("Sacro Romano Impero Cattolico", "SIMBOLO_8.jpg", listaCandidati8));
		listaPartiti.add(new Partito("Partito internettiano", "SIMBOLO_9.jpg", listaCandidati9));
		listaPartiti.add(new Partito("Ora rispetto per tutti gli animali", "SIMBOLO_10.jpg", listaCandidati10));
	}

	public ArrayList<Candidato> getListaCandidati(Partito p) {
		return p.getListaCandidati();
	}

	public ArrayList<Partito> getListaPartiti() {
		return listaPartiti;
	}

}
