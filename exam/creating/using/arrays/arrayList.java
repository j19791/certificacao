import java.util.ArrayList;
import java.util.Iterator;

class ArrayListTest{

		static void percorre(ArrayList<String> lista){
			System.out.println("---------------------------------")		;
			for(String elemento: lista){
				System.out.println(elemento);

			}
			System.out.println("")		;		
		}

		static void percorre(String[] lista){
			System.out.println("---------------------------------")		;		
			for(String elemento: lista){
				System.out.println(elemento);

			}
			System.out.println("")	;		
		}


	static public void main (String ... args){

		ArrayList<String> caminhadas = new ArrayList<>();

		System.out.println(caminhadas.size());

		caminhadas.add("Higienopolis");

		System.out.println(caminhadas.size());
		

		boolean contem;
		
		//System.out.println(contem);nao compila pois a var local contem nao foi inicializada

		System.out.println(contem = caminhadas.contains("Jd. Paulista")); //compilador sabe q a variavel contem sera inicializada e compila e roda

		System.out.println(caminhadas.remove("Berrini"));//false

		String[] walkings = caminhadas.toArray(new String[0]);//copia os elementos de uma ArrayList para uma nova array. Precisa passar o tamanho. O arrayList consegue  aumentar o tamanho caso o valor especificado não seja suficiente

		ArrayListTest.percorre(walkings);

		ArrayList<String> pedaladas = new ArrayList<String>();

		pedaladas.add(0,"guararema");
		pedaladas.add(0,"salesopolis");

		caminhadas.add("Jd Paulista");

		ArrayListTest.percorre(caminhadas);
		
		caminhadas.add(0,"Alto da Boa Vista");

		ArrayListTest.percorre(caminhadas);

		ArrayList<String> atividades = new ArrayList<String>();
		atividades.addAll(caminhadas);
		atividades.addAll(pedaladas);

		ArrayListTest.percorre(atividades);

		Iterator<String> iterador = atividades.iterator();

		while(iterador.hasNext()){//ainda tem elementos p/ percorrer ??
			System.out.println(iterador.next());//pega e devolve o proximo elemento da lista

		}

		System.out.println("exercicio do livro");
		
		ArrayList<String> ss = new ArrayList<String>();
		ss.add("a");
		ss.add("b");
		ss.add("c");
		ss.add("d");
		for(String s:ss){
			System.out.println(s);
			if(s.equals("c")) s = "b"; //apesar de s ser atribuido por novo valor, que poderá dar a impressão falsa de loop infinito, o valor de s na proxima iteração será sempre o proximo elemento na lista, ignorando o vlr atribuido
			else if(s.equals("b")) s= "c";
			System.out.println(s);
		}
		
		for(String s:ss) 
			System.out.println(s);



	}



}

