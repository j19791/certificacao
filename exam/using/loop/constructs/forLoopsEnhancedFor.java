package exam.using.loop.constructs;

import java.util.ArrayList;


class For_EnhancedFor$LoopsTest{


	public static void main(String[] args){
		
		{} //bloco voando compila
		{;}//compila
		
		/*
		loop infinito quieto
		for
			(; //criacao/inicialização de variaveis - opcional. Roda apenas 1 vez
			; //condição - opcional - roda todas as vezes
			) //incremento . Roda após a execução do loop. Incrementa antes da condição ser avaliada
		; //obrigatório colocar. Não compila se não colocar
		*/

		int i; //posso declarar antes
		long l;
		for(i=0, l=10l;    i   <   10; ){//posso inicializar no for, qtas variaveis eu desejar
			i++;//posso colocar o incremento no bloco
			System.out.println(i);
			System.out.println(l);
		}

		for(long l1 = 0, l2 = 10; //dentro do for, as variaveis declaradas são do mesmo tipo
			l1 < 10; l1++
			,System.out.println("teste dentro do for") );//posso colocar um statement dentro do for, separado por virgula

		
		double d;
		for(d=0.1;d<10;d++, System.out.println(d)); //tenho q pelo menos inicializar a variavel

		//enhanced for (for each). Itera sobre coleções
		//nao remover no enhanced for
		ArrayList<String> nomes = new ArrayList<>();
		nomes.add("H.");
		nomes.add("M.");
		nomes.add("Deitel");
		
		for(String nome : nomes){//tipo nomes tem q ser compativel com tipo nome (string)
			System.out.println(nome);
		}

		
		//for(int i1=0; i1<10, false; i1++) {nao posso colocar mais de uma expressao para ser testada
		for(int i1=0; i1<10; i1++) {
         		System.out.println('a');
        	}
		
        	System.out.println('b');
		//System.out.println(i1); o i1 existe apenas dentro do bloco do for aonde foi declarado

		/*for infinito
		for(;;) {
            		System.out.println("a");
        	}*/
        	//System.out.println("b"); //unreachable statement


	}


}


