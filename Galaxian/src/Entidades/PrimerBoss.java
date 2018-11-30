package Entidades;

import javax.swing.ImageIcon;

import Armas.*;
import Colisionadores.Colision;
import Colisionadores.ColisionadorEnemigo;
import Inteligencias.*;

public class PrimerBoss extends Enemigo {
	
	private ArmaBoss arma;
	
	public PrimerBoss(int velocidad,int x, int y) {
		super(velocidad,x,y);
		
		this.vida= 500;
		this.vidaInicial=vida;
		this.puntaje=1000;
		
		arma= new ArmaBoss(this);
		
		inicializarArregloImg();
		this.setInteligencia(new InteligenciaBoss(this));
		this.puntaje= 1000;
		
	}
	
	private void inicializarArregloImg() {
		this.imagen[0]= new ImageIcon(this.getClass().getResource("/img/boss.png"));
	}
	
	public void mover() {
		this.inteligencia.mover();
	}
	
	public void serColisionado(Colision col) {
		col.afectarEnemigo(this);
	}
	
	public void colisionar(Entidad e) {
		ColisionadorEnemigo col= new ColisionadorEnemigo(this);
		e.serColisionado(col);
	}
	
	public ArmaBoss getArmaBoss() {
		return arma;
	}
		
	public void disparar() {
		inteligencia.disparar();
	}
}

