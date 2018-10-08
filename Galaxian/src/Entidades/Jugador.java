package Entidades;


import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import Colisionadores.*;

public class Jugador extends Entidad {
	
	int dx;
	int dy;
	
	
	public Jugador(int x, int y) {
		super(12,x,y);
		
		this.vida=200;
		
		inicializarArregloImg();
	}
	
	private void inicializarArregloImg() {
		this.imagen[0]= new ImageIcon(this.getClass().getResource("/img/naveFinal1.png"));
	}
	
	public Disparo crearDisparo() {
		Disparo disp= new Disparo(5,(int)pos.getX()+(this.getGrafico().getWidth()/2 -1),(int)pos.getY()-12);
		return disp;
	}
	
	public void mover() {
        pos.setLocation(pos.x+dx, pos.y+dy);
        if (pos.x < 10) {
            pos.x = 10;
        }
        if (pos.x > 536)
            pos.x = 536;
        this.cambiarGrafico(0);
    }
   
   
     public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        switch (key){  
            case KeyEvent.VK_LEFT :
                dx = -velocidad;
                break;
            case KeyEvent.VK_RIGHT :
                dx = velocidad;
                break;
        }
    }
 
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
 
        switch (key){   
            case KeyEvent.VK_LEFT :
                dx = 0;
                break;
            case KeyEvent.VK_RIGHT :
                dx = 0;
                break;
        }
 
    }
	
	
	//METODOS PROVISORIOS
	public void colisionar(Entidad e) {
		ColisionadorJugador col= new ColisionadorJugador(this);
		e.serColisionado(col);
	}
	
	public void serColisionado(Colision col) {
		col.afectarJugador(this);
	}
}
