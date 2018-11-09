package Principal;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUIMenu extends JFrame{
	private static final long serialVersionUID = 1L;
	
	private JButton bJugar,bSalir;
	private JPanel panel;

	public GUIMenu() {
		
		setResizable(false);
		setBounds(100, 20, 600, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel= new JPanel();
		panel.setLayout(null);
		JLabel imagenFondo= new JLabel(new ImageIcon(this.getClass().getResource("/img/panelFinal.jpg")));
		imagenFondo.setSize(600, 700);
		imagenFondo.setLocation(0, 0);
		panel.add(imagenFondo);
		getContentPane().add(panel);
		
		bJugar = new JButton();
		bJugar.setBorder(null);
		bJugar.setBackground(new Color(0, 0, 0));
		bJugar.setIcon(new ImageIcon(GUIMenu.class.getResource("/img/play1.png")));
		bJugar.setBounds(185, 325, 230, 50);
		oyenteJugar oj= new oyenteJugar();
		bJugar.addActionListener(oj);
		panel.add(bJugar);
		
		bSalir = new JButton();
		bSalir.setBorder(null);
		bSalir.setBackground(new Color(0, 0, 0));
		bSalir.setIcon(new ImageIcon(GUIMenu.class.getResource("/img/exit.png")));
		bSalir.setBounds(194, 471, 200, 50);
		oyenteSalir os= new oyenteSalir();
		bSalir.addActionListener(os);
		panel.add(bSalir);
		
		
	}
	
	private void cerrar() {
		this.setVisible(false);
		this.dispose();
	}
	
	////OYENTES
	private class oyenteJugar implements ActionListener{
		
		public void actionPerformed(ActionEvent evt){
			GUI game= new GUI();
			game.setVisible(true);
			cerrar();
        }	
	}
	
	private class oyenteSalir implements ActionListener{
		public void actionPerformed(ActionEvent evt) {
			cerrar();
		}
	}
}
