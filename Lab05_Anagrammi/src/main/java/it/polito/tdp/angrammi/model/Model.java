package it.polito.tdp.angrammi.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import it.polito.tdp.anagrammi.DAO.AnagrammaDAO;

public class Model {
	private AnagrammaDAO dao= new AnagrammaDAO();
	Set <String> soluzione;
	List<String> corrette= new ArrayList<>();
	List<String> errate= new ArrayList<>();
	
	public Set <String> anagrammi(String parola) {
		if (this.check(parola)==false) {
			throw new IllegalStateException("Inserire una parola valida\n");
		}
		this.soluzione=new HashSet<>();
		List <Character> disponibili= new ArrayList<>();
		parola.toUpperCase();
		for (int i=0; i<parola.length();i++) {
			disponibili.add(parola.charAt(i));	
		}
		cerca("", 0, disponibili);
		return soluzione;	
	}
	private void cerca(String parziale, int livello, List <Character> disponibili) {
		if (disponibili.size()==0) {
			this.soluzione.add(parziale);
		}
		String temp;
		for (Character c: disponibili) {
			temp=parziale+c;
			List <Character> rimanenti= new ArrayList<>(disponibili);
			rimanenti.remove(c);
			cerca(temp, livello+1,rimanenti);	
		}
				
	}
	
	
	
	/* public List<String> risultatoCorrette(String parola) {
		//List<String> soluzione1= this.anagrammi(parola);
		for (String s: this.anagrammi(parola) ) {
			if (dao.isCorrect(s)==true) {
				corrette.add(s);
		}
		}
		return corrette;
		} */
	
	public List<String> risultatoCorrette(Set<String> soluzione) {
		//List<String> soluzione1= this.anagrammi(parola);
		soluzione=this.soluzione;
		for (String s: soluzione) {
			if (dao.isCorrect(s)==true) {
				corrette.add(s);
		}
		}
		return corrette;
		}
	
	
	
	public List<String> risultatoErrate(Set<String> soluzione) {
				soluzione=this.soluzione;
				for (String s: soluzione) {
					if (dao.isCorrect(s)==false) {
						errate.add(s);
					}
				}
				return errate;
	}

	public boolean check (String p) {
		boolean flag=true;
		for (int i=0; i<p.length();i++) {
			if (!Character.isLetter(p.charAt(i))) {
				flag=false;
			}
		}
		return flag;
	}
   
	
}
