package time;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JOptionPane;

import data.Admin;
import data.Elettore;
import gui.CardsPanel;

/**
 * @author dimitrigalli
 *
 */
public class ApplicationTime {
	
	private Timer timer;
	private TimerTask exitApp;
	private CardsPanel cp;
	private Date oraFineSessione;
	
	@SuppressWarnings("deprecation")
	public ApplicationTime(CardsPanel mainPanel, Admin admin, Elettore elettore) {
		timer = new Timer();
		exitApp = new TimerTask() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null, "La sessione di voto è TERMINATA poiché il tempo è SCADUTO.\nDa ora in avanti non è più possibile votare.", "Attenzione", JOptionPane.WARNING_MESSAGE);
				cp = new CardsPanel(admin, elettore);
				cp.switchPanel(mainPanel, "Card 4");
			}
		};
		/* La sessione di voto chiuderà alle ore 23:00. */
		oraFineSessione = new Date();
		oraFineSessione.setHours(23);
		oraFineSessione.setMinutes(00);
		oraFineSessione.setSeconds(00);
		timer.schedule(exitApp, oraFineSessione);
	}
	
}
