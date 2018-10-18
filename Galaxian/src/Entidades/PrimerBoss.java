package Entidades;

import java.util.Random;

import javax.swing.ImageIcon;

import Colisionadores.Colision;
import Colisionadores.ColisionadorEnemigo;
import Inteligencias.InteligenciaEnemigo;

public class PrimerBoss extends Enemigo {
	
	
	private Random r;
	private static PrimerBoss primerBoss;
	
	private PrimerBoss(int velocidad,int x, int y) {
		super(velocidad,x,y);
		this.vida= 100;
		inicializarArregloImg();
		this.setPuntaje(7);
		this.setInteligencia(new InteligenciaEnemigo(this));
		
		r= new Random();
	}

	public static PrimerBoss getPrimerBoss(int velo,int x,int y) {
		if(primerBoss==null) {
			primerBoss= new PrimerBoss(velo,x,y);
			return primerBoss;
		}
		else {
			return null;
		}
		

	}
	
	private void inicializarArregloImg() {
		this.imagen[0]= new ImageIcon(this.getClass().getResource("/img/boss.png"));
	}
	public void mover() {
		this.inteligencia.mover();
	}
	
	//METODOS PROVISORIOS
	public void serColisionado(Colision col) {
		col.afectarEnemigo(this);
	}
	
	public void colisionar(Entidad e) {
		ColisionadorEnemigo col= new ColisionadorEnemigo(this);
		e.serColisionado(col);
	}
	
	
	public void disparar() {
		if(r.nextInt(10)==5) {
			DisparoEnemigo d1 =new DisparoEnemigo(5,(int)pos.getX()+(this.getGrafico().getWidth()/2 -5),(int)pos.getY()+55);
			DisparoEnemigo d2 =new DisparoEnemigo(5,(int)pos.getX()+(this.getGrafico().getWidth()/2 +5),(int)pos.getY()+60);
			juego.addDisparo(d1);
			juego.addDisparo(d2);
		}
	}
}

