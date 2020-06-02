package exam.java.basics;

class Person{


	static int x = 10;

	int y = 0;

	void setX(int x){//shadowing: declarando variavel local com mesmo nome da class variable
		Person.x = x;//referenciando uma class variable
	}

	void setY(int y){ //shadowing: declarando variavel local com mesmo nome da variavel de instancia
		this.y = y;//referenciando uma variavel de instancia
	}	
	
	static void method(){
		int x = 9; //
		System.out.println(x);//o compilador sempre usará a variavel mais perto (9)

	}

	public static void m2(String[] x) {
		//x = 200;nao compila. A varaivel local mais perto é do tipo String[] que não posso atribuir a uma referencia do tipo int
		System.out.println(x);
	}

	public static void main(String[] args){

		Person.method();
	}
		
	
}

class Test{
	static int i =3;

	public static void main(String[] args){
		
		//a variavel static i é unica p/ qq objeto novo criado. não importa a qtd de objetos criados, o valor é compartilha entre os objetos
		for (new Test().i = 10; new Test().i < 100;new Test().i++) {//aqui é como se fosse uma variavel normal, declarada localmente
			System.out.println(i);
		}

		for (Test.i = 10; Test.i < 100; Test.i++) {
			System.out.println(i);
		}
	}
}