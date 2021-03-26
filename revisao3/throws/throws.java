import java.sql.*;
import java.io.*;



//testar unchecked e checked exceptions com metodos sobreescritos
//unchecked não tem problemas de sobreescrita

class MinhaException extends Exception{} //criando exception checked

class MinhaExceptionUnchecked extends RuntimeException{} //criando exception checked

interface I{}


//class Classe extends I{} nao compila


class Pai{


	void u() throws NullPointerException{};
	
	void c() throws SQLException, IOException{};

	//void c() throws SQLException, FileNotFoundException{};

}

class Filho extends Pai{



	void u() throws ArrayIndexOutOfBoundsException{}

	//void c() throws IOException  {}; nao compila pois cexc precisa ter nenhum, todos ou parte do q foi jogado no metodo do pai

	//void c(){}; //compila, nao tem nada jogando

	//void c() throws SQLException  {}; //compila

	//void c() throws NullPointerException{}; compila pois npexc é unchecked e não importa nesse caso

	//atençao: aqui foi incluido IOException no método do pai para realizar os testes abaixo

	//void c() throws FileNotFoundException{} //compilou pois FNFExc é filho de IOExc

	//fazendo o inverso: o metodo pai joga uma exception filha da exception jogada pelo metodo sobreescrito do filho

	//void c() throws SQLException, IOException    {}; nao compila

	//void c() throws MinhaException    {} nao compila pois nao foi jogado pelo Pai o metodo unchecked

	void c() throws MinhaExceptionUnchecked{} //compila pois é Unchecked

}
class TestaThrows{

	public static void main(String [] args) throws SQLException, IOException{


		new Filho().c();		

		new Pai().c();//as exceptions checked de c() do Pai obrigaram o método main a jogar tbm Exceptions (poderia ser tratado c/ try/catch

		new Filho().u();


		try{
			Integer $i = 1/0;
		}
		//nao funciona: a ordem tem q ser try + catch ou try + finally ou try + catch + finally
		/*finally{
			System.out.printf("%n %1$s", "finnaly");

		}*/
		catch(ArithmeticException a){
			System.out.printf("%n %1$s", "catch");
		}
		finally{
			System.out.printf("%n %1$s", "finnaly");

		}


		System.out.printf("%n teste com erro dentro do bloco catch");

		try{
			Integer $i = 1/0;
		}

		catch(ArithmeticException a){
			System.out.printf("%n %1$s", "catch");
			Integer _i = 1/0;
		}
		finally{
			System.out.printf("%n %1$s", "finnaly");

		}


		
		
		
		

	}


}
