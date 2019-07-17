package votingsystem;

import java.awt.BorderLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
		northpanel = new JPanel(new BorderLayout());
		northpanel.add(imagelabel1, BorderLayout.WEST);
		southpanel = new JPanel(new BorderLayout());
		southpanel.add(imagelabel2, BorderLayout.EAST);
		this.setLayout(new BorderLayout());
		this.add(northpanel, BorderLayout.NORTH);
		this.add(southpanel, BorderLayout.SOUTH);
	}

}
