package exam.working.encapsulation.loja.informatica;

import exam.working.encapsulation.loja.Produto;

class Equipamento extends Produto {

	protected String cor = "Preto";	

	int voltagem;

	int getVoltagem(){return this.voltagem;}

	void setVoltagem(int voltagem){this.voltagem = voltagem;}

	//nao compila. peso é default. mesmo herdando, peso esta em outro pacote
	/*boolean ehPesado(Produto p){
		if(p.peso > 1000) return true;
		else return false;
	}*/

}

