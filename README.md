# Repositório de todo material utilizado para certificação OCA Programmer 1Z0-808

1. Java Basics 
	1. Define the scope of variables 
		1. **for**: as variaveis declaradas na área de inicialização do loop só podem ser usadas no corpo do loop
		1. **parametros de métodos** : variaveis locais dos métodos. Não podemos declarar novas variaveis locais com o mesmo nome
		1. variáveis **static** podem ser acessadas por uma instance reference ou diretamente pela classe
		1. variaveis de classe e de instancia não podem ter o mesmo nome
		1. **shadowing** : declarar em métodos variaveis locais ou de parametros com o mesmo nome da variavel de instancia. Usar **this** para referenciar variaveis de instancia. Se nã usar this, o compilador vai usar a variável de menor escopo.
	1. Define the structure of a Java class
		1. **default package** : qdo não declara explitamente um pacote. Não podem ser importadas para uso em outros pacotes.
		1. **membros de classe**: variaveis de instancia, construtores e métodos. Podemos ter membros de tipos diferentes com o mesmo nome.
		1. **assinatura de um método**: nome do método e os tipos de parametros. Deve ter retorno. Pode ter o mesmo nome de um construtor.
		1. **construtor**: a classe pode ter 0 a n construtores. Não devem ter retorno. Pode ter um *return* mas vazio
		1. **interface**: possui métodos somente com assintura, sem implementação. Possível declarar *constantes* **final**
		1. **public class** ou **public interface** : o nome do arquivo *.java* deve ter o nome dessa *class/interface*
		1. só pode exitir *uma* **public class** ou **public interface** por arquivo *.java*		
	1. Create executable Java applications with a main method; run a Java program from the command line; produce console output
		1. *classe executavel* é aquela que possui o método **public static void main (String[] argumentos)** . Pode ter *static public* ou usar *varargs ...*
		1. **java** HelloWorld *Mario* : passando 1 parametro para a execução do programa
		1. **.class** é o *bytecode* gerado pelo *javac*
		1. **package certification;** : javac *certification/Test.java*; java *certification.Test*
		1. Passando **propriedades** na execução: java *-Dkey1=abc -Dkey2=def* Foo xpto bar 
		1. **classpath**: diretorios, jar que contem as classes e pacotes da aplicação. Padrão é o *diretório corrente (.)* 
		1. javac **cp /path/to/lib.jar** test.java
		1. java **cp /path/to/lib.jar** Test
		1. Criar um jar da pasta certification: *jar **-cf library.jar** certification*		
	1. Import other Java packages to make them accessible in your code
		1. Classes *se enxergam* se estão no **mesmo pacote**
		1. usar o **Full Qualified name** para acessar a *public class*  de outro pacote
		1. **import Full Qualified name** para evitar o uso do *Full Qualified name* em vários pontos do código
		1. **import com \*** para importar todas as classes do pacote. *Não importa subpacotes*. Cada subpacote deverá ser importado.
		1. **classes com mesmo nome**: *import java.util.Date; import java.sql.Date;* não compila se usar variaveis de instancia com o tipo Date. Pode importar apenas 1 pacote e usar o *fqn* para declarar o tipo da variável.
		1. *import java.util.\*; import java.sql.Date* : vai ser usado do Date do pacote sql (mais específico)
		1. pacote **java.lang.\*** são implicitamente importadas. *String*
		1. **import static model.Utils.\*** : importa todos os membros *static* da classe Utils		
	1. Compare and contrast the features and components of Java such as: platform independence, object orientation, encapsulation, etc.
		1. **bytecode** .class é interpretado pela **JVM** que converte em código de máquina, executado pelo **SO** nativo
		1. programa **escrito** e **compilado** apenas 1x pode ser usado em diversas plataformas diferentes.
		1. **OO**: estruturamos o código em entidades *objetos* (compontentes especializados) que possuem dados na forma de *atributos* e comportamento na forma de *métodos*
		1. Cada objeto deve ter *única responsabilidade*, favorecer *reuso de código* e cada mudança no comportamento *reflete em todos os lugares* onde o objeto é usado.
		1. *Encapsulamento* *privar* atributos e implmentação p/ q outros objetos manipule esses atributos. Liberar apenas por meio de métodos *public*
