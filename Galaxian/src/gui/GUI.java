package gui;

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

	private JPanel contentPane;
	
	private JLabel dibujo;


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
		this.setResizable(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		this.agregarDibujo();
	}
	
	protected void mover(KeyEvent key){
		Rectangle pos = dibujo.getBounds();
		int newX=0;
		int newY = (int) pos.getY();
		int ancho = (int) pos.getWidth();
		int alto = (int) pos.getHeight();
		if (key.getKeyCode()==KeyEvent.VK_RIGHT&&pos.getX()<325) {
			newX = (int) pos.getX() + 10;
			dibujo.setBounds(newX, newY, ancho, alto);
		}
		if (key.getKeyCode()==KeyEvent.VK_LEFT&&pos.getX()>10) {
			newX = (int) pos.getX() - 10;
			dibujo.setBounds(newX, newY, ancho, alto);
		}
	}
	
	private void agregarDibujo(){
		ImageIcon imagen = new ImageIcon(this.getClass().getResource("/img/nave.png"));
		dibujo = new JLabel(imagen);
		dibujo.setBounds(165,490 , 50, 50);
		
		this.add(dibujo);
	}
}
