package api.testarString;

public class ClasseString{


	private String _str;


	public String testarImutavel(String ... strings){
		if (strings.length == 2)
			strings[0] = strings[1];
		else throw new RuntimeException("vc precisa de duas strings p/ funcionar");

		return strings[0];		

	}

	public String testarImutavel(String string){

		string.substring(1,2);

		return string;

	}


	static public void saida(String str){

		System.out.printf("%n testa String imutavel com literal: %1$s", str);
	}

	static public Boolean testaString(){


		String $1 = new String("Java"), $2 = "Java";
		return ($1==$2);

		

	}

	static public Boolean testaString(String ... str){

		String $1 = new String(str[0]), $2 = str[0];
		return ($1==$2);

				

	}

	static public void testaStringNull(){

		String $1,  //se não usar a variavel, não tem problema. Se usar: não compila
		// $_1 = new String(null), nao funciona
		$2 = null; //compila, não dá erro qdo usada sem métodos. É um literal "null" basicamente

		String $3 = $2 + " como isso da certo ?"; //sem problemas qdo usada

		String $4 = null + " parece até mágica!"; //s/ problemas qdo usado

				
		
		try{
			//nem compila:
			//System.out.printf("%n Testa String null: %1$10s", $1);
			System.out.printf("%n Testa String atribuida c/ vlr null: %1$10s", $2); 
			System.out.printf("%n Testa concatenação c/ null: %1$20s", $3);
			System.out.printf("%n Testa concatenação c/ null: %1$20s", $4);
			//$2.length();	qdo uma string null é usada com seus métodos, da NPE
		}
		catch (NullPointerException n){
			System.out.printf("%n Nulo");
		}
	

	}

	static public void testaMetodosString(String ... strs) throws StringIndexOutOfBoundsException{

		
		imprime(Integer.valueOf(strs[0].length()).toString(), strs[0],  "", "length()");
		
		imprime(Boolean.valueOf(strs[0].isEmpty()).toString(), strs[0], "b", "isEmpty()");

		imprime(Boolean.valueOf("".isEmpty()).toString(), "", "b", "isEmpty()");

		imprime(strs[0].substring(0, 12), strs[0], "s", "substring(i, f)");//RANGE 0 A 12: certificacao possui 11 sendo 12 o valor maximo para pegar a str inteira

		imprime(strs[0].replace('c', 'd'), strs[0], "s", "replace(old, new)"); //com char. case sensistive

		imprime(strs[0].replace("cao", "bao"), strs[0], "s", "replace(old, new)"); //com charsequence. case sensistive

		imprime(Integer.valueOf(strs[0].compareTo("Java")).toString(), strs[0], "s", "compareTo(Java)"); //- antes, + depois. Upper antes lower

		imprime(Integer.valueOf(strs[0].compareTo("casa")).toString(), strs[0], "s", "compareTo(casa)"); //- antes, + depois. Upper antes lower

		imprime(Integer.valueOf(strs[0].compareTo("Certidao")).toString(), strs[0], "s", "compareTo(Certidao)"); //- antes, + depois. Upper antes lower

		//

	}


	static void imprime(String ... args){
		

			System.out.printf("%n testa metodo String [%3$10s] c/ argumento [%2$10s] e resultado: [%1$10s]"  , args[0], args[1] ,  args[3]);


	}
		

}