1. Using Operators and Decision Constructs 
	1. Use Java operators; use parentheses to override operator precedence
		1. **= atribuição** tipos compatíves ou o valor deverá ser = ou menos abrangente. tipos primitivos: copiamos o valor
			1. double d = 20.0f; *float é menos abrangente que double*
			1. float f = 40.0; *erro: double não cabe em float*
			1. float h = 10l; *inteiros (long) cabe em decimal*
			1. tipos menos abrangentes que int: **byte, short, char** compilador verifica se esta no range do tipo
				1. byte b = 200; *estoura byte:  -128 a 127 (único itervalo cobrado)*
				1. char c2 = -1; *erro: só positivo*
			1. *referência: polimorfismo*	
				1. List<String> names = new ArrayList<>(); *<> operador diamante*
				1. copiamos o valor da referência (o objeto é o mesmo)
		1.**aritméticos**
			1. **%** resto de divisão: *apenas inteiros*
			1. o tipo do resultado da operação é no minimo **int** ou o **mais abrangente**
				```java					
					int age = 15;
					long years = 5;
					int afterThoseYears2 = age + years;// não compila, o maior tipo era long, devolve long
					byte b = 1;
					short s = 2;
					byte b2 = i + s; //// não compila, ele devolve no mínimo int					
				```
			1.	**divisão por 0**: 
				1. *inteiro:* `System.out.println(200 / 0); //ArithmeticException`
				1. *decimal:* `System.out.println(200 / 0.0); //compila e roda:  infinito positivo`
				1. *NaN:* infinito positivo - infinito negativo
		1. **comparação == != >, < **:
			1. sempre devolve um boolean
			1. referencias e boolean somente com *== ou !=*
			1. pode comparar *char* com *numérico* ```System.out.println('a' > 1);//true```
			1. valores numéricos não considera seu tipo
		1. **lógicos**
			1. *& | *: a segunda parte sempre é avaliada, podendo incrementar variaveis e tbm chamar métodos			
			1. *curto circuito && ||: *  Quando já for possível determinar a resposta final olhando apenas para a primeira parte da expressão, a segunda não é avaliada
			```java
			System.out.println(1 == 2 & imprimir("hi"));// imprime hi, depois false
			System.out.println(1 == 2 && imprimir("bye"));//imprime false
			int i = 10;	System.out.println(i == 2 & i++ == 0);// imprime false, soma mesmo assim
			int j = 10;	System.out.println(j == 2 && j++ == 0); // imprime false, não soma
			```
		1. **incremento/decremento**
			1. *pré*: sempre a primeira coisa q é feita é o incrementar/decrementar
			```java
				int i = 10; System.out.println(++i); //imprime 11
				int j =10;	System.out.println(j++); //imprime 10
			```
		1. **operações/atribuições de uma só vez**
			```java
			short b2 = 3; b2 += 4; // compila, dá um desconto
			b2 += 4003245; // -76: compila também, mas estoura o byte
			```
		1. **atribuição c/ o próprio incremento: ** a execução é do primeiro para o último elemento das somas, temos as reduções:
			```java
			int a = 10;
			a += ++a + a + ++a;			
			a = a + ++a + a + ++a;
			a = 10 + 11 + a + ++a;
			a = 10 + 11 + 11 + ++a;
			a = 10 + 11 + 11 + 12;
			a = 44;
			```
		1. **diversas atribuições**: atribuir da direita p/ esquerda 
			```java int a = 15, b= 20, c= 30; a = b = c; // b recebe c, a recebe b, a= 30 
			int a = 15, b= 20, c= 30; a = (b = c + 5) + 5; // c + 5 = 35, b = 35, 35 + 5 = 40, a = 40```
		1. **ternário** variavel = teste booleano ? verdadeiro : falso;
		1. **referencia (.) **: p/ acessar atributos ou métodos de um obj
		1. **concatenação de Strings (+) : ** ` System.out.println(15 + ( 0 + " != 150")); // 15 + "0 != 150"; "150 != 150"	`		
		1. **precedencia: **
			1. pre incremento/decremento
			1. mult/ div/ model
			1. soma/ sub
			1. pós incremento/decremento
		1. **casting de primitivos**
			1. atribuição somente se *compatível: * um tipo cabe no outro: 
			
			**byte -> short -> int -> long -> float -> double**  *autopromoção: qdo o tipo vai da direita p/ esquerda*
			
			**char -> int ** *autopromoção*
			
			1. **casting: ** direita p/ esquerda. Moldar o valor de um tipo em outro. Queremos e avisamos o compilador q sabemos da possibilidade de perca de precisão/ truncamneto
			
			```java
			double d = 0, d2 = 3.1415;
			float f = d; //não compila: double não cabe em float
			float f = (float) d;
			int i = (int) d2;//i= 3 (valor truncado)
			```
			1. short e char tem o mesmo tamanho mas **char é apenas >=0**		
	1. Test equality between Strings and other objects using == and equals ()
		1. comparar dois objetos para ver se **apontam para o mesmo lugar**
		
		```java
			String name1 = new String("Mario");	String name2 = new String("Mario");
			System.out.println(name1 == name2); // false: 2 objetos criados com new		
		```
		
		1. **Pool de Strings: ** 
			1. antes de criar uma nova String, verifica-se se já existe no pool uma String com mesmo conteúdo. Se já existe, não cria nova, reutiliza. ``` String name1 = "Mario"; String name2 = "Mario"; System.out.println(name1 == name2);	//true	```
			1. Só coloca no pool Strings criadas com literais
			1. Quando concatenamos Strings (*literais em ambos os lados da concatenação*), o resultado tbm será colocado no pool ```String ab = "a" + "b";System.out.println("ab" == ab);//true```
			1. Se um dos objetos concatenados não for literal, cria um novo obj fora do pool ```String a = "a"; String ab = a + "b"; System.out.println("ab" == ab); // false```
			1. objetos *retornados de métodos* são novos objetos, não são buscados no pool ```String str = "12 text 345678"; String txt1 = "text";String txt2 = str.substring(3, 7); System.out.println(txt1 == txt2); // false ```
				1. se o retorno do método for *exatamente igual ao conteúdo da String passada*, não é criado novo objeto ```String str = "HELLO WORLD";String upper = str.toUpperCase(); System.out.println(str == upper); // true ```
			1. **contando Strings**				
				```java 				
				String h = new String ("hello ");//Cria 2 objetos, um literal (que vai para o pool) e o outro com o new
				String h1 = "hello "; //nenhum objeto criado, usa o mesmo do pool
				String w = "world"; //novo objeto criado e inserido no pool
				System.out.println("hello ");//nenhum objeto criado, usa do pool
				System.out.println(h1 + "world");//criado um novo objeto resultante da concatenação, mas este não vai para o pool: (variavel + literal)
				System.out.println("Hello " == h1); //Novo objeto criado e colocado no pool (Hello com H maiúsculo).
				//Logo temos 5 Strings criadas.
				```
				``` 
				for(int i = 0; i< 10; i++)
					System.out.println(method());
				}
				private static String method() {
					String x = "x"; // A String será colocada no pool apenas na primeira execução do método. Apenas um objeto String será criado
					return x.toString();
				}
				```
				
		1. **equals: ** sobreescrever método com seu critério de igualdade
			1. **== **: *true* qdo comparando os mesmos objetos na memória 		
				```java
				System.out.println(s1.equals(s3)); // String mesmo conteúdo: true
				new Client("Mario").equals(new Client("Mario"));//false : apesar do mesmo conteúdo, vc deverá sobreescrever o método equals na classe Client
				
				public boolean equals(Client second) {
					return this.name.equals(second.name);
				}
				
				new Client("Mario").equals(new Client("Mario"));//true
				```	
	1. Create if and if/else and ternary constructs ``` ```
		1. controlar o *fluxo de execução* dos programas
		1. a **condição** de um if deverá ser um valor **booleano** ``` if (2 - 1) \\erro: inteiro```
		1. não existe *elseif* usar **else if**
		1. **unreachable code** não compila qdo o código não foe executado sob nnehuma hipótese
		```java 
			public int method() {
				return 5;
				System.out.println("Will it run?"); //unreachable code
			}
		```
			1. **if(false){...}** compila apesar de não executar nada dentro do bloco
		
		1. **missing return** não compila qdo falta um fluxo para execução d euma determinada condição. Todos os caminhos possíveis devem retornar o tipo indicado pelo método ou *lançar uma exception*
		```java
			public int method(int x) {
				if(x > 200) //e se x <= 200: ??? missing return mas foi lançado a RtE para não ocorrer o erro
					return 5;
				throw new RuntimeException();
			}
		```		
	1. Use a switch statement 
	 
		int option = 1;
		
		switch (**option**) { //o argumento deverá ser sempre compatível com **int, wrapper menor q Integer, String, Enum**
		
			**case 1**: //o valor de cada case deverá ser compatível com o argumento do switch. Usar **literal, variavel final iniciada durante sua declaração com literal ou expressões com literal/ variavel final. null não é válido**
			
				System.out.println("number 1");
				
				**break;** para não executar os casos q vem abaixo
			
			**default**: //qdo nenhum caso bater. Pode aparecer no meio dos cases
			
				System.out.println("number n");
				
				break;
			
			case 2:			
			
				System.out.println("number 2");
				
				break;
			
			case 3:
				
				System.out.println("number 3");
				
				break;
		}	
	

