package Principal;

import javax.swing.ImageIcon;

public class Jugador extends Entidad {
	
	protected int vida;
	
	public Jugador(int x, int y) {
		super(10,x,y);
		vida=100;
		inicializarArregloImg();
	}
	
	private void inicializarArregloImg() {
		this.imagen[0]= new ImageIcon(this.getClass().getResource("/img/naveFinal1.png"));
	}
	
}
