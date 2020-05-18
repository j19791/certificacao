package exam.working.methods;

class ConstructorsTest{

	int a = 1; //prioridades
	//nullpointer se invocar o metodo antes de inicializar a variavel
	//int tamanho = tamanhoNome();
	String nome = "certificação"; //deixa de retornar nullpointer qdo atribui o valor
	int tamanho = tamanhoNome();//nullpointer se invocar o metodo antes de inicializar a variavel (mesmo com null)
	//1o. inicializa as variaveis membro
	//2o. construtor atribui valores as variaveis membro

	/*ConstructorsTest(){
		super(); //chama o construtor da classe pai (Object no caso)
	} construtor padrão*/

	//construtor pode ser default, public, protected ou private

	//qdo criado o construtor com parametros, o construtor padrão deixa de existir
	ConstructorsTest(int a){
		System.out.println(this.a);
		this.a = a;
	} 

	//vc precisa criar explicitamente o construtor padrão para evitar quebras de código
	ConstructorsTest(){} 

	int tamanhoNome(){
		return this.nome.length();
	}

	/* loop infinito de construtor
	ConstructorsTest(){new ConstructorsTest();} 
	*/
	
	//nao é construtor. é um novo método qq
	int ConstructorsTest(){return 1;}
	
	public static void main(String[] args){
		ConstructorsTest ct = new ConstructorsTest(2);
		System.out.println(ct.a);
		ConstructorsTest ct2 = new ConstructorsTest();
		ct2.ConstructorsTest();

		Pessoa p = new Pessoa("certificação");
		System.out.println(p.n);

	}
	
	//compila e roda
	public static void main(int... args){}

	//nao pode ter 2 mains com os mesmos argumentos, mesmo um deles sendo varargs
	//public static void main(String... args){}




}

class Pessoa{
	
	final String n ; //se uma variavel é final mas não foi inicializada, ela pode seer inicializada depois, 1x


	private String nome;
	
	/*com private nao compila na chamada
	private Pessoa(String nome){
		this.nome = nome;
	}*/

	public Pessoa(String nome){
		this.nome = nome;
		this.n = "valor default"; //primeira e unicia inicialização perimitda
		//this.n = "valor default"; nao compila. final n ja foi atribuido acima
		//this.nome = "José";
	}

}

