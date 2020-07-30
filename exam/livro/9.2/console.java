class $ConsoleSaidaTest{
//java \$ConsoleSaidaTest
	public static void main(String...args){

		System.out.printf("%s",12); //A
		System.out.printf("%d",new Integer(321)); //B
		System.out.printf("%d",(short)(byte)(double) 127); //C

		System.out.println(new char[]{'a','b','c'}); // A
		

		byte b[] = new byte[]{'a','b','c'};
		System.out.println(b); // array é impresso como um Object, menos array de char. 
		System.out.println(b[0]);//os chars serão convertidos em numeros compativeis com byte: 97

		System.out.println("abc"); 

		System.out.println(new String[]{"abc"}); // array é impresso como um Object, menos array de char

	}


}