package exam.using.loop.constructs;


class _doWhileTest{

	public static void main(String [] args){

		//do while: o bloco vai ser executado pelo menos 1x, diferente do while q a condição é testada antes de executar
		int i = 10;
		do{
			System.out.println("vai imprimir pelo menos 1x");
		}
		while(i<10); //; é obrigatório

		i = 0;
		do{
			System.out.println("15vai imprimir: " + i++);
		}
		while(i<10);

		i=0;
		do //chaves é opcional qdo tem 1 statement apenas
		System.out.println(15 + 10 + "vai imprimir: " + ++i);
		//System.out.println("vai dar erro sem chaves");//nao compila
		 while(i<10);
		
			

		

	}


}