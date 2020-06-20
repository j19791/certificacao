class A {
	public static void main(String[] args) {
		
		int zyx[][]=new int[3][10]; //ref zyx[0], zyx[1] e zyx[2] a principio apontam (refrenciam 1 array de tamanho 10 cada um)
		System.out.println(zyx[0].length);
		System.out.println(zyx[1].length);
		System.out.println(zyx[2].length);

		
		int[]x=new int[20];
		int[]y=new int[10];
		int[]z=new int[30];
		
		zyx[0]=x; //agora a ref xyx[0] refrencia um outro array de tamanho 20
		System.out.println(zyx[0].length);
		zyx[1]=y;
		System.out.println(zyx[1].length);
		zyx[2]=z;
		System.out.println(zyx[2].length);

		int i1[] = new int[10];	//ref i1 a principio aponta para um array de 10
		System.out.println(i1.length);//tamanho inicial = 10
		System.out.println(i1[0]);
		int []i2 = new int[20];
		System.out.println(i2.length);
		i1 = i2;//a referencia agora aponta p/ outro array com tamanho 20
		System.out.println(i1.length);


	}
}