1. Using **Loop** Constructs 
	1. Create and use **while** loops
		1. a *condição* deve ser *booleano*
		1. Roda enquanto a condição for *true*. executado repetidamente até a condição se tornar *false*		
		1. qdo o loop é explicitamente *infinito* e tem código depois do loop, não compila
		```java
		while(true) { // true, true, true ...
			System.out.println("do something");
		}		
		return 1; // compile error```
		
		```java
		final boolean CONDICAO = true;
		while(CONDICAO) { // true, true, true ...
			System.out.println("do something");
		}		
		return 1; // compile error```
		1. qdo a variável *não é final, compila*
		```java
		boolean rodando = true; // não final
		while(rodando) { // true? false?
			System.out.println("do something");
		}
		return 1; // ok
		```
		1. **unreachable statement**: compile error. O compilador só consegue analisar o código com *literais ou constantes*
		```java		
	`	while(false) { /* code */ } //nao compila
		while(1 > 2) { /* code */ }	//nao compila		
		int a = 1, b = 2;
			while(a > b) // compila
				System.out.println("OI");			
		```
		
	1. Create and use **for** loops including the **enhanced for** loop
		1. *inicialização*: 
			1. executada apenas 1x no começo do for. 
			1. Permitido declarar variaveis de um mesmo tipo `for(int i = 1, j= 2;;){/code}` ou inicializar diversas variáveis de tipos diferentes. `for(a=1, b=2.0, c = true;;){//code}`
		1. *condição*: verificada no começo de cada iteração. default: *true*
		1. *comandos*:
		1. *atualização*: 
			1. executada no fim da iteração. 
			1. p/ não ocorrer o *loop infinito*. 
			1. Pode fazer varias atualizações `for(int i = 0, j= 0;i< 10; i++, j++){//code}
			1. pode executar trecho de código `for(int i = 0, j= 0;i< 10; i+= 3, System.out.println(i++)){//code} 
		1. argumentos são opcionais e são preenchidos com os valores default ```for(;;) {//code}```
		1. **enhanced for**: 
			1. percorre todos os elementos de uma *Collection*: `int i[] = {1,2,3,4,5}; for (int numbers : i){System.out.println(num);}`
			1. *Não podemos modificar* o contéudo da collection q estamos percorrendo
			1. não existe *contador*. Não é possível percorrer *+1 collection ao mesmo tempo*
	1. Create and use **do/while** loops
		1. a condição é testada após rodar o trecho do código *pelo menos 1x*
		1. não esquecer do **;** `do{}while(condicao);` p/ não ocorrer erro de compilação
		1. apenas 1 linha s/ chaves é permitido dentro do do/while. Caso tenha +1 sem chaves: erro de compilação		
	1. **Compare loop** constructs
		1. *while X do/while* : condição testada apenas depois de 1 interação do loop
		1. *for X enhanced for* : não podemos remover, inicializar e percorrer + de 1 vez uma collection
		1. *while X for* : for qdo sabemos exatamente a qtd de vezes q o laço deverá ser executado. While: qdo temos apenas uma condição verdadeira p/ repetir o laço		
	1. Use **break** and **continue**
		1. aplicavel em qq estrutura de laço
		1. *break* : para o laço totalmente
		1. *continue* : interrompe apenas  a iteração atual
		1. compila while infinito c/ break 
		1. qdo tem laços encaixados, o break ou continue vale p/ o + próximo (interno)
		1. **labeled loops** 
			1. rótulo deve referenciar apenas for, loop, switch
			1. nomes dos rótulos podem ser repetidos desde q não haja conflito de escopo
			1. um mesmo statement pode ter 2 labels `first: second: for (int i = 0; i < 10; i++) {`
		```java
		external: for (int i = 1; i < 10; i++) {
			internal: for (int j = 1; j < 10; j++) {
							if (i * j == 25) {
								break external; // quebrando o for externo
							}
							if (i * j == 16) {
								continue internal; // pulando um iteração do for interno
							}
						}
					}	
		```
		1. *switch* só aceita *break*
		
		
1. Working with **Inheritance **
	1. Describe inheritance and its benefits
		1. a classe filha *especializa* a mais genérica
		1. a classe mãe precisa ser visível e tbm um de seus contrutores
		```java
		class Parent {Parent(int x) {}}
		class Child1 extends Parent{ // compile error
			// implicit Child1() { super(); }
		class Child2 extends Parent { Child2() {super(15); // ok}		
		```
		1. a classe mãe não pode ser *final* mas a filha pode
		1. métodos e atributos são herdados *independentemente da visibilidade*. A claase filha pode não enxergar o membro herdado
		```java
		class X{ private int x; public void method(){}};
		class Y extends X { public void method2(int x){this.x = x; //erro: nao enexerga private de outra classe, mesmo herdando  x  }  } 
		```
		1. não existe **herança de métodos de estáticos** : qdo herdamos uma classe c/ métodos *static*, podemos usa-los com o nome da classe filha
			1. não colocar **super** dentro do contexto *static*. Não existe objeto
			```java
			class Z extends W {
				public static void method() {
					super.method(); // compile error
				}
			}
			```
			1. **abstract** não compila em métodos *static* pois não há herança
			1. podemos escrever um método *static* na classe filha c/ o mesmo nome da classe pai mas não é *sobreescrita*
			1. **binding do polimorfismo** : o método chamado é do pai ou da filha ?
				1. *método de instancia* : tempo de execução. 
				1. *método static* : tempo de compilação. Ignora o tipo de objeto referenciado. Utiliza o método da ref
		1. **sobreescrita de atributos** : não existe. Vai ter o atributo com o mesmo nome da classe mãe, acessível com **super** ou da própria classe q sobreescreveu, acessível com **this**
		1. **toString** sobreescrever de *Object* p/ devolver uma String q represente o objeto ```public String toString()```
	1. Develop code that makes use of **polymorphism**; develop code that **overrides methods**;  differentiate between the **type of a reference** and the **type of an object**
		1. **reescrita, sobrescrita** : subclasse redefine o comportamento do método herdado da superclasse
			1. **polimorfismo** : 
				1. *binding* : (lookup)
					1. 1) em *tempo de compilação*, verificar se o pai e os filhos possuem métodos sobreescritos. Verificação da existência do método
					1. 2) em *tempo de execução*, o método invacado é o do objeto, não o da referencia *virtual method invocation*	
					- [ ] desenhar
					1. é o inverso dos métodos *static*
					- [ ] desenhar
					```java
					class Vehicle {public void turnon() {System.out.println("Vehicle running!");}}
					class Car extends Vehicle {public void turnon() {System.out.println("Car running!");} public void turnoff(){}}
					
					Vehicle v = new Car();
					v.turnon(); // Car running!
					v.turnoff(); //erro de compilação
					```	
					
			1. mesmo *nome*
			1. *parametros* iguais em tipo e ordem
			1. *retorno* do método igual ou mais específico (covariante). Não vale p/ primitivos
			1. *visibilidade* igual ou maior q a mãe
			1. número de *exceptions* lançadas *throws* devem ser o mesmo ou menor. Elas devem ser do mesmo tipo ou mais específico.
				1. *RuntimeException* podem ser adicionadas s/ a restrição
			1. método da mãe não pode ser *final*
			1. *interface* : os métodos são implicitamente *public*
			```java
			interface A {void a();}
			class B implements A {void a() {}} \\compile error: default é menos visivel q public
			```
		1. *abstract* : quem herdar dessa classe deverá sobreescrever obrigatoriamente o método do pai
		1. **this** deixa explicito que o método sobreescrito da própria classe filha q deverá ser chamado
		1. **super** deixa explicito que o método invocado deverá ser do pai sobreescrito 
			```java
			class A {public void method() {System.out.println("a");}}
			class B extends A {
				public void method() {System.out.println("b");super.method(); }//b,a
				public void method2() {
					method(); //(this), b,a
					super.method(); }}	//a		
			```
			1. Car extends Vehicle : Car **é um** veículo - **polimorfismo**
			1. método q recebe Vehicle pode receber qq *é um* : reaproveitamento do código
			1. mudamos o tipo da referência mas nunca o *tipo do objeto*. Chamamos (referencimos) o obj de várias formas diferentes
			1. referenciar pelo seu próprio tipo, classes pai, qualquer interface
			1. método default ou private do pai em pacotes diferentes : não há sobreescrita. o binding só consegue acesso ao método que esta no mesmo pacote (da própria referencia)
			- [ ] desenhar	
	1. Determine when **casting** is necessary
		1. o compilador não conhece os valores das variáveis, apenas seu tipo `String recovered = objetos[0];` nem todo object é uma String
		1. *moldar* a referencia p/ q compile `String recovered = (String) objetos[0];`
		1. na **execução**, o casting vai ver se aquele objeto é compatível com o tipo do casting
		1. alguns Vehicle são Moto `Moto m = (Moto) v`
		1. Não é compatível : **classCastException**
		1. casting **opcional** qdo não precisamos
		1. *subindo* na hierarquia de classe: autopromoção. Descendo : casting é necessario. Sem caminho possível, compila mas não executa: *classCastException*
		- [] desenhar
		1. podemos implementar **multiplas interfaces**. Fazer casting p/ *interfaces* sempre vai compilar/executar `Car c = new Car();Runnable r = (Runnable) c;`
		1. classe Car não implementa Runnable mas existe a possibilidade de algum tipo Car implementar a interface Runnable ?? Compila mas em tempo de execução pode dar erro se não tem o RunnableCar
		1. se Car fosse *final*, e não implemente Runnable. Nenhuma filha de Car poderá implementar Runnable e o código não compila
		1. **instanceof**
		```java
		Object c = new Car();
		boolean b1 = c instanceof Car; // true
		boolean b2 = c instanceof Motorcycle; // false
		String s = "a"; boolean b = s instanceof java.util.List; // obviamente incompatível : compile error
		```
		
	1. Use **super** and **this** to access **objects** and **constructors**
		1. construtor pode ser *sobrecarregado* e ter qualquer *visibilidade*
		1. p/ construir um obj da classe filha, obrigatoriamente precisamos chamar o construtor da classe mãe antes
		1. **super()** não chamamos o construtor da classe mãe explicitamente. o compilador coloca automaticamente o *super()*
		1. **this()** chama outro construtor mas da própria classe
		1. *super() e this()* só podem aparecer como primeira instrução do contrutores e apenas uma chamada
		1. **this e variaveis membro** variaveis membro com o mesmo nome da variável local: o acesso é da variável local. this: acessar variavel membro da pr´pria classe ou da classe pai		
			1. classe mae e filha com variaveis membro de mesmo nome. Diferenciar usando *this* para a variavel da propria classe e *super* para acessar a variavel da mãe
			1. se não incluir *this* ou *super* será acessado a variavel membro da filha
			1. método **static** não tem *super* e *this* : o código não é executado dentro de um objeto
			```java
			class A{int i = 5;}
			class Test extends A{int i = 10;
				public static void main() {
					this.i = 5; // this? compile error
					super.i = 10; // super? compile error					
					new A().i = 5;
					new Test().i = 10;
				}}			
			```			
	1. Use **abstract classes** and **interfaces**
		1. *interfaces* não podem ter métodos *static*
		1. uma classe abstrata pode não ter nenhum método abstratato
		1. se a classe possui pelo menos 1 método abastrato, a classe precisa ser abstrata
		1. método abstrato não tem corpo, somente sua definição
		1. classe abstrata não pode ser instanciada diretamente
		1. classe concreta q herda de uma abstrata, precisa reescrever e implementar seus métodos que ainda não foram implementados
		1. subclasse abstrata não precisa implementar todos os métodos abstratos da classe pai. Não precisa nem ter a definição dos métodos abstratos
		1. *interface* : declara métodos (por padrão: *public abstract*) q deverão ser implementados (todos) pelas classes concretas que queiram ser consideradas como tal
		1. manter a visibilidade dos modificadores 
		1. uma classe pode implementar diversar interfaces `abstract class MyType implements Serializable, Runnable`
		1. uma interface pode herdar de diversas interfaces `interface C extends Runnable, Serializable {}`
		1. declarar *variaveis* membro em uma interface: todas elas serão *constantes* `interface X {/* public static final */ int i = 5;}

1. Working with Selected classes from the **Java API** 
	1. Manipulate data using the **StringBuilder** class and its methods
		1. Strings *mutáveis*
		1. concatenar *append* `StringBuffer sb = new StringBuffer();sb.append("Caelum");sb.append(" - ");sb.append("Alura - Casa do Código"); //// Caelum - Alura - Casa do Código`
		1. criar objeto do tipo StringBUilder `new StringBuilder(); StringBuilder sb2 = new StringBuilder("java");StringBuilder sb3 = new StringBuilder(50) /* tamamnho inicial do array (length = 0)*/;StringBuilder sb4 = new StringBuilder(sb2);`
		1. permite chamadas encadeadas : `new StringBuffer().append("Caelum").append(" - ").append("Ensino e Inovação") // Caelum - Ensino e Inovação`
		```java
		StringBuffer sb = new StringBuffer();
		sb.append("Caelum - Inovação");
		sb.insert(9, "Ensino e "); // inserir coisas no meio com indice Caelum - Ensino e Inovação 
		sb.delete(6, 15); //indice inicial e final - Caelum e Inovação
		new StringBuffer("guilherme").reverse(); //emrehliug		
		```
		1. *substring* não altera o valor do seu StringBuilder ou StringBuffer , mas retorna a String que você deseja.
	1. Create and manipulate **Strings**
		1. *imutáveis* 
		1. criar `String implicit = "Java";String explicit = new String("Java"); char[] name = new char[]{'J', 'a', 'v', 'a'}; String fromArray = new String(name); String nameBuilder = new String(new StringBuilder("Java"));`
		1. não é um tipo primitivo, pode ter valor *null* `String name = null; // explicit null`
		1. conversão de *null* para String na concatenação: `String nulled = null; System.out.println("value: " + nulled); /* value: null */ System.out.println(nulled + " value"); // null value
		1. conversão de *primitivos* p/ String `String name = "Java" + ' ' + "Certification" + ' ' + 1500; //Java Certification 1500`
		1. cuidando c/a precedencia de operadores `String value = 15 + 00 + " certification"; \\ 15 certification`
		1. todos os métodos devolvem uma nova String
		```java
			"Java".length(); //4
			"".isEmpty(); /*true*/ " ".isEmpty(); /*false*/
			substring(beginIndex, endIndex); /* inclui o caractere da posição inicial mas não o da final */ subString(beginIndex); /*a partir do indice passado até o fim */
			"Java".substring(0, 4); /*Java*/ "Java".substring(0, 3)); /*Jav*/
			replace(oldChar, newChar); /*substitui as ocorrências de um char por outro*/ replace(CharSequence target,CharSequence replacement);
			trim() /*limpa os caracteres brancos das duas pontas do String*/
			"Certification".compareTo("certification"); /* -32 lexicográfico: dictionary order, except that all the uppercase letters preceed all the lowercase letters. Retorna negativo caso a  String na qual o método for invocado vier antes;zero se for igual; positivo se vier depois do parâmetro passado */
		```
		1. *StringIndexOutOfBoundsException* `"guilherme".charAt(20); "guilherme".charAt(-1);`
	1. Create and manipulate calendar data using classes from **java.time.LocalDateTime,  java.time.LocalDate, java.time.LocalTime, java.time.format.DateTimeFormatter, java.time.Period**
		1. *imutáveis*
		1. *LocalDate* yyyy-MM-dd
		1. *LocalTime* hh:mm::ss.zzz			
		1. *LocalDateTime* yyyy-MM-dd-hh:mm::ss.zzz
		1. *MonthDay* MM-dd
		1. *YearMonth* yyyy-MM
		1. *now()* criando `LocalTime currentTime = LocalTime.now(); LocalDate.now(ZoneId.of("America/Sao_Paulo"));`
		1. *of()* `LocalTime meioDia = LocalTime.of(12,0); LocalDate Natal = LocalDate.of(2014, Month.DECEMBER, 25); MonthDay.of(12, 25); LocalDateTime ldt = LocalDateTime.of(natal, meioDia);
		1. *get* `ldt.getDayOfMonth(); ldt.getDayofYear(); /*349*/; ldt.getDayOfYeak(); /*Monday*/ ldt.getMonth() /*DECEMBER*/ ; ldt.getMonthValue(); /*12*/
			1. *ChronoField* campo que será retornado `ldt.get(ChronoField.HOUR_OF_DAY) /*13*/; `
		1. *is* comparações `natal.isEqual(LocalDate.of(2015, 4, 1));  natal.isSupported(ChronoField.HOUR_OF_DAY)) /*false*/; natal.isSupported(ChronoUnit.DAYS) /*Can I make operations with days?		*/` 
		1. *with* obter versões modificadas `LocalDate d = LocalDate.of(2015, 4, 1) /*2015-04-01*/; d = d.withDayOfMonth(15).withMonth(3) /*2015-03-15*/; `
		1. *plus minus* `LocalDate d = LocalDate.of(2013, 9, 7);d = d.plusDays(1).plusMonths(3).minusYears(2); /*2011-12-08*/`
			1. *ChronoUnit* fazendo operações utilizando unidades de tempo, sem se preocupar c/ dias e meses `d = d.plusWeeks(3).minus(3, ChronoUnit.WEEKS);`
		1.  *UnsupportedTemporalTypeException*
		1. *to* ldt para ld ou lt: `LocalDateTime now = LocalDateTime.now(); LocalDate dateNow = now.toLocalDate(); // from datetime to date`
		1. *at* ld ou lt p/ ldt  `LocalDateTime ldt = LocalDate.of(2020,08,17).atTime(LocaTime.now());`
		1. *converter* 
			1. *java.util.Date* *java.util.Calendar*
			1. Date para ldt `LocalDateTime.ofInstant(new Date().toInstant(), ZoneId.systemDefault());`
			1. Calendar para ldt `;LocalDateTime.ofInstant(Calendar.getInstance().toInstant(),ZoneId.systemDefault());
			1. *Instant* representa a qtd de milisegundos desde 1/1/70
			1. ldt p/ Date `Date.from(LocalDateTime.now().toInstant(ZoneOffset.UTC))`;
		1. *Duration* `Instant t = Instant.now().plus(Duration.ofSeconds(10)); // now after 10 seconds`
			1. só tem opção de *getSeconds*. Não tem de dias `long secondsSinceEpoch = Duration.between(Instant.EPOCH /*01/01/1970 00:00:00*/, Instant.now()).getSeconds(); //calcula o intervalo em segundos de duas datas` 
			1. *ChronoUnit* calcula intervalo entre duas datas `ChronoUnit.YEARS.between(LocalDate.of(1983, 7, 22), LocalDate.of(2014, 12, 25)));`
		1. *Period* calculo de intervalos, quebrando o periodo de tempo, em dia, mes, ano  `Period lifeTime = Period.between(LocalDate.of(1983, 7, 22), LocalDate.of(2014, 12, 25)); lifeTime.getYears()) /*31 years*/; lifeTime.getMonths() /* 5 months*/; lifeTime.getDays() /*3 dias*/;`
		1. *DataTimeFormatter* métodos de formatação
			1. pacote *java.time.format*			
			```java
			DateTimeFormatter.ofPattern("yyyy MM dd").format(LocalDate.of(1983, 7, 22)) /*1983 07 22*/;
			LocalDate.of(1983, 7, 22).format(DateTimeFormatter.ofPattern("yyyy MM dd")));
			DateTimeFormatter.ofPattern("dd/MM/yyyy").format(LocalDate.parse("23/04/1986",formatter)); // tranforma o texto 23/04/1986 em uma data			
			```
			1. *DateTimeFormatException*		
	1. Declare and use an **ArrayList** of a given type 
		1. *java.util.ArrayList*
		```java
		ArrayList<String> names = new ArrayList<String>();
		ArrayList<Client> clients = new ArrayList<Client>();
		
		Client cliente = new Client(); cliente.setName("John");
		clients.add(cliente);
		
		names.add("Certification");names.add("0, java"); //padrão adiciona no fim. Com indice, adiciona na posição
		names.contains("java"); //true
		names.remove("java") /*true, encontra e remove	*/; names.remove(0) /*remove e retorna Certification*/; //só remove a primeira ocorrencia daquele objeto
		names.size(); //1
		Object[] objectArray = names.toArray(); //converte p/ array
		String[] names2 = names.toArray(new String[0]); //menor. Se o tamanho não é suficiente, cria um novo array do mesmo tamanho
		String[] names3 = names.toArray(new String[names.size()]); //tamanho suficiente p/ os elemntos		
		ArrayList<String> countries = new ArrayList<String>();countries.add("korea");countries.add("brazil");
		ArrayList<String> everything = new ArrayList<String>(); everything.addAll(names); everything.addAll(countries);//adicionar 2 coleções em outra
		names.get(0) /*Certification*/; clients.get(0).getName()); // John
		cliente.setName("Mayer"); clients.get(0).getName()); // Mayer
		names.set(0, "certification"); //altera elemento da posição
		names.indexOf("certification")); // retorna a primeira posição do elemento passado, se não acha, retorna -1	
		names.lastIndexOf("john")); // retorna a última posição do elemento, se não acha, retorna -1		
		
		Collection<String> strings = new ArrayList<String>();
		Iterator<String> iterator = strings.iterator();
		while (iterator.hasNext()) { //retorna booleano indicando se ainda há elementos p/ percorrer na coleção passada
			String current = iterator.next(); //pula p/ o proximo elemento, devolvendo-o
			System.out.println(current);
		}		
		```	
	1. Write a simple **Lambda** expression that consumes a **Lambda Predicate** expression
		1. trecho de código que pode ser passado como *parametro* para um método ou armazenado numa *variável*
		1. *interface funcional* apenas com 1 método
		1. *Predicate* interface q recebe um *objeto* e retorna um *boolean*
		```java
		Predicate<Person> matcher = new Predicate<Person>() { //classe anonima
			@Override
			public boolean test(Person p) {return p.getAge() >= 18;}
		};
		
		class PersonFilter{
			public List<Person> filter(List<Person> input,Predicate<Person> matcher){
				List<Person> output = new ArrayList<>();
				for (Person person : input) {
					if(matcher.test(person)) 
						output.add(person);
				}
				return output;
			}}		
		
		List<Person> adults = new PersonFilter().filter(persons, matcher);
		```
		1. ( parameters ) -> { code }
		```java
		Predicate<Person> matcher = (Person p) -> {return p.getAge() >= 18;};
		Predicate<Person> matcher = p -> p.getAge() >= 18;
		List<Person> adults = pf.filter(persons, p -> p.getAge() >= 18);
		```
		1. Se não houver parametros, é preciso incluir () `Runnable r = () -> System.out.println("a runnable object!");`
		1. seu código interno pode interagir com *variaveis de instancia* desde q não sejam declaradas como *final*
		1. dentro de métodos, só pode interagir com variaveis locais *final* ou variaveis q *não são alteradas*
		1. variaveis do lambda estão *dentro do mesmo escopo do método*. Cuidado p/ não conflitar c/ as variáveis que ja foram declaradas no método

