class B {
    int x() { return y();}
    int y() { return 3; }
}
class C extends B {
    C() {        
	this(x());//não podemos referenciar um método de instância ao invocar um construtor this.
    }
    C(int i) {
        System.out.println(i);
    }
    int y() { return 2; }
}
class A {
    public static void main(String[] args) {
        new C();
    }
}