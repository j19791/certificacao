package exam.java.basics.import_package.modelo;

//o import é opcional pois endereco esta dentro do mesmo pacote
import exam.java.basics.import_package.modelo.Endereco;

public class Pessoa{

	String nome;
	//qdo esta no mesmo pacote, a classe Endereco pode ser default
	Endereco endereco; //qdo rodado o javac, a classe endereço é automaticamente criada

}