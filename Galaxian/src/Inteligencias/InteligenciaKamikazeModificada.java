package Inteligencias;

import Entidades.Enemigo;
import Principal.Juego;

public class InteligenciaKamikazeModificada extends InteligenciaKamikaze{
	
	
	public InteligenciaKamikazeModificada(Enemigo e, Juego j) {
		super(e,j);
	}
	
	
	
	public void verificarCambio() {
		if(this.enemigo.getVida()<=enemigo.getVidaInicial()*0.5) {
			this.enemigo.setInteligencia(new InteligenciaMareado(this.enemigo));
		}
	}
}
