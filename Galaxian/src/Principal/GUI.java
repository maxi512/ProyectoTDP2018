package Principal;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GUI extends JFrame {
	private static final long serialVersionUID = 1L;

	private JPanel panel;
	//private JLabel dibujo;

	
	private Juego j;
	private ContadorTiempo tiempo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);					//que es esto?????
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
		});
		
		getContentPane().setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 600);
        setResizable(false);
        panel= new JPanel();
        setContentPane(panel);
        panel.setBackground(Color.BLACK);
        panel.setLayout(null);
        
		j=new Juego(this);
		tiempo= new ContadorTiempo(j);
		tiempo.start();
		
	}
	
	protected void mover(KeyEvent key){
		j.mover(key.getKeyCode());
		this.repaint();
	}
	
}
