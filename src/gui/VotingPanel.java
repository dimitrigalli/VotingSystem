package gui;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;

import data.Partito;

/**
 * @author dimitrigalli
 *
 */
public class VotingPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private int numPartiti = 12;
	private Partito partitoFacsimile = new Partito();

	public VotingPanel(CardsPanel mainPanel) {
		setBackground(Color.WHITE);
		setLayout(new GridLayout(4,3));
		for (int i = 0; i < numPartiti; i++) {
			if (i == numPartiti-1)
				add(new SchedaBiancaPanel(mainPanel));
			else
				add(new PartitoPanel(partitoFacsimile, mainPanel));
		}
	}

}
