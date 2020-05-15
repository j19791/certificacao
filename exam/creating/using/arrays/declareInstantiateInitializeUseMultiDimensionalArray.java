package exam.creating.using.arrays;

class ArrayMultiDimTest{



	public static void main(String args[]){

		//declaracao
		int tabela[][];

		int []cubo[][];

		//inicializar c/ valores default (int com 0)
		//nao da pra inicializar variaveis arrays com dimensões diferentes
		int tabela2[][] = new int[10][5]; //array de arrays

		int cubo2[][][] = new int[10][][]; //no minimo, especificar uma dimensão

		//inicializar com valores especificos
		int tabela3[][] = new int[][]{ {1,2,3,4}, {5,6,7,8}, {9, 10,11,12} };
		System.out.println(tabela3.length);//3
		System.out.println(tabela3[0].length);//4

		//array na primeira posicao, possui um array de 10 posicoes
		//na segunda posicao, array de 20
		int arrayEstranho[][] = new int[2][];
		arrayEstranho[0] = new int[10];
		arrayEstranho[1] = new int[20];
		
		//int[10][10] tabela = new int[10][10]; 
		//nao compila - os valores devem ser informados na inicialização e não na declaração
		
		int zyx[][]=new int[3][10];//inicializando com 10
        	System.out.println(zyx[0].length); //10
		System.out.println(zyx[1].length); //10
        	System.out.println(zyx[2].length); //10
		int[]x=new int[20];
        	int[]y=new int[10];
        	int[]z=new int[30];
        	zyx[0]=x;		
        	zyx[1]=y;
        	zyx[2]=z;//nao tem problema eu apontar para outro array de dimensao diferente da inicialização de xyz
        	System.out.println(zyx[2].length);//agora ficou 30 sem problemas

	}


}