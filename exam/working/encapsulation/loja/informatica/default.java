package exam.working.encapsulation.loja.informatica;


class DefaultTest{

	public static void main(String [] args){

		Equipamento[] equipamentos = new Equipamento[10];
		equipamentos[0] = new Equipamento();
		equipamentos[0].setVoltagem(110);

		Periferico perifericos[] = new Periferico[]{new Periferico()};
		

		System.out.println(perifericos[0].cor);
		

	}


}