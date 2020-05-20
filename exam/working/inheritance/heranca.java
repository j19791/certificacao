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

	public static void main(String [] args){
		
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


	}

}