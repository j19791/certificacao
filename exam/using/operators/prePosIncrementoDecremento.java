package exam.using.operators;

class $_o0o_$ {//caracteres precisam ser escapados pelo seu shell ou bash: para executar no bash é necessário usar java exam.using.operators.$\_o0o\_$
    public static void main(String[] args) {
        int $$ = 5;
        int __ = $$++;//aqui a variavel é incrementada apesar de estar sendo utilizada como valor par atribuição em outra variável
	System.out.println($$);//6
        if (__ < ++$$ || __-- > $$){//short-circuit: o teste é realizado apenas de 1 lado da expressão pois o 1o. lado ja a valida
            System.out.println("A");
	    System.out.println($$);//7 (pré-incremento)
	    System.out.println(__);//5

	}

        System.out.print($$);//7
        System.out.print(__);//5
    }
}