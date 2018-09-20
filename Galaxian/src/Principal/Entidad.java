package Principal;
import javax.swing.*;
import java.awt.*;
import Prueba.*;

public abstract class Entidad {
	
	//ATRIBUTOS
	protected int velocidad;
	protected int vida;
	protected JLabel grafico;
	protected Icon []imagen;
	protected Point pos;
	
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
        	if(dir!=-1) {//Si el movimiento que se quiere realizar es a la izquierda o derecha
                switch (dir) {
                    case 0 : //Izquierda
                        if(pos.getX()>10)pos.setLocation(pos.x - velocidad, pos.y);
                        break;
                    case 1 : //Derecha
                    	if(pos.getX()<340)pos.setLocation(pos.x + velocidad, pos.y);
                        break;
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
	
	public void destruir() {
		grafico.setIcon(null);
		vida=0;
	}
	//public abstract void serColisionado(Colision col);
}
