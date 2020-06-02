package bib;

public class Professor extends Pessoa{

	private String[] licencas;

	public String[] getLicencas(){return licencas;}

	public Professor(String nome, String[] licencas){
		super(nome);
		this.licencas = licencas;
	}

	public String toString(){
		
		if(this.licencas.length > 0){
			String licencasRetorno = "" ;
		for(String licenca : this.licencas){
			
			licencasRetorno = licencasRetorno + ", " + licenca;			
		}
			return "Nome: " + this.nome + ". Licenças: " + licencasRetorno;
		}		
		return "";			

	}

	



}