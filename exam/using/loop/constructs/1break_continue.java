package exam.using.loop.constructs;

import java.util.ArrayList;


class BreakContinueTest{


	public static void main(String parametros[]){
		
		//testando labels. preciso colocar ;
		label1a:
		label1b:; //o statement pode ter 1+ labels
		label2:;

		//break: loops ou switch
		int i = 0;
		label3: while(i++<10){
			if(i==5) break label3;//quebra o loop mais interno. se tem label, o label prcisa existir e apontando p/ um loop ou switch
			System.out.println(i);
			
		}

		//continue: apenas loops
		int j = 0;
		label3: do{
			if(j==5) continue label3; //se j for igual a 5, nao executa mais o código do bloco e vai direto para o teste da condição, continuando o laço se for o caso
			System.out.println(j);
			
		}while(j++<10);

		ArrayList<String> nomes = new ArrayList<>();
		nomes.add("Hostmidia");
		nomes.add("Deitel");
		
		label3: for(String nome: nomes){
			System.out.println(nome);
			if(nome.equals("Hostmidia")) break label3;

		}

		for(int k=0;k>10;i++){
			//break;
			System.out.println("unreachable statement");
			

		}

		//break tem no switch mas continue nao
		//o break e continue corresponde ao loop mais interno, p´roximo mas isso pode ser alterado com os labels
		//break break não existe
		//label é label e variavel é variavel. posso compartilhar os mesmos nomes

		//tabuada
		labeli1:for(int i1 = 1;i1<=10;i1++)
			labelj1:for(int j1=1;j1<=10;j1++){
				if (i1==4) continue labeli1; //vai pular a tabuada do 4 (for mais externo) e continuar com o loop
				System.out.println(i1 + " * " + j1 + " = " + i1*j1);
				
			}
		
		int i2;
		for(i2=0;i2<15;i2++, System.out.println(i2))
            		if(i2==5) continue;
		System.out.println(i2);
	}



}