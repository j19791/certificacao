class Exam {
	int timeLimit;
}

class TestReferenceAndPrimitive {
	public static void main(String[] args) {
		Exam exam = new Exam();
		exam.timeLimit = 100;
		test(exam);
		System.out.println(exam.timeLimit); //210
		
		test2(exam);
		System.out.println(exam.timeLimit);//210
		
		int i = 2;
		i = test(i); //i recebe o retorno do metodo com valor modificado
		System.out.println(i);//5
}

	static void test2(Exam exam) {
		exam = new Exam(); //novo objeto
		exam.timeLimit = 520; //valor do novo objeto nao alterado o valor do objeto original
	}

	static void test(Exam exam) {
		exam.timeLimit = 210; //valor refenciado é alterado
	}

	static int test(int i) {
		i = 5;
		System.out.println(i);//5
		return i;
	}
}