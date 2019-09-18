package main;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import db.ResetDBElettore;
import db.ResetDBPartito;
import gui.MainFrame;
import gui.MainPanel;

/**
 * @author dimitrigalli
 *
 */
public class VotingSystem {
	
	public VotingSystem() {
		new CheckConnectivity();
		
		try {
			ResetDBElettore rdbe = new ResetDBElettore();
			if (rdbe.isFound() == false) {
				JOptionPane.showMessageDialog(null, "Errore nel reset dei voti su ELETTORI! L'app sarà chiusa.", "Errore", JOptionPane.ERROR_MESSAGE);
				System.out.println("Errore nel reset dei voti su ELETTORI!");
				System.exit(2);
			}
			ResetDBPartito rdbp = new ResetDBPartito();
			if (rdbp.isFound() == false) {
				JOptionPane.showMessageDialog(null, "Errore nel reset dei voti dei partiti e dei loro candidati! L'app sarà chiusa.", "Errore", JOptionPane.ERROR_MESSAGE);
				System.out.println("Errore nel reset dei voti dei partiti e dei loro candidati!");
				System.exit(2);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		MainFrame mf = new MainFrame();
		MainPanel mp = new MainPanel();
		mf.setContentPane(mp);
	}

}
