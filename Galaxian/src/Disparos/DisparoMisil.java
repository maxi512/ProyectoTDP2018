
package Disparos;

import javax.swing.ImageIcon;

import Inteligencias.InteligenciaDisparoJugador;

public class DisparoMisil extends DisparoJugador {
	public DisparoMisil(int velocidad,int x,int y) {
		super(velocidad,x,y);
		
		this.damage= 100;
		
		this.setInteligencia(new InteligenciaDisparoJugador(this));
		inicializarArregloImg();
	}
	
	private void inicializarArregloImg() {
		this.imagen[0]= new ImageIcon(this.getClass().getResource("/img/misil.gif"));
	}	
	
	
}
