//ocorre erro de execução se o arquivo nao estiver no path abaixo. 
//o comando java devera ser java br/com/jefferson/certificacao/EstruturaTeste
//package é opcional
//package deverá ser o 1o. comando do arquivo
//só pode ter 1 package
package br.com.jefferson.certificacao; //precisa de ;

//import precisa vir depois do package
//opcional
//pode ter + de 1

import java.util.Date;
import java.io.*;



//classes default nao precisam ter o nome do arquivo p/compilar
//public class EstruturaTesteNome{ nao funciona - public class deverá ter o nome do arquivo
public class EstruturaTeste{

	static int i;	
	int j;

	int EstruturaTeste; // nao há conflito com o nome da classe
	
	void EstruturaTeste(){}; //nao é construtor. Não há conflito com o nome da classe

	EstruturaTeste(){
		//opcional
		return; //construtor nunca deverá retornar nada - return vazio
	} 

	public static void main(String args[]){

		System.out.println(i)	; //variavel de classe nao precisa de objeto para existir. Vai retornar 0 aqui 
		//System.out.println(j)	; vai dar erro. nao é estatica
		System.out.println(new EstruturaTeste().j)	;//vai funcionar pq nao estatica precisa de pelo menos 1 objeto anonimo
	}

	

}

//pode ter mais de 1 classe default mas apenas uma publica
class ClasseTeste2{

}

//pode ter mais de 1 classe default. Arquivo class é gerado separadamente
class ClasseTeste3{

}

interface Testando{

}

//package br.com.jefferson.certificacao; nao funciona aqui