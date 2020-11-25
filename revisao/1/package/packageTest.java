//import c; nao funciona importar só o pacote
//import c.C; importando classe especifica
import c.*; //importando todas as classes do pacote


public class packageTest{

	public static void main (String [] args){

		a.A a = new a.A(); //s/ import com cqn - A é public
		//b.B b = new B(); //nao acha
		b.B b = new b.B();
		/*nao acha C
		c.C c = new c.C(); //C nao esta dentro de pacote, C nao é public
		//C é public mas nao tá definido dentro de um pacote
		*/

		c.C c = new c.C(); //C dentro de pacote, public
		C c1 = new c.C();
		C c2 = new C();

		//testando properties passadas pelo console
		
		java.util.Properties p = System.getProperties();

		p.getProperty("key1");
		

	}



}