1. Working With Java **Data Types**
	1. **Declare** and **initialize variables** (including casting of primitive data types)
		1. explicitamente tipada
		1. inicialização é obrigatória antes de serem usadas
		1. variáveis locais : inicialização *explicita*
		1. no *if*, a inicialização deverá er feita em todos os caminhos possíves
		1. variável membro inicializada *implicitamente* com valores default
			1. primitivos numéricos int = 0
			1. primitivos numéricos c/ ponto flutuante  = 0.0
			1. boolean = false
			1. char = vazio = equivale a 0
			1. String e Referencias = null
		1. criação de *array* a inicialização é *implicita* `int numbers[] = new int[10]; numbers[0]; //0`
		1. **tipos primitivos**
			1. **numéricos** tood número simples (sem casa decimal) é int
				1. **inteiro** podem ser +/-
					1. *byte*  -128 a 127
					1. *short*   
					1. *char*  
						1. *não pode ser negativo* mesmo tamanho do short mas a parte positiva é maior pois foi compensada c/ a ausência do negativo
						1. inicializar com ' aspas simples `char c = 'A';`
						1. inicializar c/ numeros q representam o char na tabela unicode `char c = 65; //A`
						1. *\u* representação literal de um char unicode q não temos no teclado `char c = '\u03A9'; // unicode :letra omega `						 
					1. *int*  
					1. *long*  *l* *L*
					1. **bases diferentes** 
						1. *octal* começa c/ 0 a esquerda e vai de 0 a 7 `int i = 0761;`  
						1. *hexadecimal* começa c/ 0x ou 0X. 0 a 9, A a F (10 a 15)
						1. *binary* 0b ou 0B e pode usar apenas 0 e 1
				1. **ponto flutuante** Pode assumir +/- infinity , +/- 0, NaN . Literal com casa decimal é double
					1. *float* F f 
					1. *double* *d* *D* para explicitar na inicialização 
					1. *notação cientifica* `double d = 3.1E2 /*310.0*/; float f = 1E4F /* 10000.0f*/;`				
			1. **não numerico**
				1. *boolean*
		1. **literais** valores das variáveis diretamente no código fonte
			1. *underlines* só podem ser colocados c/ valores numéricos (se hexa A a F) em ambos os lados do _ `int a = 123_456_789;` A mesma regra vale p/ pontos flutuantes
			1. *null, false, true* são literais e tbm palavras chaves
		1. **identificadores** palavras p/ nomear variaveis, métodos, construtores, classes, interfaces
			1. não pode ser palavra chave
			1. Podem usar letras (unicode), números, $ e _ ; *-#.* não pode
			1. O primeiro caractere não pode ser um número;
			1. não tem limite de tamanho
			1. *case sensitive*
			
		1. **palavras chave**  
			```java
			abstract assert boolean break byte case catch char class const continue default do double else enum extends false final finally float for goto if implements import 
			int interface long native new null package private protected public return short static strictfp super switch synchronized this throw throws transient true try void volatile while
			```
			1. atenção: *instanceof* throw throws 		
	1. Differentiate between **object reference** variables and **primitive** variables
		1. *primitivos* armazenam valores
			1. valores são *copiados* nas atribuições de primitivo p/ outro primitivo
		1. *referencia* p/ acessar um método ou atributo de um *objeto*
			1. *ponteiro* p/ o endereço aonde o obj se encontra na memória
			1. os *endereços são copiados* nas atribuições de *referencia p/ referencia*. As duas variaveis *apontam p/ o mesmo obj*. elas são iguais `Car a = new Car(); a.age = 5; Car b = new Car();b.age = 5;Object c = a; a==b /*false*/; a==c; //true`			
	1. Know how to *read* or *write* to **object fields**
		1. não precisamos de operador qdo estamos dentro da classe. *this* é opcional
	1. Explain an **Object's Lifecycle** (creation, "dereference by reassignment" and garbage collection)
		1. *new* criação do objeto. nova instância `Person p; /*nao criado*/ p = new Person(); //criado`
		1. *acessível* criado e atribuido a uma variável `new Person() /*apenas criado, inacessível*/; Person p = new Person(); //acessível`
		1. *inacessível* não tem caminho p/ acessar o objeto `p =null;`. Quando o *escopo* da ref termina 
			1. *elegível, passível* p/ o **Garbage Collector**
		1. *qtd* de objetos criados: Veja os *literais String* q contam como objeto		
	1. Develop code that uses **wrapper** classes such as Boolean, Double, and Integer  

