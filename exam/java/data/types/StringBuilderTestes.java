package exam.java.data.types;

class StringBuilderTeste{

	public static void main(String... args){

		StringBuilder sb = new StringBuilder();
		System.out.println(sb);//funciona como se fosse toString
		System.out.println(sb.toString());

		StringBuilder sb2 = new StringBuilder("Jefferson");
		System.out.println(sb2);//funciona como se fosse toString
		System.out.println(sb2.toString());

		sb2.append(" Ribeiro"); //concatena
		System.out.println(sb2);

		StringBuilder sb3 = new StringBuilder(50); //tamamnho 50 não conteudo do string
		System.out.println(sb3);

		StringBuilder sb4 = new StringBuilder(" de");
		sb2.append(sb4); //sb pode concatenar outro sb
		System.out.println(sb2);

		sb2.append(' ');//concatenando apenas 1 caractere
		System.out.println(sb2);

		Pessoa p = new Pessoa();
		p.setNome("Deitel");
		
		StringBuilder sb5 = new StringBuilder();
		sb5.append(p);//appende com o retorno do toString da classe do objeto
		System.out.println(sb5);

		sb5.insert(0,"H. M. ");//insere na posicao 0 o texto desejado
		System.out.println(sb5);

		sb5.delete(2,5);//remove texto da posicao 3 a 5 (começa sempre pelo 0)
		System.out.println(sb5);

		//String nome = sb5; nao funciona
		String nome = sb5.toString(); //precisa converter antes: utilizar o o toString 
		System.out.println(nome);

		System.out.println(sb5.reverse());

		String nomeDoMeio = sb2.substring(10, 16);
		System.out.println(sb2);//nao altera o conteudo de sb2
		System.out.println(nomeDoMeio);

		sb2.append(" Medeiros").delete(9,17);//remove da posicao 9 ate a posicao 17, exceto a posição 17
		System.out.println(sb2);
	}



}



