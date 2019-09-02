package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class SchedaBiancaPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private String buttonMessage = new String("<html><b>VOTA <i>SCHEDA BIANCA</i></b></html>");

	public SchedaBiancaPanel(CardsPanel mainPanel) {
		setBackground(Color.WHITE);
		setLayout(new BorderLayout());
		JButton button = new JButton(buttonMessage);
		add(button, BorderLayout.CENTER);	
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (JOptionPane.showConfirmDialog(null, "Confermi il voto come SCHEDA BIANCA?") == JOptionPane.YES_OPTION) {
					JOptionPane.showMessageDialog(null, "Il tuo voto anonimo è stato inserito! Grazie per aver votato.");
					CardsPanel cp = new CardsPanel();
					cp.switchPanel(mainPanel, "Card 3");
				}
					
			}
			
		});
	}

}
