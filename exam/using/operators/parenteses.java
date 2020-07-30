class ParentesesTest{

	static public void main(String args[]){

		System.out.println(0 + "certificacao");//0certificacao

		System.out.println(15 + 1 + "certificacao"); //16certificacao : a operacao amtematica ocorre normalmente antes da concatenação

		System.out.println("certificacao" + 15 + 1);//certificacao151: primeiro ocorre A concatenação String + int (esquerda p/ direita) que é transformada em String que depois é concatenada String + int

		System.out.println(15 + (0 + "certificacao"));//0certificacao => 150certificacao

	}


}