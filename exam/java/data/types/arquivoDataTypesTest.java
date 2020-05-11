package exam.java.data.types;

class DataTypesTest{

	int variavelMembro;//valor default = 0 (todos os tipos numericos
	boolean variavelMembroBoolean;//valor default false
	String varMembroVlrDefault;//valor defaul de objeto referenciado null
	char varMembroCharDefault;


	void metodoVariavelMembro(){
		System.out.println(variavelMembro); //posso utilizar variaveis membros, de instancia, objeto sem inicializar. Os valores serão os padrões dependendo do tipo
		System.out.println(variavelMembroBoolean);
		System.out.println(varMembroVlrDefault);
		System.out.println(varMembroCharDefault);

	}

	DataTypesTest(){
		int localConstrutor; //pode ser declarada sem inicializar no construtor mas não pode ser utilizada
		//variavelMembro = localConstrutor; variavel local devera ser inicializada
		
	}	

	public static void main(String params[]){

		//int local; //compila se apenas declarar e não utilizar
		//System.out.println(local);//se utilizada no código - arquivo não compila pois avariavel local não foi inicializada dentro de metodos e construtores

		new DataTypesTest().metodoVariavelMembro();


		int condicao;
		//if (1==2) condicao = 0; se a variavel local nao for inicializada dentro do fluxo, ocorre erro de compilação
		//System.out.println(condicao);

		int arrayInt[] = new int[10]; //array inicializado sempre com seus valores padrões
		System.out.println(arrayInt[0]); 

		int testeTamanho = 2147483647;//tamamnho maximo do inteiro
		//int testeTamanho = 2147483648; ultrapassa tamanho maximo do inteiro

		System.out.println(testeTamanho);

		double testeTamanhoLong = 1f;//explicitando o float
		System.out.println(testeTamanhoLong);

		double comCasaDecimal = 1; //o valor fica 1.0
		//int semCasaDecimal = 1.0;//ocorre problema de conversao

		System.out.println(comCasaDecimal);
//		System.out.println(semCasaDecimal);

		int octo  = 0761; //começã com 0 : base octo numeros de 0 a 7
		System.out.println(octo); //o valor é convertido para base decimal (497)
		//int oc$to = 0781; //erro - base ocoto de 0 a 7

		int hexa =   0xA; //começa com 0x: base hexa de 0 a F
		System.out.println(hexa); //10

		int he$_xa = 0Xa; //os valores literais não são case sensistive 0X = 0x ou a = A
		System.out.println(he$_xa); //10

		int b1_$_in = 0b100; //base binaria
		System.out.println(b1_$_in); //4

		double $1_flut = 3.1e2; //ponto flutuante = 3.1 * 10^2
		System.out.println($1_flut); //310.0

		float _$1_float = 3e3f;
		System.out.println(_$1_float); //3000.0

		//java 7: utilizar _ para separar os digitos entre numeros
		int _SeparaDigito = 1_234;
		System.out.println(_SeparaDigito);//1234

		double _1$SeparaDigito2 = 1_2_3_4_5;
		System.out.println(_1$SeparaDigito2);//12345.0

		double _2$eparaDigito = 1__2___3_4;
		System.out.println(_2$eparaDigito);//1234.0

		//double _3$eparaDigito = 1_2_;erro
		//System.out.println(_3$eparaDigito);//

		
		//long _4$eparaDigito = 1_l;//erro	
		//System.out.println(_4$eparaDigito);//

		int _5$EPARAdIGITO = 0xA_b_C;	
		System.out.println(_5$EPARAdIGITO);//funciona 2748

		char c = 'C';
		System.out.println(c); //C

		char d = 65; //alt 65 = A
		System.out.println(d); //A

		if(d=='A') System.out.println("65==A");

		System.out.println('\u0042'); //unicode B
		

		


	}
	


}