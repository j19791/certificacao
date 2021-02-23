package api.testarSB;

public class SB implements api.SBivel{

	static public StringBuilder testaMutavel(StringBuilder[] arg){
		
		arg[0].append(" Java"); 
		return arg[0];

	}


	public void testaMetodo(StringBuilder sb){

		imprime("insert(index,str)" , sb.toString()  , sb.insert(9, "tion").toString());
		imprime("delete(inicio, fim)", sb.toString() ,	sb.delete(9, 13).toString());
			imprime("substring()", sb.toString(),sb.substring(5,9).toString()); //substring nao altera valor de sb
		imprime("indexOf(z)", sb.toString(), Integer.valueOf(sb.indexOf("z")).toString());
		imprime("reverse()", sb.toString(), sb.reverse().toString() );


	}

	public void imprime(String ... args){

		System.out.printf("%n testa StringBuilder: metodo [%3$10s] , argumento : [%2$5s], resultado: [%1$10s]", args[2], args[1], args[0]);


	}


}