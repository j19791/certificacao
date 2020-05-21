package exam.working.inheritance;


//os throws tbm precisam ser parentes para funcionar a herança
import java.io.*;
import java.util.ArrayList;


    class Veiculo {
        protected void liga () throws IOException {}
    }
    class Carro extends Veiculo {
        public void liga() throws FileNotFoundException {}
    }

/*herança ciclica nao compila
class B extends C { int m(int a) { return 1; } }
class C extends A { int m(double b) { return 3; } }
class A extends B {
    int m(String c) { return 3; }
    public static void main(String[] args) {
        System.out.println(new C().m(3));
    }
}*/



//o extends Object é desnecessário mas compila e roda
//final class Pai extends Object{classe final nao pode ser herdada
class Pai extends Object{
	//o construtor padrão sempre vai ser chamado pelos filhos, caso o construtor padrão dos filhos não tenham sido implementados
	protected String nome;
	//private int idade; classe filha nao tem acesso a membros private do pai
	protected int idade;
	String cidade;	

	
	public String toString(){//para sobreescrever o toString, aassinatura devera ser essa
		return this.nome;
	}

	Pai(){
		System.out.println("chamando construtor padrão do Pai");
	}

	protected Pai(String nome){
		System.out.println("chamando construtor do Pai com 1 parametro");
		this.nome = nome;
	}

	static void metodo(){System.out.println("metodo() static do pai");}
}


//class Filho extends Pai, Object{ nao compila. só pode herdar de 1 classe
class Filho extends Pai{
		Filho(){
			//super() sempre chamando construtor padrão de pai 
			System.out.println("construtor padrão do filho");
		}

		Filho(String nome, int idade, String cidade){
			//super() sempre chamando implicitamente construtor padrão de pai 			
			System.out.println("construtor com argumentos de filho");
			this.nome = nome;
			this.idade = idade;
			this.cidade = cidade;
				
		}

		protected Filho(final String nome){
			//sempre chama super();			
			super(nome);	//para nao chamar o super(), vc precisa implicitamente especificar o super(nome). super precisa ser sempre a primeira instrução do metodo
			System.out.println("construtor com 1 argumento de filho");		
		}

		static void metodo(){System.out.println("metodo() static do filho");}


	}

class Neto extends Filho{

		Neto(String nome){
			super(nome);		
		}

		//static void metodo(){System.out.println("metodo() static do neto");}

		//abstract static nao funciona
}


class InheritanceTest{

	public static void main(String [] args) throws RuntimeException, IOException, java.sql.SQLException, FileNotFoundException{
		
		System.out.println("NOVO PAI");
		Pai p[] = new Pai[]{new Pai(), null};
		System.out.println("ARRAY DE FILHO");
		Filho[] f = new Filho[3];
		System.out.println("NOVO FILHO PADRÃO");
		f[0] = new Filho();
		System.out.println("NOVO FILHO COM ARGUMENTOS");
		f[1] = new Filho("Jefferson", 41, "Mogi das Cruzes");
		System.out.println("NOVO FILHO COM 1 argumento");
		f[2] = new Filho("Jamile");
		System.out.println("NETO SENDO ATRIBUIDO NUMA POSIÇÃO DO ARRAY DE PAI");
		p[1] = new Neto("Daniel");
		p[1].metodo();
		f[1].metodo();
		p[0].metodo();
		Pai.metodo();
		Filho.metodo();
		Neto.metodo();
		
		Neto[] n = new Neto[]{new Neto("Lindomar")};
		n[0].metodo();//neto nao tem metodo. chama o metodo() do filho
		
		//toString sobreescrito
		System.out.println(p[0]);
		System.out.println(p[1]);
		System.out.println(f[0]);
		System.out.println(f[1]);
		System.out.println(f[2]);
		System.out.println(n[0]);


		Modal m1 = new Modal();
		Modal v[] = new Modal[3];
		v[0] = m1;
		v[0].liga();

		Modal m2 = new Helicoptero();
		v[1] = m2;
		v[1].liga(); //compilação: verifica se Modal tem liga(). execução: chama o liga de helicoptero
		//v[1].ligaHelicoptero();//compilação: verifica se Modal tem liga(). Não tem. Não compila

		Helicoptero h1 = new Helicoptero(); 
		//v[3] = h1;
		//v[3].ligaHelicoptero(); nao compila
		h1.ligaHelicoptero(); //compila

		new ImplementaInterface().imprimirMensagem("Imprimindo texto de metodo de interface implementado");

		h1.explodirHelicoptero();

		new E().x(32);

	}

}


