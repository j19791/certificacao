//import c; nao funciona importar só o pacote
//import c.C; importando classe especifica
//import c.*; //importando todas as classes do pacote

import pacotes.a.*;
import pacotes.b.*;
import pacotes.c.*;



public class packageTest{

	public static void main (String [] args){

		pacotes.a.A a = new pacotes.a.A(); //s/ import com fqn - A é public
		//b.B b = new B(); //nao acha
		pacotes.b.B b = new pacotes.b.B();
		/*nao acha C
		c.C c = new c.C(); //C nao esta dentro de pacote, C nao é public
		//C é public mas nao tá definido dentro de um pacote
		*/

		pacotes.c.C c = new pacotes.c.C(); //C dentro de pacote, public
		C c1 = new pacotes.c.C();
		C c2 = new C();

		//testando properties passadas pelo console
		
		java.util.Properties p = System.getProperties();
		p.getProperty("key1");
		

	}

}