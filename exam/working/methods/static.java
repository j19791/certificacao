package exam.working.methods;


class Moto{

	final static int NUMERO_TOTAL_MOTOS = 20;

	//static pode acessar valores de outras variaves static desde q sejam declaradas antes
	//static apenas dentro do contexto static. Nao posso acessar outros campos nao static
	static int totalDeMotos = NUMERO_TOTAL_MOTOS ;//variavel da classe
	String marca;

	static int getTotalDeMotos(){
		return totalDeMotos;
	}

	/*metodo static nao pode chamar um campo não static
	static String getMarca(){
		return marca;
	}
	*/
	
	
	//funciona. 1 metood nao static pode acessar um campo static
	int getTotaldeMotos(){
		return totalDeMotos;
	}

}

class Mobilete extends Moto{
	//nao existe sobrescrita - metodo diferente do da Moto
	static int getTotalDeMotos(){
		return 100;
	}
	

}


class StaticMethodsFieldsTest{

	static int campoStatic;	

	static int metodoStatic(){return 1;}

	public static void main(String args[]){

		System.out.println(campoStatic); //posso acessar o campo e metodo static sem precisar passar o nome da classe
		System.out.println(metodoStatic());
		System.out.println(StaticMethodsFieldsTest.campoStatic); //posso acessar o campo e metodo static sem precisar passar o nome da classe
		System.out.println(StaticMethodsFieldsTest.metodoStatic());
		//System.out.println(this.campoStatic);nao posso usar this num contexto static

		//posso acessar o campo static com o nome da classe
		System.out.println(Moto.totalDeMotos);
		//posso acessar o campo static atraves de um metodo tbm static
		System.out.println(Moto.getTotalDeMotos());

		
		Moto m = new Moto();
		//tbm posso acessar o valor do campo static atraves de uma referencia
		System.out.println(m.totalDeMotos);
		System.out.println(m.getTotalDeMotos());

		Mobilete mb = new Mobilete();
		System.out.println(mb.getTotalDeMotos());//aqui chamo o metodo static mais especifico 

		Moto mo = new Mobilete();
		System.out.println(mo.getTotalDeMotos());//aqui chamo o metodo static da mais abrangente
		
	}


}