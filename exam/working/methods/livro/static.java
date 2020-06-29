class B {
	void y() {
		this.z(); //this pode ser usado apenas dentro de metodo nao estatico
		new B().z();//mesma coisa do this acima
		B.z();//tbm consigo acessar o metodo static atraves da classe
		z();//tbm compila
		
		
	}

	static void z() {
		System.out.println("z");
		//new B().y(); posso invocar metodo nao static instanciando um novo objeto
		//y(); nao compila: metodo nao static nao pode ser chamado dentro de um contexto static
	}
}

class A {
	public static void main(String[] args) {
		new A().x();
	}

	static void x() {
		new B().y();
	}
}