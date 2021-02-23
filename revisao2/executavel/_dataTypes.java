package executavel;
import lib.*;
import static lib.Rotinas.*;

class DataTypeTest{


	public static void main(String args[]){
		
		String[] $strings = new String[10]; //vlr null é atribuido automaticamente
		

		System.out.printf("%n Inicializacao array com String %1$s; Concatenacao c/ null: %2$s", $strings[0], $strings[1] + " não deu problema c/ concatenação de valor atribuido automaticamente c/ null (array)");

		char $c[] = new char[]{'a', 65};


		System.out.printf("%n %1$c, %2$c, %3$c", $c[0], $c[1], '\u03A8');

		int []  $i = new int[]{0761, 0xFFF, 0b10111};

		System.out.printf("%n Inteiros com outras bases: %1$d , %2$d , %3$d ", $i[0], $i[1], $i[2]);

		//criar rotina´p/ converter array to ArrayList p/ ser importado

		Rotinas.converterArrayList($i)		;

		//float _f = 1.0; nao funciona - float nao recebe double
		
		float _f = 1.0F; //funciona

		float _f2 = (float) 1.0,  //funciona c/ cast
		//f3 = 1e4;  notacao cientifica é double
		
		f3 = 1e4f;

		System.out.printf("%n float: %1$f, %2$f, %3$f", _f, _f2, f3);

		int _[] = new int[]{12_4, 1_4, 01_7, 0_1_7, 0xa_f, 0b1_0, 0_17};

		for(int $i2 : _)
			System.out.printf("%n teste c/ underline: %1$d", $i2 );


		Rotinas.separar();
		
		Character _c = 'c', _c2 = 65, _c3 = new Character('a');
		
		//_c4 = new Character(65); nao compila				
		
		Rotinas.imprimirList(Rotinas.converterList(_c, _c2, _c3));

		Rotinas.separar();

		imprimir("Double");

		Double []$ = new Double[]{12d, 12.0, new Double(12.6), new Double("12.7"), 
			new Double(12), //compila
			new Double("12")
			//,new Double("0b1111") compila mas nao roda: NFEx
			};

		//Double $d2 = 10; int nao pode ser convertido diretamente p/ Double
		
		Rotinas.imprimirList(Rotinas.converterList($));

		Rotinas.separar();		

		imprimir("Integer");
		
		Integer _$1 [] = new Integer[]{1
		//, "1" String nao pdoe ser convertido p/ Integer
		//1.0, nao compila -double 
		//new Integer(1.0) nao compila
		,new Integer("1") //aceita string c/ new
		,0777 //octa
		,new Integer(0xaf)};
		
		Rotinas.imprimirList(Rotinas.converterList(_$1));

	
		Rotinas.separar();		

		imprimir("Boolean");

		Boolean $bol [] = new Boolean[]{true, 
		//"false", String nao pode ser convertido p/ Boolean
		new Boolean("true"), new Boolean("FaLsE"), new Boolean("TrUe"), 
		new Boolean("qualquer coisa")};//false

		
		
		
		Rotinas.imprimirList(Rotinas.converterList($bol));

		Rotinas.separar();		

		imprimir("Conversão Wrapper p/ primitivo numerico");

		short s = 126;		

		int $ints [] = new int[]{new Double("123.45").intValue() //nao ocorre perda de precisao
		,new Float(2).shortValue()
		//,new Long(65).charValue()  nao tem conversao				
		//,new Short(126).doubleValue() nao compila: nao tem construtor de Short p argumento int
		,new Short(s).intValue()
		,new Byte((byte) 125).byteValue()
				};

		

		for(int $i2 : $ints)
			System.out.printf("%n [%1$20d]", $i2);
		
		//Rotinas.imprimirList(Rotinas.converterList($ints));
		
		separar();

		char[] $charsValue = new char[]{new Character('a').charValue(), new Character('b').charValue()};

		for(char $_c : $charsValue )
			System.out.printf("%n [%1$20c]", $_c);

		separar();

		boolean [] $booleansValue  = new boolean[]{new Boolean("true").booleanValue(), new Boolean("FaLsE").booleanValue(), new Boolean("TrUe").booleanValue(), new Boolean("qualquer coisa").booleanValue()};//false

		for(boolean $_b : $booleansValue  )
			System.out.printf("%n [%1$20b]", $_b);

		/* string p/ primitivo */

		double [] $parseDoubles = new double[]{Double.parseDouble("1234.56")
		//	, Integer.parseInt("12345.67") NFE //inclui no anki
		, Integer.parseInt("123456") //incluir no anki
		, Short.parseShort("-127")
		, Byte.parseByte("-127")
		//, Byte.parseByte("128") //nfe out of range do byte
		, Integer.parseInt("FF", 16)
		, Long.parseLong("FF", 16)
		, Short.parseShort("FF", 16)
		//, Double.parseDouble("77", 8) //nao compila - apenas Long p/ baixo
		
		};
		
		separar();
		imprimir("Strings p/ primitivo (parse): XXX.parsexxx(str)");


		for(double $_d : $parseDoubles  )
			System.out.printf("%n [%1$20f]", $_d);	

		//String p/ wrapper

		separar();
		imprimir("String p/ wrapper: ");
		separar();

		Double [] $DoublesFromString = new Double[]{Double.valueOf("12345.67"), Double.valueOf("12345")
		//, Integer.valueOf("123.45") 
		//, Integer.valueOf("123") Integer nao pode ser convertido p/ Double
		};


		Rotinas.imprimirList(Rotinas.converterList($DoublesFromString));		

		Integer [] _integers = new Integer[]{
		Integer.valueOf("123") 
		//, Integer.valueOf("123.45") nfe
		,Integer.valueOf("ff", 16)
		};

		imprimirList(converterList(_integers));

		//Wrapper p/ String 

		separar();
		imprimir("Wrapper p/ String ");
		separar();

		String [] $strs = new String[]{
			new Integer(12347).toString()
			//,new Integer(12347) String nao recebe Integer
			//,Integer.valueOf(aa, 16).toString() nao compila: acha q aa é variavel
			,Integer.valueOf("aa", 16).toString()
			, Integer.toString(17,16)
			, Integer.toHexString(17)
		};

		imprimirList(converterList($strs));
		
		//cache
		Byte $b1 = 126, $b2 = 126;

		Integer $i1 = 123456, $i2 = 123456;

		System.out.printf("%n cache Byte 126 == : %1$b, Integer valor alto 123456 : %2$b ",$b1==$b2, $i1 == $i2);

		
		

	}
}