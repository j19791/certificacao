class FormatacaoTest{

	static public void main (String argumentos[]){

		//System.out.print(); nao compila sobrecarga s/ parametros

		System.out.println(); //compila

		char c[] = {'a', 'b', 'c'};

		System.out.println(c);//recebe array de char e trata como se fosse uma String


		String[] str = {"java", "ocjp8"};

		System.out.println(str);//impressao tratada como objeto (endereço de memória)



		/*System.out.printf("%d", 123.45d); IllegalFormatConversionException : passado um literal double sendo q estava esperando inteiro
		double d = 123.45d;
		System.out.printf("%d", d); */


		System.out.printf("%2$s %1$s", "Hello", "World"); //index : p/ fugir da ordem sequencial - atenção: começa do 1
		
		//MissingFormatArgumentException: não tem o index 3
		//System.out.printf("%3$s %1$s", "Hello", "World"); 		

		
	}





}