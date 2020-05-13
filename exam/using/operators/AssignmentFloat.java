package exam.using.operators;

class AssignmentFloatTeste{

	public static void main(String ... arg){
		float f = 100000;
		//float f = 0.0; //double p/ float nao converte

		System.out.println(f);//mas a casa decimal aparece no caso do float

		float f1 = 100000.0f; //funciona se eu explicitamente especificar f no literal
		System.out.println(f1);
	}

}