package exam.working.methods;

class MethodsArgumentsReturnTest{



	public static void main(String []args){

		Metodo m = new Metodo();
		//m.metodoRetornaException();
		m.metodoExceptionAssinatura();
		m.metodoComFinal(11);
		m.metodoPromocaoPrimitivo(1l); //parametro do método é double mas metodo pode ser chamado com parametro long
		m.metodoPromocaoPrimitivo(1f);
		m.metodoPromocaoPrimitivo(1.0);
		m.metodoPromocaoPrimitivo(1);
		m.metodoPromocaoPrimitivo('A'); //char q na verdade é compativel com tipo numerico
		
		//m.metodoPromocaoPrimitivoIntMaximo(1l);//nao funciona, recebe até int
		m.recebeQualquerObjeto(new Cliente());//polimorfismo
		m.retornaNull();
	}

}

class Metodo{
	//nao posso inicializar os parametros. Não tem parametro c/ valor default
	//return; pode ser colocado em metodo void: encerra execução do método
	
	
	//modificadores de acesso (apenas 1): default, public, protected, private
	/*outros modificadores (0 ou mais de 0): 
		final - metood não pode ser sobrecarregado qdo a classe é herdada
		syncronized: threads
		abstract: só assinatura, s/ corpo
		static: metodo da classe nao do objeto
	*/

	//abstract int metodoAbstrato(); //nao compila. classe tbm precisa ser abstrata. nao tem corpo, apenas assinatura
	
	void metodoComFinal(final int a){
		//a= 12; nao compila. valor da variavel nao pode ser atribuida novamente
		
	}

	//metodo poode receber qq valor numerico
	void metodoPromocaoPrimitivo(double a){}

	void metodoPromocaoPrimitivoIntMaximo(int a){}
	

	void metodoParametroVariavelLocal(int a){
		//int a = 1; nao compila. Variavel local ja definida como parametro do metodo
	}

	int metodoRetornaException(){
		//compila. mesmo obrigando retorno na assinatura, com throw não é obrigatório
		//aqui é throw s/ s. É Runtime nao RunTime
		throw new RuntimeException("Testando retorno com exception, sem retorno oficial");
	}

	//aqui é throws (c/ s)
	void metodoExceptionAssinatura() throws RuntimeException{

	}


	//polimorfismo
	void recebeQualquerObjeto(Object o){}

	Cliente retornaNull(){return null;} //posso retorna null qdo o metodo retorna uma referencia

	//nao compila: missing return statement
	boolean testeIf(int a){
		//no if todas as condições precisam estar satisfeitas
		if (a >0) return true;
		
		else if (a < 0) return false; 
		//else if (a <= 0) return false; //nao funciona apenas com isso
		else return false;
		
	}

}

abstract class ClasseAbstrata{

	abstract int metodoAbstrato(); //compila com abstract class
}


class Cliente{}


class A {
	public static void main(String[] args) {
		x(args.length); 
		
	}

	static int x(int j) {
	//static int x(final int l){
		final int l = 5;

		for(int i=0;i<100;i++) {
			switch(i) {
				case l: //nao compila: apesar de l ser final, o argumento precisa ser inicializado com um valor literal
					System.out.println(l);
					if(l==i) return 3;
				case 0:
					System.out.println(0);
				}
		}
		System.out.println("End");
		return -1;
	}
}

