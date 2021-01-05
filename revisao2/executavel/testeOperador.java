package executavel;

import operador.Operador;
import java.util.List;
import java.util.ArrayList;
import java.util.function.*;//para usar o Predicate

class _ExecOperador{


	static public void main (String [] argumentos){

		Operador [] _op = new Operador[10]; //inicializa um array

		//_op[0].$f = 10f; nao é primitivo. Vc precisa inicializar a posição qdo é referencia antes de usa-la (evitar o NPE)

		_op[0] = new Operador(); //inicializa o elemento do array ja inicializado anteriormente

		_op[0].$f = 10f;

		_op[1] = new Operador(); 		

		_op[1].$f = 10.0f;		

		_op[2] = new Operador(); 			
				
		_op[2].$f = (float) 10.0; //casting de double

		int atribuicoes[] = new int[10];

		atribuicoes[0] = 1;

		short s1 = 10;

		//char $c	= s1; 	 nao compila : tipos incompativeis short/char - atribuições c/ variaveis

		char $c = (char) s1; //compila c/ casting

		long _l$ = 1;  

		//atribuicoes[1] = _l$; nao compila: atribuição com long mesmo o valor cabendo em int

		char $c2 = 10;

		//short _1s = $c2; //char e short tem o mesmo tammanho de bits mas como char só pode ser positivo, o range positivo é maior no char - impossiiltando a atribuição

		atribuicoes[2] = 3 % 2; //resto é int

		//Double $1d = 10; int nao pode ser convertido p/ Double

		double  $1d = 10; //int pode ser auto promovido p/ double


		//atribuicoes[3] = $1d / 2; a divisão de um double (tipo + abrangente) é um double

		atribuicoes[3] = (int) $1d / 2; 

		atribuicoes[4] = (int) $1d / (int) 2.0;

		atribuicoes[5] = (int) ($1d /  2.0)	;

		atribuicoes[6] = (int) (1.0 % 2);

		atribuicoes[7] = (int) (7d % 2);

		byte _b1 = 1;

		byte _b2 = 2;

		//byte _b$3 = _b1 + _b2; nao compila: o resultado é no minimo é int

		atribuicoes[8] = _b1 + _b2; 


		atribuicoes[9] = 10 / 9; //divisao c/ inteiros : resultado é um inteiro

		double $_1d = 10 / 0.0; //infinito positivo: compila e roda

		double $2_ = 0.0 / 0; //nan


		//atribuicoes[9] = 10 / 0; compila mas roda c/ exception
		

		System.out.printf("%nnot a number [%1$10.8f] infinito positivo: [%2$10.8f]", $_1d , $2_);

		for(Integer $_i : atribuicoes){
			System.out.printf("%n array de int:  [%1$5d]",$_i); 

		}

		for(Operador f_1 : _op){
			if (f_1 != null)
				System.out.printf("%n atribuição com float %1$f",f_1.$f);
		}

		List<Operador> _lista = new ArrayList<>();

		Operador _1$O = new Operador();

		_1$O.$f = 1f; //cuidado. Sem colocar f, int não pode ser convertido p/ Float					
		
		_lista.add(_1$O);

		

		_lista.add(new Operador());

		Operador _2_$ = new Operador();

		_2_$.$f = 10f;

		_2_$.$f++;
		
		++_2_$.$f;

		//++_2_$.$f++; nao compila

		_lista.add(_2_$);						

		//++_2_$.incremento(1);		 nao compila

		byte _b$1 = 127;//compila limite		

		//byte _b$2 = 128; nao compila 128 aqui ultrapassa range e fica inteiro

		byte _b$2 = ++_b$1		;//compila mas estoura e começa no -128

		System.out.printf("%n%1$,d", _b$2);


		/*List<> $listaBytes = new ArrayList<>();

		$listaBytes.add(_b$1);

		$listaBytes.add(_b$2);

		
		$listaBytes.forEach((b) -> System.out.printf("%n : %d", b));*/


		
		


		_lista.forEach($O -> System.out.printf("%n usando lambda: [%1$5.2f]", $O.$f));

		
		Integer _$i1 = 20, $_i2 = 10 ,  _$3I = (_$i1 = $_i2 + 3) + 5;  //declarando e definindo de forma abreviada as variaveis

		List<Integer> _listaInteger = new ArrayList<>();

		_listaInteger.add(_$i1)		;

		_listaInteger.add($_i2)		;

		_listaInteger.add(_$3I);

		_listaInteger.forEach(d -> System.out.printf("%nlabda com Wrap e ArrayList: %d",d)) ;

		String $concat1 = 0 + "10 + " + 0;



		//String _listaObjetos[] = new String[10];

		List<String> $listaObj = new ArrayList<>();

		String _listaObjetos[] = {10 + "100",  //concatencao int +string "10100"
				   "100" + 10,  //String + int = "10010"
				    "100" + 10 + 20, // "10010" + 20 => "1001020"
				    10 + 20 + "100",//"30100"
					"100" + (10 + 20)};//"10030"
			

		for(String _o$ : _listaObjetos){
			//_o$ = new Object();
			$listaObj.add(_o$);			
		}

		$listaObj.forEach(O$ -> System.out.printf("%n teste com concatenação: %s", O$));

		//Pool de Strings
		

		String $po = "Po";
		String _testePool$[] = {"Pool", //colocado no pool
				"Pool",//reaproveita do poll - apenas qdo inicializado c/ literal
				new String("Pool"),
				"Po" + "ol", //concatencao c/ apenas literal: reaporveita do pool
				$po + "ol", //concatencao c/ variavel - nao reaproveita
				//new char[]{'P', 'o', 'l', 'l'} Array de char nao é String
				"Pool".substring(0,4), 
				"Poolicia".substring(0,4)
		 };

		System.out.printf("%n Pool de String %n teste inicializado com literal: %1$b %n teste inicializado c/ new: %2$b %n concatencao de String: %3$b %n concatencao c/ variavel: %4$b %n retorno de metodo: entrada=saida: %5$b %n retorno de metodo: entrada<>saida: %6$b"
					 , _testePool$[0] == _testePool$[1], //deveria ser false pois estão apontando para dois objetos diferentes mas esta reaproveitando do pool
					_testePool$[0] == _testePool$[2], //false por q com new nao vai p/ o pool
					_testePool$[0] == _testePool$[3] ,
					_testePool$[0] == _testePool$[4]  ,
					_testePool$[0] == _testePool$[5] ,
					_testePool$[0] == _testePool$[6] 

);  
				


		Operador _1 = new Operador();
		Operador $2 = new Operador();
		Operador $3 = new Operador();

		List<Operador> $operadores = new ArrayList<>();
		
		Predicate<Operador> $teste  = o -> o.$f > 1.00;

		 //Predicate<Operador> $Operadorigual = (o1, o2) -> o1._1$nome == o2._1$nome; nao exite test c/ mais de 1 argumento
		

		_1.$f = 2f;
		$2.$f = 1f;
		$3.$f = 3f;	
		_1._1$nome = "Maria";
		$2._1$nome = "José";
		$3._1$nome = "Maria";




		System.out.printf("%n teste equals: %1$b %2$b", _1.equals($2), _1.equals($3));		

		$operadores.add(_1);
		$operadores.add($2);
		$operadores.add($3);
		
		$operadores.forEach($o -> System.out.printf("%n Teste Predicate: %b ", $teste.test($o)));
		
		//unreachable code

		if(false){System.out.printf("rodou %s", "teste");} //roda apesar de nao entrar nunca
		
		boolean _$falso = false;

		if(_$falso){System.out.printf("rodou %s", "teste");} //roda apesar de nao entrar nunca				 

		if(1 > 2){System.out.printf("rodou %s", "teste");} //roda

		
		//switch
		Integer $i1 = 3;
		final int _$i2 = 4;
		switch($i1){
			case 1: System.out.format("%n case 1: %1$d", $i1);
			//case 1: System.out.format("%n case 1 duplicado: %1$d", $i1); não compila, não pode ter valores duplicados
			case _$i2: System.out.format("%n case com variavel final : %1$d", $i1); 
			default: System.out.format("%n case default: %1$d", $i1); //pode aparecer no meio do switch. qdo nenhum caso bater, é chamado
			//break;
			case 1+1: System.out.format("%n case 1+1: %1$d", $i1);
		}

		boolean _$b1 = true;
		
		/*
		switch(_$b1){nao compila apenas int, Integer ou String
			case true: System.out.printf("%n case com boolean true: %1$b", _$b1);
			case false: System.out.printf("%n case com boolean false: %1$b", _$b1);
		}
		*/		

		String _S$1;
		_S$1 = "TESTE";
		switch(_S$1){
			case "TESTE" : System.out.printf("%n case com String teste: %1$s", _S$1) ;
			break;
			case "NAO TESTE": System.out.printf("%n case com String nao teste: %1$s", _S$1) ;//nao occore unreachabel code no switch
		}
		
	

	}


}