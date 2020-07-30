class B { 
	B(A a) {
		System.out.println(this.getClass().getSimpleName()) ;
		new C(); 
	} 
	
	B() {
		System.out.println(this.getClass().getSimpleName()) ;
		new C(this);
	} 
}

class C { 
	C(B b) {
		System.out.println(this.getClass().getSimpleName()) ;
		new B(new A());
	} 

	C() {
		System.out.println(this.getClass().getSimpleName()) ;
		new B();
	} 
}

class A {
	
	public static void main(String[] args) {
		//System.out.println(this.class.getSimpleName()) ;
		new C(new B(new A()));
	}
}