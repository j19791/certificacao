package exam.using.decision.constructs;


class SwitchStatementTeste{

	public
		static
			void 

				main 
(
String [
]
argumentos){


	String s1 = argumentos[0];

	final String caso = "f";
	
	switch( s1 ){ //obrigatório usar parenteses e chaves. a opção deverá ser do mesmo tipo dos casos
		
		case "a": System.out.println("caso a");
			  break; //se nao colocar break, todos os casos abaixo sao executados. Com o break, sai do switch
		//default pode aparecer em qq posição da clausula
		default: System.out.println("pode aparecer em qq lugar");
			System.out.println("olha: sem chaves");
			break;
		case "b": System.out.println("caso b");
			break;
				// System.out.println("caso b2");unreachable statement. não compila se coolocar codigo depois do breakj
		case "c": {System.out.println("caso c");
				System.out.println("caso c2");
				break;}
		case "d": System.out.println("caso d");
		
		//opção String, caso int
		//case 5: System.out.println("caso que nao vai compilar");

		case "e": //obrigatório utilização dos 2 pontos
		//não é obrigatório o caso possuir instruções, pode ser vazio

		case caso: //pegadinha da prova: nao pode ser variavel mas pode ser final ou constante

		//case null: nao pode null

		//o case não aceita expressões como < x, mas sim um valor definido, literal ou constante em tempo de compilação.
	}	

	/* no case, o tipo numerico mais abrangente é o int
	long l = 1l;
	switch(l){
		case 1l:
	}*/

	//pode ser short
	short s = 1;
	switch(s){
		case 1:
	}
	
	/*nao pode se boolean
	boolean teste = false;
	switch(teste){
		case true:
	}*/


	String s2 = "a";
	switch(s2){
		case "a": System.out.println("apenas a");
		default: System.out.println("executou default sem o break no a");//o default é executado se nao colocar o break
	}	

}



}