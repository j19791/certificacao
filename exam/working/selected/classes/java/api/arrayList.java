package exam.working.selected.classes.java.api;

import java.util.ArrayList;
import java.util.Iterator;

class ArrayListTest{
	
	public static void main(String ... args){
		//limitação do array: vc é obrigado a especificar sua dimensão
	
		//declaração
		ArrayList lista = new ArrayList();
		ArrayList<String> lista2 = new ArrayList<>(); //c/ generics

		//lista.add("") erro de compilacao
		lista2.add("primeiro");

		System.out.println(lista2.contains("primeiro")); //true/false . 

		System.out.println(lista2.remove("segundo")); //true se elemento foi removido , false se não existe elemento p/ remover
		
		//ArrayList aceita duplicatas
		lista2.add("primeiro");
		lista2.add("primeiro");

		System.out.println(lista2.remove("primeiro")); //remove apenas 1 elemento repetido no ArrayList

		Object objetos[] = lista2.toArray(); //copia os elementos do ArrayList p/ um [] de objetos. Sempre devolve um [] d eobjects
		
		
			
		String[] arrayString = lista2.toArray(new String[0]); //devolve um array de String mas é preciso passar como parametro uma string e seu tamanho. tamanho >=0 (java redimensiona automaticamente)

		ArrayList<String> lista3 = new ArrayList<>();
		lista3.add("1");
		lista3.add("2");
		lista3.add("3");



		lista2.addAll(lista3);//adiciona todos os elementos de 3 em 2
		
		System.out.println(lista2.get(3));//2

		lista2.add(0,"elemento 0"); //o add do arraylist sempre adiciona no final. especificando a posição no inicio
		
		System.out.println("tamanho da lista 2: " + lista2.size()); //tamanho 6
		//lista2.add(7,"elemento 999");Index out of bounds
		lista2.add(6,"elemento 999");//adicionando no final (array de tmamanho 6) . funciona


		//lista2.add(999,"elemento 999");//adicionado uma posição x.Index out of bounds
		

		lista2.remove(2);//remove elemento q esta na posição 2
		//lista2.remove(100);index out of bounds


		//System.out.println(lista2.get(10));//Index out of bounds em tempo de exec

		lista2.set(2,"segundo"); //troca o elemento da posição 2 pelo valor do 2o. parametro

		lista2.add("elemento 0");

		System.out.println(lista2.indexOf("elemento 0")); //retorna posição da primeira ocorrencia do ArrayList da esquerda p/ direita. Se não encotnrar, retorna -1
		System.out.println(lista2.lastIndexOf("elemento 0")); //retorna posição da primeira ocorrencia do ArrayList da direita p/ esquerda. Se não encotnrar, retorna -1
		

		System.out.println(lista2.size()); //numero de elemtnos no arrayList
		for(String elemento : lista2) System.out.println(elemento);

		System.out.println();
		//toda coleção tem seu iterator
		String atual;
		Iterator<String> it = lista2.iterator();
		while(it.hasNext()){ //enquanto existe um proximo elemento no ArrayList
			atual = it.next(); //devolve o elemento da iteração
			System.out.println("elemento atual: " + atual + " tamanho do ArrayList: " + lista2.size());			
			it.remove(); //iterator consegue remover o elemento atual
		}
		



		
			
	}




}