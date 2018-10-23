package Inteligencias;

import java.util.Random;

import Entidades.Enemigo;


public class InteligenciaMareado extends InteligenciaEnemigo{
	private Random r;
	
	public InteligenciaMareado(Enemigo e) {
		this.enemigo=e;
		r= new Random();
	}
	public void mover() {
		int posXEnemigo= (int)this.enemigo.getPos().getX();
		int posYEnemigo=(int)this.enemigo.getPos().getY();
		if(posYEnemigo>700)this.enemigo.getPos().setLocation(posXEnemigo, -10);
		for(int i=0; i<4;i++) {
			int a=(int) (r.nextDouble() * 2 + 0);
			this.enemigo.mover(a);
		}
		this.enemigo.mover(3);
	}
}
	
