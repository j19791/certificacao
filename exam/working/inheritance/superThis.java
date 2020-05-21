package exam.working.inheritance;



class _Pai{
	
	int x = 0;
	_Pai(){
		System.out.println("Construtor do pai");
	}

	_Pai(String s){
		
		System.out.println("Construtor do pai com string");
	}

}

class $Filho extends _Pai{
	int x = 1;
	$Filho(){
		this("teste this");
		//super("pai com String"); nao funciona ter super e this no mesmo metodo
		

	}

	$Filho(String s){
		System.out.println("chamou o construtor do filho com String");
		System.out.println(this.x);
		System.out.println(super.x);
	}


	$Filho (int i){
		System.out.println("Inteiro");

	}

	//super e this só podem ser chamado dentro de construtores
	void metodo(){
		//super();
		//this();
	}


}


class S1uperThisTest{

	public static void main(String args[]){

		$Filho[] filhos = new $Filho[]{new $Filho("teste")};
		_Pai p = new $Filho();
		System.out.println(p.x);
		//p.metodo();
	}


}