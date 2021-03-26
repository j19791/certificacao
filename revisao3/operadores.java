class Operadores{

	public static void main(String[] args){

		//int a = - 1 - ;
		 int i = + + 1, // + ( + ( 1))
		  j=  +-+-+-1, // + ( - ( + ( - ( + ( - (1))))))= -1 
		k = - -1; - ( - (1)) = 1
		
		System.out.printf("%1$d, %2$d, %3$d", i, j, k);//1,-1,1
//		 int b = --1 ; apenas variavel
//		 int c = 1 * * 1 ;
		
		int l = 1 + + 1, // 1 + (+1) = 2
		m = 1 + + + 1, // 1 + ( + ( + (1))) = 2
		n = 1 - - - 1; // 1 - ( - ( - (1))) = 0
		System.out.printf("%1$d, %2$d, %3$d", l, m, n);


	}



}