package exam.using.operators;

class LogicalOperatorsTest{

	static boolean metodo1(){
		System.out.println("metodo1");
		return true;
	}


	public static void main(  String   [   ]    parametros){

		//as duas comparacões logicas são feitas
		System.out.println(1 == 1 & 1 > 2);
		System.out.println(1 == 1 | 1 > 2);
		System.out.println(1 == 1 ^ 1 > 2); //xor
		System.out.println(!(1 == 1));//not

		//short circuit: a 2a logica não é realizada se a primeira ja satisfaz
		System.out.println(1 == 1 && 1 > 2); //primeira nao satisfaz, deverá testar a segunda
		System.out.println(1 == 1 || 1 > 2);//primeira ja satisfaz, nao testa 1>2

		
		System.out.println(1 == 1 && metodo1());//vai chamar o metodo 1 
		System.out.println(1 == 1 || metodo1());//nem chama o metodo 1

	}



}