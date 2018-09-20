package Principal;

import javax.swing.ImageIcon;

public class OtroEnemigo extends Enemigo{
	public OtroEnemigo(int velocidad,int x, int y) {
		super(velocidad,x,y);
		inicializarArregloImg();
	}
	private void inicializarArregloImg() {
		this.imagen[0]= new ImageIcon(this.getClass().getResource("/img/Webp.net-gifmaker (1).gif"));
	}
}

 