class Modal{

	void liga() throws IOException {System.out.println("Liga modal");}

	final void explode(){System.out.println("explodiu modal!");}

	Modal fabrica(){return new Modal();}

}

class Helicoptero extends Modal{
	//sobreescrita - nome do metodo/parametros iguais ao do pai. Retorno compativel
	//modificador de acesso do filho precisa ser igual ou maior q do pai: protected > default
	//o throws do metodo filho precisa ser compativel com o throws do metodo pai ou não ter (java.sql.SQLException nao funciona)
	protected void liga() throws FileNotFoundException {System.out.println("Liga helicoptero");}

	public void ligaHelicoptero(){System.out.println("Liga helicoptero q nao tem no pai");}
	
	//nao dá pra sobreescrever metodo final
	//void explode(){System.out.println("explodiu helicoptero!");}

	Helicoptero fabrica(){return new Helicoptero();}

	void explodirHelicoptero(){
		System.out.println("explodiu helicoptero! com o explodir do super");
		super.explode();
	}


}

interface Interfaceando{

	//por default, método de interface é public abstract
	void imprimirMensagem(String mensagem);

}

class ImplementaInterface implements Interfaceando{
	//metodo implementando precisa ser public pois o metodo da interface é public
	public void imprimirMensagem(String mensagem){System.out.println(mensagem);}

}

abstract class TesteMetodoAbstrato extends ImplementaInterface {
	//sobreescrevendo metodo concrte com um metodo abstrato
	public abstract void imprimirMensagem(String mensagem);

}


class B {
    void x(int i) throws IOException {
	System.out.println("entrou em B:"  + i);
        if(i<0) return;
        this.x(-1);
        System.out.println("c");
    }
}
abstract class C extends B {
    void x(int i) throws IOException {
	System.out.println("entrou em C:"  + i);
        System.out.println("b");
        super.x(i);
    }
}
abstract class D extends C {
    void x(int i) throws IOException {
        System.out.println("entrou em D:" + i);
	super.x(i);
    }
}
class E extends D {

	E(){System.out.println("entrou em E");}
}

class TesteIf {
     void x(int i) throws IOException {
	System.out.println("entrou em B:"  + i);
        if(i<0) return;
        this.x(-1);
        System.out.println("c");
    }

  public static void main(String [] args) throws IOException {
	new TesteIf().x(-1);

	}

}

class CastingTest{


	public static void main(String [] args){
		
		Object objetos[] = new Object[100];
		String s1 = "certificacao";
		objetos[0] = s1;
		String s2;
		//s2 = objetos[0]; //mesmo objetos[0] ref um String, ref do tipo Object não pode ser atribuido diretamente a uma referencia do tipo String 
		String s3 = (String) objetos[0]; //com casting implicito, é possível compilar e rodar

		Transporte []t1 = new Moto[4]; //ok
		Transporte t2[] = new Caminhao[1]; //ok
		
		Moto[] m1 = new Moto[2]; //apenas declarei, não estou usando
		Caminhao c1[] = new Caminhao[1];

		//c1[0] = m1[0]; //nao compila
		//c1[0] = (Caminhao) m1[0]; //nao compila, nem com casting
		t1[0] = m1[0];//ok
		t1[1] = c1[0];//ok

		//diretamente nao compila
		//m1[1] = new Transporte();	

		//m1[1] = (Moto) new Transporte(); compila mas nao roda

		CarroAutomatico[] ca = new CarroAutomatico[1];
		ca[0] = new CarroAutomatico();

		Automatico a = ca[0]; //compila e roda

		Caminhao c2[] = new Caminhao[]{new Caminhao()};

		//t1[3] = ca[0]; //compila mas nao roda

		//Automatico a2 = (Automatico) new Moto();//compila mas nao roda

		System.out.println(c2[0] instanceof Caminhao);
		System.out.println(new Moto() instanceof Moto);
		

	
		
		
		

	}
}

class Transporte{}

class Moto extends Transporte{}

class Caminhao extends Transporte{}

interface Automatico{}


class CarroAutomatico extends Transporte  implements  Automatico {}









