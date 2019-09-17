package gui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import data.Admin;
import data.Elettore;

/**
 * @author dimitrigalli
 *
 */
public class CardsPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private VotingPanel vp;

	public CardsPanel(Admin admin, Elettore elettore) {
		setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		setLayout(new CardLayout());
		setLocation(240, 20);
		setSize(940, 470);
		
		add(new AdminLoginPanel(this, admin, elettore), "Card 1");
		add(new ElettoreLoginPanel(this, admin, elettore), "Card 2");
		vp = new VotingPanel(this, admin, elettore);
		add(vp, "Card 3");
		add(new ClosingPanel(this, vp, admin, elettore), "Card 4");
	}
	
	public void switchPanel(Container container, String panelName) {
        CardLayout card = (CardLayout) (container.getLayout());
        card.show(container, panelName);
    }

}
