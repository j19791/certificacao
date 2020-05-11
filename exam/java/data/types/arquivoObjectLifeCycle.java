package exam.java.data.types;

class ObjectLifeCycle{
//1-criado com construtor new()
//2-acessível - c/ refrencia
//3-inacessível - obj s/ ref - pode ser jogado fora com GC - elegível - nunca podemos saber qtos objetos foram garbage coletados


	public static void main(String[] args){
		
		Carro c; //objeto não criado ainda, apenas uma varivel c q referencia nnehum obj
		Carro d = new Carro(); //objeto criado - apenas construtor cria objetos (new)
		new Carro(); //2o. objeto criado mas sem nnehuma referencia;
		d.ano = 2015; //objeto esta sendo acessado
		System.out.println(d.ano);
		d = new Carro(); //o objeto criado anteriormente deixa de ser acessado - inacessível - pode ser garbage colllected
		System.out.println(d.ano);//vlr padrao criado com construtor
		d = null; //objeto anterior não esta mais acessível
		//System.out.println(d.ano);//null pointer exception

	}


}