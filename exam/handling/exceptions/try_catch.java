package exam.handling.exceptions;


class TryCatchTest{


	public static void main(String args[])	{

		//qdo ocorre uma exception, para a execução e vaza
		//apenas bloco try{} codigo não compila
		try{ //bloco q pode ocorrer alguma exception
			String nomes[] = {args[0], args[1]};

			nomes[1] = nomes[0].toLowerCase();

			System.out.println(nomes[1].toLowerCase());

			//new java.io.FileInputStream("a.txt");
			
		//No caso acima, podem ocorrer erros de NullPointer e IndeOfBounds : Runtime trata os 2 erros.
		//}catch(RuntimeException rtex){ //trecho do código que trata as exceptions q podem ocorrer acima
		}catch(Exception ex){
		//}catch(Throwable t){
		//}catch(java.io.IOException ioex){//nao compila se a exception precisa capturar erros q podem acontecer acima 
			
			System.out.println("peguei exceptions");

		}

		System.out.println("terminei"); //execução continua


	}


}