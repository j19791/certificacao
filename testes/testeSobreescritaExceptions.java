class A {
public void method() {
}
}
class B extends A {
public void method() throws RuntimeException { // ok
}
}
class C extends A {
public void method() throws ArrayIndexOutOfBoundsException {
// ok
}
}