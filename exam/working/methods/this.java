class Pai{

	String nome;


	Pai(){
		String nome = "Ogno";
		//this("Deus");
	}

	Pai(String nome){
		this;
		//this();

		//this.nome = nome;

	}

}



class ThisTest{

	public static void main(String [] args){

		System.out.println(new Pai("Alessandro").nome);
		
	}

}