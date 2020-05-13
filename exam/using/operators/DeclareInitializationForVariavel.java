package exam.using.operators;


class VariableInitializationForTest {

    public static void main(String[] args) {
         int y;
         for(int x = 0; x<10; ++x) {//usando x++ tbm nao funciona
	
           y = x % 5 + 2;
         }
         System.out.println(y); //variavel y pode nao ter sido inicializado no for
    }
}