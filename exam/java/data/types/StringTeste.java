package exam.java.data.types;


class StringTeste{


	public static void main(String...varargs){
		
		//String é imutavel
		//declarando e inicializando diretamente
		String direto = "Java";
		System.out.println(direto);
		//declarando e inicializando indiretamente atraves de construtor
		String indireto = new String("Java");
		System.out.println(indireto);
		char[] arrayChar = new char[]{'J','a','v','a'};
		System.out.println(arrayChar);
		//String atribuidoDeArrayDeChar = arrayChar; nao funciona, usar construtor de String
		String atribuidoDeArrayDeChar  = new String(arrayChar);//atribuição com construtor funciona
		System.out.println(atribuidoDeArrayDeChar);

		StringBuilder sb1 = new StringBuilder("Certificação");
		String str1 = new String(sb1);//atribuição de SB para String funciona utilizando o construtor de String

		String s = null;
        	//String s2 = new String(s);//compila mas da erro de execução  pois s é null

		//String s2 = new String(null); //nao compila
        	//System.out.println(s2);

		//concatenação com null	
		String str2  = null;
		String str3 = str1 + str2; //ocorre concatenação sem exception mas a concatencacao fica Certificacaonull
		System.out.println(str3);
	
		//Concatenação com valores numericos
		String str4 = str1 + 1500; //ocorre concatenação Certificacao1500
		System.out.println(str4);
		
		String str5 = 1500 + str1;
		System.out.println(str5); //1500Certificacao
		
		//precedencia de operadores da esquerda p/ direita
		String str6 = 15 + 00 + str1;
		System.out.println(str6);// aqui acontece a soma de 15+00, 15 que concatena com str1: 15Certificacao

		//String imutavel
		str1.toUpperCase();
		System.out.println(str1)		;
		
		//apenas referenciado novamente com a mesma variavel q eu consigo mudar
		str1 = str1.toUpperCase();
		System.out.println(str1)		;

		//String é um array
		System.out.println(str1.charAt(0));//pega caracter na posição 0
		//caso de index out of bounds exception. Compila mas não roda - argumentos invalidos
		//System.out.println(str1.charAt(200));
		//System.out.println(str1.charAt(-1));

		System.out.println(str1.length()); //tamanho 14, ou seja, posições de 0 a 13.lembre-se do parenteses. length() é um método de String e não uma propriedade de array/varargs
		//index out of bounds exception
		//System.out.println(str1.charAt(14));
		

		System.out.println(str1.isEmpty()); //length >0 false
		
		//espaçoes em branco contam
		String str7 = "              ";
		System.out.println(str7.length());//14. Pegadinha: length é um metodo com String (com ()). Em arrays, é um atributo. Sem ()
		System.out.println(str7.isEmpty());//false - espaçoes em branco contam

		//replace
		String str8  = "Java Como Programar";
		System.out.println(str8.replace("Java", "Phyton")); //troca a palavra Java pela Phyton, troca a palavra da esquerda pela direita, 
		System.out.println(str8); //imutavel
		System.out.println(str8.replace('a','x')); //troca todas as ocorrencias de a por x
		//str8.replace("e", 'a'); //nao funciona, replace possui duas maneiras de ser invocado: com dois chars ou com duas Strings 
		
		//substring - pegadinha: não é subString
		System.out.println(str8.substring(0));//a partir da posição 0, inclusive, retorna o resto da string. Nesse caso aqui, vai retornar toda a string
		System.out.println(str8.substring(0,4));//a partir da posição 0, inclusive, retorna o resto da string até a posição 4, não incluindo a posição 4
		System.out.println(str8.substring(18,18));//a partir do último r, sem pegar o r. Ou seja, retorna nada
		String str9 = "s1"	;
		System.out.println(str9.substring(0,2));//apesar de nao ter posicao 2, o substring vai pegar da posicao 0 (inclusive) até a posicção 2-1
		
		//equals
		System.out.println(new String("Java").equals(new String("Java")));//true
		System.out.println(new String("Java").equals(new String("JAva"))); //false : equals é case sensitive
		System.out.println(new String("Java").equalsIgnoreCase(new String("JAva"))); //true
		
		//compare - dictionary order, except that all the uppercase letters preceed all the lowercase letters.
		System.out.println(new String("Java").compareTo(new String("Java")));//0 : iguais
		System.out.println(new String("Java").compareTo(new String("JAva")));//+

		String texto = "Certificado";
		System.out.println(texto.compareTo("Arnaldo")); // 2
		System.out.println(texto.compareTo("Certificado")); // 0
		System.out.println(texto.compareTo("Grécia")); // -4
		System.out.println(texto.compareTo("certificado")); // -32
		System.out.println(new String("a").compareTo(new String("A")));//+

		System.out.println(str8.indexOf("como")); //nao achou (case sensitive) -1
		System.out.println(str8.indexOf("Como"));//achou: posicao 5
		System.out.println(str8.lastIndexOf("a"));//achou: posicao 17 - primeira ocorrencia de a, de tras p/ frente
		System.out.println(str8.indexOf("a",3));//3: primeira ocorrencia de a, a partir da posição 3, inclusive

		System.out.println(str8.startsWith("Java"));//true
		System.out.println(str8.startsWith("Phyton"));//false
		System.out.println(str8.endsWith("amar"));//true
		System.out.println(str8.endsWith("odiar"));//false
		

		//nullPointer exceptions
		//System.out.println(str2.isEmpty());//compila mas não roda. str2 é null. 

		int valor = 10;
        	int dividePor = 4;
        	double resultado = valor / dividePor;//inteiro divido por inteiro da inteiro 2. 2 ao ser atribuido a um double, ganha casa decimal: 2.0
		System.out.println(resultado);
        	System.out.println(valor + dividePor + "");
        	System.out.println("" + resultado + valor );


		// lado esquerdo de uma atribuição deve ser sempre uma variável e não uma chamada a um método.
		//s.substring(0,2) = "gua"; erro
		
	}


}