package executavel;


import java.util.*;
import static lib.Rotinas.*;
import java.util.function.*;


class Methods_Encapsulation{

	StringBuilder sb;
	static StringBuilder $sb;

	static void testarReturnComVoid(){

		return;//pode usar return antecipado c/ void

	}

	Integer testarRetorno(){

		return Integer.valueOf(1);
		//System.out.printf("%n Saiu"); nao compila: unreachable statement

	}

	Double testarRetorno(Integer $i){

		switch($i){
			case 1: return new Double($i); //ou retorna
			default: throw new RuntimeException("%Não é 1"); //ou lança exception

		}
	}
	
	int testaStringPrimitivoComFinal(final String $s){
		//$s = "2"; variavel de parametro final não pode ser reatribuido
		return Integer.parseInt($s);


	}

	private static double testaPromocao(double $d){
		return $d;

	}

	protected static void testaPolim(Mae m){
		return;

	}



	static public void main(String args[]){


		Methods_Encapsulation.testarReturnComVoid();		

		
		//Object $o = Methods_Encapsulation.testarReturnComVoid(); vc não pode atribuir um metodo c/ retorno void p/ uma variavel

		Integer $i1 = new Methods_Encapsulation().testarRetorno();

		try{
		//atenção: o método imprimir só funcionou pq utilizei import static. import simples não funcionou		
		imprimir(new Methods_Encapsulation().testarRetorno(2).toString());
		}
		catch (RuntimeException r){
			System.out.printf("%n tratei o errinho de rtex");
		}
		
		System.out.printf("%n %d", new Methods_Encapsulation().testaStringPrimitivoComFinal(new String("1")));

		List<Double> doubles = new ArrayList<>();
		byte $b = 126;
		doubles.add(testaPromocao($b));		
		doubles.forEach( d -> System.out.printf("%n valor promocao: %f", d));





		testaPolim(new Filha("Bento",Integer.valueOf("30")));

		List<Mae> filhas = new ArrayList<>();
		filhas.add(new Filha("Escolastica", 30));
		filhas.add(new Filha("Lourdes", 33));
		filhas.add(new Filha("Bernadete", 13));

		Predicate<Mae> p = f -> f.idade >= 18;
		
		List<Mae> maiores = new ArrayList<>();

		maiores = Methods_Encapsulation.filtro(filhas, p);

		maiores.forEach(f -> System.out.printf("%n %s", f));

		System.out.printf("%n %s", testaStatic());

		new Methods_Encapsulation().testaInstancia();

		Mae $m = new Filha();
		$m.metodoStatic(); //da ref

		$m.metodoInstancia(); //da instancia

		Filha.testaThis();

		//new Filha().testaAmbiguidadePrmt(1.0, 1.0); nao acha
		//new Filha().testaAmbiguidadePrmt(1,2); forçada ambiguidade : d, i ou i, d??
		
		Visibilidade $v = Visibilidade.construtor();

		

		
	}


	static List<Mae> filtro(List<Mae> filhas, Predicate<Mae> p){

		List<Mae> maiores = new ArrayList<>();

		for(Mae f : filhas)
			if(p.test(f)) maiores.add(f);

		return maiores;

	}

	
	static String testaStatic(){

		//return sb; nao compila: variavel non-static nao pode ser acessada por um contexto static
		$sb = new StringBuilder("nao nulo");
		return new Methods_Encapsulation().testaInstancia($sb.toString()).append(" funcionou").toString(); ////mas compila/roda var static

	}

	StringBuilder testaInstancia(String str){
		return new StringBuilder(str);

	}

	StringBuilder testaInstancia(){
		$sb = new StringBuilder(" metodo instancia acessando var static");//compila e roda
		return $sb ;


	}
	

}


abstract class Mae{

	Integer idade;
	String name;

	Mae(){}

	Mae(String n, Integer i){
		name = n;
		idade = i;
	}

	abstract public String toString();

	static void metodoStatic(){System.out.printf("%n metodo da mae");}
	
	void metodoInstancia(){System.out.printf("%n metodo da mae");}

	


}

class Filha extends Mae{

	Filha(){}

	Filha(String n, Integer i){
		super(n, i);
	}

	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("Filha: nome: ");
		sb.append(name).append(", idade: ").append(idade);
		return new String(sb);
		
	}

	static void metodoStatic(){System.out.printf("%n metodo da filha");}	

		void metodoInstancia(){System.out.printf("%n metodo da filha");}

	static void testaThis(){
		//this.getName(); //this é uma non-static variable: não pode ser usada dentro de um contexto static
		//getName(); //metodo non-static nao pode ser chamado dentro de contexto static
		//Filha.getName();//metodo non-static nao pode ser chamado dentro de contexto static
		new Filha().getName(); //compila e roda
		


	}

	void testaSobrecarga(){}

	void testaSobrecarga(StringBuilder $sb){} //sobrecarregado

	/*Integer testaSobrecarga() //retorno nao é considerado nos critérios de overload
		{return 
			//new Integer(1.0); nao aceita double
			//Integer.valueOf(1.0); nao aceita double
			Integer.valueOf(_s); //compila c/ String
	}*/

	Integer testaSobrecarga(String _s) {
		return 
			//new Integer(1.0); nao aceita double
			//Integer.valueOf(1.0); nao aceita double
			Integer.valueOf(_s); //compila c/ String
	}

	//private void testaSobrecarga(){} encapsulamento diferente tbm nao é overload

	//void testaSobrecarga() throws NullPointerException{}	 throws tbm nao garante sobrecarga

	void testaSobrecarga(Character c) throws NullPointerException{}	 //sobrecarga

	void testaAmbiguidadePrmt(double $d1, int $d2){System.out.printf("%n double");}

	void testaAmbiguidadePrmt(int $d1, double $d2){System.out.printf("%n int");}


	

	String getName(){
		return name;
	}

}



class Visibilidade{

	private Visibilidade(){} //funciona mesmo c/ classe default

	public static Visibilidade construtor(){

		return new Visibilidade();
	}


}

class TestaThis{

	StringBuilder sb;
	Integer i;

	TestaThis(){System.out.printf("%n construtor padrão");}	

	TestaThis(StringBuilder psb, Integer pi){
		this(); //chama o construtor padrão
		System.out.printf("%n entra construtor c/ prmt");				
		sb = psb;
		i = pi;

	}

	TestaThis(String str){System.out.printf("%n construtor c/ String");};

	TestaThis(List<Mae> maes){
		//this(testaThisComStatic()); /pode chamar metodos staticos
		//this(new StringBuilder(), Integer.valueOf("10")); compila  e roda
		this(new TestaThis().testaMetodoNonStatic()); //compila  e roda - retorna um String q é parametro de um dos construtores
	}

	static String testaThisComStatic(){return "entra no this com static";				}

	String testaMetodoNonStatic(){return new String();}

	public static void main(String args[]){

		new TestaThis(new StringBuilder(), Integer.valueOf("10"));

		new TestaThis(new ArrayList<Mae>());

	}


}


class TestaVarargs{

	//vc nao pode fazer sobrecarga com varargs ou c/ array na mesma classe. Eh um ou outro
	static void testaVarargs(String ... strs){System.out.printf("%n chamou varargs");} 

	//static void testaVarargs(String [] strs){System.out.printf("%n chamou array");}

	static void testaVarargs(String  strs){System.out.printf("%n chamou nem array nem varargs");}

	static void testaVarargs(){System.out.printf("%n sem prmts");}

	static public void main(String ... args){

		
		testaVarargs(new String());
		testaVarargs(new String[10]); //chamou varargs
		testaVarargs(); //s/ prmts

	}



}



