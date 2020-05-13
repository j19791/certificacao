package exam.using.operators;

class VariableForTest2 {
    public static void main(String[] args) {
        int i;
        for (i = 0; i < 5; i++) {//o i esta sendo inicializado dentro do for, por isso compila
            if (i++ % 3 == 0) {
                break;
            }
        }
        System.out.println(i);
    }
}