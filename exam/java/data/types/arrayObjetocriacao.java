package exam.java.data.types;


class B{
	int valor;
}
class ArrayObjetoCriadoTeste {
    public static void main(String[] args) {
        B[] bs = new B[100];//apenas um array de ref é criado. Nnehum objeto é criado
	//bs[0].valor = 100; erro de null pointer exception. nenhuma ref esta apontando p/ algum objeto
	//System.out.println(bs[0].valor);erro de null pointer exception. nenhuma ref esta apontando p/ algum objeto
	bs[0] = new B();//criando objeto e referenciando
	bs[0].valor = 100;//nao da erro de null pointer
	System.out.println(bs[0].valor);
        System.out.println("Finalizando!");
    }
}