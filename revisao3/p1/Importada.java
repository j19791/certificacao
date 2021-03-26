package p1;

public class Importada{

	StringBuilder sb;

	private Importada(){}

	public void setSb(StringBuilder sb){}

	public StringBuilder getSb(){return new StringBuilder("vazio");}


	static public Importada construir(){
		return new Importada();

	}



}