package gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * @author dimitrigalli
 *
 */
public class ClosingPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private String message = new String("<html><center>Tutti i voti sono stati correttamente inviati al MINISTERO DELL'INTERNO - DIPARTIMENTO PER GLI AFFARI INTERNI E TERRITORIALI.<br><br>È stato creato un <b><i>documento illustrativo non ministeriale</i></b> (protetto da password) contenente i risultati <u>PARZIALI</u> della sessione di voto del seggio registrato.</center></html>");

	public ClosingPanel(CardsPanel mainPanel) {
		setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("RISULTATI SESSIONE DI VOTO");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 30));
		lblNewLabel.setBounds(15, 15, 600, 30);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(message);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(100, 50, 740, 200);
		add(lblNewLabel_1);
		
		JLabel linkToFile = new JLabel("<html><body><a href=\"\">Apri il documento</a></body></html>");
		linkToFile.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		linkToFile.setHorizontalAlignment(SwingConstants.CENTER);
		linkToFile.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		linkToFile.setBounds(370, 230, 200, 30);
		add(linkToFile);
		
		linkToFile.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().open(new File("documento.txt"));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}

}
