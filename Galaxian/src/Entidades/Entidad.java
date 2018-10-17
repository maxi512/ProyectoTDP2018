package Entidades;

import javax.swing.*;
import java.awt.*;

import Colisionadores.*;
import Inteligencias.*;

public abstract class Entidad {
	
	protected Inteligencia inteligencia;
	
	//ATRIBUTOS
	protected int velocidad;
	protected int vida;
	protected JLabel grafico;
	protected Icon []imagen;
	protected Point pos;
	protected int puntaje;
	
	//CONSTRUCTOR
	protected Entidad(int velocidad,int x,int y) {
		this.velocidad= velocidad;
		pos = new Point (x,y);
		imagen= new Icon[30];
	}
	
	//METODOS
	public JLabel getGrafico() {
		if(this.grafico==null) {
			this.grafico=new JLabel (this.imagen[0]);
			this.grafico.setBounds(this.pos.x,this.pos.y,this.imagen[0].getIconWidth(),this.imagen[0].getIconHeight()); //PREGUNTAR!!!!!!!!!!　　　　
		}
		return this.grafico;
	}
	
	public void mover(int dir){
        	if(dir!=-1) {//Si el movimiento que se quiere realizar es a la izquierda o derecha arriba o abajo
                switch (dir) {
                    case 0 : //Izquierda
                        if(pos.getX()>10)pos.setLocation(pos.x - velocidad, pos.y);
                        break;
                    case 1 : //Derecha
                    	if(pos.getX()<536)pos.setLocation(pos.x + velocidad, pos.y);
                        break;
                    case 2: //Arriba
                    	pos.setLocation(pos.x,pos.y-velocidad);
                    	break;
                    case 3:{//Abajo
                    		pos.setLocation(pos.x,pos.y+velocidad);	
                    		break;
                    		}	
                }
                cambiarGrafico(0);
            }
        }
	
	protected void cambiarGrafico(int dir){
        if(this.grafico != null){
            this.grafico.setIcon(this.imagen[dir]);
            this.grafico.setBounds(this.pos.x, this.pos.y, this.imagen[dir].getIconWidth(), this.imagen[dir].getIconHeight());
        }
    }
	
	public Rectangle getRectangle() {
		return new Rectangle((int)pos.getX(),(int)pos.getY(),grafico.getWidth(),grafico.getHeight());
	}
	
	public void destruir() {
		grafico.setIcon(null);
		vida=0;
	}
	
	public void setPuntaje(int x) {
		puntaje=x;
	}
	
	public void setInteligencia(Inteligencia i) {
		inteligencia =i;
	}
	
	public int getPuntaje() {
		return puntaje;
	}
	
	public void mover() {
		
	}
	
	public Point getPos() {
		return pos;
	}

	//METODOS PROVISORIOS
	public int getVida() {
		return vida;
	}
	
	public void quitarVida(int v) {
		vida-= v;
	}
	
	public abstract void serColisionado(Colision col); //Deben ser abstractas
	
	public abstract void colisionar(Entidad e);// Deben ser abstractas 

	public void disparar() {
		
	}
}
