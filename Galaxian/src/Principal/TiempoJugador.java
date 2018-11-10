package Principal;

public class TiempoJugador extends Thread {
	private Juego elJuego;
	private boolean seguir;
		
		TiempoJugador(Juego j){
			this.elJuego= j;
			seguir=true;
		}
		
		public void run() {
			while(seguir) {
				try {
					Thread.sleep(30);
				}
				catch(InterruptedException e) {
					e.printStackTrace();
				}
				elJuego.moverJugador();
				elJuego.Actualizar();
				
				seguir= elJuego.continuarJuego();
			}
		}
}
