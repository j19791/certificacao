//o nome do arquivo .java deverá ser a public class/interface
public class JavaBasics{


	static int i;

	JavaBasics(){
		//return; unreachable statement
		
		return; //construtor pode ter retorno vazio

	}



}

class JavaBasicsTest{

	static public void main(String ... args){

		//membro static pode ser acessado por instancia ou diretamente pela class
		new JavaBasics().i = 1;

		new JavaBasics().i++;		

		JavaBasics.i++;

		System.out.println(JavaBasics.i);

		JavaBasics jb0 = new JavaBasics();
		//final JavaBasics jb = new JavaBasics();
		final JavaBasics jb = jb0; //compila e roda: ref final nao estava apontando p/ nenhum obj anteriormente
		//jb = new JavaBasics(); não compila - nova atribuição p/ uma ref final
		//jb = jb0; nao compila: ref final nao pode apontar p/ um outro obj

	}



}