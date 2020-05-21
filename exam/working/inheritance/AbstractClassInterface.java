package exam.working.inheritance;

//posso apenas utilizar instancias herdadas de classe abstrata
abstract class Animal{

	//posso ter metodos com corpo dentro de classe abstrata
	void metodo1(){}

	//metodo abstrato: sem corpo mas com ;
	//se tem pelo menos 1 metodo abstract, a classe precisa ser abstrata
	abstract void metodo2();
}


abstract class Felino extends Animal{}

//Gato precisa implementar os metodos abstratos
//extends vem antes de implements
class Gato extends Felino implements Miador, Cacador  {

	void metodo2(){};

	//vc precisa implementar publicamente (nao default) os metodos das interfaces
	public void mia(){System.out.println("miau");}
	public void corre(){System.out.println("corre");}

}

//classes abstratas podem extender classes concretas
abstract class Bichano extends Gato{

	abstract void metodoBichano();

	abstract void metodo2();

}

//todos os metodos sao abstratos e publicos
interface Miador{
	
	void mia();

	

}

//uma interface pode herdar de varias interfaces
interface Cacador extends Bebedor, Comedor{

	void corre();

}


interface Bebedor{
	
	//constante
	String BEBIDA = "leite"; //public static final

}
interface Comedor{}






class Abstract_Class_Interface_Test{

	public static void main(String[] args){

		//new Animal(); nao posso instanciar classe abstrata
		new Gato(); //gato pode ser instanciado
		Felino f = new Gato();	//new apenas com classes concretas
		Gato g1 = new Gato();
		System.out.println(g1.bebida);			


	}


}