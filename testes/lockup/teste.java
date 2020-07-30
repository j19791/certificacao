class A{
public void method() {
System.out.println("a");
method2();
}
public void method2() {
System.out.println("parent method2");
}
}
class B extends A {
public void method() {
System.out.println("b");
super.method();
}
public void method2() {
System.out.println("c");
method();
super.method();
}
public static void main(String[] args) {
new B().method2();
}
}