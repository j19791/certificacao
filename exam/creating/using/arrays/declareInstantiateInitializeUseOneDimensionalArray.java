package exam.creating.using.arrays;

class DeclareInstantiateInitializeUseOneDimensionalArrayTest{

	public static void main( String []args){

		//Declare
		//tudo abaixo compila e roda mas essas variaveis precisam obriatoriamente ser inicializadas p/ serem usadas
		int [] idades;
		double pesos[];
		long []numeros;
		long[]tamanhos;

		

		//Instantiate
		int [] idades2 = new int[10]; //obrigatório especificar o tamanho do array;		
		//int idades3[] = new int[10.1]; compila apenas com inteiro
		//int []idades4 = new int[-10];//compila mas c/ exception em tempo de execução: Negative Array Size
		int []idades5 = new int[0];//compila e executa
		//int idades6[] = new short[10];nao compila: short[] nao pode ser convertido em int[]
		boolean condicoes[] = new boolean[2];		
		pesos = new double[3]; //ja declarado anteriormente
		String[] palavras = new String[4];

		System.out.println(idades2[0]); //array de inteiro é inciializado com valor 0 (default)
		System.out.println(condicoes[1]);
		System.out.println(pesos[2]); //0.0
		System.out.println(palavras[3]);//null.com indice 4 da index out of bounds em execução

		//Initialize
		int idades7[] = new int[]{2,4,6,8};//declara, instacia, inicializa ao mesmo tempo
		System.out.println(idades7[1]);
		idades5 = new int[]{1,3,5,7}; //compila e roda
		//idades2 = {9,8,7,6}; //nao compila
		int i2[] = {1,2,3};//compila e roda

		Cliente c;
		Cliente maria = new Cliente();
		maria.nome = "Maria";
		Cliente jose = new Cliente();
		jose.nome = "José";
		Cliente clientes[] = new Cliente[]{maria, null, jose};
		
		//atenção: length é propriedade do Array (não tem ()) length() é método da String
		for(int i =0; i < clientes.length ; i++){
			if (clientes[i] == null) continue;
			System.out.println(clientes[i].nome);
		}

		for(Cliente cliente : clientes){
			if (cliente == null) continue;
			System.out.println(cliente.nome);
		}
			
		//Cliente cl;
		//for(cl : clientes){ nao funciona declarar variavel antes
		for(Cliente cl : clientes){
			if (cl == null) continue; //continue funciona no enhanced for
			System.out.println(cl.nome);
		}
		
		//aqui funciona pois nao tah acessando o cliente null, apenas imprimindo posição da memória
		for(Cliente cliente : clientes){
			//if (cliente == null) continue;
			System.out.println(cliente);
		}

		
		Vip c2 = new Vip();
		c2.nome = "Jefferson";
		Cliente clientes2[] = new Cliente[10];

		clientes2[0] = c2; //Cliente  é pai de vip. consegue atribuir
		System.out.println(clientes2[0].nome);

		c2.nome = "Deitel";
		System.out.println(clientes2[0].nome); //o elemento do array é referencia p/ o mesmo objeto q c2 aponta

		//casting implicito
		//funciona por elemento
		long l2[] = new long[10];
		int i1 = 1;
		l2[0] = i1;

		//array recebe array		
		int i3[] = new int[10];
		//long l3[] = i3; //nao posso converter int[] para long[]
		//long l3[] = (long[]) i3; //nao compila tbm com casting
		long l3[] = new long[]{i3[0]};//compila e roda

		
		Cliente clientes3[] = new Cliente[10];
		Vip vips3[] = new Vip[10];
		
		for(int i=0;i<vips3.length; vips3[i] = new Vip(), vips3[i].nome = "Jefferson",i++);
		//for(Vip vip : vips3) vip.nome = "Jefferson"; compila mas nao roda

		clientes3 = vips3;
		System.out.println(clientes3[3].nome);
		

		
		

	}



}

class Cliente{

	String nome;
	

	
}


class Vip extends Cliente{}
