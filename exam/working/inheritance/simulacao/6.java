class B {
    B() {
    }
    B(String s) {
        
	this();
        this(s); //nao pode ter 2 this
    }
}
class A {
    public static void main(String[] args) {
        B b = new B();
    }
}