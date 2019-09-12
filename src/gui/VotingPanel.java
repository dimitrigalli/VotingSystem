package gui;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JPanel;

import data.Candidato;
import data.Partito;
import data.SchedaBianca;

/**
 * @author dimitrigalli
 *
 */
public class VotingPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private ArrayList<Candidato> listaCandidati = new ArrayList<Candidato>();
	
	private ArrayList<Partito> listaPartiti = new ArrayList<Partito>();
	private SchedaBianca schedeBianche = new SchedaBianca();

	public VotingPanel(CardsPanel mainPanel) {
		setBackground(Color.WHITE);
		setLayout(new GridLayout(4,3));
		
		listaCandidati.add(new Candidato(1, "BICOCCHI", "NICOLA"));
		listaCandidati.add(new Candidato(2, "FINIZIO", "DANILO"));
		listaCandidati.add(new Candidato(3, "GALLI", "DIMITRI"));
		
		listaPartiti.add(new Partito("Liga Veneta Repubblica", "SIMBOLO_0.jpg", listaCandidati));
		listaPartiti.add(new Partito("Esseritari", "SIMBOLO_1.jpg", listaCandidati));
		listaPartiti.add(new Partito("Stati Uniti d'Europa", "SIMBOLO_2.jpg", listaCandidati));
		listaPartiti.add(new Partito("Gilet arancioni - Si cambia musica", "SIMBOLO_3.jpg", listaCandidati));
		listaPartiti.add(new Partito("Fronte Verde", "SIMBOLO_4.jpg", listaCandidati));
		listaPartiti.add(new Partito("PPA - Popolo delle Partite Iva", "SIMBOLO_5.jpg", listaCandidati));
		listaPartiti.add(new Partito("Movimento Poeti d'Azione", "SIMBOLO_6.jpg", listaCandidati));
		listaPartiti.add(new Partito("La Catena", "SIMBOLO_7.jpg", listaCandidati));
		listaPartiti.add(new Partito("Sacro Romano Impero Cattolico", "SIMBOLO_8.jpg", listaCandidati));
		listaPartiti.add(new Partito("Partito internettiano", "SIMBOLO_9.jpg", listaCandidati));
		listaPartiti.add(new Partito("Ora rispetto per tutti gli animali", "SIMBOLO_10.jpg", listaCandidati));
		
		Iterator<Partito> i = listaPartiti.iterator();
		while (i.hasNext()) {
			add(new PartitoPanel(i.next(), mainPanel));
		}
		add(new SchedaBiancaPanel(schedeBianche, mainPanel));
	}

}
