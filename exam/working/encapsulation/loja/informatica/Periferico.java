package exam.working.encapsulation.loja.informatica;

import exam.working.encapsulation.loja.Produto;

class Periferico extends Produto {

	protected String cor = "Branco";

	String conexao;

	String getConexao(){return this.conexao;}

	void setConexao(String conexao){this.conexao = conexao;}


}