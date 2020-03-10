package it.polito.tdp.parole.model;

import java.util.Comparator;

public class Comparatore implements Comparator<String>  {

	public int compare (String s1,String s2) {
		return s1.compareTo(s2);
	}
}
