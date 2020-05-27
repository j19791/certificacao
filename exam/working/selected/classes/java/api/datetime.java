package exam.working.selected.classes.java.api;

import java.time.*; //LocalDateTime
import java.time.temporal.*;//ChronoField
import java.util.*;
import java.time.format.DateTimeFormatter;

class DateTimeTest{


	public static void main(String args[]){
		

		try{
		ArrayList<LocalDate> datas = new ArrayList<>();
		ArrayList<LocalTime> tempos = new ArrayList<>();		
		ArrayList<LocalDateTime> datasTempos = new ArrayList<>();

		LocalDate ld1 = LocalDate.now();//data agora YYYY-MM-DD
		datas.add(ld1);
		datas.add(LocalDate.of(1979,04,24));
		datas.add(LocalDate.of(2015, Month.DECEMBER, 25));//utilizando enum de meses
		
		System.out.format("%1$s%n", "Datas", "Tempos", "DatasTempos");
		for(LocalDate data : datas){
			System.out.println(data);
		}
		
		LocalTime lt1 = LocalTime.now();//horario agora HH:MM:SS.mmm		
		tempos.add(lt1);
		tempos.add(LocalTime.of(8, 30));//os segundos sao opcionais
		tempos.add(LocalTime.of(18,00,00));
		
		tempos.add(LocalTime.now(ZoneId.of("America/New_York")));//horario com fuso horario
		tempos.add(LocalTime.now(ZoneId.of("America/Sao_Paulo")));
		
		System.out.format("%n%2$s%n", "Datas", "Tempos", "DatasTempos");
		for(LocalTime tempo : tempos){
			System.out.println(tempo);
		}

		LocalDateTime ldt1 =  LocalDateTime.now();//YYYY-MM-DDTHH:MM:SS.mmm
		datasTempos.add(ldt1);
		datasTempos.add(LocalDateTime.of(1994,05,01,9,25));
		datasTempos.add(LocalDateTime.of(LocalDate.of(1999,12,31), LocalTime.of(23,59,59,999)));//data, tempo
		datasTempos.add(LocalDateTime.of(ld1, lt1));//com variaveis

		System.out.format("%n%3$s%n", "Datas", "Tempos", "DatasTempos");
		for(LocalDateTime datatempo : datasTempos){
			System.out.println(datatempo);
		}

		System.out.printf("%n%1$s%n","testes extras" );
		System.out.println(MonthDay.now());//--05-27
		System.out.println(YearMonth.now());//2020-05
		
		ArrayList<Integer> extracoesDatasTempos = new ArrayList<>();
		extracoesDatasTempos.add(LocalDateTime.now().get(ChronoField.DAY_OF_WEEK)); //1 seg => 7 dom
		extracoesDatasTempos.add(LocalDate.now().getDayOfMonth());

		System.out.printf("%n%1$s%n", "extracoes");
		for(Integer extrato : extracoesDatasTempos){
			System.out.println(extrato);	
			
		}
		
		//Objetos imutaveis
		System.out.printf("%n%1$s%n", "operações com data");
		System.out.println(LocalDate.now().isBefore(LocalDate.of(2020,05,31)));//isBefore, isAfter,isEquals
		System.out.println(LocalTime.now().withHour(23));//retorna um tempo com hora = 23 . WithMinute
		System.out.println(LocalDate.now().minusDays(60).plusMonths(1).plusYears(1));//soma absolutamente uma data, hora
		System.out.println(LocalDate.now().plus(1,ChronoUnit.YEARS));//utilizando enum : SOMANDO 1 ANO (plus)
		
		//Extrair/INCLUIR data e tempo de LocalDateTime
		System.out.printf("%n%1$s%n", "extrair de LDT");
		System.out.println(LocalDateTime.now().toLocalDate());//cria um ld
		System.out.println(LocalDateTime.now().toLocalTime());//cria um novo lt
		System.out.printf("%n%1$s%n", "gerar um LDT a partir de um LD ou LT");
		System.out.println(LocalDate.now().atTime(LocalTime.of(23,59))); //cria ldt a partir de um ld
		System.out.println(LocalTime.now().atDate(LocalDate.of(1994,5,1)));//cria ldt a partir de um lt
		
		

		System.out.format("%n%1$s%n", "Date para LDT", "Calendar para LDT", "LDT para Date", "LDT para Calendar");
		System.out.println(LocalDateTime.ofInstant(new Date().toInstant(), ZoneId.systemDefault()));//new Date(). instant é um long q representa os ms desde 1970-01-01. Utilizando o fuso da maquina virtual


		System.out.format("%n%2$s%n", "Date para LDT", "Calendar para LDT", "LDT para Date", "LDT para Calendar");
		System.out.println(LocalDateTime.ofInstant(Calendar.getInstance().toInstant(),ZoneId.systemDefault() ));Calendar.getInstance();		

		System.out.format("%n%3$s%n", "Date para LDT", "Calendar para LDT", "LDT para Date", "LDT para Calendar");
		System.out.println(Date.from(LocalDateTime.now().toInstant(ZoneOffset.UTC)));

		System.out.format("%n%4$s%n", "Date para LDT", "Calendar para LDT", "LDT para Date", "LDT para Calendar passando por Date");
		Date d1 = Date.from(LocalDateTime.now().toInstant(ZoneOffset.UTC));
		System.out.println(d1);
		Calendar c1 = Calendar.getInstance();
		System.out.println(c1);
		//System.out.println(c1.setTime(d1));//nao funcionou??

		System.out.printf("%n%1$s%n", "Contas com datas");
		Instant i = Instant.now();
		Duration d = Duration.ofSeconds(10);
		System.out.println(i);
		System.out.println(i.plus(d));
		System.out.println(Instant.EPOCH);//epoch = 01/01/1970
		System.out.println(Duration.between(Instant.EPOCH, Instant.now()).getSeconds());
		
		Long du1 = ChronoUnit.YEARS.between(LocalDate.of(1979,04,24), LocalDate.now());
		System.out.println(du1.longValue()); //41 anos
		Long du2 = ChronoUnit.MONTHS.between(LocalDate.of(1979,04,24), LocalDate.now());
		System.out.println(du2.longValue()); //493 meses
		Long du3 = ChronoUnit.DAYS.between(LocalDate.of(1979,04,24), LocalDate.now());
		System.out.println(du3.longValue()); //15009 dias

		Period p = Period.between(LocalDate.of(1979,04,24), LocalDate.now());//diferença acumulada
		System.out.println(p.getYears());//41 anos
		System.out.println(p.getMonths());//1 mes
		System.out.println(p.getDays());//3 dias

		System.out.printf("%n%1$s%n", "Formatador");
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		System.out.println(formatador.format(LocalDate.now()));//Localdate p/ string
		System.out.println(LocalDate.parse("27/05/2020", formatador));//String p/ LOcalDate

		}catch(DateTimeException dtex){
			System.out.format("dtex: %s%n", dtex);
		}

	}

}