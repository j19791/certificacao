package exam.using.operators;

class ArthmeticOperatorsTest{

	public static void main(String ... args){
		
		int div = 5 / 2; //retorna 2
		System.out.println(div);
		int divResto = 5 % 2; //retorna 1
		System.out.println(divResto);

		//a)Numa operação aritmetica, o tipo devolvido no minimo é um int
		//b)retorna o maior tipo envolvido na operacao aritmetica

		short s1 = 5;
		short s2 = 10;
		//short s3 = s1 + s2; //erro: perda de precisão: retorno é int e int > short
		int i = s1 + s2;//o tipo devolvido no minimo é um int
		
		//int i2 = 2l + 1; //erro: o retorno aqui é um long: maior tipo envolvido
		long l1 = 2l + 1; //ok
		//long l2 = 2l + 1.0; //erro: double>long

		//divisão por zero
		double d = 1/0.0; //funciona: divisão por zero funciona em operações c/ ponto flutuante:  Infinity
		double f = 1.0/0; //funciona
		
	}

}