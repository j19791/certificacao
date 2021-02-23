package api.javatime;

import java.time.LocalDateTime;
import java.time.LocalDate;

//localdate nao herde da localdatetime

public abstract class JavaTime{


	public static void imprimir(LocalDateTime ldt){

		System.out.println(ldt)		;

	}


	public static void imprimir(LocalDate ld){

		System.out.println(ld)		;

	}

	public static void imprimir(String s){

		System.out.printf("%n %1$s", s);

	}

}