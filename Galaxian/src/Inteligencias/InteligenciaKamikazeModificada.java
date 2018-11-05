package Inteligencias;

import Entidades.Enemigo;
import Principal.Juego;

public class InteligenciaKamikazeModificada extends InteligenciaKamikaze{
	
	
	public InteligenciaKamikazeModificada(Enemigo e, Juego j) {
		super(e,j);
	}
	
	public void mover() {
		super.mover();
		if(this.enemigo.getVida()<=50) {
			this.enemigo.setInteligencia(new InteligenciaMareado(this.enemigo));
		}
	}
}
