package Inteligencias;

import java.util.Random;

import Armas.ArmaBoss;
import Disparos.Disparo;

import Entidades.PrimerBoss;

public class InteligenciaBoss extends InteligenciaEnemigoConArma {
	
	private Random r;
	private PrimerBoss boss;
	
	public InteligenciaBoss(PrimerBoss enem) {
		super(enem);
		r= new Random();
		boss= enem;
	}
	
	public void disparar() {
		if(r.nextInt(25)==5) {
			ArmaBoss arma= boss.getArmaBoss();
			if(arma!=null) {
				for(Disparo d: boss.getArmaBoss().generarDisparoBoss())
					enemigo.getJuego().addDisparo(d);
			}
		}
	}

}
