	package lib;

import java.util.*;

public class Rotinas{


	static public List<Object> converterArrayList(Object [] array){
		
		List<Object> saida = new ArrayList<>();


		for(Object o : array)
			saida.add(o);

		return saida;

	}

	static public List<Integer> converterArrayList(int [] array){
		
		List<Integer> saida = new ArrayList<>();


		for(int o : array)
			saida.add(o);

		return saida;

	}

	static public void imprimirList(List<Object> l){

		for(Object $o : l)
			System.out.printf("%n: %1$s", $o);

			

	}

	
	static public List<Object> converterList(Object ... array){
		
		List<Object> saida = new ArrayList<>();


		for(Object o : array)
			saida.add(o);

		return saida;

	}

	static public void separar(){

		System.out.printf("%n");


	}

	static public void imprimir(String ... args){
		for(String $str : args){
			System.out.printf("%n %1$s", $str);
		}

	}

	
	static public void imprimir(int ... args){
		for(long $str : args){
			System.out.printf("%n %1$d", $str);
		}

	}

}