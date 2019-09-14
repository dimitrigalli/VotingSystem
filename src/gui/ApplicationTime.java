package gui;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JOptionPane;

/**
 * @author dimitrigalli
 *
 */
public class ApplicationTime {
	
	@SuppressWarnings("deprecation")
	public ApplicationTime(CardsPanel mainPanel) {
		Timer timer = new Timer();
		TimerTask exitApp = new TimerTask() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null, "La sessione di voto è TERMINATA poiché il tempo è SCADUTO.\nDa ora in avanti non è più possibile votare.", "Attenzione", JOptionPane.WARNING_MESSAGE);
				CardsPanel cp = new CardsPanel();
				cp.switchPanel(mainPanel, "Card 6");
			}
			
		};
		Date oraFineSessione = new Date();
		oraFineSessione.setHours(14);
		oraFineSessione.setMinutes(20);
		oraFineSessione.setSeconds(10);
		timer.schedule(exitApp, oraFineSessione); //La sessione di voto termina alle ore 23:00!
	}
	
}
