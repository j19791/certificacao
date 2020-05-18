package exam.working.methods;

class Overload{

	/*nao funciona: sobrecarga é com relação aos argumentos. Não é com relação ao retorno
	void metodo1(){}
	int metodo1(){return 1;}
	*/

	//sobrecarga parametros diferentes com metodo de mesmo nnome
	void metodo2(){}
	void metodo2(int a){}

	//sobrecarga usando object
	void metodo3(String a){System.out.println("String");}
	void metodo3(Object o){System.out.println("Object");}

	//causa ambiguidade na hora de generalizar
	void metodo4(int a, double b){}
	void metodo4(double b, int a){}
	//void metodo4(int a, int b){}

	nao funciona, variavel ja definida
	//void metodo5( int a, int a){}



}


class OverloadedMethodsTest{


	public static void main(String[] args){

		new Overload().metodo2((short)123);//promoção int recebe short
		new Overload().metodo3("certificação"); //mais especifico
		new Overload().metodo3(new Carro());//mais generico
		
		//new Overload().metodo4(4,4);		
		

	}



}


class Carro{}