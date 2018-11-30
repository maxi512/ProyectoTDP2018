package Armas;

import java.util.LinkedList;

import Disparos.Disparo;
import Disparos.DisparoEnemigo;
import Entidades.PrimerBoss;

public class ArmaBoss extends Arma {

	private PrimerBoss e;
	
	public ArmaBoss(PrimerBoss e) {
		this.e=e;
	}
	
	public LinkedList<DisparoEnemigo> generarDisparoBoss() {
		LinkedList<DisparoEnemigo>lista=new LinkedList<DisparoEnemigo>();
		DisparoEnemigo d1 =new DisparoEnemigo(5,(int)e.getPos().getX()+(e.getGrafico().getWidth()/2 -5),(int)e.getPos().getY()+55);
		DisparoEnemigo d2 =new DisparoEnemigo(5,(int)e.getPos().getX()+(e.getGrafico().getWidth()/2 +5),(int)e.getPos().getY()+60);
		lista.add(d1);
		lista.add(d2);
		return lista;
	}

	@Override
	public Disparo generarDisparo(int x, int y) {
		// TODO Auto-generated method stub
		return null;
	}

}
