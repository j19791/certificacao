class Operadores2{

	public static void main(String args[]){

		
		int a[] = {1,2,3}, i = 0, l=2, k=3;

		a[i] = i = 9;



		int j = k = l;

		System.out.printf("%1$d, %2$d, %3$d", i, a[0], j);

		if(true || 0 < l++){System.out.printf("%n%1$d", l);} //|| nao avaliado l++ pois é ou e ja tem true
		if(true && 0 < l++){System.out.printf("%n%1$d", l);} //&& avaliado l++ pois é e - nao iria avaliar a segunda parte se fosse false


		

	}

}