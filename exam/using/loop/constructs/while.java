class WhileTest{
	
	/*nao compila
	int teste(){
		while(true){
			System.out.println("compila");
		}
		return 1;//unreachable code;
	}*/

	static public void main(String[] args){

		/*compila mas loop infinito
		while(true){
			System.out.println("compila");
		}

		*/

		final boolean RODANDO = true;

		/*nao compila
		while(RODANDO)
			System.out.println("VAR FINAL");

		System.out.println("unreacheable code");
		*/

		boolean rodando = true; //qdo é variavel nao FINAL, compila, apesar do código na última linha nunca ser executado
		
		/*while(rodando)
			System.out.println("VAR FINAL");

		System.out.println("unreacheable code mas compila"); */

		/*nao compila: explicito
		while(false)
			System.out.println("unreacheable code");			

		*/
		
		/*nao compila: explicito
		while(2<1)
			System.out.println("unreacheable code");	
		*/

		

	}


}