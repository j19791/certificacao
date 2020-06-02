package exam.java.data.types;

class InicializacaoTest{


	static public void main(String args[]){
		
		int[] inteiros = new int[10];
		System.out.println(inteiros[5]); //aqui nao ocorre NPE pois os arrays são inicializados implicitamente

		char c = '\u03A9'; // unicode
		System.out.println(c); // imprime a letra grega ômega

	}


}