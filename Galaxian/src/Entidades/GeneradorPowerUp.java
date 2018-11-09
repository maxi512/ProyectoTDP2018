package Entidades;

import java.util.Random;

import PowerUps.*;
import Principal.Juego;

public class GeneradorPowerUp {
	
	private Random r;
	private Juego juego;
	private int cantidadPowerUpTiempo;
	private int probabilidad;
	
	public GeneradorPowerUp(Juego j,int p) {
		r= new Random();
		this.juego=j;
		cantidadPowerUpTiempo=0;
		probabilidad= p;
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
		PowerUp p=new PowerUpEscudo(12,0,0);
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
			if(cantidadPowerUpTiempo==0) {
				p=new PowerUpTiempo(12,0,0);
				cantidadPowerUpTiempo=1;
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
