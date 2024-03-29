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

[Dicas](#Dicas)

### Java Basics

#### Define the scope of variables
- **for**: as variaveis declaradas na área de inicialização do loop só podem ser usadas no corpo do loop
- **parametros de métodos** : variaveis locais dos métodos. Não podemos declarar novas variaveis locais com o mesmo nome
- variáveis **static** podem ser acessadas por uma referencia ou diretamente pela classe
- variaveis de classe e de instancia não podem ter o mesmo nome
- variavel local primitiva precisa ser sempre atribuida c/ um valor se esta for usada no código. Se não for usada (apenas declarada), compila e roda.
- **shadowing** : declarar em métodos variaveis locais ou de parametros com o mesmo nome da variavel de instancia. Usar **this** para referenciar variaveis de instancia. Se nã usar this, o compilador vai usar a variável de menor escopo.
- **final** : garante que a referencia de objeto não pode referenciar outro objeto mas pode mudar o estado do objeto que é referenciado `final Fizz z = x; z.x = 6;`
	- não compila quando uma variável final (constante) é atribuida com novos valores
	- quando uma subclasse faz o shadow da variavel final da classe pai/interface, essa variavel pode ter novos valores atribuidos.
		- não pode ter novos valores atribuidos qdo a subclasse recebe implicitamente do pai a constante. Recebe também como final 
	- `final char a = 'A', d = 'D';` a e d são char e final
```java
class A{
	int x;
}
void m(){
x = x+1; //o x é do escopo da variavel mebro
int x = 0; //a partir daqui, o x é do escopo da variavel local
x = x+1 
}
```
#### Define the structure of a Java class
- **default package** : qdo não declara explitamente um pacote. Não podem ser importadas para uso em outros pacotes.
	- não se podem criar pacotes que começam com java.* ou javax.* que são reservados
- **membros de classe**: variaveis de instancia, construtores e métodos. Podemos ter membros de tipos diferentes com o mesmo nome.
- **assinatura de um método**: nome do método e os tipos de parametros. Deve ter retorno ou void. Pode ter o mesmo nome de um construtor.
- **construtor**: a classe pode ter 0 a n construtores. Não devem ter retorno. Pode ter um *return* mas vazio
- **interface**: possui métodos somente com assintura, sem implementação. Possível declarar *constantes* **final**
	- a partir do Java 8, intefaces podem ter métodos default ou static e ambos c/ implementação  
- **public class** ou **public interface** : o nome do arquivo *.java* deve ter o nome dessa *class/interface*
	- só pode exitir *uma* **public class** ou **public interface** por arquivo *.java*
	- não é obrigatório ter classes public no arquivo. O comando `java nomeDaClasse` chama a classe adequada dentro desse arquivo
#### Create executable Java applications with a **main** method; **run** a Java program from the command line; produce **console output**
- *classe executavel* é aquela que possui o método **public static void main (String[] args)** 
	- Pode ter *static public* ou usar *varargs ...*
	- pode ter modificador **final**
	- se nenhum argumento é passado p/ o main, o parametro args não é null mas non-null array de Strings de tamanho zero
- **java** HelloWorld *Mario* : passando 1 parametro para a execução do programa
	- `java BirdDisplay Sparrow "Blue Jay"`	passando 2 parametros
- **.class** é o *bytecode* gerado pelo *javac*
- compilando e rodando c/ *package certification*  `javac certification/Test.java; java certification.Test`
- Passando **propriedades** na execução: java *-Dkey1=abc -Dkey2=def* Foo xpto bar 
```java
//método 1
java.util.Properties p = System.getProperties();
p.getProperty("key1");

//método 2	
System.getProperty("key1");		
```
- **classpath**: diretorios, jar que contem as classes e pacotes da aplicação. Padrão é o *diretório corrente (.)* 
- compilar a classe A.java, definida dentro do pacote b e adicionar o jar program.jar na busca de classes durante a compilação (.) diretório atual `javac -cp program.jar:. b/A.java`
- somente p/ usar c/ javac. Não é usado com java para rodar classes dependentes do jar
`javac -cp ../proj/lib/supercharge.jar top/sub/A.java`
- usar c/ -cp apenas arquivos jar. Não funciona com coringas ou com diretórios
- rodar um .class de dentro de um jar `java cp /path/to/lib.jar pacote.Test`
- Criar um jar da pasta certification: *jar **-cf library.jar** certification*
- **printf** %[index$][flags][width][.precision]type
	![Polimorfismo](/imagens/printf.jpg)
		```
		Locale br = new Locale("pt","BR");
		System.out.printf(br,"%,f %n", 123456.789); // 123.456,789000
		```
- System.out
	- `println();`  imprime uma linha em branco
	- `println("\n");` quebra a linha
	- `print();` nao compila
	- 
#### Import other Java packages to make them accessible in your code
- package deverá ser sempre a primeira declaração dentro do código
- compila e roda se importar o próprio fqn da própria classe ou de outras classes no mesmo pacote
```java
package lilypad;
public class Frog {  }
///////////////
package lilypad;
import lilypad.Frog; //classe no mesmo pacote
import lilypad.Tadpole;//a própria classe
 public class Tadpole {
   private Frog parent;
 }
```
- Classes *se enxergam* se estão no **mesmo pacote**
- usar o **Full Qualified name** para acessar a *public class*  de outro pacote	
- **import Full Qualified name** para evitar o uso do *Full Qualified name* em vários pontos do código
	- usar o package.classe com full qualified name
	```java
	package util.log4j; 
	public class Logger{
	...
	package util;
	...
	util.log4j.Logger logger = new util.log4j.Logger();	
	```
	- dentro do mesmo pacote, não precisa import ou usar o fqn
- **import com \*** para importar todas as classes do pacote. *Não importa subpacotes*. Cada subpacote deverá ser importado.
- **classes com mesmo nome**: 
	- `import java.util.Date; import java.sql.Date;` não compila: erro no import. 
	- Pode importar apenas 1 pacote e usar o *fqn* para declarar o tipo da variável.
	- `import java.util.*; import java.sql.Date`  vai ser usado do Date do pacote sql (mais específico)
	- import não importa membros especificos da classe. Importa a classe e todos os seus membros.
- pacote **java.lang.\*** são implicitamente importadas. *String*
- **import static** importa todos os membros *static* da classe Utils.  `import static model.Utils.*`
	- Atenção, o import static não importa a classe e sim seus membros. Usar * p/ todos ou especificar um membro
		```java
		import static <package>.<classname>.*; //importa todos os membros static da classe 
		import static <package>.<classname>.<fieldname>; //importa algum membro static especifico da classe
		import static java.util.Collections; \\não compila
		import static pacote.A.a //compila, importa apenas o membro static a 
		```
- não especificar parametros de um método quando apenas o método é importado;
- import comum importa inclusive todos os membros static
- nâo especificar o nome da classe quando invocar um membro static importado
```java
import static pacote.A.a ;
int _a = a;

```
 

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
	- double não cabe em float `float f = 40.0; //não compila`
	- `float f = 5.5f;` deverá ser atribuido dessa forma
	- inteiros (long) cabe em decimal `float h = 10l;`
	- negativação de variaveis
	```java
	int a = 1, b = -a, c = -b; //b = -1 e c= 1
	```
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
	- se ocorrer uma atribuição durante o calculo da expressão, as variáveis a direita dessa atribuição serão atualizados c/ esse novo valor
	```java
	int k = 1;
	k += (k = 4) * (k + 2);// k = 1 + (4) * (4 + 2);	
	```
	- int, long, float ou double podem receber int sem problemas
	- **referência**
		- `List<String> names = new ArrayList<>();` <> operador diamante
		- copiamos o valor da referência (o objeto é o mesmo)
		- referencias de objetos podem ter o mesmo nome do tipo mas primitivos não
		```java
		String String = "string isa string"; //compila e roda
		int int = 1; //não compila
		```
- **aritméticos**
	- **%** resto de divisão. O tipo resultado segue a regra das outras operações
		- pode ser usado com números decimais:  5.5 % 3 = 2.5
		- `-i % k ` o sinal do resto é correspondente ao sinal do dividendo (i), não importando o sinal do divisor. Nesse caso, o sinal do resto é negativo		   - 1.0 % 0.0 = NaN. Nan é menor que qualquer número 
	- variável int que recebe o valor de uma divisão|: o valor é **truncado** e **não arredondado** 
	- o tipo do resultado da operação com variaveis é no minimo **int** ou o **tipo mais abrangente** . Não importa se a operação é feita c/o variáveis ou literais
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
		- tipos primitivos diferentes são promovidos na comparação
		```
		int i = 5; float f = 5.5f;  if (i == f) c++ //i é promovido p/ float
		```
	- não é possível comparar primitivo c/ array
	- == tem precedencia menor que os outros operadores de comparação	
- **lógicos**
	- *& |* a segunda parte sempre é avaliada, podendo incrementar variaveis e tbm chamar métodos			
	- *curto circuito && ||*  Quando já for possível determinar a resposta final olhando apenas para a primeira parte da expressão, a segunda não é avaliada
	```java
	System.out.println(1 == 2 & imprimir("hi"));// imprime hi, depois false
	System.out.println(1 == 2 && imprimir("bye"));//imprime false
	int i = 10;	System.out.println(i == 2 & i++ == 0);// imprime false, soma mesmo assim
	int j = 10;	System.out.println(j == 2 && j++ == 0); // imprime false, não soma
	System.out.println(false & true); //false
	```
	- **^** ou exclusivo
- **incremento/decremento (unários)**
	- *pré* sempre a primeira coisa q é feita é o incrementar/decrementar
	```java
		int i = 10; System.out.println(++i); //imprime 11
		int j =10;	System.out.println(j++); //imprime 10
		
		int k = 0;
		return k++; //vai retornar 0
		return ++k; vai retornar 1		
	```
	- só pode incrementar variáveis. Não usar incremento/ decremento com métodos
	- outros unários: -(valor) !(boolean)
- **operações/atribuições de uma só vez**
	```java
	short b2 = 3; b2 += 4; // compila, dá um desconto pois internamente existe um cast: b2 = (short) (b2 + 4)
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
	- obrigatório ter verdadeiro e falso
- **referencia** `ref.atributo()` p/ acessar atributos ou métodos de um obj
- **bitwise** & | ^ ~ << >>
- **concatenação de Strings** 
	- `System.out.println(15 + ( 0 + " != 150")); // 15 + "0 != 150"; "150 != 150"	`
	- operações com boolean + String não é possível `System.out.println(false & true + "Hello World"); //não compila. Compila apenas se colocar parenteses na operação c/ booleans`
	- o sentido da concatenação é da esquerda p/ direita a menos que se coloque parenteses
		```
			"" + 2 + 7; //=27
			"" + (2 + 7); //=9 
			2 + 7 + ""; //=9
		```
	- uma concatenção de String sempre cria um novo objeto em memória
	- String + char e ou numérico : tudo se transforma em String: "a"+'b'+63 = "ab63"			  		
	- char e ou numérico + String : primeiro a soma dos números (inclusive char) e depois concatena c/ String: 'b'+63+"a" =  "161a"
- **precedencia**
	- pre incremento/decremento
	- potência e raiz quadrada
	- mult/ div/ % (na ordem que aparecem, da esquerda p/ direita)
	- soma/ sub (na ordem que aparecem, da esquerda p/ direita)
	- ^ && || (lógicos)
	- pós incremento/decremento
	- = é menor que os de comparação
- **casting de primitivos**
	- atribuição somente se *compatível* um tipo cabe no outro: 			
	**byte -> short -> int -> long -> float -> double**  *autopromoção: qdo o tipo vai da direita p/ esquerda*			
	**char -> int** *autopromoção*			
	- **casting** direita p/ esquerda. Moldar o valor de um tipo em outro. Queremos e avisamos o compilador q sabemos da possibilidade de perca de precisão/ truncamento
		- casting apenas com variáveis de um tipo maior p/ um tipo menor. Contantes ou literais podem ser atribuidos desde que o valor esteja dentro do range
	```java
	double d = 0, d2 = 3.1415;
	float f = d; //não compila: double não cabe em float
	float f = (float) d; //compila com cast
	int i = (int) d2;//compila: i= 3 (valor truncado)
	```
	- short e char tem o mesmo tamanho mas **char é apenas positivo**
		- é necessário casting para conversão de short p/ char e vice-versa
	- `static short method(short s){}; method(7); //erro` passagem de um valor de um tipo mais abrangente num metodo para um parametro de tipo menos abrangente não compila devido a perda de informação. Utilizar cast qdo possível
#### Test equality between Strings and other objects using **==** and **equals()**
- == comparar dois objetos do mesmo tipo ou subclasses para ver se **apontam para o mesmo lugar**		
```java
	String name1 = new String("Mario");	String name2 = new String("Mario");
	System.out.println(name1 == name2); // false: 2 objetos criados com new		
```
- equals de objetos cque não estão relacionados através de herança é sempre false
- equals de Wrappers de tipo diferente são sempre **false**	
- equals de Object é o mesmo que ==
- StringBuilder não tem equals, apenas String
- ArrayList : equals verifica os mesmos elementos na mesma ordem	
- arrays não tem equals
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
- booleanos podem ser atribuidos dentro de um if `boolean b1 =false, b2 =true; if(b1=b2) \\b1 agora é true`
- **unreachable code** não compila qdo o código não foe executado sob nnehuma hipótese
```java 
	public int method() {
		return 5;
		System.out.println("Will it run?"); //unreachable code
	}
```
`if(false){...}` compila apesar de não executar nada dentro do bloco
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
- se o default aperecer no meio de cases, não é condição de sair do switch. Se não tiver break, todos os cases abaixo do default serão testados se tbm não possuirem break;
- o switch deverá obrigatoriamente ter um corpo mesmo sem cases ou default
```java
switch(8); //não compila
 int x = 0;  switch(x){ } //compila  e roda
```

```java
int option = 4;		
final int c1 = 5;
switch (option) { //Pode ser constante. 
		 //o argumento deverá ser sempre compatível com int (igual ou menor que int), wrapper menor ou igual q Integer, String, Enum
	case c1: //o valor de cada case deverá ser compatível com o argumento do switch. 
	//Usar literal, variavel final (wrapper c/ final não é cte e não pode ser usado ) 
	//inicializada durante sua declaração (nao pode delcarar e inicializar em outra instrução), com literal ou expressões com literal/ variavel final (compile time constant)
	//null não é válido. 
	//Não pode duplicar cases
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
- variaveis declaradas dentro dos blocos dos loops são válidas apenas dentro do bloco e não ocorre erro de compilação pois não há redeclaração das variaveis em cada iteração
- a *condição* deve ser *booleano*
- `while() //vazio` não compila
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
- nem todos os whiles tem loop infinito
```java
while(--i < 10){
//i vai até o menor valor negativo e depois vai para o maior positivo, saindo do loop
}
```
#### Create and use for loops including the enhanced for loop
- *inicialização*
	- `for(;;){}` compila e roda infinitamente      
	- executada apenas 1x no começo do for. 
	- obrigatório inicializar variáveis declaradas
	- Permitido declarar variaveis de um mesmo tipo `for(int i = 1, j= 2;;){//code}` ou inicializar diversas variáveis de tipos diferentes. `for(a=1, b=2.0, c = true;;){//code}`
	- variaveis declaradas dentro do for possuem escopo apenas dentro do bloco do for
- *condição* verificada no começo de cada iteração. default: *true*
	- cuidado c/ unreachable code `for(;false;) {System.out.println("a");break;} System.out.println("b"); //código dentro e depois do bloco do for nunca será executado pois false é literal` 
- *comandos*
- *atualização*
	- executada no fim da iteração. 
	- p/ não ocorrer o *loop infinito*. 
	- Pode fazer varias atualizações `for(int i = 0, j= 0;i< 10; i++, j++){//code}`
	- pode executar trecho de código como se fosse um bloco, mesmo as instruções sendo separadas por , `for(int i = 0, j= 0;i< 10; i+= 3, System.out.println(i++)){//code} `
		- comandos válidos: atribuição, invocação de métodos, instanciaçã, pre/pós incremento/decremento
	- atualização c/ ++i ou i++ da no mesmo
- argumentos são opcionais e são preenchidos com os valores default `for(;;) {} //`
- **enhanced for**: 
	- percorre todos os elementos de uma *Collection* e de um array: `int i[] = {1,2,3,4,5}; for (int numbers : i){System.out.println(num);}`
	- *Não podemos modificar* o contéudo da collection q estamos percorrendo
	- não existe *contador*. Não é possível percorrer *+1 collection ao mesmo tempo*
	- não usar variaveis declaradas anteriomente do for. Declarar uma nova variável exclusiva para o for
	 - pode usar *final* na declaração da variável e mesmo assim vai compilar e rodar sem problemas
#### Create and use do/while loops
- a condição é testada após rodar o trecho do código *pelo menos 1x*
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
	- rótulo deve referenciar apenas for, loop, switch para uso de break ou continue
	- não pode usar palavra chave mas pode usar nome de classes como String, por exemplo.
	- um rótulo pode ser aplicado para um bloco {} de comandos e um break ou continue pode apontar p/ esse tipo de bloco
	```java
	l1:{
          System.out.println("A");
          l2:
          {
            for(;;) break l1;
          }
      	}	
	```
	- um rótulo pode ser criado sem nenhum bloco mas ficara isolado, sem erro de compilação
	- nomes dos rótulos podem ser repetidos desde q não haja conflito de escopo
	- um mesmo statement pode ter 2 labels `first: second: for (int i = 0; i < 10; i++) {`
	- um label pode estar numa linha vazia (como em external abaixo) antes que tbm vai funcionar
```java
external: 
for (int i = 1; i < 10; i++) {
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
- `block: { break block; }` compila e roda break de um bloco com label;
		
[[↑] Back to top](#Anotações-para-certificação-OCA-Programmer-1Z0-808)		
		
### Working with Inheritance

#### Describe inheritance and its benefits
- A classe mãe pode usar parametros do tipo das classes filhas nos seus métodos
```java
class Bottle {
    void Bottle() {}
    void Bottle(WaterBottle w) {} //parametro do tipo filha num método da classe mãe
}
class WaterBottle extends Bottle {}
```
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
	- pode  criar um método static na classe filha com o mesmo nome do método static da classe pai (shadow) mas não ocorre polimorfismo
	- não colocar **super** dentro do contexto *static*. Não existe objeto
	```java
	class Z extends W {
		public static void method() {
			super.method(); // compile error
		}
	}
	```
	- não pode sobreescrer um método *static* c/ um método *non-static* e vice-versa. Ambos devem ser static (hide) ou non-static (overrriden)
	- **abstract** não compila em métodos *static* pois não há herança
	- private abstract não compila
	- construtores e blocos static não são herdados 
- métodos *private* não são sobreescritos mas são verificados em tempo de compilação
- **binding do polimorfismo**  o método chamado é do pai ou da filha ?
	- *método de instancia*  tempo de execução. 
	- *método static*  tempo de compilação. Ignora o tipo de objeto referenciado. Utiliza o método da ref. Não há polimorfismo com métodos static
	- *variaveis membro non-static ou static* polimorfismo apenas p/ métodos não static. As variaveis são sempre da ref.
		- é chamada a variável do objeto (com o mesmo nome da variável do pai) dentro dos métodos com polimorfismo pois eles são chamados implicitamente c/ this.  
	- quando o método da referencia (que é classe pai) esta escondido (private, default), o método usado é a da ref e não do obj referenciado
	- mesmo c/ cast, o método chamado é do objeto
	- **ref.getClass()** retorna o nome da classe do objeto que a ref aponta
	- qdo uma classe filha tem mais métodos q o pai,a ref do tipo pai não pode chamar esses métodos se não ocorre erro de compilação
	```java
	class Game {  public void play() throws Exception   { }}
	class Soccer extends Game {  public void play(String ball) {}}
	...
	Game g = new Soccer();
	g.play("bola");//não compila
	```
		 
- **não existe sobreescrita de atributos**  Vai ter o atributo com o mesmo nome da classe mãe, acessível com **super** ou da própria classe q sobreescreveu, acessível com **this**
```java
class Base{    int i=10; } 
class Sub extends Base{   int i=20;    } //This i hides Base's i.  
...
 Sub s = new Sub(); int k = s.i; //assigns 20 to k.  
 
 k = ((Base)s).i;//assigns 10 to k. The cast is used to show the Base's i.  
 
 Base b = new Sub(); k = b.i;//assigns 10 to k
```
- um membro de uma classe intermediária de uma hierárquia de classes esconde o membro com o mesmo nome de uma classe pai (mesmo public)   
```java
class A{  public int i = 10;}
class B extends A{  private int i = 30; }
class C extends B{}
...
System.out.println(new C().i); //nao compila: i é private em B e o i de B esconde o i public de A

```

- uma variável membro do pai final pode ser redeclarada na filha (shadow)
- **toString** sobreescrever de *Object* p/ devolver uma String q represente o objeto ```public String toString()```
	- o toString() de Object retorna <classname>@<hashcode>
#### Develop code that makes use of polymorphism; develop code that overrides methods;  differentiate between the type of a reference and the type of an object
- **sobreescrita** : o tipo da referência (em tempo de compilação) e o tipo de parametro definem o método que vai ser chamado.
- **reescrita** : subclasse redefine o comportamento do método herdado da superclasse
	- **polimorfismo** : 
		- *binding* : (lookup)
			- 1) em *tempo de compilação*, verificar se o pai e o filho possuem métodos polimorficos. Verificação da existência do método. 
				- Podem estar escondidos mas compila e executa.
					- qdo o método do pai é private, o método chamado é o do pai
				- se o método sobreescrito possui throws de checked exception, a chamada deverá tratar esse método com try/catch ou um novo throws
					- com casting, avisa p/ o compilador especificamente o método do obj referenciado, que sobreescreve, e se não tem throws de checked exceptions, a chamada não precisa de tratamento
			- 2) em *tempo de execução*, o método invocado é o do objeto, não o da referencia *virtual method invocation*. Chama o métood da ref apenas quando este é *hidden*			 	
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
	- *retorno* do método igual para primitivos e Objetos ou mais específico (covariante) apenas p/ Objetos		
		- Não vale quando um método ja foi declarado usando void
		
```java
class Blip {
 protected int blipvert(int x) { return 0; } }
class Vert extends Blip {
protected long blipvert(int x) { return 0; } } //long é diferente de int. Não compila
```		
	
- *visibilidade* igual ou maior q a mãe
- número de *exceptions* checked lançadas *throws* devem ser o mesmo ou menor (ou nnehuma). Elas devem ser do mesmo tipo ou mais específico.
	- *RuntimeException* e suas filhas que tbm são unchecked podem ser adicionadas s/ a restrição
- as exceptions lançadas pelo throws tbm são herdadas pelos métodos das classes filhas quando há polimorfismo apenas. Se elas são checked, qdo ocorrer polimorfismo, as invocações deverão estar tratadas c/ try/catch ou lançar com throws
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
- não compila `super.super.m1()`
- Car extends Vehicle : Car **é um** veículo - **polimorfismo**
- método q recebe Vehicle pode receber qq *é um* : reaproveitamento do código
- mudamos o tipo da referência mas nunca o *tipo do objeto*. Chamamos (referencimos) o obj de várias formas diferentes
- referenciar pelo seu próprio tipo, classes pai, qualquer interface
- método default ou private do pai em pacotes diferentes : não há sobreescrita. o binding só consegue acesso ao método que esta no mesmo pacote (da própria referencia)			
#### Determine when casting is necessary
- `((Y)x2).do2();` antes de invocar o método, é feito casting da variavel de referencia por causa do ()
- o compilador não conhece os valores das variáveis, apenas seu tipo `String recovered = objetos[0];` nem todo object é uma String
- *moldar* a referencia p/ q compile `String recovered = (String) objetos[0];`
- o **compilador** verifica apenas se as referências são possíveis de fazer casting
- não é possível fazer casting direto com referências
```
Object o = new String(); //necessário ocorrer o polimorfismo
String s = (String) o;
```
- na **execução**, o casting vai ver se aquele objeto é compatível com o tipo do casting
- alguns Vehicle são Moto `Moto m = (Moto) v`
- Não é compatível : **classCastException**
- casting **opcional** qdo não precisamos
- pode realizar casting numa referencia null `Pai p = null; Filha f = (Filha) p;`
- *subindo* na hierarquia de classe: autopromoção. Descendo : casting é necessario. Sem caminho possível, compila mas não executa: *classCastException*
![casting](/imagens/casting.jpg)
- podemos implementar **multiplas interfaces**. Fazer casting p/ *interfaces* sempre vai compilar/executar `Car c = new Car();Runnable r = (Runnable) c;`
- classe Car não implementa Runnable mas existe a possibilidade de algum tipo Car implementar a interface Runnable ?? Compila mas em tempo de execução pode dar erro se não tem o RunnableCar
- se Car fosse *final*, e não implemente Runnable. Nenhuma filha de Car poderá implementar Runnable e o código não compila
- **instanceof** um obj pode ser uma instância dos seus pais não importa se são classes ou interfaces
	- não usar com primitivos
	- ref instanceof nomedaClasse
```java
Object c = new Car();
boolean b1 = c instanceof Car; // true
boolean b2 = c instanceof Motorcycle; // false
String s = "a"; boolean b = s instanceof java.util.List; // obviamente incompatível : compile error
```
- resolve *ambiguidade*
```java
interface T1{    int VALUE = 1;     }
interface T2{    int VALUE = 2;     }
class TestClass implements T1, T2{}  	
...
TestClass tc = new TestClass(); 
System.out.println(tc.VALUE); //erro de compilação
System.out.println(( ( T1) tc).VALUE); //1
```

#### Use super and this to access objects and constructors
- construtor pode ser *sobrecarregado* e ter qualquer *visibilidade*
- **this** isolado representa o objeto instanciado
```java
class TestClass{    static int si = 10;    
public TestClass(){ System.out.println(this);    } //this = TestClass@3b22cdd0 (toString() de Object)   
...
new TestClass();   	
```
- p/ construir um obj da classe filha, obrigatoriamente precisamos chamar o construtor da classe mãe antes
- **this** dentro do construtor contem o objeto com suas variaveis preenchidas c/ valores passados ou não dentro do construtor
```java
public class Network {

	 int id;
	 Network p;
	 String s;
	
	 Network(){	 }
	 
	Network(int x, Network n){
		id = x;
		p = this; //this: id = 1,  p = null
		if(n != null) p= n;
	}
	
	main()
	Network n1 = new Network(1, null);

```
- **super()** não chamamos o construtor da classe mãe explicitamente. o compilador coloca automaticamente o *super()*
- **this()** chama outro construtor mas da própria classe
	- não podemos referenciar um método de instância ao invocar um construtor this `this(x()); //não compila`
	- se o filho chama o construtor do pai e o construtor do pai chama this() (c/ ou s/ argumentos), o construtor chamado é do próprio pai e não do filho
		- o método chamado sempre será o do objeto filho, mesmo dentro do construtor do pai. Dentro do construtor do filho, pode chamar o método do pai com super.metodo()
- *super() e this()* só podem aparecer como primeira instrução do contrutores e apenas uma chamada, mesmo se a classe possuir construtores sobrecarregados
- *super() e this()* não podem ser chamados fora dos construtores 
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
- construtor pai pode lançar exceptions mas os construtores dos seus filhos deverão lançar exceptions de tipo igual, maior ou outras exceptions
	- Inverso dos métodos
```java
class A{public A() throws IOException{ }}    
class B extends A{ public B() throws Exception{ } //pois super() precisa ser tratado
```	
#### Use **abstract classes** and **interfaces**
- *interfaces* não podem ter métodos *static*
	- a partir do java 8 pode ter métodos static com bloco com implementação;
- interface pode ter método default c/ implementação
	- não pode ter métodos default static pois um método default sempre é da instância
	- uma interface  pode redeclarar o método como abstract qdo extende outra interface c/ método default
		- a classe que implementa essa interface com método abstract deverá re-implementar esse método abstract. O método default não é mais chamado nesse caso.
	- classe não compila qdo realiza implementação multipla de interfaces com métodos default com a mesma assinatura
		- a menos que essa classe sobreescreve os métodos default
	- métodos default não podem sobreescrever métodos de Object como equals
- interfaces não herda de Object
- uma classe abstrata pode não ter nenhum método abstrato
- se a classe possui pelo menos 1 método abastrato, a classe precisa ser abstrata
- método abstrato não tem corpo, somente sua definição
- classe abstrata e interfaces não poden ser instanciadas diretamente
	- compila e roda com classes anonimas
```java
	interface TestA { String toString(); }
	
	public class Main{
		public static void main(String... args) {
			System.out.println(
			    new TestA() {
	                public String toString(){
	                    return "test"; 
	                    
	                }
	            }
		    );
		}
	}
```
- classe concreta q herda de uma abstrata, precisa reescrever e implementar seus métodos que ainda não foram implementados
- subclasse abstrata não precisa implementar todos os métodos abstratos da classe pai. Não precisa nem ter a definição dos métodos abstratos
- *interface* : declara métodos (por padrão: *public abstract*) q deverão ser implementados (todos) pelas classes concretas que queiram ser consideradas como tal
- manter a visibilidade dos modificadores 
- uma classe pode implementar diversar interfaces `abstract class MyType implements Serializable, Runnable`
- uma interface pode herdar de diversas interfaces `interface C extends Runnable, Serializable {}`
	- pode redeclarar um método default herdado e torna-lo abstract
	- pode redeclarar um método default herdado com uma nova implementação
- declarar *variaveis* membro em uma interface: todas elas serão *constantes* `interface X {/* public static final */ int i = 5;}`
	- `interface X {/* public static final */ int i ;}` não compila. variavel de interface é final e é preciso inicializa-la implicitamente
	- classe que implementa interface c/ variaveis (são static) pode chama-las diretamente como membros static
	 ```java
	 public interface IInt{ int thevalue = 0; }
	 public class Sample implements IInt{    
	 	...
		Sample s = new Sample();  
		int j = s.thevalue; 
		int k = IInt.thevalue;
		int l = thevalue; 
		int m = Sample.thevalue;	 
	 ```
- é sempre preferível usar interface do que classes abstract
	
[[↑] Back to top](#Anotações-para-certificação-OCA-Programmer-1Z0-808)

### Working with Selected classes from the **Java API** 

#### Manipulate data using the **StringBuilder** class and its methods
- StringBuffer (thread-safe) e StringBuilder têm exatamente a mesma interface. Use sempre que possível a StringBuilder qdo não há compartilhamento entre threads (+ rápida por não tratar locks).
- StringBuilder são *mutáveis*
- é *final*
- concatenar *append* `StringBuffer sb = new StringBuffer();sb.append("Caelum");sb.append(" - ");sb.append("Alura - Casa do Código"); //// Caelum - Alura - Casa do Código`
	- `sb.append(false)` funciona: Caelum - Alura - Casa do Códigofalse 
- criar objeto do tipo StringBuilder 
```java
	StringBuffer sb = new StringBuffer(); //capacity = 16 (default)
	StringBuilder sb2 = new StringBuilder("java");
	StringBuilder sb3 = new StringBuilder(50) /* não converte p/ "50". É o tamanho inicial do array (length = 0)*/;
	StringBuilder sb4 = new StringBuilder(sb2);
	
	//nao compila
	StringBuilder b = "rumble";	
	utilizar qualquer outro tipo de primitivo não funciona
```
 
- permite chamadas encadeadas : `new StringBuffer().append("Caelum").append(" - ").append("Ensino e Inovação") // Caelum - Ensino e Inovação`
	- substring só pode ser chamado no final de chamadas encadeadas pq retorna uma String e não um StringBuilder
```java
sb.append("Caelum - Inovação"); //sempre insere no fim
sb.append(" no mercado de trabalho ", 0, 11); //sempre insere no fim. Vai inserir apenas "Caelum - Inovação no mercado"
sb.insert(9, "Ensino e "); // inserir coisas no meio com indice:  Caelum - Ensino e Inovação. Insere no fim quando é passado pro indice o tamanho do StringBuilder  
sb.delete(6, 15); //indice inicial e final (pode ser maior que o tamanho do SB, não da exception de SIOOBEx  - Caelum e Inovação
new StringBuffer("guilherme").reverse(); //emrehliug		
```
- *substring* não altera o valor do seu StringBuilder ou StringBuffer , mas retorna a String que você deseja.
- *indexOf* e *lastIndexOf* retornam -1 qdo não encontra
- SB x String: não compila quando tenta comparar String e StringBuilder usando == ou equals. Não existe cast entre eles
- setLength() altera o tamanho
```java
StringBuilder sb = new StringBuilder("12345678"); //capacity = 16 + 8= 24      
sb.setLength(5); //tamanho = 5 (12345)
sb.setLength(10); //tamanho 10 (12345     ) c/ mais 5 espaços em branco
```

#### Create and manipulate **Strings**
- *imutáveis* : o valor da String não muda quando usada um método seu. Só muda quando é feita uma re-atribuição p/ a mesma variavel.
- é *final* (não pode ter subclasses)
- criar 
```java
	String implicit = "Java";
	String explicit = new String("Java"); 
	char[] name = new char[]{'J', 'a', 'v', 'a'}; 
	String fromArray = new String(name); 
	String nameBuilder = new String(new StringBuilder("Java"));
```
- `"String".toCharArray()` converte o string para um array de char
- não é um tipo primitivo, pode ter valor *null* `String name = null; // explicit null`
- não recebe parametro do tipo numérico ou booleano
- não compila. Não existe construtor q recebe null `new String(null);`
- *NullPointerException* `String s = null; String s2 = new String(s);`		
- deverá ser sempre inicializada dentro de métodos, mesmo com null
- `"Certificação".startsWith("C");` retorna true/false
- conversão de *null* para String na concatenação `String nulled = null; System.out.println("value: " + nulled); /* value: null */ System.out.println(nulled + " value"); // null value`
- conversão de *primitivos* p/ String `String name = "Java" + ' ' + "Certification" + ' ' + 1500; //Java Certification 1500`
- na concatenação, tbm existe a precedencia de operadores `String value = 15 + 00 + " certification"; \\ 15 certification`
- todos os métodos devolvem uma nova String
```java	
	"".isEmpty(); /*true*/ " ".isEmpty(); /*false*/
	substring(beginIndex, endIndex); /* inclui o caractere da posição inicial mas não o da final */ subString(beginIndex); /*a partir do indice passado até o fim */
	"Java".substring(0, 4); /*Java*/ "Java".substring(0, 3)); /*Jav*/; //limite do endIndex é 4 nesse caso pois p/ descobrir o endIndex é 4-1 = 3 entao o substring vai de 0 a 3. Se beginIndex e endIndex for igual, nao retorna nada e nao da erro.
	replace(oldChar, newChar); /*substitui todas as ocorrências de um char por outro*/ 
	replace(CharSequence target,CharSequence replacement); //atenção: não existe replace sobrecarregado c/ (String, char) ou (char, String). É case sensitive
	trim() /*limpa os caracteres brancos das duas pontas do String. SB não tem trim() */
	"Certification".compareTo("certification"); /* -32 lexicográfico: minusculas são maiores que maiusculas. C < c retorna valor -. Contrário retornaria + */
```
- **charAt()**
	- retorna um char e pode receber char que é promovido p/ int como argumento.
	- *StringIndexOutOfBoundsException* `"guilherme".charAt(20); "guilherme".charAt(-1);`
- Variável String não pode ser atribuida com valores númericos, booleano ou char a menos que exista uma concatenação com uma String (literal ou variável). `String $s = 1 + "" +  false + "" + 'a';`
- resulta numa String a soma `new String("b") + new StringBuilder("a");` ou `new StringBuilder("a") + new String("b");` 					
#### Create and manipulate calendar data using classes from **java.time.LocalDateTime,  java.time.LocalDate, java.time.LocalTime, java.time.format.DateTimeFormatter, java.time.Period**
- imutáveis
	- conseguimos obter versões modificados c/ o retorno dos métodos
- LocalDate yyyy-MM-dd
- LocalTime hh:mm::ss.zzz
	- LocalTime.NOON = 12:00
- LocalDateTime yyyy-MM-dd-hh:mm::ss.zzz
- YearMonth yyyy-MM
- MonthDay MM-dd
- não possuem construtor
- Month (enumerator)
	- JANUARY, DECEMBER
- java.time.temporal.*
	- UnsupportedTemporalTypeException
	- ChronoField (get) (enumerator) 
		- DAY_OF_WEEK, DAY_OF_MONTH, DAY_OF_YEAR, MONTH_OF_YEAR, YEAR, MINUTE_OF_HOUR, HOUR_OF_DAY
	- ChronoUnit (operações c/ datas) (enumerator)
		- DAYS, WEEKS, MONTHS, YEARS, HOURS
			- between(ld1,ld2) //nao quebra o período calculado: 35 anos ou 200 meses ou 4567 dias
- ZoneId
	- of("America/Sao_Paulo")
	- SystemDefault
- ZoneOffset
	- UTC
- now()
	- now(ZoneId.of("America/Sao_Paulo"))
	- Instant.now()
- parse(String, formatador)
	- formatador:
		- DateTimeFormatter
			- ISO_LOCAL_DATE_TIME ``
			- ISO_DATE_TIME `2015-02-15T21:32:51.346`
			- ISO_WEEK_DATE `2015-W07-7`
			- ISO_ORDINAL_DATE `2015-046`
			- BASIC_ISO_DATE   `20150215`
		- DateTimeFormatter.ofPattern("yyyy MM dd")	
		- String aceitável p/ parse "2011-12-03T00:00:00"
- of
	- of(YYYY,MM,dd) //ld
	- of(HH,mm) //lt
	- of(ld,lt) //ldt
	- conversao de Date ou Calendar (ja convertidos p/ Instant (objeto intermediario usado p/ conversões))
		- ldt.ofInstant(Instant, ZoneId.SystemDefault)
	- format(DTF.ofPattern("dd/MM/yyyy"))
	- of(MM,dd) //md
- get_()
	- DayOfMonth()
	- DayOfWeek() //SATURDAY
	- Month() //DECEMBER
	- MonthValue() //12
	- get(CF)
		- não compila qdo o obj não tem a parte (horas c/ ld ou data c/ lt)
- is_
	- Equal(ld)
 	- Supported(CF) //true, false
	- Supported(CU) //Can I make operations with DAYS ?? true, false
	não funciona com MonthDay
- with_
	- Month(3)
	- Hour(12)
	- DayOfMonth(15)
	- Year(1979)
- plus_
	- encadeável
	- Days(1), Months(2), Years(3)
	- plus(3, CU)
	- minus
	- não funciona com MonthDay
- to_ 
	- ldt p/ ld ou lt
	- LocalDate()
	- LocalTime()
	- Instant(ZoneOffset.UTC) //conversao p/ Instant p/ converter p/ Date ou Calendar
- at_ 
	- ld ou lt p/ ldt
	- Time(lt)
	- Date(ld)
- Duration 
	- só segundos
	- between(I1,I2)
		- get_
			- Seconds()
		- get(CU)
	- of_
		- Seconds(10)
- Period
	- não encadeia os seus métodos. Quando ocorre, apenas o último método da cadeia é chamado `Period p = Period.ofDays(1).ofYears(2); // apenas ofYears(2) é usado`		
	- between(ld1, ld2) //quebra o periodo calculado: 31 anos e 5 meses e 3 dias
		- get_
			- Days(), Months(), Years()
	- of(years, month, days);
	- of_
		- Days(n), Years(n);
	- parse("P1Y12M30D"); //1 ANO, 12 MESES E 30 DIAS. Qdo não especificado, o valor default de Y, M ou D é 0
		- get_
			- Days(), Months(), Years()	
- java.util.*
	- Date //p conversão p/ ldt, precisa converter antes p/ Instant
		- new Date()
			- toInstant()
		- from (Instant) //conversão de LDT p/ Date
	- Calendar
		- getInstance()
			- ToInstant()
- java.time.format.*
	- DateTimeFormatter
		- ofPattern("yyyy MM dd")
			- format(ld) //formata ld a partir de um padrão
			- M : formata 1,2,3,4,5,6,7,8,9,10,11,12
			- MM: 01, 02, 03...12
			- MMM: Jan Fev Mar
			- yyyy ou uuuu podem ser usados
		- ofLocalizedTime(FormatStyle.SHORT) retorna apenas o horário 11:22 AM
		- ofLocalizedDateTime(FormatStyle.SHORT); retorna 3/7/14 11:22 AM (M/D/YY)
	- DateTimeFormatException
			
	![conversões](/imagens/java.time.jpg)
#### Declare and use an **ArrayList** of a given type 
- *java.util.ArrayList*
- atenção: não tem length() (String) ou length (Array). ArrayList usa size()
- primitivos não poder ser usados em ArrayList. Wrappers respectivos sim.
- são ordenados por um índice														      
- ArrayList sobreescreve metodo equals :  mesmos elementos na mesma ordem.
```java
List<String> _lista = new ArrayList<>(2); //pode especificar tamanho (default =10) mas o valor size() corresponde ao número de elementos ja inseridos. Pode inserir mais de 2 elementos nesse caso
ArrayList<String> names = new ArrayList<String>();
ArrayList<Client> clients = new ArrayList<Client>();

List s2 = new ArrayList(  s1.subList(1, 2) ); //criando uma lista a partir de uma sublista

Client cliente = new Client(); cliente.setName("John");
clients.add(cliente); //retorna boolean: true se a lista foi alterada

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
names.set(0, "certification"); //altera elemento da posição e retorna o elemento que foi alterado
names.indexOf("certification")); // retorna a primeira posição do elemento passado, se não acha, retorna -1	
names.lastIndexOf("john")); // retorna a última posição do elemento, Se não acha, retorna -1
names.lastIndexOf("john",6)); // retorna a última posição do elemento, a partir da posição 6. Se não acha, retorna -1


Collection<String> strings = new ArrayList<String>();
Iterator<String> iterator = strings.iterator();
while (iterator.hasNext()) { //retorna booleano indicando se ainda há elementos p/ percorrer na coleção passada
	String current = iterator.next(); //pula p/ o proximo elemento, devolvendo-o
	System.out.println(current);
}		
```	
#### Write a simple **Lambda** expression that consumes a **Lambda Predicate** expression
- trecho de código que pode ser passado como *parametro* para um método ou armazenado numa *variável*
- *interface funcional* apenas com 1 método abstract mas pode ter métodos static ou default
	- uma classe que implementa interface funcional continua sendo classe e não pode ser usada com lambda
- *Predicate* interface q recebe um *objeto* e retorna um *boolean*
	- é generificada. É necessário sempre passar o <Tipo>
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
- lambda + Predicate: precisa de 1 parametro e o código deverá ser uma expressão que retorna um boolean
	
- ( parameters ) -> { code }
```java
Predicate<Person> matcher = (Person p) -> {return p.getAge() >= 18;};
Predicate<Person> matcher = p -> p.getAge() >= 18;
List<Person> adults = pf.filter(persons, p -> p.getAge() >= 18);
```
- pode colocar o tipo do parametro quando envoltos em parenteses
- blocos {} 
	- precisa ter ; com mais de uma linha de código   
	- sem código, o ; é opcional
	- sem {} é opcional ;
	- pode incluir return 
	- apenas 1 statement, o {} é opcional
- Se houver 1 parametro () é opcional, mais de 1 parametro ou s/ parametro, é preciso incluir () `Runnable r = () -> System.out.println("a runnable object!");`
- seu código interno pode interagir com *variaveis de instancia* desde q não sejam declaradas como *final*
- dentro de métodos, só pode interagir com variaveis locais *final* ou variaveis q *não são alteradas*
- variaveis do lambda estão *dentro do mesmo escopo do método*. Cuidado p/ não conflitar c/ as variáveis que ja foram declaradas no método
![Predicate](/imagens/Predicate_Lambda.jpg)
[[↑] Back to top](#Anotações-para-certificação-OCA-Programmer-1Z0-808)

### Working With Java Data Types

#### Declare and initialize variables (including casting of primitive data types)

- explicitamente tipada
- declaração e inicialização em cadeia não é permitido
```java
int a = b = c = 100; //não compila
int  b, c; int a = b = c = 100; //compila e roda pois as variaveis foram declaradas inicialmente e depois inicializadas em cadeia em outra instrução
```
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
- variável membro **final** deverá ser implicitamente inicializada na sua declaração, dentro dos blocos de inicialização static/non-static ou no construtor. A variável final não inicializa com valor default
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
					- literais binários não podem usar d ou f no final para efinilos como ponto flutuante. L de long pode;
		- **ponto flutuante** Pode assumir +/- infinity , +/- 0, NaN . Literal com casa decimal é double
			- *float* F f 
				- armazena de 6-7 digitos de precisão. Acima disso, existe perda de precisão
			- *double* *d* *D* para explicitar na inicialização 
			- *notação cientifica* o literal default é double `double d = 3.1E2 /*310.0*/; float f = 1E4F /* 10000.0f*/;`
			- F f D d usado apenas para decimais. L l pode ser usado p/ qq base
			- `double d = 4.` 4. pode ser usado como double = 4.0
	- **não numerico**
		- *boolean*
- **literais** valores das variáveis diretamente no código fonte
	- *underlines* ou *underscores* só podem ser colocados c/ valores numéricos (se hexa A a F) em ambos os lados do _ `int a = 123_456_789;` A mesma regra vale p/ pontos flutuantes
		- `int b1 = 0b_1; \\não compila`
		- não pode colocar nos pontos das casas decimais
		- serve apenas p/ melhorar leitura. São ignorados pelo compilador. Cuidado com cases q podem estar visualmente diferentes mas são iguais pro JVM
		- `int x = 1____3;` compila: podemos colocar multiplos underscores
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
- *inacessível* não tem caminho p/ acessar o objeto `p =null;`. 
	- Quando o *escopo* da ref termina 
	- *elegível, passível* p/ o **Garbage Collector**
	- ilhas de isolamento : variáveis de instancia do tipo objeto referenciando outros objetos dentro da ilha de isolamento 
	- `System.gc();` sugere a JVM o GC, que pode ignorar. Não é garantido
	- `void finalize()` da classe Object é chamado qdo o objeto é coletado. Pode sobreescreve-lo para determinar ações quando o objeto é coletado
	- objetos referenciados pelas variaveis de instancia de um objeto que é passível p/ o GC também contam p/ o GC
- *qtd* de objetos criados: Veja os *literais String* q contam como objeto
- Objetos retornados de métodos não são elegiveis p/ GC depois do fim de execução desses métodos. O objeto retornado é referenciado agora por que chamou esse método
- Principais tarefas do GC: alocação de memória, manutençãod e objetos referenciados em memória e reaproveitamento de memória de objetos que não estão sendo mais referenciados
#### Develop code that uses **wrapper** classes such as Boolean, Double, and Integer  
- classes que representam primitivos
- são filhos de *Number*
- são *final*
- char : Character. Apenas 1 construtor  `new Character(´d´);`
	- `Character c = new Character(´d´); char c2 =  c.charValue()` converte para char apesar que o unbox tbm faz isso
- int: Integer
- criando 
	- *numéricos*
 	```java
 	Double d1 = new Double(22.5); 
 	Double d2 = new Double("22.5"); 
	Double d3 = 1; //não compila. boxed de int somente p/ Integer
	Double d4 = 1.0; 
 	Integer.valueOf(1); 
 	Integer i = 1234;
 	new Double(null);//NPexception
 	new Double(); //não compila. Não existe construtor de wrappers s/ argumentos
	
	Short _s = new Short(1); //não compila. 1 é int. O argumento deverá ser short ou um casting ´p/ short
 	```
	
	- *NumberFormatException*
		`int i = Integer.parseInt("12.3");` 12.3 não trunca p/ 12
	- *Boolean*
	
	```java 
	new Boolean(true); new Boolean("true"); new Boolean("TRue") ; //true 
	new Boolean("T"); new Boolean(null); //false
	new Boolean(); //não compila. Não existe construtor de wrappers s/ argumentos
	```
	
- convertendo
	![Wrapper](/imagens/wrapper.jpg)
	- Wrappper p/ primitivo *xxxValue()* `new Long("123").doubleValue(); //convertendo Long para double`
		- todos os numericos se convertem entre si
		- Boolean, Character só convertem p/ boolean e char, respectivamente
	- String p/ primitivo *XXX.parseXXX("")* `double d = Double.parseDouble("123.00");`
		- `int i = Integer.parseInt("12.3"); // 12.3 não trunca p/ 12` *NumberFormatException*
		- o parse retorna um primitivo que deve ser atribuido apenas a variáveis cujo range cabe
			- `char one =  Integer.parseInt("1");` não compila: conversão de int p/ char
		- parser de números int c/ base `int i6 = Integer.parseInt("FF",16); //255 Hexa`
	- String p/ Wrapper
		- usar o próprio construtor do Wrapper
		- XXX.valueOf("") `Integer i2 = Integer.valueOf("5AF", 16);`
	- Wrapper p/ String
		- `String number = Integer.valueOf(256).toString();`
		- com base apenas Long e Integer `String l = Long.toString(20, 16); `
		- Integer e Long podem converter direto p/ base escolhida `String hexString = Long.toHexString(11); // B, Hexadecimal`
	- *Autoboxing* compilador é responsável por transformar os wrapper em primitivos *(unboxing)* e primitivos em Wrappers *(boxing)* 
		```java
		Integer intWrapper = Integer.valueOf(1);intWrapper++; //will unbox, increment, then box again.
		boolean isValid = new Boolean (true)
		```
		- `Float f = 1; não compila` não é permitido promoção de primitivo e autoboxing em seguida
	
	- *comparando* 
		- Wrapper == primitivo : a ref wrapper será *unboxed* e apenas os valores serão comparados e não os objetos em memória
		- *equals* c/ wrappers de diferentes tipos sera sempre *false*, não importa o valor  
		- `Integer i1 = 1234;Integer i2 = 1234; i1 == i2 /*false (duas ref apontando p/ obj dif)*/; i1.equals(i2) /*true*/; `
		- qdo uma ref x p/ um wrappper recebe um novo valor e outra referencia y ja tinha apontado p/ essa referencia x anteriormente, significa que as duas referencias agora apontam p/ objetos diferentes 
		```java
			Integer x = 400;
			Integer y = x;
			x++; //x e y agora apontam p/ objetos diferentes e y não é incrementado
		```		
		- qdo o vlr é muito baixo, devido ao *cache*, a comparação pode ser *true* `Integer i1 = 123; Integer i2 = 123; i1 == i2 /*true*/;  i1.equals(i2)) /*true*/ ;`
			- Boolean, Byte, Short, Integer de -128 a 127, caracteres ASCII como letras e números
- *NullPointerException*  operações c/ obj null `Integer a = null; int b = 44; a + b; //throws NPE	`

[[↑] Back to top](#Anotações-para-certificação-OCA-Programmer-1Z0-808)

### Creating and Using Arrays

#### Declare, instantiate, initialize and use a one-dimensional array
- armazenamento sequencial de variveis em memória de um tipo. São ordenados por um index
- são objetos
	- int[] é uma classe com o nome de [I e o nome da classe para int[][] is [[I
	- new int[10].getClass().isArray() retorna true 
- *primitivos*
	- *declarar* `int[] age;` e suas variações
	```java
	int[] i, j; //i e j são arrays de int 
	int i[], j; //somente i é um array de int. j é int
	```
	- *inicialização* 
		- **new** criação do novo obj e seus elementos são inicializados implicitamente c/ vlr default.		
		- definir a capacidade `int[] ages = new int[10];`					
			- capacidade zero compila e roda
			- apenas int é valido para definir a dimensão do array
			- capacidade negativa compila mas joga *NegativeArraySizeException*
			- a dimensão é avaliada da esquerda p/ direita
			```java
			int i = 4;
      			int ia[][][] = new int[i][i = 3][i]; //dimensão = 4,3,3
			```
		- c/ valores conhecidos 
			- `int[] numbers = new int[]{1,2,5,7,5};`
			- ou vc passa o tamanho ou passa os valores. `int y[] = new int[3] {0,3,5}; //não compila`
			- pode inicializar c/ vlr nulos `Car[] cars = new Car[]{new Car(), null, new Car()};` 
			- declarar e inicializar *somente na mesma linha* `int[] numbers = {1,2,5,7,5};`
			- `String[] sa = { };` array de tamanho 0
				- qualquer referência p/ uma posição desse rarray vai gerar ArrayIndexOutOfBoundsException ou IndexOutOfBoundsException
			- é possível atribuir o array de primitivos ou de objetos a uma ref do tipo Object mas é necessário um cast p/ aproveitar essa atribuição 
				- `Object obj = new int[] { 1, 2, 3 }; int[] someArray = (int[])obj;`
			- não é possível atribuir a uma ref array de Object um array de primitivos
		- é possível atribuir uma dimensão para um array multidimensional e depois altera-la
		```java
		int nums[][] = new int[3][3];
		nums[0] = new int[2]; //ok
		```
		`int[][] ints = new int[3][2]; ints[2] ={1,2,3}; ` não compila
	- *acesso*
		- `numbers[0] = 10;` 
		- *ArrayIndexOutOfBoundsException* acessar posição q não existe
			- `numbers[-1];`
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
	- arrays de diferentes dimensoes não fazem casting: int[] é um tipo de objeto diferente de int[][]
	- *ClassCastException* não tente fazer casting de array c/ Object `Object[] values= new Object[2] values[0] = "Certification"; String[] vals = (String[]) values;`
- Array anonimo
```java
void m(int i[]){}
m(new int[]{1,2,3});
```
	
#### Declare, instantiate, initialize and use multi-dimensional arrays
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
	- um elemento de um array multi pode receber a ref de outro array multi se ambos possuem a mesma dimensão
	```java
	short b[][] = new short[4][4];
	short b2 [][][][] = new short[2][3][2][2]
	b2[1][1] = b; //b2[1][1] possui 2 dimensoes e b tbm
	``` 
- *acesso* `table[0][1];`
	
[[↑] Back to top](#Anotações-para-certificação-OCA-Programmer-1Z0-808)

### Working with Methods and Encapsulation

#### Create methods with arguments and return values; including overloaded methods
- *modificador de visibilidade*, inclusive o implicito *default / package private*
	- não usar `default` qdo modificar métodos default - apenas usar nenhum modificador já é suficiente.
- tipo de *retorno*
	- opcional *return* qdo o tipo é *void*				
		- pode ser usado como um *retorno antecipado* `void nothing(int i) {if(i >= 0) return; System.out.println("negative");}`
		- não pode ser *atribuido* a uma variável qdo o tipo é *void*
	- não pode ter nenhum código depois do *return*
	- com tipo de retorno definido, deverá retornar algo ou jogar exception em cada um dos caminhos possíveis do método `throw new RuntimeException()` Cobrir tudo
		- `return null` apenas quando o tipo de retorno é um objeto. Não compila como retorno com tipos primitivos
	- o retorno do método sempre deverá estar ao lado do nome
- **assinatura** identificação única dos métodos: não pode ter mais de um método c/ mesmo nome e lista de parametros
	- *nome* seguindo a regra dos *identificadores*
	- *parametros* (pode ser vazio) com tipo e nome
		- inicialização dos parametros é feito por quem invoca o método
		- métodos sobrecarregados que recebem parametro do tipo Object: qdo é passado null na chamada, sempre chama o método c/ o tipo mais especifico
		```java
		public static void method(Object o){System.out.println("Object Version");   }
   		public static void method(java.io.FileNotFoundException s){System.out.println("java.io.FileNotFoundException Version");}
   		public static void method(java.io.IOException s){System.out.println("IOException Version");}
   		...      		
      		method(null); //vai ser chamado o FileNotFoundException que é o mais específico
		```
		- não tem valores default, todos são obrigatórios
		- modificador *final* o parametro não pode ter seu valor modificado depois da chamada do método
		- nenhum método pode receber parametro void ou método com retorno void
		- *promoção*
			- *primitivos* o método espera double mas se passar qq outro tipo mais restritivo, este será promovido automaticamente p/ double
				- promoção tem mais prioridade do que boxing/unboxing
			```java
			void m(double a, double b){}
			void m(Integer a, Integer b){}
			m(1,2); // chama o método c/ double
			```
			- *polimorfismo* passar qq objeto que *seja um* objeto do tipo do parametro
			- literais int não podem ser passados para um método com parametro < int
			```java
			static boolean check(short x)
			check(10); //não compila
			check((short) 10); //compila
			short s = 10; //apesar disso, a atribuição funciona
			```
										       	
			
- modificadores opcionais
	- *final* o método não pode ser sobreescrito nas classes filhas
	- *abstract* obriga as classes filhas a implmentarem o método. Não pode ter corpo
		- não existe método *abstract* e *private*
	- *static* o método deixa de ser de instancia e passa ser acessado diretamente pela classe
	- *throws* indica as exceptions q podem ser jogadas pelo método			
- métodos *não abstratos* devem possuir *corpo*	
- métodos *non-static* são chamados dentro de um método non-static apenas c/ o nome (o this. é implicito) ou com uma referência. 
	- Nunca chamar diretamente c/ o nome da classe `StaticTest.m1();`
- argumentos recebidos tem que ser diferentes no tipo ou quantidade
- tipo de retorno e visibilidade não são considerados p/ determinar sobrecarga de métodos
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
- método com parâmetros *varargs*
	- public int howMany( boolean... b2) {} pode ser invocado como howMany(new boolean[2]); //varargs recebe array
	- compila e roda `metodo(String[]... args)` varargs de arrays
	- Se existe uma sobrecarga do método s/ parametros, invocamos sem argumentos, o método chamado é o s/ argumentos	
	- prioridade na chamada dos métodos sobrecarregados
		- 1. promoção
		- 2. box/unboxing
		- 3. varargs
	```java
	void probe(int... x) { System.out.println("In ..."); }  //1    
    	void probe(Integer x) { System.out.println("In Integer"); } //2    
    	void probe(long x) { System.out.println("In long"); } //3     
    	void probe(Long x) { System.out.println("In LONG"); } //4
	...
	Integer a = 4; new TestClass().probe(a); //chama o método 2
        int b = 4; new TestClass().probe(b); //chama o método 3 (promoção tem prioridade em relação a unbox/box e varargs
	```
	- método c/ parametros não varargs e com varargs. Varargs sempre deverá ser o último
	- um parametro array pode receber um varargs
```java
public void go(int x, String... y) {
 System.out.print(y[y.length - 1] + " ");
  }
//referenciando
new Main().go( 2, "hi", "world");
```
 
```java
void yingyang(Integer[] ints) {
void yingyang(Integer... ints) { //nao compila
```
![Sobrecarga x Sobreescrita](/overload_overriden_methods.jpg)

#### Apply the **static** keyword to methods and fields  
- pertence a classe e não a cada objeto
- não precisa ter um objeto instanciado da classe. Apenas seu nome
```java
 public class Rope {
    public static void swing() {}
Rope r = null;
r.swing();// não gera NPEx. a chamada é automaticamente mudada p/ Rope.swing()											
```
												
- não usar um método/atributo de instancia dentro de um método *static* 
```java
public class Car{
	private int weight;
	public static int getWeight() {
		return weight; /*compile error*/}}
```
- não deverão existir membros static e non-static c/mesmo nome 
- `static int b = getMethod() /*0*/; public static int getMethod() {return a /*0, a ainda nao inicializada*/; } static int a = 15;`
- membros estáticos podem ser acessados através de *instâncias da classe*
- classe fiha não pode possuir um *método não static* que *sobreescreve* um método static. Ambos (hide) nenhum deve ser static (sobreescrita).
- *binding* do método é feito em tempo de compilação
- a inicialização de variaveis mebro static pode chamar metodos static `static int idade = grabAge(); static int grabAge() { return 18;}`			
- não chamar outros métodos c/ this.method() dentro de um método static
- os métodos podem ser chamados sem o nome da classe ou com o nome da classe dentro de outro método
#### Create and overload constructors; differentiate between default and user defined constructors
- construtor não pode ser final, static ou abstract
- construtor default dado pelo compilador, não recebe argumentos, tem a *visibilidade da classe* e tem a chamada a **super()** `class A { /* implicito*/ A() {super();} /*default*/}` 
- caso vc adicione um construtor qq, o construtor default *deixa de existir* e as invocações a ele passam a dar erros de compilação. 
	- construtor default é o construtor implicito dado pela JVM sem argumentos
	- construtor sem argumentos escrito pelo programados não é default
- construtor não default tem a visibilidade definida pelo programador (pode ser private e protected também). Se não definir, a visibilidade é default (package private).
- dentro do construtor vc pode acessar as variaveis membros *static* ou *non-static*
- não esqueça que a inicialização das variaveis membros são com os valores default e logo em seguida, os valores atribuidos dentro do construtor
```java
int length = getLength();
String lastname = "Silveira";
int getLength() {return lastname.length();} //compila mas NullPointerException

String lastname = "Silveira"; //mudando a ordem das variaveis membro
int length = getLength();		
int getLength() {return lastname.length();} //compila e roda		
```
- as variaveis membro do filho ainda possuem os valores default na criação da instancia Pai durante a criação do filho
```java
class A{
   A() {  print();   }	
...
class B extends A{
   int i =   4;
   void print() { 
       System.out.println(i); }
...
A a = new B(); //new B() chama super() que é a criação do pai. Durante a criação do pai é chamado o print do objeto que imprime o this.i (do objeto) que nesse momento esta com valor default (0), não foi inicializado com 4 que é somente qdo termina de construir B	
```
- cuidado c/ o loop infinito `Test() {new Test(); // StackOverflow}` 
- é comum criar um construtor privado e um método static p/ criar seu obj
- métodos c/ o mesmo nome da classe e c/ tipo de retorno (mesmo void) são apenas métodos, não construtores	
- construtores tbm podem ser sobrecarregados `class Test {public Test() {} public Test(int i) {}}`
- *this()* um construtor pode invocar outro construtor na mesma classe `class Test {public Test() {System.out.println("simple");}public Test(int i) {this(); /*simple*/}}`
	- deve ser sempre a primeira instrução do construtor
	- não é possível ter duas chamadas a *this()*
	- pode passar instruções/métodos *static* como argumento `Test() {this(value());} private static String value() {return "value...";} Test(String s) {System.out.println(s);}`
		- não compila se passar métodos não static. O obj não terminou de ser construido ainda durante a execução do construtor
- *loops* não compilam

	
#### Apply access modifiers
- *visibilidade*
- usar um único modificador de acesso por vez
- classes e interfaces só podem ser *default* ou *public*
- membros da classe recebem modificadores
- parametros não recebem modificadores de visibilidade. Apenas o *final*
	- **public** acessado de qq componente em qq pacote
	- **protected** acessado por classes e interfaces no *mesmo pacote* ou pelas classes *filhas, independente do pacote*
	
```java
package a;
public class AccessTest {
	protected void c(){ }
}

package b;
import a.AccessTest;

public class AccessTester extends AccessTest{
    public static void main(String[] args) {
        AccessTest ref = new AccessTest();
		// ref.c(); não compila pois c() só é visível por quem estenda AccessTest
		AccessTester ref2 = new AccessTester();
		ref2.c(); //compila e roda pois ref2 é referencia p/ um objeto q estende AccessTest
    }
}
```

	- **default** *package private* visivel apenas dentro do mesmo pacote. 
		- Mesmo com *import*, as classes default não são visíveis. 
		- Se existem outras classes publicas no import, não ocorre erro na linha do import. Se importar especificamente uma classe default, o erro tbm é na instrução do import
	- **private** só podem ser acessadas de dentro da classe
	- atributos final precisam ser inicializados na declaração, no bloco de inicialização ou no construtor (quando é atributo de instancia)
	
#### Apply encapsulation principles to a class (information hiding)		
- *assinatura* do método é o que importa p/ o usuário da classe
- é *o q ela faz* e não como q ela faz
- *interface de uso* conjunto de assinaturas de métodos visiveis dentro de uma classe
- encapsular é esconder suas variáveis membro c/ private ou protected. Default quebra o encapsulamento
- o getter deverá retornar uma copia do atributo encapsulado mutável (lista, StringBuilder)
```java
public class Student{
        ArrayList<Integer> scores;
       	public ArrayList<Integer> getScores(){      
       		return new ArrayList(scores);   
}  
```
- imutabilidade: variaveis de instancia private e somente getters
- especificação *javabeans* 
	- método public ou protected p/ acessar a leitura do atributo *getter* 
	- escrita com método publico ou protected *setter* (c/ validação)		
	- *is* getter boolean
		- também pode ser usado get c/ boolean
#### Determine the effect upon **object references** and **primitive** values when they are **passed  into methods** that change the values
- *passagem de parametros* por copia de valores. Mudanças nos valores das variaveis definidas na lista de parametros de um método não afetam variaveis de outros métodos
	- *primitivos* variaveis c/ mesmo nome em métodos diferentes. Alterações em uma das variaveis não altera o valor da outra
		- String tbm é considerado primitivo nesse caso
	- *de referência* 	variaveis não primitivas guardam referencias que apontam p/ o mesmo objeto. Modificações no obj podem ser feitas por n referencias. 
		- a referência continua apontando p/ o objeto anterior quando essa referência é passada numa invocação de método e um novo objeto é atribuido a essa referência dentro desse método
		- array não é primitivo
		- o parametro de um método que aponta para um objeto que foi promovido durante a chamada desse método, ainda chama dinamicamente os métodos do objeto
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
				- **RuntimeException** : SecurityException, ClassCastException, NullPointerException, IndexOutOfBoundsException, IllegalArgumentException, IllegalStateException
				- é opcional trata-las 
			- **checked** não são faceis de evitar. O compilador verifica se o programa pode lançar um checked exception e obriga-lo a tratar c/ *try-catch* ou *throws*
				- SQLException
				- IOException : FileNotFoundException	
				- ClassNotFoundException
#### Create a **try-catch** block and determine how exceptions alter normal program flow		
- **try {}** trecho do código que pode gerar um erro de execução
	- obrigatório uso {}
	- as linhas abaixo daquela q gerou o erro não são executadas
	- *JVM* redireciona o fluxo do try p/ o catch, faz o tratamento e continua o fluxo fora do bloco try/catch			
- **catch (Throwable t){}** pegando e tratando todos os possíveis erros de execução. 
	- obrigatório uso {}
	- **catch (Exception e){}** fazer um catch em Throwable não é uma boa prática pois os *Error* não deveriam ser tratados pela aplicação
	- cuidado c/ *unreachable code* usar em uma *checked exception* somente se o bloco do try pode realmente lançar a checked exception em questão `try {System.out.println("SQLException");} catch(SQLException e){//não compila` 
		- compila `try {new FileInputStream("a.txt");} catch(FileNotFoundException e){ // tratamento de FileNotFoundException.}`
	- pode usar p/ os erros de execução q não são checked `try {System.out.println("Ok");} catch (RuntimeException e)`
	- se a exception *não é a q foi definida*, joga a exception como se não houvesse bloco try-catch
	- *polimorfismo* exemplo pegar IOException é o mesmo que pegar todas as filhas de IOException
	- multiplos catchs: invocado somente o + adequado. 
		- A ordem importa: o JVM procura o 1º catch q pode trabalhar a exception adequada. 
		- *unreachable code* Quando tem polimorfismo em multiplos catches, priorizar na ordem os mais especificos
	- multi-catch
	```java
	try {     // code
	} 
	catch (ExceptionType1 | Exceptiontype2 ex){  //ex é implicitamente final e não pode receber atribuiçoes dentro do catch 
    	// catch block
	}
	```
	- se ocorrer um erro dentro do bloco catch, o erro é jogado p/ fora do bloco, finally (se houver) é executado,  e o bloco pai que deverá ou não tratar esse erro.
	- `catch(MyException me){System.out.println(me); }` imprime apenas o nome da exception e a mensagem (se houver)
		- `catch(MyException me){me.printStackTrace(); }` ira retornar o nome da exception, uma mensagem (se houver) e também todos os métodos chamados com as linhas de código respectivas
		- o stack trace é impresso se não foi possível capturar e tratar o erro c/ o catch ou não teve nenhum tratamento de erro
	- mesmo dentro do catch ou finally, também deverá ser tratado dentro de sub-blocos try/catch métodos que lançam exception checked. Ou lançar na assinatura do método
- **finally** seja no sucesso ou no fracasso, temos a obrigação de cumprir certas tarefas. Conexão deveria ser fechada, por exemplo
	- obrigatório uso {}
	- pode usar finally s/ o catch
	- finally jamais devera vir antes do catch: a ordem tem q ser try + catch ou try + finally ou try + catch + finally
	- erros ou exceptions dentro de blocos catch ou finally podem ocorrer e se não forem tratados, a JVM vão trata-los como erros/ exceptions normalmente e parar a execução do programa.
	- mesmo c/ return antecipado, o bloco finally é executado
		- o return do finally sobrepõe return de try ou catch. Não há problema de unreachable statement
	- o bloco finally não é executado se existe `System.exit(0);` dentro de um bloco try ou bloco try com finally
	- a exception lançada dentro do bloco finally é a que vai ser lançada pelo método mesmo ocorrendo exceptions dentro de try (qdo não tratada) ou catch (serão ignoradas)
#### Describe the **advantages** of Exception handling 
#### Create and invoke a **method that throws an exception**
- um método eventualmente  não tem condições de tratar um determinado erro de execução
```java
public static void methodX() throws Exception {       throw new AssertionError();    }  //o throws pode ser lançado mesmo de forma desnecessária
```
- **throws** no caso de *checked exception* deverá passar o erro p/ o próximo método da pilha (inclusive o main) mas é preciso deixar explito/avisado
- qdo poder ocorrer erro na inicialização de variaveis membros, avisar c/ throws na assinatura do construtor `class FileAccess {private InputStream is = new FileInputStream("input.txt");FileAccess() throws IOException{}}`
- **throw new RuntimeException()** ao indentificar uma situação errada, criar um erro de execução e lançar p/ quem o chamou
- cuidado c/ *unreachable code* todo código abaixo de `throw new RuntimeException()` jamais será executado
- se é *checked exception* , avisar na assinatura do seu método com o *throws*
	- se outros métodos chamam esse método, esses métodos tbm deverão ter *throws*, incluse o main ou usar try-catch
- apenas instanciar a exception c/ *new* não vai joga-la
- `throw null` ira compilar mas gerar uma  NullPointerException
- criando próprias exceptions `class FundoInsuficienteException extends Exception{}` p/ serem lançadas
- você pode utilizar o throws de uma Exception mesmo que o bloco do código jamais lance essa exception
	```java
	public void m() throws java.io.IOException{
		System.out.println("ok");
	}
	
	```
- um método pode incluir na sua assinatura uma exception pai e lançar uma exception filha. O método que chamar esse método deverá tratar FileNotFoundException
```java
void m() throws IOException{
	    throw new FileNotFoundException();
	}
```
	
#### Recognize common exception classes (such as NullPointerException, ArithmeticException, ArrayIndexOutOfBoundsException, ClassCastException)
- **IndexOutOfBoundsException** acessar uma posição q não existe no *ArrayList*
	- **ArrayIndexOutOfBoundsException** acessar uma posição q não existe no *array*
	- **StringIndexOutOfBoundsException** acessar uma posição q não existe na *String*
- **NullPointerException** qdo é usado o **.** com uma referencia *null*
- **ClassCastException** casting p/ uma ref p/ um tipo incompatível
- **IllegalArgumentException** o método deve informar a quem o invocou que os valores passados nos seus parametros não são validos
	- **NumberFormatException** não é possível *parsear* texto em números
- **IllegalStateException** estado atual do obj não permite q ele seja executado
- **ExceptionInInitializerError** quando uma exception non-checked é lançada dentro de um bloco de inicialização. Sobrepõe todas as outras exceptions
- **StackOverflowError** métodos invocados são empilhados na *Pilha de Execução*. A pilha tem um limite e pode estourar
- **NoClassDefFoundError** todas as classes referenciadas devem estar no *classpath*
- **OutOfMemoryError** qdo o *Garbage Collector* não consegue liberar da memória os objetos que não são mais utilizados ou loop infinito dentro do main
- **NoSuchMethodError** qdo a JVM procura uma assinatura de um método específico e não acha. Exemplo: rodar um código java sem o método main especificado corretamente

[[↑] Back to top](#Anotações-para-certificação-OCA-Programmer-1Z0-808)


### Dicas
- Nenhuma palavra-chave em Java possui caractere maiúsculo

#### novidades Java
- 1.4
	- assert
- 1.5 
	- autoboxing
	- varargs
	- import static
	- StringBuilder
	- foreach
	- retorno covariante na sobreescrita
- 1.7 
	- underline nos literais
	- operador diamente <>
	- try-with-resources
	- tipo String como variável do switch 
- 1.8 
	- java.time.*
	- lambda 
	- interface c/ métodos default e static

#### import
- java.lang (implicito, pode importar explicitamente que não da erro) 
	- String 
	- Math.*
- java.io.*
	-	 
- java.util.* 
	- Calendar
	- Date
	- ArrayList
	- Collections
	- function.* (Predicate)
- java.sql.* 
	- Date
	- SQLException
- java.time.*
	- temporal.*
		- ChronoField
		- ChronoUnit
	- LocalDate, etc	
 
#### Pegadinhas
- String usa "" e char ''
- não esquecer de importar pacotes que não fazer parte da *lang*
- `throws new RuntimeException()` errado. O correto é `throw new RuntimeException()`
- var static e non-static não podem ter o mesmo nome
- cuidado com o `static import`. O correto é `import static`
- length ou size:
	- String : length()
	- Array: length
	- varargs: lenght
	- ArrayList: size()
- instanceOf errado. Correto instanceof
- RunTimeException errado. Correto RuntimeException
- import duplicado compila e roda normalmente
- não existe *elseif* usar **else if**
- `if (false) ; else ; //compila` 
- `if (true) else; //não compila : uma instrução não pode começar c/ else` 
- `if(true) 	if(false); //compila`
- métodos implementados de interface deverão ser public
- não esquecer do **;** `do{}while(condicao); //erro de compilação` 
- rotulos: apenas c/ for, while, switch
- switch só aceita break. Não existe continue
- no switch não existe `case default:` .  É `default:` apenas 
- não pode usar boolean no switch e case
- Binding Poloimorfismo: variaveis membrom métodos static e escondidos são sempre da ref
- LocalDate.of(2021,12,24) e não LocalDate.of(“2021-12-24”)
- LocalDate, LocalTime e LocalDateTime não possuem construtor
- StringBuilder: não existe firstIndexOf. Apenas IndexOf
- String : concat; StringBulder: append
	- não existe insert e reverse em String (apenas SB)
- não existe subString. É substring
- substring retorna a String que você deseja mas não altera o valor do seu StringBuilder ou StringBuffer.
	- nos encadeamentos c/ SB, o substring não altera nada e passa p/ outros métodos a mesma string que recebeu 
- try/catch/finally: variaveis declaradas dentro do bloco try estão fora do escopo dos blocos catch e finally 
- long deverá ser declarado seu literal com **l** ou declarar a variavel c/ tipo long sem o **l** 
- não existe *delete* em Collections e sim **remove**

#### Atenção
- unreachable code
	- `while (false) { x=3; }` Não compila
	- `for( int i = 0; false; i++) x = 3` não compila 
	
	- switch("guilherme") case "guilherme" : ...; case "42": ...; case default ...;  compila e roda s/ problemas
	- `if (false) { x=3; }` Compila sem problemas
	- `for( int i = 0; i< 0; i++) x = 3;` compila e roda
	- `do{ x = 3; } while(false);` compila e roda

	


#### não cai mas é útil
- operadores bitwise
	- **&**


- BigDecimal: melhorar forma p/ tratar moeda. Trata números c/ ponto flutuante s/ perder sua precisão.
- enum
	- nao podem ser locais. 
	- Podem ser de var de instancia
```java
class Nav{
	public enum Direction { NORTH, SOUTH, EAST, WEST }
}
//referenciando em outra classe
Nav.Direction d = Nav.Direction.NORTH;

```	 
	- componente independente do arquivo (como interface ou outras classes)
```java
enum Days {M, T, W, TH, F, SA, SU };

for (Days d : Days.values()) //Days.values() retorna um array de Days
		    System.out.printf("%1$s", d);
		    
		System.out.printf("%n %1$b %n %2$b", Days.M == Days.M, Days.M.equals(Days.M)); //permitido usar == e equals sem problemas

```
- inicialização das variaveis membros
	- o que importa é o carregamento das classes em tempo de compilação.
	```java
	class A{
	A{} //2
	static{} //1
	}
	class B extends A{
	B{} //4 : nao espera o super() para chamar o A()
	{} //3
	}
	----
	A a = new B()		
	```			
	- 1º : inicialização de atributos e blocos static na ordem que aparecem no código
		- inicializa apenas membros static
		- executado apenas uma vez mesmo quando não há criação de instancia
	- 2º : inicialização de atributos e blocos non-static na ordem que aparecem no código
		- métodos chamados c/ new
		- pode tbm inicializar membros static mas não tem preferência de ordem
	- 3: construtores
	- não importa se o bloco static/non-static vem antes da declaração das variaveis membros
	- blocos podem ter variaveis locais que escondem a vasriavel membro
	```
	static int x = 2;
	static {int x = 3} //somente dentro desse bloco o x=3
	```

- `System.exit()` para de executar o programa

- native: chama métodos escritos em outras linguagens. 

- Math
	- não precisa importar `java.lang.Math.*`
	- Math.max(x,y);
	- Math.sqrt(x)
	- Math.random();
		- `int randomNum = (int)(Math.random() * 101);  // 0 to 100`
	- Math.round(0.5); //1
		- igual ou acima de 5, arredonda p/ cima. Abaixo de 4, trunca	
- Scanner
	- importar java.util
	- ```java
		Scanner myObj = new Scanner(System.in);  // Create a Scanner object
    	System.out.println("Enter username");
    	String userName = myObj.nextLine();  // Read user input (String only)
		System.out.println("Username is: " + userName);		
	```
	- nextBoolean()	Reads a boolean value from the user
	- nextByte()	Reads a byte value from the user
	- nextDouble()	Reads a double value from the user
	- nextFloat()	Reads a float value from the user
	- nextInt()	Reads a int value from the user
	- nextLong()	Reads a long value from the user
	- nextShort()	Reads a short value from the user
	- InputMismatchException
	
- File Handling
	- importar java.io.*
	- tratar sempre c/ IOException 
	- File
		- File myObj = new File("filename.txt"); // Specify the filename or directory name
		- File myObj = new File("C:\\Users\\MyName\\filename.txt"); //windows
		- /Users/name/filename.txt // mac/linux
	
		- canRead()	Boolean	Tests whether the file is readable or not
		- canWrite()	Boolean	Tests whether the file is writable or not
		- createNewFile()	Boolean	Creates an empty file
		- delete()	Boolean	Deletes a file or directory
		- exists()	Boolean	Tests whether the file exists
		- getName()	String	Returns the name of the file
		- getAbsolutePath()	String	Returns the absolute pathname of the file
		- length()	Long	Returns the size of the file in bytes
		- list()	String[]	Returns an array of the files in the directory
		- mkdir()	Boolean	Creates a directory	
	
	- FileWriter 
		```java
		FileWriter myWriter = new FileWriter("filename.txt");
      	myWriter.write("Files in Java might be tricky, but it is fun enough!");
      	myWriter.close();
		```
	- Scanner
		```java
		File myObj = new File("filename.txt");
      	Scanner myReader = new Scanner(myObj);
      	while (myReader.hasNextLine()) {
        	String data = myReader.nextLine();
        	System.out.println(data);
      	}
      	myReader.close();
		```
- Threads
	- problemas de concorrência
```java
	//criando Thread extendendo
	public class Main extends Thread {
  		public void run() {
    		System.out.println("This code is running in a thread");
  		}
	}
	
	//criando implementando Runnable
	public class Main implements Runnable {
  		public void run() {
    		System.out.println("This code is running in a thread");
  		}
	}
	
	//running classe q extende
    Main thread = new Main();
    thread.start();
    
    //running classe q implementa Runnable
    Main obj = new Main();
    Thread thread = new Thread(obj);
    thread.start();
```

- Inner Classes
	- não são top level classes
	- podem ser public, private e protected
```java
class OuterClass {
  int x = 10;

  class InnerClass {
    int y = 5;
  }
  
  public static class Point {} //static inner class
				
public static void main(String[] args){

	class Local{}	//classe local			
				
	OuterClass.InnerClass myInner = new OuterClass().new InnerClass(); //inner class
	OuterClass.Point point = new OuterClass.Point();				
	Local local = new Local();
				
}				
}
```

- Inner Interfaces
				
```java
public class Shoot {
   interface Target {
      boolean needToAim(double angle);
   }
}
```


- Collections
	- Collections.sort
	- Collections.binarySearch(collection, elemento)

- Arrays
	- java.util.Arrays
	- Arrays.sort(a) 
		- a = array q deseja ordenar
		- retorna void. Não colocar dentro de foEeach
		- ordenação 123ABCabc
		- ordenação de String: Número vem antes de letra ("30", "8", "3A", "FF") => [30, 3A, 8, FF]		
	- Arrays.asList(a)
		- transforma um array numa lista;
		- não pode remover ou adicionar elementos nessa nova lista: UnsupportedOperationException
		- `Arrays.asList(5, 10, -5, -10);` também funciona 
	- Arrays.binarySearch(array, elemento q deseja achar)
		- o array precisa ser ordenado anteriormente. Se não for ordenado, compila  e roda mas o resultado da busca é indefinido
		- retorna a posição do elemento encontrado;
			- se não achar, retorna a posição que o elemento procurado deveria estar, negativa e subtrai por -1
			`[–10, –5, 5, 10]; Collections.binarySearch(numberList, 4);` deveria estar na posição 2 => -2 - 1: retornará -3
	- Arrays.equals(a1, a2); //primitivos
	- Arrays.deepEquals(Object[] a1, Object[] a2); //objetos
	- Arrays.fill(array, valor); // preenche as posições do array c/ o valor especificado
- Collection
	- interfaces e implementações
		- Collection
			- List : implementa métodos adicionais
				- implementações: ArrayList, LinkedList
			- Set e SortedSet: implementa apenas métodos de Collection
				- implementações: HashSet, TreeSet, LinkedHashSet
			- Queue
			- Deque
				- implementações: ArrayDeque, LinkedList
		- não é Collection: Map e SortedMap
			implementações: HashMap, TreeMap, LinkedHashMap
	
- HashMap
	- armazena como chave/valor. Você pode acessar através d eum index que pode ser uma String inclusive
	- importar 	java.util.HashMap;
```java
	HashMap<String, String> capitalCities = new HashMap<String, String>();
	capitalCities.put("England", "London");
	System.out.println(capitalCities);
	capitalCities.get("England");
	capitalCities.remove("England");
	capitalCities.clear(); //remove all items
```

- HashSet
	- collection of items where every item is unique
	- import java.util.HashSet; 
	- `HashSet<String> cars = new HashSet<String>();    cars.add("Volvo");`

- se a.equals(b) então a.hashCode() == b.hashCode()

[[↑] Back to top](#Dicas)
