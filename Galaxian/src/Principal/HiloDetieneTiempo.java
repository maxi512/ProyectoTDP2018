package Principal;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import Entidades.Disparo;
import Entidades.Entidad;
import Inteligencias.Inteligencia;
import Inteligencias.InteligenciaObstaculo;

public class HiloDetieneTiempo extends Thread {
	
	private Juego elJuego;
	
	
	
	///NO ANDA
	public HiloDetieneTiempo(Juego j){
		this.elJuego= j;
	}
	
	public void run() {
		LinkedList<Entidad> listaEntidades = elJuego.getListaEntidades();
		LinkedList<Disparo> listaDisparo = elJuego.getListaDisparos();

		Map<Entidad,Inteligencia>mapeo= new HashMap<Entidad ,Inteligencia>();
		
		//Map<Entidad,Inteligencia>mapeoDisparo= new HashMap<Disparo ,Inteligencia>();

		for(Entidad e: listaEntidades) {
			mapeo.put(e, e.getInteligencia());
			e.setInteligencia(new InteligenciaObstaculo());
		}
		
		for(Disparo d: listaDisparo) {
			mapeo.put(d,d.getInteligencia());
			d.setInteligencia(new InteligenciaObstaculo());
		}
		
		try {
			Thread.sleep(2000);
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("antes de volver a poner inteligencia");
		
		for(Entidad e: listaEntidades) {
			if(mapeo.get(e)!=null) {
				System.out.println("Inteligencia no es nula");
			}
			e.setInteligencia(mapeo.get(e));
		}
		
		for(Disparo d: listaDisparo) {
			d.setInteligencia(mapeo.get(d));
		}		
		
		System.out.println("despues de poner inteligencia");
		
			
	}
}
