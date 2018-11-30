package Entidades;

import java.util.Random;

import PowerUps.*;
import Principal.Juego;

public class GeneradorPowerUp {
	
	private Random r;
	private Juego juego;
	private int probabilidad;
	
	public GeneradorPowerUp(Juego j,int p) {
		r= new Random();
		this.juego=j;
		probabilidad= p;
		PowerUpTiempo.setInstanciaNull();
	}
	
	public PowerUp getPowerUpAleatorio() {
		int num = r.nextInt(probabilidad);
		PowerUp p;
		if(num==1) {
			p=getPowerUpRandom();
		}
		else {
			p=null;
		}
		return p;
	}
	
	private PowerUp getPowerUpRandom() {
		int num=r.nextInt(6);
		PowerUp p=null;
		switch(num) {
		case 0:
			p=new PowerUpEscudo(12,0,0);
			break;
		case 1:
			p=new PowerUpArmaRapida(12,0,0);
			break;
		case 2:
			p=new PowerUpArmaMejorada(12,0,0);
			break;
		case 3:
			p= new PowerUpMisil(12,0,0);
			break;
		case 4:
			p=PowerUpTiempo.getInstancia(12,0,0);
			if(p==null) {
				p=new PowerUpVida(12,0,0);	
			}
			break;
		case 5:
			p=new PowerUpVida(12,0,0);
			break;
		}
		p.setJuego(juego);
		return p;
	}
}
