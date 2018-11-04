package Entidades;

public class EscudoKamikaze extends Escudo {

	
	public EscudoKamikaze(Jugador j) {
		super(j);
		j.cambiarGrafico(1);
		j.setImagenActual(1);
	}

	@Override
	public void recibirDaño(int daño) {
		j.setVida(j.getVida()-daño);
	}
	
	public void recibirDañoKamikaze(int daño) {
		j.setEscudo(new EscudoNormal(j));
	}
	
}
