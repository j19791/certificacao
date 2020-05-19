package exam.using.operators;

class IncrementOperatorsTest{

	//atenção: incremento só pode ser usado em variaveis. Não pode ser usado em chamadas de meetodos, mesmo q eles retornem tipos numéricos
	public static void main(String[] args){
		int i = 1;
		//pós-incremento
		i++; //2
		System.out.println(i); //2
		System.out.println(i++); //2 - a impressao esta vindo antes do incremento
		System.out.println(i); //3
		//pre decremento
		System.out.println(--i);//2 - o decremento apareceu antes da impressão
		
		i = i +1;//3
		i+= 1; //4 - igual acima mas abreviado
		System.out.println(i);//4
		// -=, *=, /=, %=
		
		byte b = 1;
		b += 200;
		System.out.println(b);//-55 . No caso de operador incremento, o resultado nao é inteiro. O Java trata o estouro
		
		//atribuição multipla
		int a = 10;
		a += ++ a +  a + ++    a; 
		System.out.println(a);
		/*
		a = a + ++a +a + ++a;
		a = 10 + ++a +a + ++a;
		a = 10 + 11 + 11 + 12;//44

		*/
		int e = 10;
		
		int c = 15;

		int d = (e = c) + 1;//d = 16
		System.out.println(d);


	}

}