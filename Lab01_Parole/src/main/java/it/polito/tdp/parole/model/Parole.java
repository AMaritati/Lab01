package it.polito.tdp.parole.model;

import java.util.*;


public class Parole {
	LinkedList<String> listaP; 
		
	public Parole() {   // costruttore
		listaP = new LinkedList<String>();
	}
	
	public void addParola(String p) {
		listaP.add(p);
	}
	
	public List<String> getElenco() {
		List<String> listaOrdinata = new LinkedList<String>(listaP);
		Collections.sort(listaOrdinata, new Comparatore());		
		return listaP;
	}
	
	public void reset() {
		listaP.clear();
	}

}
