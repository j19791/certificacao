package exam.java.data.types;

class ClasseTeste{

	int valor;

}


class ObjectRefVarTest{




	public static void main(String[]args){
	
		ClasseTeste ct = new ClasseTeste(); //ct refrencia novo objeto criado
		ct.valor = 10; //é atribuido um valor a esse novo objeto criado. Ct continua referenciando
		System.out.println(ct.valor);
		ClasseTeste ct2 = ct;//ct2 referencia o mesmo objeto criado anteriormente. Não tem construtor aqui para ct2
		System.out.println(ct2.valor); //mesmo valor
		
		ct.valor = ct.valor + 5; //o valor do objeto refrenciado é somado com 5
		System.out.println(ct.valor);
		System.out.println(ct2.valor);  //o valor é o mesmo para ct2. ct2 continua referenciando o mesmo obj criado anteriormente com construtor
		
		ct2.valor = ct2.valor + 5; //o valor do objeto refrenciado por ct2 tbm pode ser somado com 5. ct continua ref o mesmo obj
		System.out.println(ct.valor);
		System.out.println(ct2.valor);


		ct2.valor = ct.valor + 5; //o valor do objeto refrenciado por ct2 tbm pode ser somado com 5. ct continua ref o mesmo obj
		System.out.println(ct.valor);
		System.out.println(ct2.valor);

	
	}

}



