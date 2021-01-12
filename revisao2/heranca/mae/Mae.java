package heranca.mae;

public abstract class Mae{

	protected String name;

	private static Integer contador = 0;

	protected Mae(){
		System.out.printf("%n entrou no contrutor Mae(): contador: %d", contador);
		contador++;
		System.out.printf("%n saiu no contrutor Mae(): contador: %d", contador);
	}
		


	protected Mae(String name){
		//super();Aqui entrou em Object()
		this();
		System.out.printf("%n entrou no contrutor Mae(String): contador: %d", contador);
		this.name = name;
		System.out.printf("%n saiu no contrutor Mae(String): contador: %d", contador);
	}

	public String getName(){
		return name;

	}

	public String toString(){
		return "Nome: " + name;
	}

	public static Integer getContador(){
		return contador;
	}

	public String testaBindingInstanciaPolimorfismo(){
		return "pegou da mae";


	}

	public abstract void testaAbstract();

}