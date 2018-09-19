package Principal;

import javax.swing.ImageIcon;

public class EnemigoBase extends Enemigo{
	public EnemigoBase(int velocidad,int x, int y) {
		super(velocidad,x,y);
		inicializarArregloImg();
	}
	private void inicializarArregloImg() {
		this.imagen[0]= new ImageIcon(this.getClass().getResource("/img/EnemigoBasico.png"));
	}
}
