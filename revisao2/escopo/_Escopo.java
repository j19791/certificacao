package escopo;


public class _Escopo{

	public static byte i;

	//short i; nao pode ter uma variavel static com o mesmo nome de outra variavel nao static



	public byte metodo(byte param){


		byte i;

		for(i = 0; i <= 126; i++){
			System.out.printf("%n i dentro do for: %1$d", i);

		}

		System.out.printf("%n i fora do for: %1$+d", i);

		for(byte j = 0; j <= 126; j++, System.out.printf("%n j dentro do for: %1$d", j));

		//System.out.printf("%n j fora do for: %1$d", j); nao compila: escopo da variavel declarada dentro do bloco for	apenas dentro do bloco for

		//byte param; nao compila: variavel ja declarada nos parametros do método


		return i;


	}

	public static void metodo2(){

		double _b1[] = new double[2];

		System.out.printf("retorno do metodo static: %1$.2f", _b1[0] + _b1[1])		;


		//return _b1[0] + _b1[1];	//aqui retorna no minimo int - soma de duas variaveis



	}


}