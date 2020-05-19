package exam.working.encapsulation.loja;

public class Produto{

	private double preco;

	int peso;

	int getPeso(){return this.peso;}

	void setPeso(int peso){this.peso = peso;}
	
	protected String cor = "Azul";

	public double getPreco(){
		return this.preco;

	}


	public void setPreco(double preco){
		this.preco = preco;

	}

}