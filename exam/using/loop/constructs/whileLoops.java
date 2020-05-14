package exam.using.loop.constructs;

class WhileLoopsTests{

	public static void main(String args[]){
		int i = 0;
		
		//parenteses obrigatório
		//chaves não obrigatório
		//expressão booleana precisa ser avaliada
		//
		while (i<10) 
			//System.out.println(i);loop infinito. (Compila e roda)
			//System.out.println(i++);//incremento do i afim de quebrar o while
			System.out.println(++i);//pré-incremento: começa no 1 e vai até 10 
		
		//sempre falso
		//while(false) System.out.println("Unreachable statement");//nao compila

		//variavel = pode ser true em algum momento q o compilador nao sabe. compila e roda
		boolean condicao = false;
		while(condicao) System.out.println(condicao);

		//constante - nunca muda - compilador sabe q o codigo nunca vai ser executado. não compila
		final boolean condicao2 = false;
		while(condicao2) System.out.println("Unreachable statement");
	}





}

