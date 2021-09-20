## Anotações para certificação OCA Programmer 1Z0-808

[Java Basics](#Java-Basics)

[Using Operators and Decision Constructs](#Using-Operators-and-Decision-Constructs)

[Using Loop Constructs](#Using-Loop-Constructs) 

[Working with Inheritance](#Working-with-Inheritance)

[Working with Selected classes from the Java API](#Working-with-Selected-classes-from-the-Java-API)

[Working With Java Data Types](#Working-With-Java-Data-Types)

[Creating and Using Arrays](#Creating-and-Using-Arrays)

[Working with Methods and Encapsulation](#Working-with-Methods-and-Encapsulation)

[Handling Exceptions](#Handling-Exceptions)

### Java Basics

#### Define the scope of variables
- **for**: as variaveis declaradas na área de inicialização do loop só podem ser usadas no corpo do loop
- **parametros de métodos** : variaveis locais dos métodos. Não podemos declarar novas variaveis locais com o mesmo nome
- variáveis **static** podem ser acessadas por uma referencia ou diretamente pela classe
- variaveis de classe e de instancia não podem ter o mesmo nome
- **shadowing** : declarar em métodos variaveis locais ou de parametros com o mesmo nome da variavel de instancia. Usar **this** para referenciar variaveis de instancia. Se nã usar this, o compilador vai usar a variável de menor escopo.
- **final** : garante que a referencia de objeto não pode referenciar outro objeto mas pode mudar o estado do objeto que é referenciado `final Fizz z = x; z.x = 6;`
#### Define the **structure** of a Java **class**
- **default package** : qdo não declara explitamente um pacote. Não podem ser importadas para uso em outros pacotes.
- **membros de classe**: variaveis de instancia, construtores e métodos. Podemos ter membros de tipos diferentes com o mesmo nome.
- **assinatura de um método**: nome do método e os tipos de parametros. Deve ter retorno. Pode ter o mesmo nome de um construtor.
- **construtor**: a classe pode ter 0 a n construtores. Não devem ter retorno. Pode ter um *return* mas vazio
- **interface**: possui métodos somente com assintura, sem implementação. Possível declarar *constantes* **final**
- **public class** ou **public interface** : o nome do arquivo *.java* deve ter o nome dessa *class/interface*
- só pode exitir *uma* **public class** ou **public interface** por arquivo *.java*		
#### Create executable Java applications with a **main** method; **run** a Java program from the command line; produce **console output**
- *classe executavel* é aquela que possui o método **public static void main (String[] argumentos)** . Pode ter *static public* ou usar *varargs ...*
- **java** HelloWorld *Mario* : passando 1 parametro para a execução do programa
- **.class** é o *bytecode* gerado pelo *javac*
- compilando e rodando c/ *package certification*  `javac certification/Test.java; java certification.Test`
- Passando **propriedades** na execução: java *-Dkey1=abc -Dkey2=def* Foo xpto bar 
```java
java.util.Properties p = System.getProperties();
p.getProperty("key1");		
```
- **classpath**: diretorios, jar que contem as classes e pacotes da aplicação. Padrão é o *diretório corrente (.)* 
- compilar a classe A.java, definida dentro do pacote b e adicionar o jar program.jar na busca de classes durante a compilação (.) diretório atual `javac -cp program.jar:. b/A.java`
- rodar um .class de dentro de um jar `java cp /path/to/lib.jar pacote.Test`
- Criar um jar da pasta certification: *jar **-cf library.jar** certification*
- **printf** %[index$][flags][width][.precision]type
	![Polimorfismo](/imagens/printf.jpg)
		```
		Locale br = new Locale("pt","BR");
		System.out.printf(br,"%,f %n", 123456.789); // 123.456,789000
		```
		
#### Import other Java packages to make them accessible in your code
- Classes *se enxergam* se estão no **mesmo pacote**
- usar o **Full Qualified name** para acessar a *public class*  de outro pacote
- **import Full Qualified name** para evitar o uso do *Full Qualified name* em vários pontos do código
- **import com \*** para importar todas as classes do pacote. *Não importa subpacotes*. Cada subpacote deverá ser importado.
- **classes com mesmo nome**: 
	- `import java.util.Date; import java.sql.Date;` não compila: erro no import. 
	- Pode importar apenas 1 pacote e usar o *fqn* para declarar o tipo da variável.
	- `import java.util.*; import java.sql.Date`  vai ser usado do Date do pacote sql (mais específico)
	- import duplicado compila normalmente
	- import não importa membros especificos da classe. Importa a classe e todos os seus membros.
- pacote **java.lang.\*** são implicitamente importadas. *String*
- **import static** importa todos os membros *static* da classe Utils.  `import static model.Utils.*`
	- Atenção, o import static não importa a classe	
	- cuidado com o *static import*
#### Compare and contrast the features and components of Java such as: platform independence, object orientation, encapsulation, etc.
- **bytecode** .class é interpretado pela **JVM** que converte em código de máquina, executado pelo **SO** nativo
- programa **escrito** e **compilado** apenas 1x pode ser usado em diversas plataformas diferentes.
- **OO**: estruturamos o código em entidades *objetos* (compontentes especializados) que possuem dados na forma de *atributos* e comportamento na forma de *métodos*
- Cada objeto deve ter *única responsabilidade*, favorecer *reuso de código* e cada mudança no comportamento *reflete em todos os lugares* onde o objeto é usado.
- *Encapsulamento* *privar* atributos e implmentação p/ q outros objetos manipule esses atributos. Liberar apenas por meio de métodos *public*		

[[↑] Back to top](#Anotações-para-certificação-OCA-Programmer-1Z0-808)

### Using Operators and Decision Constructs 
#### Use Java **operators**; use **parentheses** to override operator **precedence**
- **atribuição** tipos compatíves ou o valor deverá ser = ou menos abrangente. tipos primitivos: copiamos o valor
	-  float é menos abrangente que double `double d = 20.0f;`
	- double não cabe em float `float f = 40.0;`
	- inteiros (long) cabe em decimal `float h = 10l;`
	- tipos menos abrangentes que int: **byte, short, char** compilador verifica se esta no range do tipo
		- estoura byte:  -128 a 127 (único itervalo cobrado) `byte b = 200;` 
		- erro: só positivo `char c2 = -1;` 
	- cuidado c/ atribuição com variaveis de tipo mais abrangente 
	```java
		short s = 10; char c = s; //não compila pois s (não 10) é short q pode ser negativo
		short s = 10; (short) char c = s; //com casting compila
		char c = 10; short s = c; //apesar de terem 2 bytes, nao compila pois o range + do char > short (pois compensa o lado negativo q nao tem no char). Com casting funciona
	```
	- o lado esquerdo de uma atribuição deve ser sempre uma variável, e não uma chamada a um método ou outro literal `"guilherme".substring(0,2) = "gua";` 
	- **referência: polimorfismo**
		- `List<String> names = new ArrayList<>();` <> operador diamante
		- copiamos o valor da referência (o objeto é o mesmo)
- **aritméticos**
	- **%** resto de divisão. O tipo resultado segue a regre das outras operações 
	- o tipo do resultado da operação com variaveis é no minimo **int** ou o **tipo mais abrangente** . Não importa se a operação é feita c/o variáveis ou literais
	- o resultado é no minimo int, não importa se o tipo da variavel que for atribuida for double `double d =  5 / 2; //2` a parte decimal vai ser perdida
		```java					
			int age = 15; long years = 5;
			int afterThoseYears2 = age + years;// não compila, o maior tipo era long, devolve long
			byte b = 1;	short s = 2;
			byte b2 = i + s; //// não compila, ele devolve no mínimo int					
		```
	- **divisão por 0**
		- *inteiro* `System.out.println(200 / 0); //ArithmeticException`
		- *decimal* `200 / 0.0; 3.0/0; 0.0/0; //compila e roda:  infinito positivo`
		- *NaN* infinito positivo - infinito negativo
- **comparação** == != > >= <= < 
	- sempre devolve um boolean
	- referencias e boolean somente com *== ou !=*
	- pode comparar *char* com *numérico* `System.out.println('a' > 1);//true`
	- valores numéricos não considera seu tipo
	- não é possível comparar primitivo c/ array
- **lógicos**
	- *& | * a segunda parte sempre é avaliada, podendo incrementar variaveis e tbm chamar métodos			
	- *curto circuito && ||*  Quando já for possível determinar a resposta final olhando apenas para a primeira parte da expressão, a segunda não é avaliada
	```java
	System.out.println(1 == 2 & imprimir("hi"));// imprime hi, depois false
	System.out.println(1 == 2 && imprimir("bye"));//imprime false
	int i = 10;	System.out.println(i == 2 & i++ == 0);// imprime false, soma mesmo assim
	int j = 10;	System.out.println(j == 2 && j++ == 0); // imprime false, não soma
	```
	- **^** ou exclusivo
- **incremento/decremento**
	- *pré* sempre a primeira coisa q é feita é o incrementar/decrementar
	```java
		int i = 10; System.out.println(++i); //imprime 11
		int j =10;	System.out.println(j++); //imprime 10
	```
	- só pode incrementar variáveis. Não usar incremento/ decremento com métodos
- **operações/atribuições de uma só vez**
	```java
	short b2 = 3; b2 += 4; // compila, dá um desconto
	b2 += 4003245; // -76: compila também, mas estoura o byte
	```
- **atribuição c/ o próprio incremento** a execução é do primeiro para o último elemento das somas, temos as reduções:
	```java
	int a = 10;
	a += ++a + a + ++a;			
	a = a + ++a + a + ++a;
	a = 10 + 11 + a + ++a;
	a = 10 + 11 + 11 + ++a;
	a = 10 + 11 + 11 + 12;
	a = 44;
	```
- **diversas atribuições** atribuir da direita p/ esquerda 
	```java
	int a = 15, b= 20, c= 30; a = b = c; // b recebe c, a recebe b, a= 30 
	int a = 15, b= 20, c= 30; a = (b = c + 5) + 5; // c + 5 = 35, b = 35, 35 + 5 = 40, a = 40
	```
- **ternário** `variavel = teste booleano ? verdadeiro : falso;`
- **referencia . ** p/ acessar atributos ou métodos de um obj
- **concatenação de Strings** `System.out.println(15 + ( 0 + " != 150")); // 15 + "0 != 150"; "150 != 150"	`		
- **precedencia**
	- pre incremento/decremento
	- mult/ div/ % 
	- soma/ sub
	- pós incremento/decremento
- **casting de primitivos**
	- atribuição somente se *compatível* um tipo cabe no outro: 			
	**byte -> short -> int -> long -> float -> double**  *autopromoção: qdo o tipo vai da direita p/ esquerda*			
	**char -> int** *autopromoção*			
	- **casting** direita p/ esquerda. Moldar o valor de um tipo em outro. Queremos e avisamos o compilador q sabemos da possibilidade de perca de precisão/ truncamneto
	```java
	double d = 0, d2 = 3.1415;
	float f = d; //não compila: double não cabe em float
	float f = (float) d;
	int i = (int) d2;//i= 3 (valor truncado)
	```
	- short e char tem o mesmo tamanho mas **char é apenas positivo**
	- `static short method(short s){}; method(7); //erro` passagem de um valor de um tipo mais abrangente num metodo para um parametro de tipo menos abrangente não compila devido a perda de informação. Utilizar cast qdo possível
#### Test equality between Strings and other objects using **==** and **equals()**
- comparar dois objetos para ver se **apontam para o mesmo lugar**		
```java
	String name1 = new String("Mario");	String name2 = new String("Mario");
	System.out.println(name1 == name2); // false: 2 objetos criados com new		
```		
- **Pool de Strings** 
	- antes de criar uma nova String, verifica-se se já existe no pool uma String com mesmo conteúdo. Se já existe, não cria nova, reutiliza. 
		`String name1 = "Mario"; String name2 = "Mario"; System.out.println(name1 == name2);	//true`
		- Só coloca no pool Strings criadas com literais
	- Quando concatenamos Strings (*literais em ambos os lados da concatenação*), o resultado tbm será colocado no pool `String ab = "a" + "b";System.out.println("ab" == ab);//true`
	- Se um dos objetos concatenados não for literal, cria um novo obj fora do pool `String a = "a"; String ab = a + "b"; System.out.println("ab" == ab); // false`
	- objetos *retornados de métodos* são novos objetos, não são buscados no pool `String str = "12 text 345678"; String txt1 = "text";String txt2 = str.substring(3, 7); System.out.println(txt1 == txt2); // false `
		- se o retorno do método for *exatamente igual ao conteúdo da String passada*, não é criado novo objeto `String str = "HELLO WORLD";String upper = str.toUpperCase(); System.out.println(str == upper); // true `
	- **contando Strings**				
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
- **equals** sobreescrever método com seu critério de igualdade
	- **==** *true* qdo comparando os mesmos objetos na memória 		
		```java
		System.out.println(s1.equals(s3)); // String mesmo conteúdo: true
		new Client("Mario").equals(new Client("Mario"));//false : apesar do mesmo conteúdo, vc deverá sobreescrever o método equals na classe Client
		
		public boolean equals(Client second) {
			return this.name.equals(second.name);
		}
		
		new Client("Mario").equals(new Client("Mario"));//true
		```	
#### Create **if** and **if/else** and **ternary** constructs
- controlar o *fluxo de execução* dos programas
- a **condição** de um if deverá ser um valor **booleano** `if (2 - 1) \\erro: inteiro`
- não existe *elseif* usar **else if**
- **unreachable code** não compila qdo o código não foe executado sob nnehuma hipótese
```java 
	public int method() {
		return 5;
		System.out.println("Will it run?"); //unreachable code
	}
```
	- ` if(false){...} ` compila apesar de não executar nada dentro do bloco
- **missing return** não compila qdo falta um fluxo para execução d euma determinada condição. Todos os caminhos possíveis devem retornar o tipo indicado pelo método ou *lançar uma exception*
```java
	public int method(int x) {
		if(x > 200) //e se x <= 200: ??? missing return mas foi lançado a RtE para não ocorrer o erro
			return 5;
		throw new RuntimeException();
	}
```		
#### Use a switch statement 	 
- expressões c/ literais no case `case 5 + 5 : ` são validas mas  `case > 10`não são validadas. Não pode duplicar valores dos cases, mesmo usando expressões.
```java
int option = 4;		
final int c1 = 5;
switch (option) { //o argumento deverá ser sempre compatível com int, wrapper menor ou igual q Integer, String, Enum
	case c1: //o valor de cada case deverá ser compatível com o argumento do switch. Usar literal, variavel final inicializada durante sua declaração com literal ou expressões com literal/ variavel final. null não é válido. Não pode duplicar cases
		System.out.println("number 1");
		break; //para não executar os casos q vem abaixo			
	default: //qdo nenhum caso bater. Pode aparecer no meio dos cases			
		System.out.println("number n");				
		break;			
	case 1+1:			
		System.out.println("number 2");				
		break;			
	case 2+c1:				
		System.out.println("number 3");				
		break;
	case 4:
	System.out.println("number 4");				
		break;
}	
```

[[↑] Back to top](#Anotações-para-certificação-OCA-Programmer-1Z0-808)

### Using Loop Constructs 
#### Create and use **while** loops
- a *condição* deve ser *booleano*
- pode ter uma operação na condição `while (i++<10)`
- Roda enquanto a condição for *true*. executado repetidamente até a condição se tornar *false*		
- qdo o loop é explicitamente *infinito* e tem código depois do loop, não compila (unreachable statement). 
- Se não tem código depois do loop, compila e executa infinitamente.
```java
while(true) { // true, true, true ...
	System.out.println("do something");
}		
return 1; // compile error


final boolean CONDICAO = true;
while(CONDICAO) { // true, true, true ...
	System.out.println("do something");
}		
return 1; // compile error


boolean rodando = true; // não final
while(rodando) { // true? false? //compila
	System.out.println("do something");
}
return 1; // ok
```

- **unreachable statement** compile error. O compilador só consegue analisar o código com *literais ou constantes*
```java		
while(false) { /* code */ } //nao compila
while(1 > 2) { /* code */ }	//nao compila		
int a = 1, b = 2;
	while(a > b) // compila
		System.out.println("OI");			
```

#### Create and use for loops including the enhanced for loop
- *inicialização*
	- `for(;;){}` compila e roda infinitamente      
	- executada apenas 1x no começo do for. 
	- Permitido declarar variaveis de um mesmo tipo `for(int i = 1, j= 2;;){//code}` ou inicializar diversas variáveis de tipos diferentes. `for(a=1, b=2.0, c = true;;){//code}`
- *condição* verificada no começo de cada iteração. default: *true*
	- cuidado c/ unreachable code `for(;false;) {System.out.println("a");break;} System.out.println("b"); //código dentro e depois do bloco do for nunca será executado pois false é literal` 
- *comandos*
- *atualização*
	- executada no fim da iteração. 
	- p/ não ocorrer o *loop infinito*. 
	- Pode fazer varias atualizações `for(int i = 0, j= 0;i< 10; i++, j++){//code}`
	- pode executar trecho de código como se fosse um bloco, mesmo as instruções sendo separadas por , `for(int i = 0, j= 0;i< 10; i+= 3, System.out.println(i++)){//code} `
- argumentos são opcionais e são preenchidos com os valores default `for(;;) {} //`
- **enhanced for**: 
	- percorre todos os elementos de uma *Collection*: `int i[] = {1,2,3,4,5}; for (int numbers : i){System.out.println(num);}`
	- *Não podemos modificar* o contéudo da collection q estamos percorrendo
	- não existe *contador*. Não é possível percorrer *+1 collection ao mesmo tempo*
#### Create and use do/while loops
- a condição é testada após rodar o trecho do código *pelo menos 1x*
- não esquecer do **;** `do{}while(condicao);` p/ não ocorrer erro de compilação
- apenas 1 linha s/ chaves é permitido dentro do do/while. Caso tenha +1 sem chaves: erro de compilação		
#### Compare loop constructs
- *while X do/while* : condição testada apenas depois de 1 interação do loop
- *for X enhanced for* : não podemos remover, inicializar e percorrer + de 1 vez uma collection
- *while X for* : for qdo sabemos exatamente a qtd de vezes q o laço deverá ser executado. While: qdo temos apenas uma condição verdadeira p/ repetir o laço		
#### Use break and continue
- aplicavel em qq estrutura de laço
- *break* : para o laço totalmente
- *continue* : interrompe apenas  a iteração atual
- compila while infinito c/ break 
- qdo tem laços encaixados, o break ou continue vale p/ o + próximo (interno)
- **labeled loops** 
	- rótulo deve referenciar apenas for, loop, switch
	- nomes dos rótulos podem ser repetidos desde q não haja conflito de escopo
	- um mesmo statement pode ter 2 labels `first: second: for (int i = 0; i < 10; i++) {`
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
- *switch* só aceita *break*
		
[[↑] Back to top](#Anotações-para-certificação-OCA-Programmer-1Z0-808)		
		
### Working with Inheritance

#### Describe inheritance and its benefits
- a classe filha *especializa* a mais genérica
- a classe mãe precisa ser visível e tbm um de seus contrutores
```java
class Parent {Parent(int x) {}}
class Child1 extends Parent{ // compile error
	// implicit Child1() { super(); }
class Child2 extends Parent { Child2() {super(15); // ok}		
```
- a classe mãe não pode ser *final* mas a filha pode
- métodos e atributos são herdados *independentemente da visibilidade*. A claase filha pode não enxergar o membro herdado
```java
class X{ private int x; public void method(){}};
class Y extends X { public void method2(int x){this.x = x; //erro: nao enexerga private de outra classe, mesmo herdando  x  }  } 
```
- não existe **herança de métodos de estáticos**  qdo herdamos uma classe c/ métodos *static*, podemos usa-los com o nome da classe filha
	- não colocar **super** dentro do contexto *static*. Não existe objeto
	```java
	class Z extends W {
		public static void method() {
			super.method(); // compile error
		}
	}
	```
	- **abstract** não compila em métodos *static* pois não há herança
	- podemos escrever um método *static* na classe filha c/ o mesmo nome da classe pai mas não é *sobreescrita*
	- **binding do polimorfismo**  o método chamado é do pai ou da filha ?
		- *método de instancia*  tempo de execução. 
		- *método static*  tempo de compilação. Ignora o tipo de objeto referenciado. Utiliza o método da ref. Não há polimorfismo com métodos static
		- *variaveis membro* polimorfismo apenas p/ métodos não static. As variaveis são sempre da ref.
- **não existe sobreescrita de atributos**  Vai ter o atributo com o mesmo nome da classe mãe, acessível com **super** ou da própria classe q sobreescreveu, acessível com **this**
- **toString** sobreescrever de *Object* p/ devolver uma String q represente o objeto ```public String toString()```
#### Develop code that makes use of polymorphism; develop code that overrides methods;  differentiate between the type of a reference and the type of an object
- **reescrita, sobrescrita** : subclasse redefine o comportamento do método herdado da superclasse
	- **polimorfismo** : 
		- *binding* : (lookup)
			- 1) em *tempo de compilação*, verificar se o pai e os filhos possuem métodos sobreescritos. Verificação da existência do método
			- 2) em *tempo de execução*, o método invacado é o do objeto, não o da referencia *virtual method invocation*	
			![Polimorfismo](/imagens/polimorfismo.jpg)
			- é o inverso dos métodos *static*					
			```java
			class Vehicle {public void turnon() {System.out.println("Vehicle running!");}}
			class Car extends Vehicle {public void turnon() {System.out.println("Car running!");} public void turnoff(){}}
			
			Vehicle v = new Car();
			v.turnon(); // Car running!
			v.turnoff(); //erro de compilação
			```	
			
	- mesmo *nome*
	- *parametros* iguais em tipo e ordem
	- *retorno* do método igual ou mais específico (covariante). Não vale p/ primitivos
	- *visibilidade* igual ou maior q a mãe
	- número de *exceptions* checked lançadas *throws* devem ser o mesmo ou menor. Elas devem ser do mesmo tipo ou mais específico.
		- *RuntimeException* e suas filhas que tbm são unchecked podem ser adicionadas s/ a restrição
	- método da mãe não pode ser *final*
	- *interface* : os métodos são implicitamente *public*
	```java
	interface A {void a();//public}
	class B implements A {void a() {}} //compile error: default é menos visivel q public
	```
- *abstract* : quem herdar dessa classe deverá sobreescrever obrigatoriamente o método do pai
- **this** deixa explicito que o método sobreescrito da própria classe filha q deverá ser chamado
- **super** deixa explicito que o método invocado deverá ser do pai sobreescrito 
	```java
	class A {public void method() {System.out.println("a");}}
	class B extends A {
		public void method() {System.out.println("b");super.method(); }//b,a
		public void method2() {
			method(); //(this), b,a
			super.method(); }}	//a		
	```
	- Car extends Vehicle : Car **é um** veículo - **polimorfismo**
	- método q recebe Vehicle pode receber qq *é um* : reaproveitamento do código
	- mudamos o tipo da referência mas nunca o *tipo do objeto*. Chamamos (referencimos) o obj de várias formas diferentes
	- referenciar pelo seu próprio tipo, classes pai, qualquer interface
	- método default ou private do pai em pacotes diferentes : não há sobreescrita. o binding só consegue acesso ao método que esta no mesmo pacote (da própria referencia)			
#### Determine when casting is necessary
- `((Y)x2).do2();` antes de invocar o método, é feito casting da variavel de referencia por causa do ()
- o compilador não conhece os valores das variáveis, apenas seu tipo `String recovered = objetos[0];` nem todo object é uma String
- *moldar* a referencia p/ q compile `String recovered = (String) objetos[0];`
- na **execução**, o casting vai ver se aquele objeto é compatível com o tipo do casting
- alguns Vehicle são Moto `Moto m = (Moto) v`
- Não é compatível : **classCastException**
- casting **opcional** qdo não precisamos
- *subindo* na hierarquia de classe: autopromoção. Descendo : casting é necessario. Sem caminho possível, compila mas não executa: *classCastException*
![casting](/imagens/casting.jpg)
- podemos implementar **multiplas interfaces**. Fazer casting p/ *interfaces* sempre vai compilar/executar `Car c = new Car();Runnable r = (Runnable) c;`
- classe Car não implementa Runnable mas existe a possibilidade de algum tipo Car implementar a interface Runnable ?? Compila mas em tempo de execução pode dar erro se não tem o RunnableCar
- se Car fosse *final*, e não implemente Runnable. Nenhuma filha de Car poderá implementar Runnable e o código não compila
- **instanceof** um obj pode ser uma instância dos seus pais não importa se são classes ou interfaces
```java
Object c = new Car();
boolean b1 = c instanceof Car; // true
boolean b2 = c instanceof Motorcycle; // false
String s = "a"; boolean b = s instanceof java.util.List; // obviamente incompatível : compile error
```

#### Use **super** and **this** to access **objects** and **constructors**
- construtor pode ser *sobrecarregado* e ter qualquer *visibilidade*
- p/ construir um obj da classe filha, obrigatoriamente precisamos chamar o construtor da classe mãe antes
- **super()** não chamamos o construtor da classe mãe explicitamente. o compilador coloca automaticamente o *super()*
- **this()** chama outro construtor mas da própria classe
	- não podemos referenciar um método de instância ao invocar um construtor this `this(x()); //não compila`
- *super() e this()* só podem aparecer como primeira instrução do contrutores e apenas uma chamada, mesmo se a classe possuir construtores sobrecarregados 
- **this e variaveis membro** variaveis membro com o mesmo nome da variável local: o acesso é da variável local. this: acessar variavel membro da pr´pria classe ou da classe pai		
	- classe mae e filha com variaveis membro de mesmo nome. Diferenciar usando *this* para a variavel da propria classe e *super* para acessar a variavel da mãe
	- se não incluir *this* ou *super* será acessado a variavel membro da filha
	- método **static** não tem *super* e *this* : o código não é executado dentro de um objeto
	- *this* pode ser usada p/ acessar variaveis membro *static* s/ problemas 
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
#### Use **abstract classes** and **interfaces**
- *interfaces* não podem ter métodos *static*
- uma classe abstrata pode não ter nenhum método abstratato
- se a classe possui pelo menos 1 método abastrato, a classe precisa ser abstrata
- método abstrato não tem corpo, somente sua definição
- classe abstrata não pode ser instanciada diretamente
- classe concreta q herda de uma abstrata, precisa reescrever e implementar seus métodos que ainda não foram implementados
- subclasse abstrata não precisa implementar todos os métodos abstratos da classe pai. Não precisa nem ter a definição dos métodos abstratos
- *interface* : declara métodos (por padrão: *public abstract*) q deverão ser implementados (todos) pelas classes concretas que queiram ser consideradas como tal
- manter a visibilidade dos modificadores 
- uma classe pode implementar diversar interfaces `abstract class MyType implements Serializable, Runnable`
- uma interface pode herdar de diversas interfaces `interface C extends Runnable, Serializable {}`
- declarar *variaveis* membro em uma interface: todas elas serão *constantes* `interface X {/* public static final */ int i = 5;}`

[[↑] Back to top](#Anotações-para-certificação-OCA-Programmer-1Z0-808)

### Working with Selected classes from the **Java API** 

#### Manipulate data using the **StringBuilder** class and its methods
- StringBuffer (thread-safe) e StringBuilder têm exatamente a mesma interface. Use sempre que possível a StringBuilder qdo não há compartilhamento entre threads (+ rápida por não tratar locks).
- StringBuilder são *mutáveis*
- concatenar *append* `StringBuffer sb = new StringBuffer();sb.append("Caelum");sb.append(" - ");sb.append("Alura - Casa do Código"); //// Caelum - Alura - Casa do Código`
- criar objeto do tipo StringBUilder `new StringBuilder(); StringBuilder sb2 = new StringBuilder("java");StringBuilder sb3 = new StringBuilder(50) /* tamamnho inicial do array (length = 0)*/;StringBuilder sb4 = new StringBuilder(sb2);`
- não compila se tentar criar atribuindo diretamente uma String `StringBuilder b = "rumble";//nao compila` 
- permite chamadas encadeadas : `new StringBuffer().append("Caelum").append(" - ").append("Ensino e Inovação") // Caelum - Ensino e Inovação`
```java
StringBuffer sb = new StringBuffer();
sb.append("Caelum - Inovação");
sb.insert(9, "Ensino e "); // inserir coisas no meio com indice Caelum - Ensino e Inovação 
sb.delete(6, 15); //indice inicial e final - Caelum e Inovação
new StringBuffer("guilherme").reverse(); //emrehliug		
```
- *substring* não altera o valor do seu StringBuilder ou StringBuffer , mas retorna a String que você deseja.
- *indexOf* e *lastIndexOf* retornam -1 qdo não encontra
- não compila quando tenta comparar String e StringBuilder usando ==
#### Create and manipulate **Strings**
- *imutáveis* : o valor da String não muda quando usada um método seu. Só muda quando é feita uma re-atribuição p/ a mesma variavel.
- criar `String implicit = "Java";String explicit = new String("Java"); char[] name = new char[]{'J', 'a', 'v', 'a'}; String fromArray = new String(name); String nameBuilder = new String(new StringBuilder("Java"));`
- não é um tipo primitivo, pode ter valor *null* `String name = null; // explicit null`
- não compila. Não existe construtor q recebe null `new String(null);`
- *NullPointerException* `String s = null; String s2 = new String(s);`		
- deverá ser sempre inicializada dentro de métodos, mesmo com null
- conversão de *null* para String na concatenação `String nulled = null; System.out.println("value: " + nulled); /* value: null */ System.out.println(nulled + " value"); // null value`
- conversão de *primitivos* p/ String `String name = "Java" + ' ' + "Certification" + ' ' + 1500; //Java Certification 1500`
- na concatenação, tbm existe a precedencia de operadores `String value = 15 + 00 + " certification"; \\ 15 certification`
- todos os métodos devolvem uma nova String
```java
	"Java".length(); //4 - cuidado c/ a propriedade length dos arrays
	"".isEmpty(); /*true*/ " ".isEmpty(); /*false*/
	substring(beginIndex, endIndex); /* inclui o caractere da posição inicial mas não o da final */ subString(beginIndex); /*a partir do indice passado até o fim */
	"Java".substring(0, 4); /*Java*/ "Java".substring(0, 3)); /*Jav*/; //limite do endIndex é 4 nesse caso pois p/ descobrir o endIndex é 4-1 = 3 entao o substring vai de 0 a 3. Se beginIndex e endIndex for igual, nao retorna nada e nao da erro.
	replace(oldChar, newChar); /*substitui as ocorrências de um char por outro*/ replace(CharSequence target,CharSequence replacement); //atenção: não existe replace sobrecarregado c/ (String, char) ou (char, String). É case sensitive
	trim() /*limpa os caracteres brancos das duas pontas do String*/
	"Certification".compareTo("certification"); /* -32 lexicográfico: dictionary order, except that all the uppercase letters preceed all the lowercase letters. Retorna negativo caso a  String na qual o método for invocado vier antes;zero se for igual; positivo se vier depois do parâmetro passado */
```
- *StringIndexOutOfBoundsException* `"guilherme".charAt(20); "guilherme".charAt(-1);`
- Variável String não pode ser atribuida com valores númericos, booleano ou char a menos que exista uma concatenação com uma String (literal ou variável). `String $s = 1 + "" +  false + "" + 'a';`
#### Create and manipulate calendar data using classes from **java.time.LocalDateTime,  java.time.LocalDate, java.time.LocalTime, java.time.format.DateTimeFormatter, java.time.Period**
- *imutáveis*
- *LocalDate* yyyy-MM-dd
- *LocalTime* hh:mm::ss.zzz			
- *LocalDateTime* yyyy-MM-dd-hh:mm::ss.zzz
- *MonthDay* MM-dd
- *YearMonth* yyyy-MM
- atenção: LocalDate, LocalTime e LocalDateTime não possuem construtor
- *now()* criando `LocalTime currentTime = LocalTime.now(); LocalDate.now(ZoneId.of("America/Sao_Paulo"));`
- *of()* `LocalTime meioDia = LocalTime.of(12,0); LocalDate Natal = LocalDate.of(2014, Month.DECEMBER, 25); MonthDay.of(12, 25); LocalDateTime ldt = LocalDateTime.of(natal, meioDia);`
- *get* `ldt.getDayOfMonth(); ldt.getDayofYear(); /*349*/; ldt.getDayOfWeek(); /*Monday*/ ldt.getMonth() /*DECEMBER*/ ; ldt.getMonthValue(); /*12*/`
	- *ChronoField* campo que será retornado `ldt.get(ChronoField.HOUR_OF_DAY) /*13*/; `
	- importar `java.time.temporal.ChronoField;`
- *is* comparações `natal.isEqual(LocalDate.of(2015, 4, 1));  natal.isSupported(ChronoField.HOUR_OF_DAY)) /*false*/; natal.isSupported(ChronoUnit.DAYS) /*Can I make operations with days?		*/` 
- *with* obter versões modificadas `LocalDate d = LocalDate.of(2015, 4, 1) /*2015-04-01*/; d = d.withDayOfMonth(15).withMonth(3) /*2015-03-15*/; `
- *plus minus* `LocalDate d = LocalDate.of(2013, 9, 7);d = d.plusDays(1).plusMonths(3).minusYears(2); /*2011-12-08*/`
- *ChronoUnit* fazendo operações utilizando unidades de tempo, sem se preocupar c/ dias e meses. calcula intervalo entre duas datas 	
	- importar `java.time.temporal.ChronoUnit;`
	- `d = d.plusWeeks(3).minus(3, ChronoUnit.WEEKS);`
	- `ChronoUnit.YEARS.between(LocalDate.of(1983, 7, 22), LocalDate.of(2014, 12, 25)));`
	-  *UnsupportedTemporalTypeException*
- *Instant* representa a qtd de milisegundos desde 1/1/70 `Instant t = Instant.now().plus(Duration.ofSeconds(10)); // now after 10 seconds`
- *to* ldt para ld ou lt: `LocalDateTime now = LocalDateTime.now(); LocalDate dateNow = now.toLocalDate(); // from datetime to date`
- *at* ld ou lt p/ ldt  `LocalDateTime ldt = LocalDate.of(2020,08,17).atTime(LocaTime.now());`
- *converter* 
	- *java.util.Date* *java.util.Calendar*
	- Date para ldt `LocalDateTime.ofInstant(new Date().toInstant(), ZoneId.systemDefault());`
	- Calendar para ldt `;LocalDateTime.ofInstant(Calendar.getInstance().toInstant(),ZoneId.systemDefault());`	
	- ldt p/ Date `Date.from(LocalDateTime.now().toInstant(ZoneOffset.UTC))`;
- *Duration* 
	- só *getSeconds*. Não tem data `long secondsSinceEpoch = Duration.between(Instant.EPOCH /*01/01/1970 00:00:00*/, Instant.now()).getSeconds(); //calcula o intervalo em segundos de duas datas` 
- *Period* calculo de intervalos, quebrando o periodo de tempo, em dia, mes, ano  `Period lifeTime = Period.between(LocalDate.of(1983, 7, 22), LocalDate.of(2014, 12, 25)); lifeTime.getYears()) /*31 years*/; lifeTime.getMonths() /* 5 months*/; lifeTime.getDays() /*3 dias*/;`
- *DataTimeFormatter* métodos de formatação
	- pacote *java.time.format*			
	```java
	DateTimeFormatter.ofPattern("yyyy MM dd").format(LocalDate.of(1983, 7, 22)) /*1983 07 22*/;
	LocalDate.of(1983, 7, 22).format(DateTimeFormatter.ofPattern("yyyy MM dd")));
	DateTimeFormatter.ofPattern("dd/MM/yyyy").format(LocalDate.parse("23/04/1986",formatter)); // tranforma o texto 23/04/1986 em uma data			
	```
	- *DateTimeFormatException*
	![conversões](/imagens/java.time.jpg)
#### Declare and use an **ArrayList** of a given type 
- *java.util.ArrayList*
- atenção: não tem length() (String) ou length (Array). ArrayList usa size()
- ArrayList sobreescreve metodo equals :  mesmos elementos na mesma ordem.
```java
ArrayList<String> names = new ArrayList<String>();
ArrayList<Client> clients = new ArrayList<Client>();

Client cliente = new Client(); cliente.setName("John");
clients.add(cliente);

names.add("Certification");names.add(0, "java"); //padrão adiciona no fim. Com indice, adiciona na posição. cuidado c/ a ordem dos parametros
names.contains("java"); //true
names.remove("java") /*true, encontra e remove	*/; names.remove(0) /*remove e retorna Certification*/; //só remove a primeira ocorrencia daquele objeto
names.size(); //1
Object[] objectArray = names.toArray(); //converte p/ array do Object, não de String
String[] names2 = names.toArray(new String[0]); //cria um array de String, menor. Se o tamanho não é suficiente, cria um novo array do mesmo tamanho
String[] names3 = names.toArray(new String[names.size()]); //cria um array de String, tamanho suficiente p/ os elemntos		
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
#### Write a simple **Lambda** expression that consumes a **Lambda Predicate** expression
- trecho de código que pode ser passado como *parametro* para um método ou armazenado numa *variável*
- *interface funcional* apenas com 1 método
- *Predicate* interface q recebe um *objeto* e retorna um *boolean*
- `import java.util.function.*;` 
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
- ( parameters ) -> { code }
```java
Predicate<Person> matcher = (Person p) -> {return p.getAge() >= 18;};
Predicate<Person> matcher = p -> p.getAge() >= 18;
List<Person> adults = pf.filter(persons, p -> p.getAge() >= 18);
```
- pode colocar o tipo do parametro quando envoltos em parenteses
- blocos {} 
	- com código precisam ter ;  
	- sem {} é opcional ;
	- pode incluir return 
- Se houver parametros () é opcional, caso contrário, é preciso incluir () `Runnable r = () -> System.out.println("a runnable object!");`
- seu código interno pode interagir com *variaveis de instancia* desde q não sejam declaradas como *final*
- dentro de métodos, só pode interagir com variaveis locais *final* ou variaveis q *não são alteradas*
- variaveis do lambda estão *dentro do mesmo escopo do método*. Cuidado p/ não conflitar c/ as variáveis que ja foram declaradas no método
![Predicate](/imagens/Predicate_Lambda.jpg)
[[↑] Back to top](#Anotações-para-certificação-OCA-Programmer-1Z0-808)

### Working With Java Data Types

#### **Declare** and **initialize variables** (including casting of primitive data types)

- explicitamente tipada
- inicialização é obrigatória antes de serem usadas (inclusive c/ primitivos)
- variáveis locais : inicialização deverá ser *explicita*
- no *if*, a inicialização deverá ser feita em todos os caminhos possíves
- variável membro inicializada *implicitamente* com valores default
	- primitivos numéricos int = 0
	- primitivos numéricos c/ ponto flutuante  = 0.0
	- boolean = false
	- char = vazio = equivale a 0
	- String e Referencias = null
- criação de *array* a inicialização é *implicita* `int numbers[] = new int[10]; numbers[0]; //0`
- **tipos primitivos**
	- **numéricos** todo número simples (sem casa decimal) é int
		- **inteiro** podem ser +/-
			- *byte*  -128 a 127
			- *short*   
			- *char*  
				- *não pode ser negativo* mesmo tamanho do short mas a parte positiva é maior pois foi compensada c/ a ausência do negativo
				- inicializar com ' aspas simples `char c = 'A';`
				- inicializar c/ numeros q representam o char na tabela unicode `char c = 65; //A`
				- *\u* representação literal de um char unicode q não temos no teclado `char c = '\u03A9'; // unicode :letra omega `						 
			- *int*  
			- *long*  *l* *L*
			- **bases diferentes** 
				- *octal* começa c/ 0 a esquerda e vai de 0 a 7 `int i = 0761;`  
				- *hexadecimal* começa c/ 0x ou 0X. 0 a 9, A a F (10 a 15)
				- *binary* 0b ou 0B e pode usar apenas 0 e 1
		- **ponto flutuante** Pode assumir +/- infinity , +/- 0, NaN . Literal com casa decimal é double
			- *float* F f 
			- *double* *d* *D* para explicitar na inicialização 
			- *notação cientifica* o literal default é double `double d = 3.1E2 /*310.0*/; float f = 1E4F /* 10000.0f*/;`				
	- **não numerico**
		- *boolean*
- **literais** valores das variáveis diretamente no código fonte
	- *underlines* só podem ser colocados c/ valores numéricos (se hexa A a F) em ambos os lados do _ `int a = 123_456_789;` A mesma regra vale p/ pontos flutuantes
	- *null, false, true* são literais e tbm palavras chaves
	- `int a = -0;` é permitido
- **identificadores** palavras p/ nomear variaveis, métodos, construtores, classes, interfaces
	- não pode ser palavra chave
	- Podem usar letras (unicode), números, $ e _ ;
	- unicode `char \u0062 = 'a'; ` \u0062 é b
	- `ch\u0061r c = 'a';` funciona
	- *-#.* não pode
	- O primeiro caractere não pode ser um número;
	- não tem limite de tamanho
	- *case sensitive*			
- **palavras chave**  
	```java
	abstract assert boolean break byte case catch char class const continue default do double else enum extends false final finally float for goto if implements import 
	int interface long native new null package private protected public return short static strictfp super switch synchronized this throw throws transient true try void volatile while
	```
	- atenção: *instanceof* throw throws 		
#### Differentiate between **object reference** variables and **primitive** variables
- *primitivos* armazenam valores
	- valores são *copiados* nas atribuições de primitivo p/ outro primitivo
- *referencia* p/ acessar um método ou atributo de um *objeto*
	- *ponteiro* p/ o endereço aonde o obj se encontra na memória
	- os *endereços são copiados* nas atribuições de *referencia p/ referencia*. As duas variaveis *apontam p/ o mesmo obj*. elas são iguais `Car a = new Car(); a.age = 5; Car b = new Car();b.age = 5;Object c = a; a==b /*false*/; a==c; //true`			
#### Know how to *read* or *write* to **object fields**
- não precisamos de operador qdo estamos dentro da classe. *this* é opcional
#### Explain an **Object's Lifecycle** (creation, "dereference by reassignment" and garbage collection)
- *new* criação do objeto. nova instância `Person p; /*nao criado*/ p = new Person(); //criado`
- *acessível* criado e atribuido a uma variável `new Person() /*apenas criado, inacessível*/; Person p = new Person(); //acessível`
- *inacessível* não tem caminho p/ acessar o objeto `p =null;`. Quando o *escopo* da ref termina 
	- *elegível, passível* p/ o **Garbage Collector**
- *qtd* de objetos criados: Veja os *literais String* q contam como objeto		
#### Develop code that uses **wrapper** classes such as Boolean, Double, and Integer  
- classes que representam primitivos
- char : Character. Apenas 1 construtor  `new Character(´d´);`
- int: Integer
- criando (wrappers numéricos) `Double d1 = new Double(22.5); Double d2 = new Double("22.5"); Integer.valueOf(1); Integer i = 1234;` 
	- *NumberFormatException*
- boolean : Boolean `new Boolean(true); new Boolean("TRue") /*true*/; new Boolean("T"); //false`
- convertendo
	![Wrapper](/imagens/wrapper.jpg)
	- Wrappper p/ primitivo *xxxValue()* `new Long("123").doubleValue(); //convertendo Long para double`
		- todos os numericos se convertem entre si
		- Boolean, Character só convertem p/ boolean e char, respectivamente
	- String p/ primitivo *XXX.parseXXX("")* `double d = Double.parseDouble("123.00");`
		- *NumberFormatException*
		- parser de números int c/ base `int i6 = Integer.parseInt("FF",16); //255 Hexa`
	- String p/ Wrapper
		- usar o próprio construtor do Wrapper
		- XXX.valueOf("") `Integer i2 = Integer.valueOf("5AF", 16);`
	- Wrapper p/ String
		- `String number = Integer.valueOf(256).toString();`
		- com base apenas Long e Integer `String l = Long.toString(20, 16); `
		- Integer e Long podem converter direto p/ base escolhida `String hexString = Long.toHexString(11); // B, Hexadecimal`
	- *Autoboxing* compilador é responsável por transformar os wrapper em primitivos *(unboxing)* e primitivos em Wrappers *(boxing)* `Integer intWrapper = Integer.valueOf(1);intWrapper++; //will unbox, increment, then box again.`
	- *comparando* 
		- `Integer i1 = 1234;Integer i2 = 1234; i1 == i2 /*false (duas ref apontando p/ obj dif)*/; i1.equals(i2) /*true*/; `
		- qdo o vlr é muito baixo, devido ao *cache*, a comparação pode ser *true* `Integer i1 = 123; Integer i2 = 123; i1 == i2 /*true*/;  i1.equals(i2)) /*true*/ ;`
			- Boolean, Byte, Short, Integer de -128 a 127, caracteres ASCII como letras e números
- *NullPointerException*  operações c/ obj null `Integer a = null; int b = 44; a + b; //throws NPE	`

[[↑] Back to top](#Anotações-para-certificação-OCA-Programmer-1Z0-808)

### Creating and Using Arrays

#### Declare, instantiate, initialize and use a **one-dimensional** array
- armazenamento sequencial de variveis em memória de um tipo
- são objetos
- *primitivos*
	- *declarar* `int[] age;` e suas variações		
	- *inicialização* 
		- **new** criação do novo obj e inicializadas implicitamente c/ vlr default. 
		- S/ o **new** Variaveis membro assumem vlr default. Variaveis locais ficam sem valor mesmo, podendo ocorrer erro de compilação
		- definir a capacidade `int[] ages = new int[10];`					
			- capacidade zero compila e roda
			- capacidade negativa compila mas joga *NegativeArraySizeException*
		- c/ valores conhecidos 
			- `int[] numbers = new int[]{1,2,5,7,5};`
			- ou vc passa o tamanho ou passa os valores. `int y[] = new int[3] {0,3,5}; //não compila`
			- pode inicializar c/ vlr nulos `Car[] cars = new Car[]{new Car(), null, new Car()};` 
			- declarar e inicializar *somente na mesma linha* `int[] numbers = {1,2,5,7,5};`
	- *acesso*
		- `numbers[0] = 10;` 
		- *ArrayIndexOutOfBoundsException* acessar posição q não existe
	- *percorrendo*
		- atributo *length* recupera capacidade
		- usar o *enhanced for*				
- *referencias*
	- *inicializa* c/ valores *null*, cuidado c/ **NullPointerException**
	- usar *polimorfismo*
	```java
		abstract class Exam {}
		class PracticalExam extends Exam {}
		class TheoreticalExam extends Exam {}
		class Test {public static void main(String[] args) {
			Exam[] exams = new Exam[2];
			exams[0] = new TheoreticalExam();
			exams[1] = new PracticalExam();}}
	```
- *casting*	
	- não funciona com primitivos `int[] values = new int[10]; long[] vals = values; // compile error`
	- c/ ref é possível c/ o polimorfismo
	- *ClassCastException* não tente fazer casting de array c/ Object `Object[] values= new Object[2] values[0] = "Certification"; String[] vals = (String[]) values;`
#### Declare, instantiate, initialize and use **multi-dimensional** arrays
- array de arrays
- *declaração*
```java
int[][] table; 
int[][] cube[]; // Um array de três dimensões. 
int[] [][]hipercube[];  // Um array de quatro dimensões.
```
![Array multi-dimensional](/imagens/array.jpg)
- *inicialização* `int[][] table = new int[10][15];`
	- inicializar apenas a 1ª dimensão `int[][][] cube = new int[10][][]; `
	- inicializar posteriormente outras dimensões 
	```java
	int[][] weird = new int[2][]; weird[0] = new int[20]; weird[1] = new int[10];
	int[][][] weird = new int[2][][]; weird[0] = new int[20][];	weird[0][0] = new int[2];
	```	
	- inicializar c/ valores `int[][] test = new int[][]{{1,2,3},{3,2,1},{1,1,1}};`
- *acesso* `table[0][1];`
	
[[↑] Back to top](#Anotações-para-certificação-OCA-Programmer-1Z0-808)

### Working with Methods and Encapsulation

#### Create methods with **arguments** and **return** values; including **overloaded** methods
- *assinatura*
	- *modificador de visibilidade*, inclusive o implicito *default / package private*
		- não usar `default` qdo modificar métodos default - apenas usar nenhum modificador já é suficiente.
	- tipo de *retorno*
		- opcional *return* qdo o tipo é *void*				
			- pode ser usado como um *retorno antecipado* `void nothing(int i) {if(i >= 0) return; System.out.println("negative");}`
			- não pode ser *atribuido* a uma variável qdo o tipo é *void*
		- não pode ter nenhum código depois do *return*
		- com tipo de retorno definido, deverá retornar algo ou jogar exception em cada um dos caminhos possíveis do método `throw new RuntimeException()` Cobrir tudo
	- *nome* seguindo a regra dos *identificadores*
	- *parametros* (pode ser vazio) com tipo e nome
		- inicialização dos parametros é feito por quem invoca o método
		- não tem valores default, todos são obrigatórios
		- modificador *final* o parametro não pode ter seu valor modificado depois da chamada do método
		- *promoção*
			- *primitivos* o método espera double mas se passar qq outro tipo mais restritivo, este será promovido automaticamente p/ double
			- *polimorfismo* passar qq objeto que *seja um* objeto do tipo do parametro					
	- modificadores opcionais
		- *final* o método não pode ser sobreescrito nas classes filhas
		- *abstract* obriga as classes filhas a implmentarem o método. Não pode ter corpo
		- *static* o método deixa de ser de instancia e passa ser acessado diretamente pela classe
		- *throws* indica as exceptions q podem ser jogadas pelo método			
- métodos *não abstratos* devem possuir *corpo*		
#### Apply the **static** keyword to methods and fields  
- pertence a classe e não a cada objeto
- não precisa ter um objeto instanciado da classe. Apenas seu nome
- não usar um método/atributo de instancia dentro de um método *static* `public class Car{private int weight;public static int getWeight() {return weight; /*compile error*/}}`
- `static int b = getMethod() /*0*/; public static int getMethod() {return a /*0, a ainda nao inicializada*/; } static int a = 15;`
- membros estáticos podem ser acessados através de *instâncias da classe*
- classe não pode possuir um *método não static* que *sobreescreve* um método static (mesmo em classe filha)
- *binding* do método é feito em tempo de compilação
- a inicialização de variaveis mebro static pode chamar metodos static `static int idade = grabAge(); static int grabAge() { return 18;}`			
- não chamar outros métodos c/ this.method() dentro de um método static
#### Create and **overload constructors**; differentiate between **default** and **user defined constructors**
- argumentos recebidos tem que ser diferentes no tipo ou quantidade
- tipo de retorno e visibilidade não são suficientes p/ distinguir
- em tempo de compilação é decidido o método q vai ser chamado
- sobrecarga com polimorfismo (tipos parentes), o compilador invoca o mais especifico
- forçar a invocação do mais genérico, *casting* `new Test().method((Object) "random");`
- troca de ordem dos tipos dos parametros é sobrecarga mas pode não compilar qdo um tipo é mais especifico q o outro e na invocação é passado valores ambiguos
```java
void method(int i, double x) {} // ok
void method(double x, int i) {} // ok
new Test().method(2.0, 3); // double, int
new Test().method(2, 3.0); // int, double
new Test().method(2, 3); // compile error
void method(Object o, String s) {System.out.println("object");}
void method(String s, Object o) {System.out.println("string");}
new Xpto().method("string", "string"); // compile error
```
- construtor **default** dado pelo compilador, não recebe argumentos, tem a visibilidade da classe e tem a chamada a **super()** `class A { /* implicito*/ A() {super();} /*default*/}` 
- caso vc adicione um construtor qq, o construtor padrão *deixa de existir* e as invocações a ele passam a dar erros de compilação. 
- construtor não padrão tem a visibilidade definida pelo programador. Se não definir, a visibilidade é default.
- dentro do construtor vc pode acessar as variaveis membros
- não esqueça que a inicialização das variavies membros são com os valores default e logo em seguida, os valores atribuidos dentro do construtor
```java
int length = getLength();
String lastname = "Silveira";
int getLength() {return lastname.length();} //compila mas NullPointerException

String lastname = "Silveira"; //mudando a ordem das variaveis membro
int length = getLength();		
int getLength() {return lastname.length();} //compila e roda		
```
- cuidado c/ o loop infinito `Test() {new Test(); // StackOverflow}` 
- podem ter todos os modificadores de acesso
- é comum criar um construtor privado e um método static p/ criar seu obj
- métodos c/ o mesmo nome da classe e c/ tipo de retorno (mesmo void) são apenas métodos, não construtores	
- construtores tbm podem ser sobrecarregados `class Test {public Test() {} public Test(int i) {}}`
- *this()* um construtor pode invocar outro construtor na mesma classe `class Test {public Test() {System.out.println("simple");}public Test(int i) {this(); /*simple*/}}`
	- deve ser sempre a primeira instrução do construtor
	- não é possível ter duas chamadas a *this()*
	- pode passar instruções/métodos *static* como argumento `Test() {this(value());} private static String value() {return "value...";} Test(String s) {System.out.println(s);}`
		- não compila se passar métodos não static. O obj não terminou de ser construido ainda durante a execução do construtor
- *loops* não compilam
- metodo com parametros *varargs* 
	- Se existe uma sobrecarga do método s/ parametros, invocamos sem argumentos, o método chamado é o s/ argumentos
	- métodos sobrecarregados c/ varargs são invocados por último. Dado prioridade aos métodos assinados c/ array ou objeto.
```java
void yingyang(Integer[] ints) {
void yingyang(Integer... ints) { //nao compila
```
	
#### Apply access modifiers
- *visibilidade*
- usar um único modificador de acesso por vez
- classes e interfaces só podem ser *default* ou *public*
- membros da classe recebem modificadores
- parametros não recebem modificadores de visibilidade. Apenas o *final*
	- **public** acessado de qq componente em qq pacote
	- **protected** acessado por classes e interfaces no *mesmo pacote* e por *quem estenda, independente do pacote*
	- **default** *package private* visivel apenas dentro do mesmo pacote. 
		- Mesmo com *import*, as classes default não são visíveis. 
		- Se existem outras classes publicas no import, não ocorre erro na linha do import. Se importar especificamente uma classe default, o erro tbm é na instrução do import
	- **private** só podem ser acessadas de dentro da classe
	
#### Apply encapsulation principles to a class (information hiding)		
- *assinatura* do método é o que importa p/ o usuário da classe
- é *o q ela faz* e não como q ela faz
- *interface de uso* conjunto de assinaturas de métodos visiveis dentro de uma classe
- encapasular é esconder seus atributos c/ private
- especificação *javabeans* método público p/ acessar a leitura do atributo *getter*, escrita *setter* (c/ validação)		
#### Determine the effect upon **object references** and **primitive** values when they are **passed  into methods** that change the values
- *passagem de parametros* por copia de valores. Mudanças nos valores das variaveis definidas na lista de parametros de um método não afetam variaveis de outros métodos
	- *primitivos* variaveis c/ mesmo nome em métodos diferentes. Alterações em uma das variaveis não altera o valor da outra
	- *de referência* 	variaveis não primitivas guardam referencias que apontam p/ o mesmo objeto. Modificações no obj podem ser feitas por n referencias. 
- *pilha de execução* lugar onde são empilhados os métodos invocados na mesma ordem q foram chamados
- *heap de objetos* lugar onde são guardados os objetos criados durante sua execução

### Handling Exceptions

#### Differentiate among **checked** exceptions, **unchecked** exceptions, and **Errors**
- providencias apropriadas qdo um erro de execução ocorrer. Controla o q deve acontecer
- hierarquia de classes que modelam os erros
![Hierarquia de erros](/imagens/exceptions.jpg)
	- *Throwable*
		- **Error** erros de execução gerados por uma situação totalmente anormal que não deveria ser prevista pela aplicação
			- **OutOfMemoryError** JVM não tem mais memória RAM disponível p/ as aplicações						
		- **Exception** responsabilidade das aplicações
			- dificil tratar todas as situações possíves q fogem do padrão do comportamento q estamos desejando
			- não queremos ter q verificar toda vez se o valor é válido; não queremos entupir o código c/ ifs
			- alternativa p/ controle de fluxo
			- permitem que *isolemos o tratamento* de um comportamento por blocos, separando a lógica do negócio do tratamento de erros
			- **unchecked** podem ser evitadas se programar mais cuidadosamente
				- **RuntimeException**
				- é opcional trata-las 
			- **checked** não são faceis de evitar. O compilador verifica se o programa pode lançar um checked exception e obriga-lo a tratar c/ *try-catch* ou *throws*
				- SQLException
				- IOException : FileNotFoundException						 
#### Create a **try-catch** block and determine how exceptions alter normal program flow		
- **try {}** trecho do código que pode gerar um erro de execução
	- as linhas abaixo daquela q gerou o erro não são executadas
	- *JVM* redireciona o fluxo do try p/ o catch, faz o tratamento e continua o fluxo fora do bloco try/catch			
- **catch (Throwable t){}** pegando e tratando todos os possíveis erros de execução. 
	- **catch (Exception e){}** fazer um catch em Throwable não é uma boa prática pois os *Error* não deveriam ser tratados pela aplicação
	- cuidado c/ *unreachable code* usar em uma *checked exception* somente se o bloco do try pode realmente lançar a checked exception em questão `try {System.out.println("SQLException");} catch(SQLException e){//não compila` 
		- compila `try {new FileInputStream("a.txt");} catch(FileNotFoundException e){ // tratamento de FileNotFoundException.}`
	- pode usar p/ os erros de execução q não são checked `try {System.out.println("Ok");} catch (RuntimeException e)`
	- se a exception *não é a q foi definida*, joga a exception como se não houvesse bloco try-catch
	- *polimorfismo* exemplo pegar IOException é o mesmo que pegar todas as filhas de IOException
	- multiplos catchs: invocado somente o + adequado. 
		- A ordem importa: o JVM procura o 1º catch q pode trabalhar a exception adequada. 
		- *unreachable code* Quando tem polimorfismo em multiplos catches, priorizar na ordem os mais especificos
		- se ocorrer um erro dentro do bloco catch, o erro é jogado p/ fora do bloco e o bloco pai que deverá ou não tratar esse erro.
- **finally** seja no sucesso ou no fracasso, temos a obrigação de cumprir certas tarefas. Conexão deveria ser fechada, por exemplo
	- pode usar finally s/ o catch
	- finally jamais devera vir antes do catch: a ordem tem q ser try + catch ou try + finally ou try + catch + finally
#### Describe the **advantages** of Exception handling 
#### Create and invoke a **method that throws an exception**
- um método eventualmente  não tem condições de tratar um determinado erro de execução
- **throws** no caso de *checked exception* pode passar o erro p/ o próximo método da pilha mas é preciso deixar explito/avisado
	- qdo poder ocorrer erro na inicialização de variaveis membros, avisar c/ throws na assinatura do construtor `class FileAccess {private InputStream is = new FileInputStream("input.txt");FileAccess() throws IOException{}}`
- **throw new RuntimeException()** ao indentificar uma situação errada, criar um erro de execução e lançar p/ quem o chamou
	- cuidado c/ *unreachable code* todo código abaixo de `throw new RuntimeException()` jamais será executado
	- se é *checked exception* , avisar na assinatura do seu método com o *throws*
	- apenas instanciar a exception c/ *new* não vai joga-la
	- criando próprias exceptions `class FundoInsuficienteException extends Exception{}` p/ serem lançadas
#### Recognize common exception classes (such as NullPointerException, ArithmeticException, ArrayIndexOutOfBoundsException, ClassCastException)
- **ArrayIndexOutOfBoundsException** acessar uma posição q não existe no *array*
- **IndexOutOfBoundsException** acessar uma posição q não existe no *ArrayList*
- **NullPointerException** qdo é usado o **.** com uma referencia *null*
- **ClassCastException** casting p/ uma ref p/ um tipo incompatível
- **NumberFormatException** não é possível *parsear* texto em números
- **IllegalArgumentException** o método deve informar a quem o invocou que os valores passados nos seus parametros não são validos
- **IllegalStateException** estado atual do obj não permite q ele seja executado
- **ExceptionInInitializerError** não consegue carregar na memória todas as classes referenciadas pela aplicação qdo a JVM é disparada
- **StackOverflowError** métodos invocados são empilhados na *Pilha de Execução*. A pilha tem um limite e pode estourar
- **NoClassDefFoundError** todas as classes referenciadas devem estar no *classpath*
- **OutOfMemoryError** qdo o *Garbage Collector* não consegue liberar da memória os objetos que não são mais utilizados ou loop infinito dentro do main

[[↑] Back to top](#Anotações-para-certificação-OCA-Programmer-1Z0-808)

### novidades Java
* 1.4
* 1.5 autoboxing, varargs, import static, StringBuilder, foreach
* 1.7 underline nos literais, operador diamente <>, try-with-resources
* 1.8 java.time, lambda

### import
* java.io 
* java.util Calendar, Date, ArrayList
* java.sql Date, SQLException
* (implicito) java.lang String 
* java.lang.Math.* 
	
## dicas
* Nenhuma palavra-chave em Java possui caractere maiúsculo
* array.length : length é uma propriedade do array. length() tá errado

## unreachable code
** while (false) { x=3; } Não compila. 
** switch("guilherme") case "guilherme" : ...; case "42": ...; case default ...;  compila e roda s/ problemas
** if (false) { x=3; } aqui não tem problema. Compila sem problemas



