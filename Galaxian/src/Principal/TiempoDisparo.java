package Principal;

public class TiempoDisparo extends Thread  {
	private Juego elJuego;
	
	public TiempoDisparo(Juego j){
		this.elJuego= j;
	}
	
	public void run() {
		while(true) {
			try {
				Thread.sleep(25);
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
			elJuego.moverDisparo();
			elJuego.eliminarDisparos();
			
		}
	}
}
