class B {
    int x() { return y();}//3-chama y() mas nao de B e sim de C
    int y() { return 3; }
}
class C extends B {
    C() {
        super(); //1-chama o construtor B(), nao tem
        z(x());//2-resolve o x(). Nao tem em C, procura em B
    }
    void z(int i) {
        System.out.println(i);
    }
    int y() { return 2; }//4-metodo y() chamado
}
class A {
    public static void main(String[] args) {
        new C();
    }
}