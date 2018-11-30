package Inteligencias;

import Entidades.Enemigo;

public class InteligenciaEnemigoArmaCambiaMareado extends InteligenciaEnemigoConArma {

	
	public InteligenciaEnemigoArmaCambiaMareado(Enemigo enem) {
		super(enem);
	}
	
	
	public void verificarCambio() {
		if(enemigo.getVida()<= enemigo.getVidaInicial()*0.3) {
			this.enemigo.setInteligencia(new InteligenciaMareado(this.enemigo));
		}
	}

}
