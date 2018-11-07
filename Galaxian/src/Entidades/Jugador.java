package Entidades;


import javax.swing.ImageIcon;

import Armas.Arma;
import Armas.ArmaBasicaJugador;
import Colisionadores.*;
import Disparos.Disparo;

public class Jugador extends Entidad {
	
	private Arma arma;
	private Escudo escudo;
	
	
	public Jugador(int x, int y) {
		super(10,x,y);
		
		this.vida=100;
		
		arma= new ArmaBasicaJugador(this);
		
		
		inicializarArregloImg();
		
		escudo=new EscudoNormal(this);
	}
	
	private void inicializarArregloImg() {
		this.imagen[0]= new ImageIcon(this.getClass().getResource("/img/playerShip1_blue.png"));
		this.imagen[1]= new ImageIcon(this.getClass().getResource("/img/naveEscudo.png"));
	}
	
	public Disparo crearDisparo() {
		Disparo disp;
		disp = arma.generarDisparo();
		return disp;
	}
	
	public void sumarVida(int v) {
		this.vida+=v;
	}
	
	
	
	public void quitarVida(int daño) {
		escudo.recibirDaño(daño);
	}
	
	
	//METODOS PROVISORIOS
	public void colisionar(Entidad e) {
		ColisionadorJugador col= new ColisionadorJugador(this);
		e.serColisionado(col);
	}
	
	public void serColisionado(Colision col) {
		col.afectarJugador(this);
	}
	
	 public void Update(){
		 arma.Update();
	 }
	 
	 public void setArma(Arma a) {
		 this.arma=a;
	 }

	public void setVida(int i) {
		this.vida=i;
	}
	
	public void setEscudo(Escudo e) {
		this.escudo=e;
	}
	
	public void recibirDañoKamikaze(int daño) {
		escudo.recibirDañoKamikaze(daño);
	}

}
