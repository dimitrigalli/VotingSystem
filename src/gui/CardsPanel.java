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
	
	private AdminLoginPanel alp;
	private ElettoreLoginPanel elp;
	private VotingPanel vp;
	private ClosingPanel clopan;

	public CardsPanel(Admin admin, Elettore elettore) {
		setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		setLayout(new CardLayout());
		setLocation(240, 20);
		setSize(940, 470);
		
		alp = new AdminLoginPanel(this, admin, elettore);
		add(alp, "Card 1");
		elp = new ElettoreLoginPanel(this, admin, elettore);
		add(elp, "Card 2");
		vp = new VotingPanel(this, admin, elettore);
		add(vp, "Card 3");
		clopan = new ClosingPanel(this, vp, admin, elettore);
		add(clopan, "Card 4");
	}
	
	public void switchPanel(Container container, String panelName) {
        CardLayout card = (CardLayout) (container.getLayout());
        card.show(container, panelName);
    }

}
