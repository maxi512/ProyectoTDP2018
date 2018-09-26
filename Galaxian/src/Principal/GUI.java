package Principal;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GUI extends JFrame {
	private static final long serialVersionUID = 1L;

	private JPanel panel;
	private JLabel [] labelPuntaje;
	private Juego j;
	private ContadorTiempo tiempo;
	private OyenteDisparo OyenteMouse;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI() {
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				mover(arg0);
			}
			public void keyReleased(KeyEvent arg) {
				destruirEnemigo(arg);
			}
		});
		
		getContentPane().setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 900);
        setResizable(false);
        panel= new JPanel();
        
        setContentPane(panel);
        panel.setBackground(Color.BLACK);
        panel.setLayout(null);
        
        //LABEL PUNTAJE
        labelPuntaje= new JLabel[8];
        for(int i=0;i<labelPuntaje.length;i++) {
        	ImageIcon img= new ImageIcon(this.getClass().getResource("/img/Sin t�tulo-3.png"));
        	labelPuntaje[i]=new JLabel(img);
        	labelPuntaje[i].setBounds(420+i*20, 20, 30, 30);
        	labelPuntaje[i].setVisible(true);
        	panel.add(labelPuntaje[i]);
        }

        //OYENTE MOUSE
        OyenteMouse= new OyenteDisparo();
        panel.addMouseListener(OyenteMouse);
        
		j=new Juego(this);
		
		//INICIALIZO HILOS
		tiempo= new ContadorTiempo(j);
		tiempo.start();
		
		
	}
	
	protected void mover(KeyEvent key){
		j.mover(key.getKeyCode());
		this.repaint();
	}
	
	protected void destruirEnemigo(KeyEvent key) {
		if(key.getKeyCode()==KeyEvent.VK_SPACE) {
			j.eliminarEnemigo();
			j.actualizarLabels();
			//labelPuntaje.setText("Puntaje: "+j.getPuntajeTotal());
		}
	}
	
	
	
	private class OyenteDisparo implements MouseListener{

		//CURSOR TIENE QUE ESTAR ADENTRO DEL LABEL
		public void mouseClicked(MouseEvent e) {
			j.eliminarEnemigo();
			System.out.println("Elimine enemigo");
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}

	public JLabel[] getLabelPuntaje() {
		return labelPuntaje;
	}
}
