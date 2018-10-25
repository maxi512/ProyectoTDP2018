package Principal;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GUI extends JFrame {
	/**
	* ATRIBUTOS DE PRUEBA
	*/
	  public Key left = new Key();
	  public Key right = new Key();
	  public Key space = new Key();
	/**
	 * ACA TERMINAN LOS ATRIBUTOS DE PRUEBA
	 */
	
	private static final long serialVersionUID = 1L;

	private JPanel panel;
	private JLabel [] labelPuntaje;
	private JLabel labelVida;
	
	private Juego j;
	private ContadorTiempo tiemp1;
	private TiempoJugador tiempo;
	
	//ATRIBUTOS PROVISORIOS
	private TiempoDisparo tiempoDisparo;
	
	public class Key{
		private boolean isKeyDown = false;
        public void toggle(boolean isKeyDown){
            this.isKeyDown = isKeyDown;
        }
        public boolean isKeyDown(){
            return isKeyDown;
        }
	}
	/**
	 * Create the frame.
	 */
	public GUI() {		
		addKeyListener(new KeyAdapter() {
						
			@Override
			public void keyPressed(KeyEvent arg0) {
				toggleKey(arg0.getKeyCode(),true);
			}
			public void keyReleased(KeyEvent arg0) {
				toggleKey(arg0.getKeyCode(),false);
			}
		});
		
		getContentPane().setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 20, 600, 700);
        panel= new JPanel();
        setResizable(false);
        
        setContentPane(panel);
        panel.setBackground(Color.BLACK);
        panel.setLayout(null);
    
        
        j=new Juego(this);
        
      //LABEL PUNTAJE
        labelPuntaje= new JLabel[8];
        for(int i=0;i<labelPuntaje.length;i++) {
        	ImageIcon img= new ImageIcon(this.getClass().getResource("/img/numeros/Sin título-3.png"));
        	labelPuntaje[i]=new JLabel(img);
        	labelPuntaje[i].setBounds(420+i*20, 20, 30, 30);
        	labelPuntaje[i].setVisible(true);
        	panel.add(labelPuntaje[i]);
        }
        //LABEL VIDA
        
        labelVida= new JLabel();
        labelVida.setBounds(0,0,100,50);
        labelVida.setForeground(Color.WHITE);
        labelVida.setText("VIDA: ");
        panel.add(labelVida);
        
        //Hilos
        tiempoDisparo= new TiempoDisparo(j);
        tiempoDisparo.start();
        tiempo= new TiempoJugador(j);
        tiempo.start();
        tiemp1=new ContadorTiempo(j);
        tiemp1.start();
	}
	

	public void toggleKey(int keyCode, boolean isPressed){
        if(keyCode == KeyEvent.VK_RIGHT)
            right.toggle(isPressed);
        if(keyCode == KeyEvent.VK_LEFT)
            left.toggle(isPressed);
        if(keyCode == KeyEvent.VK_SPACE)
            space.toggle(isPressed);
    }

	public JLabel[] getLabelPuntaje() {
		return labelPuntaje;
	}
	
	public JLabel getLabelVida() {
		return labelVida;
	}

	public void destruir() {
		panel.removeAll();
		this.repaint();
	}
}
	
	