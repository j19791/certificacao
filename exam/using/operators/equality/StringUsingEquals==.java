package exam.using.operators.equality;

class StringUsingEqualsTest{ //nao conseguiu compilar usando == , mas gerou class com o nome da classe alterado

	public static void main(String args     [ ]  ){

		//criando String com literal
		String s1 = "Certificação";
		String s2 = "Certificação";

		System.out.println(s1 == s2);//true. qdo literal, mesmo valor, mesmo local na memoria (otimizacção da JVM)
		System.out.println(s1.equals(s2));//true. comparação apenas com valor, sem se preocupar com posição de memoria

		String s3 = new String("Certificação");//criacao do obj
		String s4 = new String("Certificação");//criacao do obj
		String s5 = s3;//referenciando o obj referenciado por s3


		System.out.println(s3 == s4); //false. comparando se as referencias estão apontando para o mesmo objeto
		System.out.println(s3.equals(s4)); //true. comparando apenas valores
		
		System.out.println(s3 == s5); //true. as duas variaveis referenciam o mesmo objeto
		System.out.println(s3 == s4);//false. objetos diferentes
		System.out.println(s3.equals(s4));//true. comparando apenas os valores
		
		System.out.println(s1 == s3); //false. referencias apontando para obj diferente em memoria
		System.out.println(s1.equals(s3)); //true. comparação de valor


		String ab = "a" + "b"; //literal + literal = literal -- obj é colocado no pool
		System.out.println(ab == "ab");//true - "ab" liteal "ab" ja esta no pool. nao criado novo

		String a = "a"; //"a" literal foi colocado no pool de String
		String ab2 = a + "b"; //nao literal + literal = nova posicao da memoria e não foi colocado no pool
		System.out.println(ab2 == "ab");//false. posições diferentes na memoria

		String s6 = "Estudando certificação";		
		String s8 = "certificacao";//novo obj no pool
		String s7 = s6.substring(10); //certificação. //novo objeto. não retornado do pool. quando String retorna de metodo, coloca no pool
		System.out.println(s7);
		System.out.println(s7==s8);//false

		String s9 = s8.toLowerCase(); //o resultado do metodo é exatamente igual a s8;nao é criado novo objeto, o valor vem do pool
		System.out.println(s9);
		System.out.println(s9==s8);
		
		//contagem de objetos criados
		String h = new String ("hello "); //2: 1 literal que vai p/ o pool e outro com new
		String h1 = "hello "; //0: literal hello ja esta no pool
		String w = "world"; //1: literal vai p/ o pool

		System.out.println("hello "); //0 : literal ja esta no pool       
		System.out.println(h1 + "world"); //1: objeto + literal cria novo objeto. Não vai p/ o pool
		System.out.println("Hello " == h1); //false. 1: Hello != hello . Hello literal q vai p/ o pool
		//total de objetos criados: 5
		

	}


}