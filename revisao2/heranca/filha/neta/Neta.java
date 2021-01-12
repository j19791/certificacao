package heranca.filha.neta;

public class Neta extends heranca.filha._Filha2 implements heranca.interfaciavel.I1{

	public Neta(String n){
		super(n);

	}

	public void metodo1(){} //precisa ser public pois o metodo da interface é por padrãp public abstract

	public void testaAbstract(){System.out.println("entrou");}


}