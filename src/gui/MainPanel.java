package gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * @author dimitrigalli
 *
 */
public class MainPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private BufferedImage image1;
	private BufferedImage image2;
	private JLabel imagelabel1;
	private JLabel imagelabel2;
	private JPanel northpanel, southpanel;
	private JLabel title;
	
	public MainPanel() {
		super();
		try {
			image1 = ImageIO.read(new File("images"+File.separator+"Logo-DIEF.png"));
			image2 = ImageIO.read(new File("images"+File.separator+"Logo-MIUR.png"));
		} catch (IOException e) {
			System.out.println("Error: images \"Logo-DIEF.png\" and \"Logo-MIUR.png\" not found\n");
			e.printStackTrace();
		}
		imagelabel1 = new JLabel(new ImageIcon(image1));
		imagelabel2 = new JLabel(new ImageIcon(image2));
		title = new JLabel("<html>SISTEMA DI VOTO DIGITALE-ELETTRONICO</html>");
		title.setFont(new Font("Lucida Grande", Font.BOLD, 50));
		title.setHorizontalAlignment(SwingConstants.LEFT);
		title.setVerticalAlignment(SwingConstants.CENTER);
		northpanel = new JPanel(new BorderLayout());
		northpanel.add(imagelabel1, BorderLayout.WEST);
		southpanel = new JPanel(new BorderLayout());
		southpanel.add(imagelabel2, BorderLayout.EAST);
		northpanel.add(title);
		southpanel.add(new DigitalClock(), BorderLayout.WEST);
		southpanel.add(new WarningPanel());
		this.setLayout(new BorderLayout());
		this.add(northpanel, BorderLayout.NORTH);
		this.add(southpanel, BorderLayout.SOUTH);
		this.add(new JPanel(), BorderLayout.WEST);
		this.add(new JPanel(), BorderLayout.EAST);
		this.add(new BackgroundPanel(), BorderLayout.CENTER);
	}

}
