package exam.java.data.types;

class CalculadoraTest{

	public static void main(String[] varargs){
		
		Calculadora c = new Calculadora();
		System.out.println(c.soma(1,2,3,5,9,10));
		System.out.println(c.soma("Jefferson",1,2,3,5,9,10));	
		int[] parcelas = {1,2,3,5,9,10}	;
		//new int[]{23789,673482};
		System.out.println(c.somaArray(parcelas));	//array na´é vargs mas vargs é array	
		System.out.println(c.soma(parcelas));
		System.out.println(c.soma());//devido à regra de sempre invocar o mais específico, ele sempre invoca o método sem argumentos. Se não tivesse esse método, o retorno seria 0
	}

}

class Calculadora{
	//varargs (numero variavel de argumentos, tbm pode receber array ou nnehum valor
	int soma (int... numbers){
		int soma = 0;
		for(int i=0;i<numbers.length;i++){//atenção: length é atributo, não é método por isso não tem (). Qdo recebe um array, cada elemento do array é tratado como se fosse um argumento diferente
			soma += numbers[i];
		}
		return soma;
			
	}
	
	/*varargs precisa ser o ultimo argumento do metodo
	int soma(int... numbers, String nome){
		int soma = 0;
		for(int i=0;i<numbers.length;i++){
			soma += numbers[i];
		}
		return soma;
	}*/

	int soma(String nome, int... numbers){
		int soma = 0;
		for(int i=0;i<numbers.length;i++){
			soma += numbers[i];
		}
		return soma;
	}

	int somaArray(int[] numbers){
		int soma = 0;
		for(int i=0;i<numbers.length;i++){
			soma += numbers[i];
		}
		return soma;

	}
	
	//metodo mais especifico: sempre chamado qdo nao for passado nennhum valor
	int soma(){
		return 99;
	}
}