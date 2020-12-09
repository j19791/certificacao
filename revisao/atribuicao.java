class AtribuicaoTest{


	public static void main(String [] args){

		byte b = 0;
		short s = 1;
		char c = 2;
		int i = 3;
		long l =4;
		float f = 5;
		double d = 6; //atribuição funciona mesmo s/ a casa decimal
		
		//double recebe qq tipo numerico
		d = f;
		d = l;
		d = i;
		d = c;
		d = s;



		//f = d;  float nao recebe double
		f = l;
		f = i;
		f = c;
		f = s;
		
		//atribuição c/ variavel
		//b = s; byte nao recebe short - mesmo esse short sendo 1
		
		//b = 128; nao compila - ultrapassa o range -128 a 127
		b = 127;

		//c = b; //char só pode receber valor +
		s = b;		
		
		c = 'A';
		//s = c; char tem um range positivo maior q short pois apesar de ser tbm 2 bits 

		i = c;

		//f = 2.0; nao compila : double nao cabe em float
		f = 2.0f; //vc precisa explicitar o float no literal 
		f = 2f;
		
		System.out.printf("float: %f", f); //na impressao, sai 2,000000
		
		s = (short) c; //compila qdo usado casting

		s = (short) 10.0d;

		System.out.printf("%n casting de char p/ short: %d", s);

		b =  2 % 3; 

				
		
		System.out.printf("%n resto da divisao: %d", b);


		b = 5 + 7; //operacao com literais pode ser resolvido pelo compilador a atribuição s/ erros

		System.out.printf("%n resultado da operacao com literais pode ser resolvido pelo compilador a atribuição s/ erros: %d", b);

		//b = b + b; com variaveis, nao compila: resultado da operacao sempre inteiro

		//b = b +1; nao compila, variavel com literal retorna no minimo um int

		




	}


}