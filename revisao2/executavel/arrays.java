package executavel;
import static lib.Rotinas.*;


class ArraysTest{


	public static void main(String ... args){

		//Boolean [] b  = new Boolean[]; //não compila s/ dimensao
		Boolean [] b  = new Boolean[0];

		//b[0] = true; AIOOBEx

		//Boolean [] _b  = new Boolean[-1]; compila mas NASEx
		

		Integer _inteiros[] = new Integer[1];

		//_inteiros[0].intValue(); nao inicializaou obj mas apenas o array: NPE

		//Integer [] $ints = new Integer[1]{new Integer(1)}; nao compila: ou vc passa a dimensao ou inicializa c/ valores

		Integer [] $ints2 = new Integer[1];

		Integer [] $ints3 = new Integer[]{new Integer(1), Integer.valueOf(2), 3, Integer.valueOf("4")}; 

		imprimirList(converterArrayList($ints3));

		separar();

		Character $chars[] = {'J', 'a', 'v', 'a'}; //declarar e inicializar na mesma linha

		imprimirList(converterArrayList($chars));		

		separar();

		Double _doubles[];

		//_doubles[] = {new Double(1.0), Double.valueOf(2.0), 3.0, Double.valueOf("4.0"), new Double(5)}; nao compila

		//_doubles = {new Double(1.0), Double.valueOf(2.0), 3.0, Double.valueOf("4.0"), new Double(5)}; nao compila

		_doubles = new Double[]{new Double(1.0), Double.valueOf(2.0), 3.0, Double.valueOf("4.0"), new Double(5)
		//, 6 primitivo int nao pode ser convertido p/ Double
		};

		imprimirList(converterArrayList(_doubles));				

		//pode criar array de abstract	class
		Mae[] filhas = new Mae[1];
		
		filhas[0] = new Filha();

		//new Mae(); abstract class nao pode ser inicializada


		Interfaciavel[] interfaces = new Interfaciavel[0];		

		separar();
		imprimir("atribuicao de arrays");

		int ints[] = {1,2,3,4,5}, ints2[] = new int[10];

		imprimir("ints");
		imprimir(ints);

		ints2 = ints; //atribuicao de array em array

		imprimir("ints2");		
		imprimir(ints2);		

		//long longs[] = ints; int[] nao pode ser convertido em long[]
		long longs[] = {ints[0]	, ints[1], ints[2]}; //mas pode receber normalmente elementos int

		int $i = 1;
		long $l = 1, $l2 = $i;

		separar();
		imprimir("array de Objects");
		
		Object _objetos$ [] = {"Sao", "Judas","Tadeu"};

		//String _santo$ [] =  _objetos$; Object[] nao pode ser convertido em String[]
		//String _santo$ [] = (String) _objetos$; Object[] nao pode ser convertido em String - casting

		//String _santo$ [] = (String[]) _objetos$; //compila mas da CCEx 


		separar();
		imprimir("Arrays bi");
		Integer $integers[][] = new Integer[2][]; //declarando uma dimensao dew array bidimensional
		$integers[0] = new Integer[1];//declarando a segunda dimensao do array bi
		$integers[1] = new Integer[2];

		for(Integer[] $s : $integers)
			System.out.printf("%n length de array bi %1$10d", $s.length);

		Integer $integers2 [][] = {{1,2,3}, {4,5}};

		for(Integer[] $s : $integers2)
			System.out.printf("%n length de array bi %1$10d", $s.length);



	}



}

abstract class Mae{}

class Filha extends Mae{}

interface Interfaciavel{}
