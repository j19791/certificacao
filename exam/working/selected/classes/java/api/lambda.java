package exam.working.selected.classes.java.api;

import java.util.*;
import java.util.function.*;//para usar o Predicate


class LambdaTest{


	public static void main(String args[]){

		/*
			- 1 lambda pode ter mais de 1 parametro ou nenhum parametro. Nesses casos, incluir ()
			- Pode incluir ou não o tipo do parametro
			- código do método com mais de uma linha, incluir {}
			- nao precisa incluir return
		*/

		ArrayList<Pessoa> pessoas = new ArrayList<>();		

		pessoas.add(new Pessoa("Daniel", 6, "neto" ));
		pessoas.add(new Pessoa("Pai", 70, "pais"));
		pessoas.add(new Pessoa("Mae", 74, "pais"));
		pessoas.add(new Pessoa("Jefferson", 41, "filho"));
		pessoas.add(new Pessoa("Jamile", 37, "filho"));	

		Predicate<Pessoa> filtro = new MaioresDeIdade();
		
		//criando novo filtro com classe anonima
		Predicate<Pessoa> filtroNomeComecaComJ = new Predicate<Pessoa>(){//com classes anonimas é obrigatório incluir o tipo no generics do new
			public boolean test(Pessoa p){				
				return p.getNome().startsWith("J");
			}
		};
				
		System.out.printf("%n%1$s%n", "Maiores", "Menores");

		List<Pessoa> adultos = new FiltradorDePessoas().filter(pessoas, filtro);

		for(Pessoa p : adultos){
			System.out.println(p);
		}

		System.out.printf("%n%2$s%n", "Maiores", "Menores");

		List<Pessoa> menores = new FiltradorDePessoas().filter(pessoas, new MenoresDeIdade());
		for(Pessoa p : menores){
			System.out.println(p);
		}

		System.out.printf("%n%3$s%n", "Maiores", "Menores", "começa com J");

		List<Pessoa> comecaComJ = new FiltradorDePessoas().filter(pessoas, filtroNomeComecaComJ);
		for(Pessoa p : comecaComJ){
			System.out.println(p);
		}
		
		System.out.printf("%n%4$s%n", "Maiores", "Menores", "começa com J", "Pais");

		//lambda - apenas com interfaces funcionais. Predicate = Matcher
		Predicate<Pessoa> filtroPais = (Pessoa p) -> {return p.getParentesco().equals("pais") ? true : false ;};
		
		List<Pessoa> pais = new FiltradorDePessoas().filter(pessoas, filtroPais);
		for(Pessoa p : pais){
			System.out.println(p);
		}

		ArrayList<Predicate<Pessoa>> filtros = new ArrayList<>();
		Predicate<Pessoa> filtroFilhos = f -> f.getParentesco().equals("filho"); //mais consciso. maiores omissões. Inferindo ok.
		

		filtros.add(filtroFilhos);
		List<Pessoa> filhos = new FiltradorDePessoas().filter(pessoas, filtros.get(0));
		
		System.out.printf("%n%5$s%n", "Maiores", "Menores", "começa com J", "Pais", "Filhos");
		for(Pessoa p : filhos){
			System.out.println(p);
		}

		List<Pessoa> netos = new FiltradorDePessoas().filter(pessoas, p -> p.getParentesco().equals("neto"));//utilizando o lambda direto como parametro
		System.out.printf("%n%6$s%n", "Maiores", "Menores", "começa com J", "Pais", "Filhos", "Netos");
		for(Pessoa p : netos){
			System.out.println(p);
		}

		//Calculator<Integer> divide = (int a, int b) -> {return (Integer) (a / b);}; nao compila pois o generics da interface calculator (Integer) é diferente do tipo dos parametros passados na function (int)
		Calculator<Integer> divide = (Integer a, Integer b) -> {return a / b;};
		
		/*nao compila: o construtor da thread recebe um runnable. O int i do for nao pode ser usado para criar o lambda 
		for(int i = 0; i < 10; i++){
                	new Thread(() -> System.out.println(i)).start();
            	}

		*/
	}

}

interface Calculator<T>{
    T function(T a, T b);
}

class Pessoa{

	private int idade;
	private String nome;
	private String parentesco;

	public String getNome(){
		return this.nome;
	}

	public int getIdade(){
		return this.idade;
	}

	public String getParentesco(){
		return this.parentesco;
	}

	Pessoa(String nome, int idade, String parentesco){
		this.idade = idade;
		this.nome = nome;
		this.parentesco = parentesco;
	}

	public String toString(){
		return "nome: " + this.nome + ", idade: " + idade ;
	}
}

//interface funcional: apenas 1 metodo
//Predicate é a interface do Java para esse caso
interface Matcher<T>{
	boolean test(T t);
}

class MaioresDeIdade implements Predicate<Pessoa>{

	public boolean test(Pessoa p){
		return p.getIdade() >= 18; //criterio p/ o Matcher (filtro) maior de idade: idade da pessoa >= 18
	}

}

class MenoresDeIdade implements Predicate<Pessoa>{
	
	public boolean test(Pessoa p){
		return p.getIdade() < 18;

	}

}

class FiltradorDePessoas{

	public List<Pessoa> filter(List<Pessoa> entrada, //lista de entrada
                               Predicate<Pessoa> matcher){ //critério do filtro
        
	List<Pessoa> saida = new ArrayList<>(); //lista de saida instanciada

        for (Pessoa pessoa : entrada) {
            if(matcher.test(pessoa)){
                saida.add(pessoa);
            }
        }    
        return saida; //lista filtrada
    }

}