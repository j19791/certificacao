package loops;

public class Loop{


	public void testaLoop(){

		Integer $i = 1;

		while($i++ < 10){
			System.out.printf("%n testa loop: %1$d", $i);

		}

	}

	static public void testaLoopExpInf(){

		while(true){
			System.out.printf("compila pq é %1$s", "infinito" );
		}//pode compilar e executar até aqui
		
		//com código abaixo de um loop explicitamente infinito, não roda
		//System.out.printf("unreachable statement"); 

	}

	//static public void testaLoopExpInf(final Boolean condicao){
	static public void testaLoopExpInf(final boolean condicao){
		//compila e roda qdo o final esta nos argumentos do método
		while(condicao){
			
			System.out.printf("compila pq é %1$s", "infinito" );			
		}

		System.out.printf("unreachable statement"); 
	}

	static public void testaLoopExpInfComFinal(){
		//final Boolean condicao = true; compila infinitamente com wrapper
		final boolean condicao = true; //nao compila c/ código depois do while

		while(condicao){
			
			System.out.printf("compila pq é %1$s", "infinito" );			
		}

		//System.out.printf("unreachable statement"); 


	}

	static public String[] testaCondicaoFalse(){

		boolean CONDICAO = false; //compila, executa infinitamente pq é variavel
		//final boolean CONDICAO = false; nao compila pq é cte
		//while(false)
		while(CONDICAO)
			System.out.printf("%n compila e executa" );							
		return new String[]{};

	}


	public static Character[] testaFor(Boolean[] args){
		
		//for(;;) false
		//for(;true;)
		
		System.out.printf("%n unreachable statement qdo false ou true" ); 									
				

		return new Character[1];

	}

	static public Object[] testaInicializacaoFor(String ... args){

		for(int i=0, j=0; i < 10; i++, j++)
			System.out.printf("%n metodo testaInicializacaoFor" ); 									

		Integer _i ;
		Byte $b ;

		for(_i = 0, $b = 0; _i < 10; _i++,  System.out.printf("%n metodo testaInicializacaoFor com inicializacao c/ tipos diferentes: %1$d %2$d", _i, $b ) );

		return new Object[1];
	}

	static public Boolean[] testaDoWhile(Boolean condicao){
		//if(condicao == true){
		do{
			System.out.printf("%n testa do while");
			condicao = false;	
		}while(condicao);
		//return new Boolean[]{true};
		//}
		throw new RuntimeException("testaDoWhile");

	}

	static public void testaWhileInfinitoComBreak(){
		
		rotulo: while(true){
			break rotulo2;
		}

		return;

	}


}