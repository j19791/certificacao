interface Z {}
interface W {}
interface Y extends Z, W {} //uma interface pode extender mais de 1 interface
//class F extends Z, W {} uma classe nao pode extender mais de 1 interface/classe
//class F implements Z, W,Y {}
class B {}
class C extends B implements Y {}
class D extends B implements Z, W {} //uma classe pode implementar mais de 1 interface
class E extends C {}
class A {
  public static void main(String[] args) {

	//B b = new C(); //compila e roda. C ext B
	//C c = (C) new B();//compila mas nao roda. Nem todo B é um C
	//Y y = new D(); //nao compila. D nao é um Y
	//Z z = (Z) (B) new D();//compila e roda. C que é subtipo de B consegue chegar no Z
	//Y y = (Y) new A(); compila por causa do casting mas nao roda pois A nao tem nada a ver com Y
	//D d = (D) (Y) (B) new D();//compila mas nao roda. D nao consegue fazer cast de y	
	D d = (B) (Z) (W) (Y) new D();//compila mas nao roda. D nao consegue fazer cast de y

    //System.out.println(((B) (Z) (W) (Y) new D()) instanceof D);



  }
}