1. Creating and Using **Arrays**
	1. Declare, instantiate, initialize and use a one-dimensional array
	1. Declare, instantiate, initialize and use multi-dimensional arrays

1. Working with **Methods** and **Encapsulation**
	1. Create methods with arguments and return values; including overloaded methods
	1. Apply the static keyword to methods and fields  
	1. Create and overload constructors; differentiate between default and user defined constructors
	1. Apply access modifiers
	1. Apply encapsulation principles to a class
	1. Determine the effect upon object references and primitive values when they are passed  into methods that change the values

1. Handling **Exceptions**
	1. Differentiate among checked exceptions, unchecked exceptions, and Errors
	1. Create a try-catch block and determine how exceptions alter normal program flow
	1. Describe the advantages of Exception handling 
	1. Create and invoke a method that throws an exception
	1. Recognize common exception classes (such as NullPointerException, ArithmeticException, ArrayIndexOutOfBoundsException, ClassCastException)

1. Assume the following:
	1. Missing package and import statements: If sample code do not include package or import statements, and the question does not explicitly refer to these missing statements, then assume that all sample code is in the same package, or import statements exist to support them.
	1. No file or directory path names for classes: If a question does not state the file names or directory locations of classes, then assume one of the following, whichever will enable the code to compile and run:
	1. All classes are in one file
	1. Each class is contained in a separate file, and all files are in one directory
	1. Unintended line breaks: Sample code might have unintended line breaks. If you see a line of code that looks like it has wrapped, and this creates a situation where the wrapping is significant (for example, a quoted String literal has wrapped), assume that the wrapping is an extension of the same line, and the line does not contain a hard carriage return that would cause a compilation failure.
	1. Code fragments: A code fragment is a small section of source code that is presented without its context. Assume that all necessary supporting code exists and that the supporting environment fully supports the correct compilation and execution of the code shown and its omitted environment.
	1. Descriptive comments: Take descriptive comments, such as "setter and getters go here," at face value. Assume that correct code exists, compiles, and runs successfully to create the described effect.



