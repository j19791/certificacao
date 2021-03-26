class TestaStatic{

	static Integer $i;
	Integer $j;
	static TestaStatic ts;

	public static void main(String args[]){

		Integer _i = $i; //esta implicito o nome da classe (context static)

		Integer _k = TestaStatic.$i;

//		Integer _j = $j; var non-static nao pode ser acessada num contexto static

		ts = new TestaStatic();		

		Integer _j = new TestaStatic().$j; //contexto non-static

		new TestaStatic().getStatic();

//		TestaStatic.getNStatic();

		new TestaStatic().getNStatic();//contexto non-static

		new TestaStatic().getMNSVNS();

		new TestaStatic().$j = $i; 

		$i = new TestaStatic().$j ;

	}

	public Integer getStatic(){
		getNStatic();		
		getMNSVNS();		
		return $i;
	}

	public Integer getMNSVNS(){
		return $j;
	}



// 
	public static Integer getNStatic(){
		//return $j; contexto static nao pode acessar uma nao static variavel
		getNStatic2();
		new TestaStatic().getMNSVNS();
		return new TestaStatic().$j;
	}

	public static Integer getNStatic2(){
		//return $j; contexto static nao pode acessar uma nao static variavel
		return new TestaStatic().$j;
	}

}