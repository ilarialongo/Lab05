package it.polito.tdp.angrammi.model;

import java.util.List;
import java.util.Set;

public class TestModel {

	public static void main(String[] args) {
	Model model= new Model();
	Set<String> ana_dog = model.anagrammi("ciao") ;
	System.out.println(ana_dog) ;
	List<String> corrette = model.risultatoCorrette(ana_dog);
	System.out.println(corrette);
	List<String> errate = model.risultatoErrate(ana_dog);
	System.out.println(errate);
	

	}

}
