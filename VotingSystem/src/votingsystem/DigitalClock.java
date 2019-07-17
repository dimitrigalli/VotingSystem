package votingsystem;

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

public class DigitalClock extends JPanel {

	private static final long serialVersionUID = 1L;
	Timer updateTimer;
	int DELAY = 100;

	public DigitalClock() {
		GridLayout gridLayout = new GridLayout(2, 1, 0, -30);
		setLayout(gridLayout);
		
		JLabel timeLabel = new JLabel("00:00:00");
		timeLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		timeLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 50));
		timeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(timeLabel);
		
		JLabel dayLabel = new JLabel("     Mercoledì 17 luglio 2019     ");
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
