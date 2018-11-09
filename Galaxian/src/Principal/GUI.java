package Principal;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class GUI extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	private Key left = new Key();
	private Key right = new Key();
	private Key space = new Key();

	private JLabel [] labelPuntaje;
	private JLabel labelVida,finPartidaGanar,finPartidaPerder;
	private Juego j;
	private JPanel panelFinPartida;
	
	private ContadorTiempo tiemp1;
	private TiempoJugador tiempo;
	private TiempoDisparo tiempoDisparo;
	private JButton bSalir,bReiniciar;
	
	
	public class Key{
		private boolean isKeyDown = false;
        public void toggle(boolean isKeyDown){
            this.isKeyDown = isKeyDown;
        }
        public boolean isKeyDown(){
            return isKeyDown;
        }
	}
	
	public GUI() {
		setResizable(false);
		getContentPane().setBackground(new Color(0, 0, 0));
		setBounds(new Rectangle(100, 20, 600, 700));
		getContentPane().setBounds(new Rectangle(0, 0, 600, 700));
		getContentPane().setLayout(null);
		
		armarBotones();
		armarLabelFinPartida();
		armarPanelJuego();
		
		
		panelFinPartida = new JPanel();
		panelFinPartida.setBounds(0, 0, 600, 700);
		panelFinPartida.setLayout(null);
		
		
		
		iniciarHilos();		
	}
	
	public void toggleKey(int keyCode, boolean isPressed){
        if(keyCode == KeyEvent.VK_RIGHT)
            right.toggle(isPressed);
        if(keyCode == KeyEvent.VK_LEFT)
            left.toggle(isPressed);
        if(keyCode == KeyEvent.VK_SPACE)
            space.toggle(isPressed);
    }
	
	private void armarPanelJuego() {
		OyentePanel oc= new OyentePanel();
		addKeyListener(oc);
	    j= new Juego(this);
	       
	    //LABEL PUNTAJE
	    labelPuntaje= new JLabel[8];
	    for(int i=0;i<labelPuntaje.length;i++) {
	     	ImageIcon img= new ImageIcon(this.getClass().getResource("/img/numeros/Sin título-3.png"));
	      	labelPuntaje[i]=new JLabel(img);
	       	labelPuntaje[i].setBounds(420+i*20, 20, 30, 30);
	       	labelPuntaje[i].setVisible(true);
	       	getContentPane().add(labelPuntaje[i]);
	    }
	      
	       
	    //LABEL VIDA
	    labelVida= new JLabel();
	    labelVida.setBounds(0,0,100,50);
	    labelVida.setForeground(Color.WHITE);
	    labelVida.setText("VIDA: ");
	    getContentPane().add(labelVida);
	        
	    //Hilos
	    tiemp1=new ContadorTiempo(j);
	    tiempo= new TiempoJugador(j);
	    tiempoDisparo= new TiempoDisparo(j);
	    
	}
	
	private void iniciarHilos() {
		tiempo.start();
		tiemp1.start();
	    tiempoDisparo.start();
	}
	
	private void armarBotones() {
		
		bSalir = new JButton("");
		bSalir.setBorder(null);
		bSalir.setBackground(new Color(0, 0, 0));
		bSalir.setIcon(new ImageIcon(GUI.class.getResource("/img/exit.png")));
		oyenteSalir os= new oyenteSalir();
		bSalir.addActionListener(os);
		
		bReiniciar = new JButton("");
		bReiniciar.setIcon(new ImageIcon(GUI.class.getResource("/img/jugardevuelta.png")));
		bReiniciar.setBorder(null);
		bReiniciar.setBackground(new Color(0, 0, 0));
		OyenteReiniciarJuego oj= new OyenteReiniciarJuego();
		bReiniciar.addActionListener(oj);
	}
	
	private void armarLabelFinPartida() {
		finPartidaPerder = new JLabel("");
		finPartidaPerder.setIcon(new ImageIcon(GUI.class.getResource("/img/pantallaPerder.jpg")));
		finPartidaPerder.setBounds(0, 0, 600, 700);
		
		
		finPartidaGanar = new JLabel("");
		finPartidaGanar.setIcon(new ImageIcon(GUI.class.getResource("/img/pantallaGanar.jpg")));
		finPartidaGanar.setBounds(0, 0, 600, 700);
	}
	
	public JLabel[] getLabelPuntaje() {
		return labelPuntaje;
	}
	
	public JLabel getLabelVida() {
		return labelVida;
	}
		
	public void terminar(int i) {
		getContentPane().removeAll();
		getContentPane().repaint();
		if(i==0) {
			bSalir.setBounds(203, 472, 200, 50);
			bReiniciar.setBounds(38, 321, 530, 50);
			panelFinPartida.add(finPartidaGanar);
		}
		else {
			bSalir.setBounds(203, 472, 200, 50);
			bReiniciar.setBounds(38, 345, 530, 50);
			panelFinPartida.add(finPartidaPerder);
		}
		panelFinPartida.add(bSalir);
		panelFinPartida.add(bReiniciar);
		getContentPane().add(panelFinPartida);
	}
	
	private void cerrar() {
		this.setVisible(false);
		this.dispose();
	}
	
	public Key getLeft() {
		return left;
	}
	
	public Key getRight() {
		return right;
	}
	
	public Key getSpace() {
		return space;
	}
	
	///OYENTES
	private class OyentePanel implements KeyListener{
		public void keyPressed(KeyEvent arg0) {
			toggleKey(arg0.getKeyCode(),true);
		}
		public void keyReleased(KeyEvent arg0) {
			toggleKey(arg0.getKeyCode(),false);
		}
		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}
	}

	private class oyenteSalir implements ActionListener{
		public void actionPerformed(ActionEvent evt) {
			cerrar();
		}
	}

	private class OyenteReiniciarJuego implements ActionListener{
		public void actionPerformed(ActionEvent evt) {
			GUIMenu menu= new GUIMenu();
			menu.setVisible(true);
			cerrar();
		}
	}
}
