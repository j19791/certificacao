package executavel;

import static api.testarString.ClasseString.*;
import api.testarString.ClasseString;
import static api.testarSB.SB.testaMutavel;
import api.javatime.data.Data;
import java.time.temporal.*;
import java.time.*;
import java.time.format.*;
import java.util.Date;
import java.util.Calendar;
import java.util.List;
import java.util.ArrayList;
import java.util.function.*;


class TestaApi{

	static public void main(String ... args){

		String[] listinha = new String[2];
	
		listinha[0] = new api.testarString.ClasseString().testarImutavel("antes", "depois");

		System.out.printf("%n testa imutavel: %1$s", listinha[0]);

		String $1 = "Marcos";

		api.testarString.ClasseString.saida($1)		;

		String $2 = "Matheus";

		api.testarString.ClasseString.saida($2)		;

		$1 = $2;

		api.testarString.ClasseString.saida($1)		;		


		String $3 = new String("Lucas"), $4 = new String("João");

		api.testarString.ClasseString.saida($3)		;		

		api.testarString.ClasseString.saida($4)		;		

		$3 = $4;

		api.testarString.ClasseString.saida($3)		;

		System.out.printf("%n testa igualdade atribuicao literal com instanciação: [%1$10b]", api.testarString.ClasseString.testaString("Java"));
		
		testaStringNull();
		
		try{
			testaMetodosString("Certificacao");
		}
		catch(StringIndexOutOfBoundsException e){
			System.out.printf("%n erro de:  %s", "SIOOBEXC");
		}

		System.out.printf("%n testa string imutavel: Levi : [%1$10s]", new ClasseString().testarImutavel("Levi"));


		//new api.testarSB.SB().testaMetodo("Certificacao");

		System.out.println(testaMutavel(new StringBuilder[]{new StringBuilder("Certificacao")})); //nao da pra passar diretamente "Certificacao", vc precisa criar o objeto


		StringBuilder $sb = new StringBuilder("Certificacao");

		$sb.append(" Java").append(" 8").append(" da Oracle.");

		System.out.println($sb);

		new api.testarSB.SB().testaMetodo(new StringBuilder("Certificacao"));		

		System.out.printf("%n");

//		new api.javatime.data.Data().imprimir(new api.javatime.data.Data().criarLD());

//		new Data().imprimir(new Data().criarLD(2021, 1, 19));

//		new Data.imprimir(new Data().criarLD(2021, java.time.Month.JANUARY, 19));

		new Data().imprimir();

		new Data(2021, 1, 20).imprimir();

		new Data(2021, java.time.Month.JANUARY, 19).imprimir();

		new Data(2021, java.time.Month.JANUARY, 20).get();
		
		new Data().is();

		LocalDate Sao_Sebastiao = LocalDate.of(2021, 1,20);

		//new Data(Sao_Sebastiao).isSupported(ChronoField.DAY_OF_WEEK);

		System.out.printf("%n isSupported DAY_OF_WEEK: %1$b; DAY_OF_MONTH: %2$b; DAY_OF_YEAR: %3$B",Sao_Sebastiao.isSupported(ChronoField.DAY_OF_WEEK), Sao_Sebastiao.isSupported(ChronoField.DAY_OF_MONTH), Sao_Sebastiao.isSupported(ChronoField.DAY_OF_YEAR));
		
		System.out.printf("%n %b",Sao_Sebastiao.isEqual(LocalDate.of(2021, Month.JANUARY, 20)));

		System.out.printf("%n Data Original: %1$s, with: DayOfMonth: %2$s, withMonth: %3$s,  withYear: %4$s ",Sao_Sebastiao,Sao_Sebastiao.withDayOfMonth(21), Sao_Sebastiao.withMonth(2),  Sao_Sebastiao.withYear(2022));			

		System.out.printf("%n Data Original: %1$s, plus: plusDays(1): %2$s, plusWeeks(1): %3$s", Sao_Sebastiao,  Sao_Sebastiao.plusDays(1), Sao_Sebastiao.plusWeeks(1));

		System.out.printf("%n Data Original: %1$s, plus: plus(1, ChronoUnit.DAYS): %2$s, CU.WEEKS: %3$s", Sao_Sebastiao,  Sao_Sebastiao.plus(1, ChronoUnit.DAYS), Sao_Sebastiao.plus(1, ChronoUnit.WEEKS));		

		System.out.printf("%n Data Original: %1$s, TOLDT: %2$S", Sao_Sebastiao, Sao_Sebastiao.atTime(12,0) );				

		Period $p = Period.between(LocalDate.now(), LocalDate.of(2021,Month.DECEMBER,31));


		System.out.printf("%n Period betwwen hoje até o ultimo dia do ano (quebrado). Anos : %1$-10d, Meses: %2$010d, Dias: %3$,2d", $p.getYears(), $p.getMonths(), $p.getDays());

		LocalDate _uda = LocalDate.of(2021,12,31), $h = LocalDate.now();

		long[] intervalos = new long[]{ChronoUnit.DAYS.between($h, _uda), ChronoUnit.MONTHS.between($h, _uda), ChronoUnit.YEARS.between($h, _uda), ChronoUnit.WEEKS.between($h, _uda)};


		System.out.printf("%n Intervalo entre hoje ate o ultimo dia de ano (nao quebrado). Dias: %1$010d, Meses: %2$-10d, Years: %3$,10d, Weeks: %4$(d   ", intervalos[0],intervalos[1],intervalos[2],intervalos[3]);

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		LocalDate Sao_Vicente = LocalDate.of(2021,01,22);

		System.out.printf("%n Formatação de data: %1$s; Natal - parse String p/ LD usando DTF: [%2$20s]", dtf.format(Sao_Vicente), LocalDate.parse("25/12/2021", dtf));

		Date $d1 = new Date();
		Calendar _c1 = Calendar.getInstance();

		System.out.printf("%n Date: %1$s; Calendar: %2$s", $d1, _c1);

		LocalDateTime $ldt3 = Sao_Vicente.atTime(12,00);

		Instant $i = $d1.toInstant(), $i2 = _c1.toInstant(), $i_ldt_to_date = $ldt3.toInstant(ZoneOffset.UTC);

		
		

		ZoneId _zid = ZoneId.systemDefault();

		LocalDateTime $ldt = LocalDateTime.ofInstant($i, _zid), $ldt2 = LocalDateTime.ofInstant($i2, _zid);

		System.out.printf("%n Date p/ LDT: [%1$20s]; Calendar p/ LDT: [%2$20s]", $ldt, $ldt2);
		
		
		Date $d2 = Date.from($i_ldt_to_date);
	//	Calendar $c2 = Calendar.getInstance($i_ldt_to_date);

		System.out.printf("%n LDT para Date %1$s", $d2)		;
	
		List<LocalTime> $ltm = new ArrayList<>();

		$ltm.add(LocalTime.now());

		$ltm.add(LocalTime.of(10,36));

		$ltm.forEach( _lt -> System.out.printf("%n lt: %1$s; getHour: [%2$-10d], getMinute: [%3$10d], 			getSecond: [%4$010d], 			getMiliSecond: [%4$,2d]. getcomCF: HOUR_OF_DAY: %5$d, MINUTE_OF_HOUR: [%6$010d], ISsupport: %7$b, with: %8$s ", 
			_lt, _lt.getHour(), 
			_lt.getMinute(), 
			_lt.getSecond(), 
			_lt.get(ChronoField.HOUR_OF_DAY),
			_lt.get(ChronoField.MINUTE_OF_HOUR),
			//_lt.isEqual(LocalTime.of(10,36,000))
			_lt.isSupported(ChronoUnit.HOURS),
			_lt.withHour(12).withMinute(50)
			));

		$ltm.forEach( lt -> System.out.printf("hora: %1$s . Plus: hours: %2$s, c/ c.u.: %3$s", 
			lt,
			lt.plusHours(1),		
			lt.plus(1, ChronoUnit.HOURS)



		))		;


		System.out.printf("%n Duration between dois tempos: %1$d. Duration of seconds: %2$s", 
				Duration.between(LocalTime.of(10,11), LocalTime.of(12,00)).getSeconds(), //só tem getSeconds()
				Duration.ofSeconds(10)); //Duration retorna Duration q não é digito

		DateTimeFormatter $dtm2 = DateTimeFormatter.ofPattern("HH:mm");

		LocalTime _ltm3 = LocalTime.of(10,25);

		System.out.printf("%n formator de tempo: %1$s, %2$s, %3$s", _ltm3.format($dtm2), $dtm2.format(_ltm3), $dtm2.format(LocalTime.parse("10:27:32.123", DateTimeFormatter.ofPattern("HH:mm:ss.SSS"))));

		List<String>  $livros = new ArrayList<>();
		
		$livros.add(0, "Mateus");
		$livros.add(1, "Marcos");
		$livros.add(2, "Lucas");		
		$livros.add(3, "João");
		$livros.add("Hebreus");

//		Predicate<String> $evangelho = new Predicate<>(){boolean test(String s) {if (s.isEquals("Mateus") || s.isEquals("João") || s.isEquals("Lucas") || s.isEquals("Marcos") ) return true; else return false;}}
			

//		List<String> $evangelhos =  LivrosFilter.filtro(  $livros , $evangelho );

		List<String> $evangelhos =  new LivrosFilter().filtro(  $livros ,  l -> l.equals("Mateus") || l.equals("João") || l.equals("Lucas") || l.equals("Marcos") );

		$evangelhos.forEach($l -> System.out.printf("%n %s", $l));

		
		//Predicate _p2 = i -> i >= 18 ;

		
		

		

		
		
	}


}

class LivrosFilter{

	 List<String> filtro(List<String> $livros, Predicate p){

		List<String> $saida = new ArrayList<>();		

		for(String l : $livros  )
			if(p.test(l))
				$saida.add(l)				;

		return $saida;

	}
}