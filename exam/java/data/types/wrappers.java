package exam.java.data.types;

import java.util.*;

class WrappersTest{

	static Character metodoNovoCharacter(Character c){
		return new Character(c);

	}


	public static void main(String args[]){
		
		//ArrayList<int> listaInt = new ArrayList<>();nao funciona. ArrayList é apenas de objetos
		ArrayList<Integer> lista = new ArrayList<>();//compila
		

		/*Wrappers: objetos que representam tipos primitivos
		int = Integer
		char = Character
		*/
		try{
		//Integer i1 = new Integer(); nao compila.
		Integer i2 = new Integer(1);
		Integer i3 = new Integer("1");

		//Character c1 = new Character(123);nao compila
		//new Integer("alfa"); //compila mas nao roda
		
		Character c2 = WrappersTest.metodoNovoCharacter('c');

		
		
		}
		catch(NumberFormatException nfe){
			System.out.println("exception");
		}

		//Character c3 = new Character("a");//nao compila: string nao pode ser convertida para char

		Boolean b1 = new Boolean("true"); //true
		Boolean b2 = new Boolean(true);//true
		Boolean b3 = new Boolean("qq coisa");//false

		//conversões para primitvo
		//Wrapper - primitivo : xxx = X().xxxValue
		int i4 = new Integer("2020").intValue();
		int i5 = new Long(1l).intValue();
		byte by1 = new Long(10L).byteValue();
		byte by2 = new Double(10.25).byteValue();//compila e roda mas com perda de informação
		System.out.println(by2);//10
		//byte by3 = 10.25;nao compila  e nem roda

		char c4 = new Character('C').charValue();
		System.out.format("%c\n", c4);
		boolean b4 = new Boolean("Positivo").booleanValue();
		System.out.printf("%b\n", b4);	

		//String - primitivo: x = X.parseX(String)
		//int i7 = Double.parseInt("3.1451"); nao compila
		//int i8 = Integer.parseInt("3.1451"); //compila mas nao roda: NumberFormatException
		//int i8 = Integer.parseInt("3L");//compila mas nao roda: NFE
		//long l1 = Long.parseLong("3L");//compila mas nao roda: NFE
		long l1 = Long.parseLong("3");
		int i9 = Integer.parseInt("FFF", 16); //16-BASE HEXA: fff = 4095 (decimal). Se fosse na base default (10), compila mas NFE
		System.out.printf("%d\n", i9);

		//String => wrapper: valueOf()
		Integer I1 = new Integer("10");//proprio construtor
		Integer I2 = Integer.valueOf("5Af", 16);
		
		//Integer I3 = Long.valueOf("999"); Long nao pode ser convertido p/ integer
		//Integer I3 = (Integer) Long.valueOf("999");

		//primitivo/wrapper => String: toString()
		Double.toString(24.70);//"24.70"
		Integer.toString(24);//"24"
		System.out.println(Long.toString(1l));//"1"
		int i10 = 10;
		//String s1 = i10.toString();nao compila
		System.out.printf("%s",i10);

		//autoboxing: operacoes matematicas com wrapper : >= java5. Antes deveria converter para primitivo
		Double D1 = new Integer(10).doubleValue() + new Integer(20).doubleValue();//ANTES JAVA 5
		Integer I4 = new Integer(10) + new Integer(20);//DEPOIS JAVA 5		
		System.out.println(I4);

		Integer I5  = i10; //compila e roda
		System.out.println(I5);//10
		Integer I6 = 11; //compila e roda sem problemas
		//Integer I6 = 11l;//nao compila: long nao pode ser convertido p/Integer
		//Double D2 = 11l;//nao compila: long nao pode ser convertido para Double
		long l2 = Integer.valueOf("10",8); // Integer pode ser convertido p/ long - Wapper p/ primitivo ok
		//int i11 = Integer.valueOf("10.8"); // nfe
		double d1 = 11l;//compila e roda: conversao entre tipos primtivos é ok			
		System.out.println(I6);//11
		i = Integer.parseInt("10");
		m1(i + 1);

		

	}

	private static void m1(Integer j) {
        	System.out.println(i);  }

	static int i;


}