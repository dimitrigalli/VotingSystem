package main;

import gui.MainFrame;
import gui.MainPanel;

/**
 * @author dimitrigalli
 *
 */
public class VotingSystem {
	
	private MainFrame mf;
	private MainPanel mp;
	
	public VotingSystem() {
		System.out.println("Launching VotingSystem");
		mf = new MainFrame();
		mp = new MainPanel();
		mf.setContentPane(mp);
	}

}
