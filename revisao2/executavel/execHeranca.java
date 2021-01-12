package executavel;

import java.util.List;
import java.util.ArrayList;
import heranca.mae.Mae;
import heranca.mae.Mae2;
import heranca.filha.*;
import heranca.filha.neta.*;
import heranca.interfaciavel.I1;

class _execHeranca{

	static public void main(String ... args){

		//new heranca.mae.Mae(); mae nao pode ser instanciada pois é abstract
		List<Mae> lista = new ArrayList<>();

		Mae m1 = new heranca.filha._Filha1("Joana");
		Mae m2 = new heranca.filha._Filha2("Madalena");
		Mae _m3 = new heranca.filha.neta.Neta("Mirella");

		Neta4 $n4 = new Bisneta(); //bisneta tbm implementa I1		

		heranca.interfaciavel.I1 $i1 = (I1) $n4; //em tempo dee compilacao, a var de ref do tipo Neta4 precisa do cast para I1. Em tempo de execução não ocorre o cce pois o objeto ref (Bisneta) implementa I1

		//new Neta5(); //se nao implementar os metodos abstratos que herdou, nao compila		

		//System.out.printf("%n constante de interface: %1$d",new I1().$_1); nao compila: interface não pode instanciar

		System.out.printf("%n constante de interface implementada por uma classe: %1$d",new Bisneta().$_1); 
		

		Mae[] filhas = new Mae[]{m1, m2, _m3};

		for(Mae $m : filhas)
			lista.add($m);



		lista.forEach(m -> System.out.printf("%n Filha: %1$s , contador: %2$d", m, m.getContador()));

		System.out.printf("%n Contador: Mae: %1$d, filhas: %2$d, neta: %3$d", Mae.getContador(), _Filha2.getContador() , Neta.getContador());

		System.out.printf("%n testar contexto static: %1$d", _Filha1.testaStatic());

		lista.forEach(m -> System.out.printf("%n testa binding polimorfismo: %1$s",m.testaBindingInstanciaPolimorfismo()));
				
		lista.forEach(m -> System.out.printf("%n testa instaceof Mae: %1$b",m instanceof Mae));		
		
		_m3.testaAbstract();
		
		/*
		Predicate<Mae> matcher = new Predicate<mae>() { //classe anonima
			@Override
			public boolean test(Mae m) {return m instanceof Mae;}
		};		

		List<Object> objetosFiltrados = matcher.filter(lista, m -> );
		*/

		_Filha2 $f2 = new _Filha2();
		
		//Neta $n = (Neta) $f2; CCE - em tempo de exec, filha nao pode ser neta

		//Neta2 $n2 = (Neta2) $f2;		cce

		//$Filha3 $f3 = new $Filha3();
		//Neta3 _n3 = (Neta3) $f3; cce

		Mae2 $m2 = new Mae2();
		//$Filha3 $f3 = ($Filha3) $m2; cce


		V $v = new C();
		//C $c = (C) new V();cce
		//C $c =   $v; tempo de compilacao: V nao é um C
		C $c =   (C) $v; //compila em tempo de comp e exec

	}

}


class V{}

class C extends V{}

class M extends V{}
