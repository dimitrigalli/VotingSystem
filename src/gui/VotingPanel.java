package gui;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JPanel;

import data.Admin;
import data.Candidato;
import data.Elettore;
import data.ListeCandidatiPartiti;
import data.Partito;
import data.SchedaBianca;

/**
 * @author dimitrigalli
 *
 */
public class VotingPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private ArrayList<Partito> listaPartiti = new ArrayList<Partito>();
	private ListeCandidatiPartiti liste = new ListeCandidatiPartiti();
	private SchedaBianca schedeBianche = new SchedaBianca();
	
	public VotingPanel(CardsPanel mainPanel, Admin admin, Elettore elettore) {
		setBackground(Color.WHITE);
		setLayout(new GridLayout(4,3));
		
		listaPartiti = liste.getListaPartiti();
		
		int index = 0;
		Iterator<Partito> i = listaPartiti.iterator();
		while (i.hasNext()) {
			add(new PartitoPanel(i.next(), mainPanel, listaPartiti, index, admin, elettore));
			index++;
		}
		add(new SchedaBiancaPanel(schedeBianche, mainPanel, admin, elettore));
	}

	public ArrayList<Partito> getListaPartiti() {
		return listaPartiti;
	}
	
	public ArrayList<Candidato> getListaCandidati(Partito partito) {
		return partito.getListaCandidati();
	}

	public SchedaBianca getSchedeBianche() {
		return schedeBianche;
	}
	
}
