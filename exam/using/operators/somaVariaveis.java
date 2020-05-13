package exam.using.operators;

class SomaBytesTeste{
    public static void main(String[] args) {
        byte b1 = 5;
        byte b2 = 3;
        //byte b3 = b1 + b2;//aqui o retorno é sempre int, independente se é literal ou variavel
	byte b3 = (byte) (b1 + b2); //funciona com casting
	//byte b4 = (byte) b1 + b2; //nao funciona pois o casting esta sendo feito apenas no b1
	//byte b5 = b1 - b2;//tbm nao funciona
    }
}