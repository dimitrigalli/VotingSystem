package votingsystem;

import javax.swing.JFrame;

/**
 * @author dimitrigalli
 *
 */
public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	public MainFrame() {
		super();
		this.setTitle("VotingSystem");
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE); // Solo l'amministratore può chiudere il frame principale
		this.setSize(getMaximumSize());
		this.setVisible(true);
	}
	
}
