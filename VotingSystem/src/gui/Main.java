package gui;

import java.awt.EventQueue;

/**
 * @author dimitrigalli
 *
 */
public class Main {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new VotingSystem();
			}
		});
	}

}
