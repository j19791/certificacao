class VarargsTest{

	static void method1(int ... args){
		System.out.println(args.length);

	}

	static void method2(Object ... args){
		System.out.println(args.length);

	}



	public static void main(String... args){//tbm funciona a sintaxe ... no lugar de []

		System.out.println("deu certo o varargs com ...");

		VarargsTest.method1(new int[]{12345, 678910});//atenção: aqui é passado 2 argumentos para o varargs e não 1 array de int
		VarargsTest.method2(new Object[]{"gato", "cachorro"});//atenção: aqui é passado 2 argumentos para o varargs e não 1 array de int		
		

	}


}