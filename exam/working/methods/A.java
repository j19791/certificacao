package exam.working.methods;

class B { 
	B(A a) {
		System.out.println("chamou o B(A a)");
		new C(this);  //qdo é passado this, significa q esta sendo passado a new C(B b)
	} 
	B() { 
		System.out.println("chamou o construtor de B()");
		new C(this);
		
	} 
}

class C { 
	C(B b) {
		System.out.println("chamou o C(B b)");
		//new B(new A());
	} 
	
	C() {
		System.out.println("chamou o construtor de c()");
		//new B();
		
	} 
}

class A {
    public static void main(String[] args) {
        //new C(new B(new A()));
	new C();

	new B();
    }
}



