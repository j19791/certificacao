package api.javatime;

import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.temporal.*;


public interface JavaTimavel{


//	LocalDateTime criar(); //nao da pra criar metodos c/ nomes iguais e retornos diferentes

	
	void criarLD();

	void get();

	boolean is();

	boolean isSupported(ChronoField cf);
	

	void with();


	void plus();


	void minus();


	void to();

	



	


}