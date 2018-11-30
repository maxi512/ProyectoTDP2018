package Principal;

import Entidades.*;
import Inteligencias.*;

public class VisitorDetieneTiempo {
	
	public VisitorDetieneTiempo() {

	}
	
	public void detenerEnemigo(Enemigo e) {
		e.setInteligencia(new InteligenciaObstaculo());
	}
}
