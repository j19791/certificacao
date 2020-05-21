class B {
    void x() {
        System.out.println(y());
    }
    int y(){return 0;}
}
class C extends B {
    int y() { return 1; }
}
class D extends C {
    int y() { return 2; }
}
class A {
    public static void main(String[] args) {
        D d  = (D) (C) new D();
        d.x();
    }
}