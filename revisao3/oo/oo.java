class Pai{
	private void m(){}

}


class Filho extends Pai{

	public void n(){}

}


class Oo{

	public static void main(String ... args){

		//new Filho.m(); Apesar de ser herdado pelo filho, o método privado do pai só pode ser acessado dentro da classe Pai apenas. 

		Pai p = new Filho();
		//p.n(); não compila: em tempo de compilacao Pai p (var ref) nao tem o método n

		Pai _p = (Pai) new Filho();		
				

	}

}

class MyClass {
	public static void main(String[] args) {
		A[] arrA;
		B[] arrB;
		
		arrA = new A[10];
		arrB = new B[20];
		arrA = arrB; // (1) -- the assignment is done from a subclass reference to a superclass reference
		arrB = (B[]) arrA; // (2) -- assures the compiler that arrA will refer to an object that can be referenced by arrB. This will work when run,since arrA will refer to an object of type B[].
		arrA = new A[10];
		//arrB = (B[]) arrA; // (3) -- ccex - also assure the compiler that arrA will refer to an object that can be referenced by arrB. This will not work when run, since arrA will refer to an object of type A[].

		//A a = new A();
		//B b = new B();
		//b = (B) a; ccex
		//B b = (B) new A(); ccex
		
		A a = new B();
		//B b =  a; nao compila
		B b = (B) a;

		




	}
}

class A {}
class B extends A {}