package executable;

import biblioteca_codigo.Pessoa;

public class Professor extends Pessoa{

	private boolean	licenca;

	public boolean getLicenca(){return licenca;}

	Professor(){
		super("Sem nome", 0);
	}

	Professor(String nome, int idade){
		super(nome,idade);

	}

	

}

class ProfessorTest{

public static void main(String args[]){

		System.out.println(new Professor("Mário", 41).getNome());

	}

}


