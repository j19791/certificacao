package exam.java.data.types;

class CallTest{

	public static void main(String[] varargs){
		
		Pessoa p = new Pessoa();
		p.setNome("Jefferson"); //invocação do método
				

	}

}

class Pessoa{

	String nome;
	
	String getNome(){
		return nome;
	}

	void setNome(String nome){
		this.nome = nome;
	}

	public String toString(){
		return nome;
	}
}