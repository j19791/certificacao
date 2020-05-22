package exam.handling.exceptions;

import java.io.*;

//criando nova unchecked exception
class ArgumentoNaoPassadoException extends RuntimeException{
	ArgumentoNaoPassadoException(String m){
		super(m);
	}


}


class StackErros{
	static void metodo1(String args[]) {
		System.out.println("m1:entrou");
		metodo2(args);
		System.out.println("m1:saiu");
	}
	static void metodo2(String args[])  {//se foi tratado, nao rpecisa mais do throws
		System.out.println("m2:entrou");
		try{
			metodo3(args);
		}catch(FileNotFoundException flfex){
			System.out.println("m2:erro tratado");
		}
		
		System.out.println("m2:saiu");
	}
	static void metodo3(String args[]) throws FileNotFoundException{ //nao tratado aqui, devolve o erro pra pilha
		System.out.println("m3:entrou");
		//if(args.length < 1) throw new IllegalArgumentException("excecao metodo 3");		
		InputStream is = new FileInputStream("a.txt");
		System.out.println("m3:saiu");
	}
}


class TryCatchTest{

	//cuidado com a inicializacao das variaveis membro
	//InputStream is = new FileInputStream("a.txt"); //nao compila. Tem q tratar como checked exception

	TryCatchTest() throws FileNotFoundException {};//agora compila
	


	public static void main(String args[]) {

		StackErros.metodo1(args);
				
		//joga exception
		if (args.length < 1) throw new ArgumentoNaoPassadoException("Obrigado passar pelo menos 1 argumento");

		//qdo ocorre uma exception, para a execução e vaza
		//apenas bloco try{} codigo não compila
		try{ //bloco q pode ocorrer alguma exception
			String nomes[] = {args[0], args[1]};

			nomes[1] = nomes[0].toLowerCase();

			System.out.println(nomes[1].toLowerCase());

			//new java.io.FileInputStream("a.txt");
			
		//No caso acima, podem ocorrer erros de NullPointer e IndeOfBounds : Runtime trata os 2 erros.
		}
		//pode ter varios catch: cada um vai tratar da sua maneira
		catch(RuntimeException rtex){} //trecho do código que trata as exceptions q podem ocorrer acima
		catch(Exception ex){}
		catch(Throwable t){}
		
		/*catch(java.io.IOException ioex){//nao compila se a exception precisa capturar erros q podem acontecer acima 
			
			System.out.println("peguei exceptions");

		}*/
		finally{System.out.println("esse trecho é sempre executado, mesmo com catch ou sem erro");}
		System.out.println("terminei"); //execução continua

		

		



	}


}


class MyException extends RuntimeException {

}
class A {
    void m2() throws java.io.FileNotFoundException, RuntimeException {//inclundo RuntimeException, o erro é tratado. Compila e roda. Se o RuntimeException, apenas compila e da erro de execução
        System.out.println("e");
        boolean sim = true;
        if(sim) throw new MyException();//esse teste é necessário para o compilador. A linha de abaixo pode ser executada (pelo menos para o compilador)
        System.out.println("f");
    }
    void m() throws java.io.FileNotFoundException, RuntimeException {
        System.out.println("c");
        try {
            m2();
        } catch(java.io.FileNotFoundException ex) {
        }
	catch(RuntimeException rtex){}
        System.out.println("d");
    }
    public static void main(String[] args) throws 
    java.io.IOException, RuntimeException {
        System.out.println("a");
        new A().m();
        System.out.println("b");
    }
}
