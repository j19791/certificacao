package exam.working.encapsulation;

import exam.working.encapsulation.editora.*;//importo Livro, quadrinho e publicacao

class AcessModifiersTest{

	public static void main(String args[]){

		//acessando classes publicas
		Livro l = new Livro(); //preciso importar o pacote do livro, ou o *
		Quadrinho q = new Quadrinho();//importando *
		Publicacao p = new Publicacao();//importando *

		l.autor = "C. S. Lewis";//autor é public, consigo acessar
		System.out.println(l.getAutor());//getAutor é public

		//l.paginas = 700; //paginas é protected. Apenas quem herda ou esta dentro do pacote pode acessar
		l.setPaginas(700); //setPaginas é public. Posso acessar o metodo
		System.out.println(l.getPaginas());//getPaginas é public, posso acessar o método

	}

}
