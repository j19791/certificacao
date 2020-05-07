class EstaticoTeste{

	static int i = 1;

	public static void main(String[] a){

		System.out.println(i); // variaveis estaticas podem ser acessadas dentro de metodos estaticos
		//System.out.println(EstaticoTeste().i); nao funciona, i é atributo nao metodo
		System.out.println(new EstaticoTeste().i); //precisa dar new (criando objeto anonimo)
		i =i +1;
		System.out.println(i);//podem ser modificados - retorno = 2
		

	}


}

