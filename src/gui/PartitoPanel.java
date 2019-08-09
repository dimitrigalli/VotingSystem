package gui;

import java.awt.Color;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import data.Partito;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;

/**
 * @author dimitrigalli
 *
 */
public class PartitoPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private BufferedImage img;
	private ArrayList<String> listaProva = new ArrayList<String>();

	public PartitoPanel(Partito partito) {
		setBackground(Color.WHITE);
		setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		setLayout(null);
		
		JLabel lblNomepartito = new JLabel("NOMEPARTITO");
		lblNomepartito.setHorizontalAlignment(SwingConstants.CENTER);
		lblNomepartito.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblNomepartito.setBounds(5, 5, 130, 20);
		add(lblNomepartito);
		
		try {
			img = ImageIO.read(new File("images"+File.separator+"FacsimileLogoPartito.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Error: image \"FacsimileLogoPartito.jpg\" not found\n");
			e.printStackTrace();
		}
		JLabel imgSimboloPartito = new JLabel(new ImageIcon(img));
		imgSimboloPartito.setBounds(28, 25, 85, 85);
		imgSimboloPartito.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		add(imgSimboloPartito);
		
		JLabel lblNewLabel = new JLabel("Preferenza candidato");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.ITALIC, 15));
		lblNewLabel.setBounds(135, 20, 160, 20);
		add(lblNewLabel);
		
		listaProva.add("*nessuna preferenza*");//da sostituire con classe Candidato!!!
		listaProva.add("Francesco Totti");//da sostituire con classe Candidato!!!
		listaProva.add("Daniele De Rossi");//da sostituire con classe Candidato!!!
		listaProva.add("Alessandro Florenzi");//da sostituire con classe Candidato!!!
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel<String>(listaProva.toArray(new String[0])));
		comboBox.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		comboBox.setBounds(135, 40, 175, 30);
		add(comboBox);
		
		JButton btnNewButton = new JButton("VOTA");
		btnNewButton.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		btnNewButton.setBounds(160, 80, 120, 30);
		add(btnNewButton);
	}
}