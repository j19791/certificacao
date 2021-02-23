package executavel;

import java.sql.SQLException;
import java.io.FileNotFoundException;
import java.io.*;

class ErroCustomizadoException extends Exception{



}

class ExceptionTest{

	FileInputStream fis;


	ExceptionTest() throws FileNotFoundException {

		fis = new FileInputStream("a.txt");

	}


	static public void main(String ... args) { //throws FileNotFoundException{ 


		try{		
			new ExceptionTest(); //se chamou rotina com throws, a rotina q chamou deverá ter um try/catch ou throws tbm
		}
		catch(FileNotFoundException e){
			System.out.printf("FileNotFound exc");			
		}

		try{

			System.out.printf("%n teste %1$10d", 10);
			new FileInputStream("a.txt");
		}
		
		catch(FileNotFoundException e){ 
			System.out.printf("FileNotFound exc");

		}
		finally{
			System.out.printf("finally c/ catch: Ocorreu erro");			
		}


		try{

			System.out.printf("%n teste %1$10d", 10);
			//new FileInputStream("a.txt");
		}
		finally{
			System.out.printf("finally");			
		}



	}

/*
		catch(SQLException e){ sqlexception nunca sera lancada
			System.out.printf("SQL Exception");
		
		catch(FileNotFoundException e){ // nunca sera lancada
			System.out.printf("FileNotFound exc");

		}

		catch(IOException e){ //nao compila: mais generica antes, a mais especifica nunca sera chamada
			System.out.printf("IO exc");
		}		

		catch(FileNotFoundException e){ 
			System.out.printf("FileNotFound exc");
		}		
		 unreachable code: se a classe mais especifica vier antes, o codigo abaixo nunca sera executado
		catch(IOException e){ //mais especifica depois
			System.out.printf("IO exc");
		}		
		

	}

*/
}

