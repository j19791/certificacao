package exam.using.operators;

class SubtracaoCharTeste {
    public static void main(String[] args) {
        char c = 65;
        char c2 = 68 - 65;//funciona: é char (caso especial) 
	char c3 = 68 + 65;//funciona: é char (caso especial) 
        System.out.println(c + c2);
	System.out.println(c + c3);
    }
}