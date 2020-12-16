package datatypes;


class _JavaDataTypesTest{


	static public void main (String argumentos[]){

		byte b; //se nao usar, td bem, compila e roda


		//identificadores ilegais
		//int -i = 1; hifen
		//float #f = 2f; jogo da velha
		//double 1d = 1.0d; começar c/numero

		//identificadores legais
		int _i = 1; //underline
		float $f = 1; //cifrão
		double d1 = 1.0; //não começar c/ numero

		System.out.printf("%nunderline: %d; cifrao: %f; nao começar c/ numero: %f ", _i, $f, d1);

		//base octal: começa c/ zero
		int _octo$1 = 0765; //a impressao é na base decimal
		
		long $2_ = 076_5; //501

		short _3$ = 0_765; //pode ter _ no 0 do literal octal

		//byte ã1 = 0_765; byte recebe de -127 a 126

		//base binaria: começa c/ 0B ou 0b
		//byte ç$1 = 0B10; ç identificador ilegal

		byte $1 = 0B1_0; 

		//base hexa
		int $b1 = 0xa_F; //175, com byte estorou
		

		System.out.printf("%nbase octal: %d; long recebendo octal c/ underline: %d; short recebendo octal: %d; byte recebe binario: %d; int recebe hexa: %d", _octo$1, $2_, _3$, $1, $b1  );

		//underlines
		int i_ = 1_2;
		double d__ = 1.2_3;

		double _$ = 1.2_3_0;

		// double $1 = _12; _ apenas entre numeros

		//double $1 = 1_.2_3; //apenas entre numeros

		System.out.printf("%n underline c inteiros %d; underline c/ decimais: %f; c/ zero no fim: %f", i_, d__, _$);

		//faltou testar noação cientifica


	}



}