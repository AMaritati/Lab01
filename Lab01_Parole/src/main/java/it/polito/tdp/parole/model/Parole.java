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
	
	public boolean controllaParola (String p) {
		char c;
		boolean result = true;
		
		for(int i=0;i<p.length();i++){
            c = p.charAt(i);
            if(!((Character.isLetter(c)))){
                result = false;
                return result;
            }
        }
        
		return result;
	}
	
	public List<String> getElenco() {
		List<String> listaOrdinata = new LinkedList<String>(listaP);
		Collections.sort(listaOrdinata, new Comparatore());		
		return listaOrdinata;
	}
	
	public void reset() {
		listaP.clear();
	}
	
	public void cancel (String s) {
		for (String p : listaP) {
			if(p.equals(s))
		       listaP.remove(s);
	}
		
	}
}
