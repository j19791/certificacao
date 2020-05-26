package exam.java.basics.produce.console.output;

import java.util.*;

class ConsoleFormatTest{

	String saida;

	public String toString(){
		
		return this.saida;

	}

	ConsoleFormatTest(String saida){
		this.saida = saida;

	}


	
	

	public static void main(String args[]){

		if (args.length > 0)
			System.out.print(new ConsoleFormatTest(args[0]));
		
		// \n quebra de linha -- array é um objeto
		System.out.print(args + "\n");//[Ljava.lang.String;@15db9742
		
		//exceção no caso de array de char
		System.out.println(new char[]{'a','b'});//imprime ab

		//System.out.print();//nao compila sem argumentos
		System.out.println();//compila e roda

		System.out.printf("%s",12); //mesmo 12 sendo int, imprime (nao pula linha)
       		 System.out.printf("%d",new Integer(321)); //ok
        	System.out.printf("%d",(short)(byte)(double) 127);//compila  e roda 127 cosigo converter p/ double. 127.0 double consigo cating para byte. 127 byte consigo casting para short
		
		byte b[] = new byte[]{'a','b','c'};
		System.out.println(b[0]); //'a' = 95 byte
		
		
		
		//impressão formatada
		/* tipos
		%b boolean
		%c caracteres
		%d inteiros
		%f ponto flutuante
		%n quebra de linha

		indice, flag, tamanho
		*/

		//interpolação

		try{
			
			System.out.format("%s %s %n", "Hello", "World");//Hello World
			System.out.format("%2$s %1$s %n", "Hello", "World");//World Hello. $ considera ordem dos parametros passados. Base 1
			System.out.format("[%5d] %n",42);//o tamanho do conteudo fica com 5, alinhado na direita. Se o tamanho do conteudo extrapolar o valor especificado, o conteudo não é cortado. Os colchetes servem apenas p/ facilitar a exibição do conteúdo
			System.out.format("[%-5d] %n",42);//o tamanho do conteudo fica com 5, alinhado a esquerda.
			System.out.format("[%05d] %n",42);//o tamanho do conteudo fica com 5, alinhado a direita, completa com 0 até o tamanho especificado (5).
			//System.out.format("[%05d] %n","tes");//compila mas nao roda. apenas numeros da pra completar com zeros
			System.out.format("[%1$+d] [%2$+d] [%2$(d] [%1$(d]   ", 42, -50, 42 );//+ coloca o sinal de positivo.
											//( qdo negativo, o valor fica entre parenteses
											//se o valor é postivo e coloca entre parenteses, o valor fica apenas com sinal +
	
			
			System.out.format("%,.2f", 10000000000.444); //, separador de milhar do sistema operacional . numero de casas decimais. Arredonda >= 5 p/ cima, <5 , trunca



		}
		catch(java.util.IllegalFormatConversionException ex1){
			System.out.println("Exception");

		}catch(FormatFlagsConversionMismatchException ex2){
			System.out.println("Exception2");
		}
			
		


	}

	


}