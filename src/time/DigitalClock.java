package time;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import java.awt.Font;

/**
 * @author dimitrigalli
 *
 */
public class DigitalClock extends JPanel {

	private static final long serialVersionUID = 1L;
	Timer updateTimer;
	int DELAY = 100;
	private String Day, Month, DateStr;
	private Date currentDate;

	public DigitalClock() {
		GridLayout gridLayout = new GridLayout(2, 1, 0, -30);
		setLayout(gridLayout);
		
		JLabel timeLabel = new JLabel("00:00:00");
		timeLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		timeLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 50));
		timeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(timeLabel);
		
		currentDate = new Date();
		@SuppressWarnings("deprecation")
		int day = currentDate.getDay();
		if (day == 0) Day = new String("Domenica");
		else if (day == 1) Day = new String("Lunedì");
		else if (day == 2) Day = new String("Martedì");
		else if (day == 3) Day = new String("Mercoledì");
		else if (day == 4) Day = new String("Giovedì");
		else if (day == 5) Day = new String("Venerdì");
		else if (day == 6) Day = new String("Sabato");
		@SuppressWarnings("deprecation")
		Integer date = currentDate.getDate();
		@SuppressWarnings("deprecation")
		int month = currentDate.getMonth();
		if (month == 0) Month = new String("gennaio");
		else if (month == 1) Month = new String("febbraio");
		else if (month == 2) Month = new String("marzo");
		else if (month == 3) Month = new String("aprile");
		else if (month == 4) Month = new String("maggio");
		else if (month == 5) Month = new String("giugno");
		else if (month == 6) Month = new String("luglio");
		else if (month == 7) Month = new String("agosto");
		else if (month == 8) Month = new String("settembre");
		else if (month == 9) Month = new String("ottobre");
		else if (month == 10) Month = new String("novembre");
		else if (month == 11) Month = new String("dicembre");
		@SuppressWarnings("deprecation")
		Integer year = currentDate.getYear() + 1900;
		DateStr = new String(Day+" "+date.toString()+" "+Month+" "+year.toString());
		JLabel dayLabel = new JLabel("     "+DateStr+"     ");
		dayLabel.setVerticalAlignment(SwingConstants.CENTER);
		dayLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		dayLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(dayLabel);
		
		updateTimer = new Timer(DELAY, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Date currentTime = new Date();
				String formatTimeStr = "kk:mm:ss";
				DateFormat formatTime = new SimpleDateFormat(formatTimeStr);
				String formattedTimeStr = formatTime.format(currentTime);
				timeLabel.setText(formattedTimeStr);
			}
		});
		updateTimer.start();
	}

}
