package api.javatime.data;

import java.time.*;
import api.javatime.*;
import java.time.temporal.*;

public class Data extends JavaTime implements api.javatime.JavaTimavel {

	private LocalDate data;


	public Data(){
		criarLD();
	}

	public void imprimir(){
		System.out.println(data)	;
	}


	public Data(Integer y, Integer m, Integer d){
		criarLD(y, m, d);
	}

	public Data(Integer y, Month m, Integer d){
		criarLD(y, m, d);

	}

	

	public void criarLD(){

		data =  LocalDate.now();

	}

	public void criarLD(Integer y, Integer m, Integer d){

		data =LocalDate.of(y, m,d);

	}

	public void criarLD(Integer y, Month m, Integer d){

		data = LocalDate.of(y, m,d);

	}

	public void get(){

		System.out.printf("%n dia do mes: [%1$010d]; dia da semana: [%2$10s]; mes por extenso: [%3$10s]; mes numero: [%4$-10d]", data.getDayOfMonth(), data.getDayOfWeek(), data.getMonth(), data.getMonthValue());		

	}

	public boolean is(){

		MonthDay Sao_Sebastiao = MonthDay.of(Month.JANUARY, 20), Sao_Silvestre = MonthDay.of(Month.DECEMBER, 31);

		System.out.printf("%nsÃO sILVESTRE  é igual a dia de São Sebastião: %1$b", Sao_Silvestre.equals(Sao_Sebastiao));

		


		return true;		
		
	}


	public boolean isSupported(ChronoField cf)	{

return true;
}

	public void to(){}

	public void minus(){}

	public void plus(){}

	public void with(){



	}

}
