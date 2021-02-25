class Livro{

	String teste;

	public static void main (String ... args){

		//static int i; static não pode ser declarado como var local

		//CARACTERES UNICODE
		 char a = '\u0061';
		// char 'a' = 'a';
		 char \u0062 = 'a'; // \u0062 = b
		 ch\u0061r c = 'a'; // \u0061 = a
		 //ch'a'r a = 'a';

		System.out.println(new Livro().teste); //vai inicializar e imprimir null


	}



}

class ThisUsage {
	int planets;
	static int suns;
	
	public void gaze() {
		int i;
		i = this.planets; //ok
		i = this.suns; //ok - mesmo sendo static, pode ser usado c/ this
		//this = new ThisUsage(); nao compila
		//this.i = 4; //nao compila: this é c/ relacao a var de instancia
		this.suns = planets; //ok - - mesmo sendo static, pode ser usado c/ this
	}

	static public void main(String ... args ){

		new ThisUsage().gaze();
	}
}

class MyClass {
	public static void main(String[] args) {
		int size = 20;
		int[] arr = new int[ size ]; //cada elemento será atribuido c/ seu valor default - nesse caso 0 (int)
		for (int i = 0; i < size; ++i) {
			System.out.println(arr[i]);
		}
	}
}

class DefaultValuesTest {
	int[] ia = new int[1]; //DEFAULT 0
	boolean b; ////false
	int i; //0
	Object o; //null
	
	public static void main(String[] args) {
		DefaultValuesTest instance = new DefaultValuesTest();
		instance.print();
	}

	public void print() {
		System.out.println(ia[0] + " " + b + " " + i + " " + o); //nao ira ocorrer NPE c/ concatenacao de valor null
	}
}

class Passing {
	public static void main(String[] args) {
		int a = 0; int b = 0;
		int[] bArr = new int[1]; //array - Objeto criado
		bArr[0] = b; 
		inc1(a); 
		inc2(bArr); //passando referencia p/ um obj - os efeitos dentro do método afetaram o objeto
		System.out.println("a=" + a + " b=" + b + " bArr[0]=" + bArr[0]);
	}

	public static void inc1(int x) { x++; }
	public static void inc2(int[] x) { x[0]++; } //os efeitos dentro do metodo afetaram o objeto passado como referencia, mesmo trabalhando c/ var local
}


class ParameterUse {
	public static void main(String[] args) {
		int a = 0;
		final int b = 1;
		int[] c = { 2 };
		final int[] d = { 3 };
		useArgs(a, b, c, d);
	}

	static void useArgs(final int a, int b, final int[] c, int[] d) {
		 //a++; erro - var local é final
		 b++;
		 b = a;
		 c[0]++; //nao da erro pois é o elemento q esta sendo alterado e não o objeto array
		 d[0]++; 
		 //c = d;  erro - o array c é final
	}

	void compute(char[] ca, int... is) { }
}

class RQ800_40 {
	static void print(Object... obj) {
		System.out.println("Object...: " + obj[0]);
	}

	public static void main(String[] args) {
		
		Object o = 1; //nao tem problema Object receber um primitivo
		System.out.println(o);//1
		print("9", "1", "1");
		 print(9, 1, 1); //nao tem problema Object receber um primitivo
		print(new int[] {9, 1, 1}); //aqui vai mostrar o endereco de memoria do array de primitivos
			

		 print(new Integer[] {9, 1, 1});

		Object o2[] = new Integer[] {9, 1, 1};
		System.out.println(o2[0]); //9		
			

		 print(new String[] {"9", "1", "1"});
		 print(new Object[] {"9", "1", "1"});
	}
}

class RQ800_20 {
	static void compute(int... is) { // (1)
		System.out.print("|");
		for(int i : is) {
			System.out.print(i + "|");
		}
		System.out.println();
	}

	static void compute(int[] ia, int... is) { // (2)
		compute(ia);
		compute(is);
	}

	static void compute(int[] inta, int[]... is) { // (3)
		for(int[] ia : is) {
		compute(ia);
		}
	}

	static void testeArray(int[]... inta) { //varargs de array recebe qq dimensao de array
		for(int[] ia : inta) {
			for(int ia2 : ia) {
				System.out.println(ia2);
			}
		}
	}

	public static void main(String[] args) {
		compute(new int[] {10, 11}, new int[] {12, 13, 14}); // (4)
		compute(15, 16); // (5)
		compute(new int[] {17, 18}, new int[][] {{19}, {20}}); // (6)
		compute(null, new int[][] {{21}, {22}}); // (7)
		
		testeArray(new int[] {12, 13, 14});
		testeArray(new int[][] {{19}, {20}});
		//testeArray(new int[][][] {{19}, {20}, {{21}}});

		//int[]... ia = new int[][] {{19}, {20}};
				
	}
}