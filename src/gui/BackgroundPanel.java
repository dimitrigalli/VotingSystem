package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

import data.Admin;
import data.Elettore;

/**
 * @author dimitrigalli
 *
 */
public class BackgroundPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private Image bgImg;
	
	Admin admin;
	Elettore presidente;
	Elettore segretario;
	Elettore scrutatore;
	
	Elettore elettore;

	public BackgroundPanel() {
		this.setBorder(BorderFactory.createLineBorder(Color.BLUE, 3));
		this.setLayout(null);
		try {
			bgImg = ImageIO.read(new File("images"+File.separator+"BackgroundSchede.jpg"));
		} catch (IOException e) {
			System.out.println("Error: image \"BackgroundSchede.jpg\" not found\n");
			e.printStackTrace();
		}
		
		admin = new Admin();
		presidente = new Elettore();
		segretario = new Elettore();
		scrutatore = new Elettore();
		admin.setPresidente(presidente);
		admin.setSegretario(segretario);
		admin.setScrutatore(scrutatore);
		elettore = new Elettore();
		
		this.add(new CardsPanel(admin, elettore));
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(bgImg, 0, 0, null);
	}

}
