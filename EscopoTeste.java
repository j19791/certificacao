//não precisa ser public 
class EscopoTeste{

	int i; //variavel de instancia, objeto, atributo, membro. Funciona mesmo se os metodos declararem variaveis locais. Não precisam ser inicializadas

	//static int i;  nao funciona com o mesmo nome, mesmo sendo static

	static int j = 4;
	
	//sempre incluir parenteses no método
	void metodo1(){// se o método não for abstrato, incluir sempre bloco de comando {}
		String v1 = "v1: Escopo metodo1";
		System.out.println(v1);

	};

	EscopoTeste(){};//construtor padrão explicito (não é metodo)

	void metodo2(String v1){
		//String v1 = "v1: Escopo local do metodo2"; não posso definir nova variavel com o mesmo nome do parametro do metodo
		System.out.println(v1);// sempre colocar ; no final das linhas de comando

	}

	void metodo3(){
		System.out.println(i)	; //o escopo da variavel de instancia/objeto/atributo/membro é acessível atraves dos seus metodos não estáticos
	}
	
	/*não funciona : o escopo da variavel de instancia/objeto/atributo/membro não é acessível atraves dos seus metodos estáticos
	static void metodo4Statico(){
		System.out.println(i)	;
	}*/

	//funciona pois j static
	static void metodo5Statico(){
		System.out.println(j)	;
	}


	//a classe precisa ter metodo main para rodar com o comando java
	//o metodo main deverá ser public
	public static void main(String args[]){ 
		
		String v1 = "v1: Escopo local main";// as váriaveis deverão ser inicializadas sempre, não importa se são primitivas
		
		//pode ter blocos de código soltos sem nenhum código
		{ 
			//String v1 = "v1 dentro de um bloco solto"; //nao funciona pois o v1 ja foi declarado anteriormente num bloco q nao acabou
			//System.out.println(v1);
		}		
		
		{ 
			String v2 = "v2 dentro de um bloco solto"; //nao funciona pois o v1 ja foi declarado anteriormente
			System.out.println(v2);
		}

		String v2 = "v2 fora do bloco solto";//funciona pois v2 anterior foi declarado dentro de um bloco q começa e acaba antes
		System.out.println(v2);		

		// int v1 = 0; não pode declarar variavel com o mesmo nome no mesmo escopo, mesmo se são de tipos diferentes ou static

		System.out.println(v1);
		
		EscopoTeste t1 = new EscopoTeste(); //os objetos instanciados de classe deverão ser sempre inicializados com new (no minimo c/ o construtor padrão implicito)
		
		//metodo1();precisa ter um objeto instanciado chamando o metodo
		t1.metodo1();
		t1.metodo2("parametro do metodo2");

		//testando o escopo das variaveis atributos com mesmo nome
		for(int i=0;i<3;i++){//bloco do for
			System.out.println(i);
		}

		for(int i=0;i<3;i++) System.out.println(i);//funciona pois o bloco implicito é sempre o comando q vem depois do for
			//System.out.println(i);não funciona pois o escopo da variavel i é apenas dentro do for. Não tem bloco
		
		int i = 0; //funciona mesmo se existe variavel de instancia/objeto atributo da classe com o mesmo nome
		if(i < 1) System.out.println("testando escopo do if");

		EscopoTeste t2 = new EscopoTeste();

		System.out.println("Variavel de instancia/objeto/atributo/membro i: " + t2.i);

		t2.metodo3(); //funciona pois o metodo 3 não é estatico

		System.out.println(j);//funciona pois j é atributo estatico - o vaLOR É O MESMO não importa objeto
		System.out.println(t1.j);//funciona pois j é atributo estatico. podem ser acessadas de qq escopo, até por metodos estaticos
		System.out.println(t2.j);//funciona pois j é atributo estatico

		int j = 2;
		System.out.println(j);//aqui o valor é da variavel local, não da classe (static)

		
		EscopoTeste.metodo5Statico();

		metodo5Statico(); //funciona pois o nome da classe esta implicito

	}


}