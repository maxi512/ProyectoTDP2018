package Principal;

public class MapaBase extends Mapa {
	public MapaBase() {
		this.enemigos= new Enemigo[5];
		this.obstaculos= new Obstaculo[10];
		int x= 20;
		int y= 20;
		for(int i =0;i<enemigos.length;i++) {
			enemigos[i]=new EnemigoBase(100,x,y);
			x+=30;
			y+=30;
		}
	}
}
