package votingsystem;

import javax.swing.JPanel;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class WarningPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private BufferedImage WarningIcon;

	public WarningPanel() {
		setLayout(null);
		
		try {
			WarningIcon = ImageIO.read(new File("images"+File.separator+"WarningIcon.png"));
		} catch (IOException e) {
			System.out.println("Error: image \"WarningIcon.png\" not found\n");
			e.printStackTrace();
		}
		
		JLabel warningImage = new JLabel(new ImageIcon(WarningIcon));
		warningImage.setHorizontalAlignment(SwingConstants.CENTER);
		warningImage.setBounds(125, 15, 100, 100);
		add(warningImage);
		
		JLabel warningMessage = new JLabel("<html>È vietato introdurre all’interno delle cabine elettorali telefoni cellulari o altre apparecchiature in grado di fotografare o registrare immagini. Chiunque contravviene al divieto di cui al comma 1 è punito con l’arresto da tre a sei mesi e con l’ammenda da 300 a 1000 euro.</html>");
		warningMessage.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		warningMessage.setHorizontalAlignment(SwingConstants.CENTER);
		warningMessage.setBounds(250, 15, 500, 100);
		add(warningMessage);
		
	}
}
