package Principal;

public class MapaBase extends Mapa {
	
	public MapaBase() {
		this.enemigos= new EnemigoBase[5];
		this.obstaculos= new Obstaculo[10];
		int x= 20;
		int y= 20;
		for(int i =0;i<enemigos.length;i++) {
<<<<<<< HEAD
			enemigos[i]=new EnemigoBase(100,x,y);
=======
			enemigos[i]=new EnemigoBase(5,x,y);
>>>>>>> e940f06e43b863b57886ec5b5d7e805e11cd5af0
			x+=30;
			y+=30;
		}
	}
}
