class WrapperTest{

	static public void main(String ... args){

		int _i;
		//_i = 3.14; nao compila - perda na conversão double to int
		_i = (int) 3.14; //converte c/ cast
		Integer iRef;
		iRef = 786; //(1)
		iRef = (Integer)(2007 - 786); //(2)
		
			
		iRef = (int)3.14; //(3)
		System.out.printf("%n%1$d",iRef);
		
		//iRef = (Integer)3.14; erro de compilação - double nao pode ser convertido / Integer
		iRef = (Integer)(int)3.14; //(5)

		Integer i = -10;
Integer j = -10;
System.out.print(i==j);
System.out.print(i.equals(j));
Integer n = 128;
Integer m = 128;
System.out.print(n==m);
System.out.print(n.equals(m));

System.out.printf("%n");

Integer i1 = new Integer(-10);
Integer j1 = new Integer(-10);
Integer k1 = -10;
System.out.print(i1==j1);
System.out.print(i1.equals(j1));
System.out.print(i1==k1);
System.out.print(i1.equals(k1));

System.out.printf("%n");

YingYang yy = new YingYang();
yy.yingyang(10);
//yy.yingyang(10,12);
yy.yingyang(new Integer[] {10, 20});
//yy.yingyang(new Integer(10), new Integer(20));


Number n1; //?

	}



}

class YingYang {
void yingyang(Integer i) {
System.out.println("Integer: " + i);
}
void yingyang(Integer[] ints) {
System.out.println("Integer[]: " + ints[0]);
}
/*nao compila. Não pode declarar 2 métodos sobrecarregados c/ ... e []
void yingyang(Integer... ints) {
System.out.println("Integer...: " + ints[0]);
}*/
}
