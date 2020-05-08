class ArraysTest{


	public static void main (String args[]){

        System.out.println(args); //aqui vai ser impresso um código estranho mas não vai dar erro, mesmo s/ argumentos
        System.out.println(args.length);
        System.out.println(args[0]); //nessa linha pode ocorrer ArrayIndexOutOfBoundsException se a classe for executada sem argumentos 



	}

}