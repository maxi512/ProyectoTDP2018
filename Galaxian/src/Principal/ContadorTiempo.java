package Principal;

public class ContadorTiempo extends Thread{
	private Juego elJuego;
	private boolean seguir;
	
	ContadorTiempo(Juego j){
		this.elJuego= j;
		seguir=true;
	}
	
	public void run() {
		while(seguir) {
			try {
				Thread.sleep(100);
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
			elJuego.mover();
			elJuego.detectarColisiones();
			elJuego.eliminarEntidades();
			elJuego.accionarDisparos();
			elJuego.agregarDisparos();
			elJuego.manage();
			elJuego.actualizarLabels();
			seguir=elJuego.jugadorVivo();
		}
		elJuego.terminarJuego();
	}
}
