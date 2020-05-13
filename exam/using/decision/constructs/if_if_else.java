package exam.using.decision.constructs;

class IfIfElseTeste{

	String metodo(int i){
		if(i>10) return "ok";//nunca sabemos o valor de i
		return "nok";//obrigatorio colocar um return para o metodo caso a condição boooleana nao seja satisfatória
	}


	public static void main    (String args   [ ] ){

		boolean v = true;
		//obrigatório usar parenteses no if
		if      (    v     )    System.out.println("testa verdadeiro");

		//compila
		if (2<1) System.out.println("isso aqui nunca roda");

		//compila
		if(false) System.out.println("isso aqui nunca roda");

		//nao existe elseif  usar else if

		//o else, qdo precisar, sempre vem depois dos else if e nao antes



	}



}