package Disparos;

import javax.swing.ImageIcon;

import Entidades.*;
import Inteligencias.InteligenciaDisparoJugador;

public class DisparoMejorado extends DisparoJugador {

	public DisparoMejorado(int velocidad,int x,int y) {
		super(velocidad,x,y);
		
		this.damage= 50;
		
		this.setInteligencia(new InteligenciaDisparoJugador(this));
		inicializarArregloImg();
	}
	
	private void inicializarArregloImg() {
		this.imagen[0]= new ImageIcon(this.getClass().getResource("/img/disparoMejorado.png"));
	}	
	
}
