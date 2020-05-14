class ReturnTest{

	public static void main(String[] args){

		if(true){
			System.out.println("entrou no if");
			return;//saiu do if e do programa. 
			//System.out.println("nao sei se executa esse codigo");//unreachable statement
		}
		//o codigo abaixo nao é executado		
		System.out.println("o return é do main ou do bloco?");

		return;		

		

	}



}

