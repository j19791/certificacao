package executavel;

import static escopo._Escopo.*; //nao esquecer de colocar o * para importar os membros

class Executavel{


	static public void main (String ... parametros){

		final byte b; //pode nao inicializar dentro do metodo

		b = 1; //variavel final pode receber valor se ainda nao tinha recebido antes

		new escopo._Escopo().metodo(b);

		metodo2();

		i = 1; //variavel static do _Escopo()


	}



}