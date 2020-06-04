import java.util.ArrayList;
import java.util.List;

class AtribuicaoTest{


	static public void main (String ... args){

		//float f = 1.00;nao compila. float nao recebe double
		float f1 = 1.00f; //compila pois declaramos o tipo do literal numerico explicitamente
		System.out.println(f1);
		double d1 = 20f;//compila e roda pois float é menos abrangente q double
		double d2 = 20; //compila e roda mesmo recebendo um valor inteiro
		System.out.printf("%n%1$f%n",d1, d2);
		System.out.printf("%n%2$f%n",d1, d2);
		//byte, short, char pode receber até um limite do tipo int
		byte b1 = 125;//compila e roda pois o máximo do byte é 127, mesmo int sendo mais abrangente
		System.out.printf("%n%3$d%n",d1, d2, b1);

		List<String> elementos = new ArrayList<>();//polimorfismo: List recebe ArrayList
		List<String> elementos2 = new ArrayList<String>();//polimorfismo: List recebe ArrayList
		

	}

}