package exam.working.encapsulation.loja.livraria;

public class Publicacao{

	//public: qq um q importa o pacote tem acesso
	public String autor;
	protected int paginas;

	public String getAutor(){
		return this.autor;
	}

	public int getPaginas(){
		return this.paginas;
	}

	public void setPaginas(int paginas){
		this.paginas = paginas;//posso acessar o protected
	}



}

/* classes publicas precisam estar em seu proprio arquivo
public class Livro extends Publicacao{}


public class Quadrinho extends Publicacao{
	public  String escritor;
	public String desenhista;

	public String getDesenhista(){
		return this.desenhista;
	}

}

*/