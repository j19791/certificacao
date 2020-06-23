import java.util.ArrayList;

class ForTest{


	static public void main (String args[]){

		/*
		for
			inicialização de variaveis: apenas 1 x, no começo
			condição: é testada no começo de cada iteração
			atualização: é feita no final de cada iteração			
		*/


		/* for sem argumentos
		for(;//inicializacao: valor default vazio
			; //condição:o valor default é true
		){//atualização: vlr default vazio
			System.out.println("loop infinito");
		}*/

		//permitido declarar e inicializar apenas tipos iguais
		for(int i=0, j=0; i < 2 & j < 2; i++,j++)
			System.out.println("[" + i + ", " + j + "]");

		int i;
		double d;
		boolean b;

		for(i=1,d=2.0,b=true;//possível inicializar tipos diferentes
		i<10;
		i++,d++){
			System.out.println(i);
			System.out.println(d);
		}
		
		System.out.println("--------------");

		for(i=1,d=2.0,b=true;
		i<10;
		i++,d++, System.out.println(i), System.out.println(d) //comandos podm ser executados na atualização
		){
			System.out.println(b);
			
		}

		int numeros[] = {1,2,3,4,5,6};

		for(int i1 : numeros){
			i1 = 0; //os elementos nao mudam no array
		}

		for(int i1 : numeros){
			System.out.println(i1);
		}

		

		


	}



}