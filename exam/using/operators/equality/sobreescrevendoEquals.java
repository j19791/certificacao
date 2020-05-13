package exam.using.operators.equality;




class SobreescrevendoEqualsTeste{

	public static void main(String[] args){

		Cliente c1 = new Cliente("Jefferson");
		Cliente c2 = new Cliente("Jefferson");
		
		System.out.println(c1.equals(c2));//false. O equals utilizado é o equals do Object que utiliza == (compara as referencias das variaveis p/ objetos)


	}


}


class Cliente{

	String nome;	
	
	Cliente(    String      nome){
		this.nome = nome;
	}
	
	//aqui a assinatura do equals precisa ser exatamente essa para sobreescrever o meto equals do Object 
	//não é sobrecarga (metodos com parametros com tipos diferentes)
	public boolean equals(Object obj){
		Cliente c = (Cliente) obj;
		return this.nome == c.nome; //a comparacao entre objetos vai ser com o conteúdo dos nomes

	}

		
	
	
}