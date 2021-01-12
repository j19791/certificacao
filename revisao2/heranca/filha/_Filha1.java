package heranca.filha;


final //nao consegue mais gerar filhas dessa classe
 public class _Filha1 extends heranca.mae.Mae { 

	


	public _Filha1(String nome){

		super(nome);
				System.out.printf("entrou no construtor Filha");

	}


	public static Integer testaStatic(){
		//super.getName(); non-static variable super nao pode ser usada dentro de contexto static
		//getName(); non-static method nao pode ser referenciado dentro de um contexto static
		System.out.printf("%n nome da Filha dentro de context static: %1$s",new _Filha1("nome").getName());
		return getContador(); //metodo static sendo chamado dentro de outro metodo static
	}

	//usando polimorfismo: sempre pega o metodo sobreescrito do obj referenciado
	public String testaBindingInstanciaPolimorfismo()  {
		return "pegou da filha";


	}

}