class $A {
	static void method() {
		System.out.println("a");
	}
}

class $B extends $A {
	static void method() {
		System.out.println("b");
	}
}


class $1A{

	int b = method();
	
	int method(){
		return a;
	}

	int a = 15;

}

class $1B{

	static int b = method();	
	
	static int method(){
		return a;
	}

	static int a = 15;

}

class _StaticTest{

	public static void main (String ... args){

		$A a = new $A();
		$B b = new $B();

		a.method();
		b.method();


		$A a2 = b;
		a2.method(); //refrencia $A

		$A a3 = new $B();
		a3.method(); //referencia $A

		$1A a4 = new $1A();
		
		System.out.println(a4.b); //15 - nao static - ordem de inicialização importa

		System.out.println($1B.b); //0 - vlr default - static: ordem de inicialização importa


	}


}