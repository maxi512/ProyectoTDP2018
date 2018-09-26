package Principal;

import javax.swing.ImageIcon;

public class EnemigoBase extends Enemigo{
	public EnemigoBase(int velocidad,int x, int y) {
		super(velocidad,x,y);
		inicializarArregloImg();
		this.setPuntaje(7);
	}
	private void inicializarArregloImg() {
		this.imagen[0]= new ImageIcon(this.getClass().getResource("/img/Webp.net-gifmaker (2).gif"));
	}
}
