package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 * @author dimitrigalli
 *
 */
public class InteractivePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private Image bgImg;

	public InteractivePanel() {
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
		try {
			bgImg = ImageIO.read(new File("images"+File.separator+"BackgroundSchede.jpg"));
		} catch (IOException e) {
			System.out.println("Error: image \"BackgroundSchede.jpg\" not found\n");
			e.printStackTrace();
		}
		
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(bgImg, 0, 0, null);
	}

}
