package exam.java.data.types;

class Carro{
	//object fields
	String modelo;

	int ano;

	Carro(){
		ano = 2014;
	}

	void reseta(){
		ano = 2014;
	}

	String getDadosImpressao(){
		return modelo + " - " + ano;
	}

	void setModelo(String modelo){
		this.modelo = modelo;//deve se colocar o this para atribuir o valor a variavel membro 
	}
}
class ReadWriteObjectFieldsTest{

	public static void main(String...args){
		
		Carro c = new Carro();
		c.modelo="C3";
		c.setModelo("Palio");
		System.out.println(c.getDadosImpressao());
		System.out.println(c.modelo.length());
		
	}

}		

