package Principal;

public class ContadorTiempo extends Thread{
	private Juego elJuego;
	private boolean seguir;
	
	ContadorTiempo(Juego j){
		this.elJuego= j;
		seguir=true;
	}
	
	public void run() {
		boolean cambiarNivel=false;
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
			//elJuego.manage();
			elJuego.actualizarLabels();
			
			
			//Me fijo si tengo que cambiar de nivel
			if(elJuego.jugadorVivo() && (elJuego.nivelActual()<=elJuego.maxNiveles())) {
				cambiarNivel= !elJuego.hayEnemigos();
			}
		
			if(cambiarNivel) {
				elJuego.cambiarNivel();
				cambiarNivel=false;
			}
			
			
			seguir= elJuego.continuarJuego();
		}
		elJuego.terminarJuego();
	}
}