## dicas
* case sensitive
* contagem de posição sempre começa do 0
* fortemente tipado
* atentar as pequenas regras necessárias para que o código compile
* verifique cada ponto-e-vírgula, visibilidade, escopo de variáveis, nomes e parâmetros de métodos
* Para compilar, estamos trabalhando com arquivos e diretórios, portanto javac b/A.java; enquanto, para rodar, estamos pensando em pacotes e classes: java b.A.
* Podemos ter espaços em branco desde que não quebre uma palavra-chave, nome de método, classe etc. ao meio. Onde pode ter um espaço em branco, pode haver vários.
* Nenhuma palavra-chave em Java possui caractere maiúsculo

* unreachable code
** while (false) { x=3; } Não compila. 
** if (false) { x=3; } aqui não tem problema. Compila sem problemas
* casting Y y = (Y) x; 
* Basicamente o que você está falando para o compilador é "eu sei que em tempo de execução o que vai ter na variavel x é um tipo compatível com Y, então por favor, não dê erro de compilação.
* Parâmetros de métodos também podem ser considerados variáveis locais ao método

## Herança
* Uma interface pode extender mais de uma interface e uma classe pode implementar varias interfaces
interface Z {}
interface W {};
interface Y extends Z, W {}

## Encapsulamento (modificadores de acesso)
* class/ interface: public, default
* membros: 
** private (apenas dentro da classe)
** default: (não escreva default) dentro do arquivo ou mesmo pacotes
** protected: herança, dentro de si, dentro do pacotes
** public: aberta para qq um (precisa importar pacote)



## Tipos de Dados
* valores padrão
** númerico:  byte, short, char, int, long, float, double = 0. qdo Char, não impresso.
** boolean false
** referencia null


* valores literais
* int padrão = numero sem casas decimais
* double padrão = numero com casas decimais
* explicitar tipos:
** l, L long
** double d, D double 
** f, F float
* tamanhos

** short - 2 bytes (16 bits, de –32.768 a 32.767);

** int - 4 bytes (32 bits, de –2.147.483.648 a 2.147.483.647);
** long - 8 bytes (64 bits, de –9.223.372.036.854.775.808 a 9.223.372.036.854.775.807).
* boolean em Java só pode ser false ou true. Não existe 0 para false ou 1 para true
* tipos primitivos: atribuição é por cópia do valor
* octal: int i = 0761; //497 (0 a 7)
* hexadecimal: int i = 0xAB3400; // 11219968
* binário:

