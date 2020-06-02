package bib;

public abstract class Pessoa{

	protected String nome;

	Pessoa(String nome){this.nome = nome;}

	Pessoa(){}

	public String getNome(){return nome;}


}