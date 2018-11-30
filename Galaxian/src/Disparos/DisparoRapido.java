package Disparos;

import javax.swing.ImageIcon;

import Inteligencias.InteligenciaDisparoJugador;

public class DisparoRapido extends DisparoJugador {
	
	public DisparoRapido(int velocidad, int x, int y) {
		super(velocidad, x, y);
		
		this.damage=10;
		
		this.setInteligencia(new InteligenciaDisparoJugador(this));
		inicializarArregloImg();
	}
	
	
	private void inicializarArregloImg() {
		this.imagen[0]= new ImageIcon(this.getClass().getResource("/img/disparoChico.png"));
	}
	
}
