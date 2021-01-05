package operador;

public class Operador{

	//float #f = 40.0; nao compila float nao recebe double
	//float #f = 40.0f; nao funciona identificador com #
	//float $f = 40.0f; modificador default - visivel apenas dentro da classe
	public Float $f;
public String _1$nome;


	public int incremento(int i){
		return i;
	}

	public boolean equals(Operador o){
		return this._1$nome == o._1$nome ;
	}

	public boolean testeRetorno(int i){
		if (i > 2) return true; //somente com isso - nao compila: missing return
		else throw new RuntimeException ("teste missing return");

	}

}