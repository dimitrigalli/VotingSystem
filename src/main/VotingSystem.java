package main;

import gui.MainFrame;
import gui.MainPanel;

/**
 * @author dimitrigalli
 *
 */
public class VotingSystem {
	
	public VotingSystem() {
		MainFrame mf = new MainFrame();
		MainPanel mp = new MainPanel();
		mf.setContentPane(mp);
	}

}
