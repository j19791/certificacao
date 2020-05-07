class A implements B { //A
}
//public interface B { nao funciona pois o nome do arquivo deverá ser igual a classe public
interface B {
}
class C extends A { //C
}
//class D extends A, implements B { //D nao pode ter virgula
class D extends A implements B {
}