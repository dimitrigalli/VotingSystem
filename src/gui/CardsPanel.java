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
	
	private Admin admin;
	private Elettore elettore;
	
	private VotingPanel vp;

	public CardsPanel() {
		setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		setLayout(new CardLayout());
		setLocation(240, 20);
		setSize(940, 470);
		
		admin = new Admin();
		elettore = new Elettore();
		
		add(new AdminLoginPanel(this, admin), "Card 1");
		add(new ConfirmAdminLoginPanel(this, admin), "Card 2");
		add(new ElettoreLoginPanel(this, admin, elettore), "Card 3");
		add(new ConfirmElettoreLoginPanel(this, elettore), "Card 4");
		vp = new VotingPanel(this, elettore);
		add(vp, "Card 5");
		add(new ClosingPanel(this, vp, admin), "Card 6");
	}
	
	public void switchPanel(Container container, String panelName) {
        CardLayout card = (CardLayout) (container.getLayout());
        card.show(container, panelName);
    }

}
