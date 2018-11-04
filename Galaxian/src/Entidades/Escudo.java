package Entidades;

public abstract class Escudo {
	protected Jugador j;
	
	public Escudo(Jugador j) {
		this.j=j;
	}
	
	public abstract void recibirDaño(int daño); 
	
	public void recibirDañoKamikaze(int daño) {
		j.setVida(j.getVida()-daño);
	}
		
}
