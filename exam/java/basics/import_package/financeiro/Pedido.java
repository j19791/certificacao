package exam.java.basics.import_package.financeiro;

//evitando usar o full qualified name
import exam.java.basics.import_package.modelo.Pessoa;
//import java.util.Date;
//import java.sql.Date; nao vai conseguir importar pois o date ja esta sendo importado de java.util
import java.util.*; 
import java.sql.Date; // Não existe ambiguidade uma vez que o import específico tem preferência em cima do *
import static exam.java.basics.import_package.modelo.util.Util.*;//vc só consegue importar as variaveis ou metodos staticos, nao a classe especifica. Não da para instanciar um objeto dessa classe

class Pedido{
	
	//nao vai achar Pessoa. Pessoa nao esta no pacote exam.java.basics.import_package.financeiro
	//usando full qualified name - Pessoa deverá ser public
	//exam.java.basics.import_package.modelo.Pessoa cliente;	
	Pessoa cliente;//usando import
	//java.util.Date dataUtil; //s/ conflito: funciona se especificar com full qualified name
	//java.sql.Date dataSql; //s/ conflito: funciona se especificar com full qualified name
	//Produto produto; nao dá p/ acessar classes de pacote default
	//Date dataConflito; data conflituosa de util e sql
	
	public static void main(String parametros[]){

		//Util u = new Util(); //nao funciona, vc só consegue importar membros (atributos e metodos)

		System.out.println(exam.java.basics.import_package.modelo.util.Util.TAMANHO);

		System.out.println(exam.java.basics.import_package.modelo.util.Util.maiorIgual(3,2))		;

		//pode se usar o import static

		System.out.println(TAMANHO);

		System.out.println(maiorIgual(2,3));
	}


}