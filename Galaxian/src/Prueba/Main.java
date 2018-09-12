package Prueba;

public class Main {
	public static void main(String args[]) {
		Jugador jug= new Jugador(15);
		DispEnemigo disp= new DispEnemigo(10, 18);
		
		disp.colisionar(jug);
		if(jug.getVida()<0) {
			System.out.println("El jugador ha muerto");
		}
		else {
			System.out.println("La vida del jugador es: "+jug.getVida());
		}
	}
}
