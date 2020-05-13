package exam.using.operators;

import java.util.*;

class OperatorsTest{

	public static void main(String [] args){
	
		//atribuição: Assignment
		//tipo mais abrangente = tipo menos abrangente
		//byte - short - int - long - float- double
		//char
		
		double d = 30; //double > int
		System.out.println(d);					
		//int i = d; nao converte: int < double
		float f = 10l; //float>long 
		//float f2 = 10d; //nao converte float<double
		
		//char nao recebe conversão
		short s = 65;
		System.out.println(s);
		byte b = 1;
		//char c = s; //short tem mesmo tamanho do char mas char nao recebe nada de outro tipo
		//char c = b; //nao funciona tbm
		
		//mas outros tipos maiores podem receber char
		char c = 65;
		int i = c;
		long l = c;
		//s = c; //nao converte
		//b = c; //nao converte
		
		//refrencias
		ArrayList<String> lista = new ArrayList<String>();
		ArrayList<String> l2 = lista; //ok

		List<String> l3 = lista; //ArrayList implementa List : ArrayList (menor abrangencia) < List 

		ArrayList<String> lista2 = new ArrayList<>(); //java 7 funciona o diamante (s/ especificar tipo do array)
		lista2 = lista;

	}


}