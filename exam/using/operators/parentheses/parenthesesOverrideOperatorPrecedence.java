package exam.using.operators.parentheses;

class ParenthesesTest{

	public static void main(   String [     ] argumentos   ){

		System.out.println(15 + 0 + "cento e cinquenta"); //15 + 0 = 15 + string
		System.out.println("cento e cinquenta " + 15 + 0);//string 150 - aqui oocrre concatenação pura- com string vindo antes

		System.out.println(0 + "cento e cinquenta");//0String

		System.out.println(15 + (0 + "cento e cinquenta")); //15 + 0String = 150String

		System.out.println("jefferson".length());//9
		
		//1o. resultado da execução do metodo 
		//2o. concatenacao String
		System.out.println("jefferson" + "ribeiro".length());//jefferson7

		//1o. concatenacao
		//2o. execução do metodo
		System.out.println(("jefferson" + "ribeiro").length());//16
		

	}

}