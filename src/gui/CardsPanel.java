package gui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 * @author dimitrigalli
 *
 */
public class CardsPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private VotingPanel vp;

	public CardsPanel() {
		setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		setLayout(new CardLayout());
		setLocation(240, 20);
		setSize(940, 470);
		
		add(new AdminLoginPanel(this), "Card 1");
		add(new ConfirmAdminLoginPanel(this), "Card 2");
		add(new ElettoreLoginPanel(this), "Card 3");
		add(new ConfirmElettoreLoginPanel(this), "Card 4");
		vp = new VotingPanel(this);
		add(vp, "Card 5");
		add(new ClosingPanel(this, vp), "Card 6");
	}
	
	public void switchPanel(Container container, String panelName) {
        CardLayout card = (CardLayout) (container.getLayout());
        card.show(container, panelName);
    }

}
