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
		1. **construtor:** a classe pode ter 0 a n construtores. Não devem ter retorno. Pode ter um *return* mas vazio
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
		1. **classes com mesmo nome:** *import java.util.Date; import java.sql.Date;* não compila se usar variaveis de instancia com o tipo Date. Pode importar apenas 1 pacote e usar o *fqn* para declarar o tipo da variável.
		1. *import java.util.\*; import java.sql.Date* : vai ser usado do Date do pacote sql (mais específico)
		1. pacote **java.lang.\*** são implicitamente importadas. *String*
		1. **import static model.Utils.\*** : importa todos os membros *static* da classe Utils		
	1. Compare and contrast the features and components of Java such as: platform independence, object orientation, encapsulation, etc.
		1. **bytecode** .class é interpretado pela **JVM** que converte em código de máquina, executado pelo **SO** nativo
		1. programa **escrito** e **compilado** apenas 1x pode ser usado em diversas plataformas diferentes.
		1. **OO:** estruturamos o código em entidades *objetos* (compontentes especializados) que possuem dados na forma de *atributos* e comportamento na forma de *métodos*
		1. Cada objeto deve ter *única responsabilidade*, favorecer *reuso de código* e cada mudança no comportamento *reflete em todos os lugares* onde o objeto é usado.
		1. *Encapsulamento* *privar* atributos e implmentação p/ q outros objetos manipule esses atributos. Liberar apenas por meio de métodos *public*
1. Using Operators and Decision Constructs 
	1. Use Java operators; use parentheses to override operator precedence
		1. **= atribuição** tipos compatíves ou o valor deverá ser = ou menos abrangente. tipos primitivos: copiamos o valor
			1. double d = 20.0f; *float é menos abrangente que double*
			1. float f = 40.0; *erro: double não cabe em float*
			1. float h = 10l; *inteiros (long) cabe em decimal*
			1. tipos menos abrangentes que int: **byte, short, char**
				1. byte b = 200; *estoura byte:  -128 a 127 (único itervalo cobrado)*
				1. char c2 = -1; *erro: só positivo*
			1.*referência: polimorfismo*	
				1. List<String> names = new ArrayList<>(); *<> operador diamante*
				1. copiamos o valor da referência (o objeto é o mesmo)
		1.**aritméticos**
			1. **%** resto de divisão: *apenas inteiros*
			1. o tipo do resultado da operação é no minimo **int** ou o **mais abrangente**
				1.```java					
					int age = 15;
					long years = 5;
					int afterThoseYears2 = age + years;// não compila, o maior tipo era long, devolve long
					byte b = 1;
					short s = 2;
					byte b2 = i + s; //// não compila, ele devolve no mínimo int					
				```
			1.	**divisão por 0**: 
				*inteiro:*```System.out.println(200 / 0); //ArithmeticException```
				*decimal:*```System.out.println(200 / 0.0); //compila e roda:  infinito positivo```				
				*NaN:* infinito positivo - infinito negativo
		1.**comparação**:
			1. sempre devolve um boolean
			1. referencias e boolean somente com *== ou !=*
			1. pode comparar *char* com *numérico* ```System.out.println('a' > 1);//true```
		1.**lógicos**
			1. *& | *: a segunda parte sempre é avaliada, podendo incrementar variaveis e tbm chamar métodos			
			1. *curto circuito && ||: *  Quando já for possível determinar a resposta final olhando apenas para a primeira parte da expressão, a segunda não é avaliada
			1. 
			```java
			System.out.println(1 == 2 & imprimir("hi"));// imprime hi, depois false
			System.out.println(1 == 2 && imprimir("bye"));//imprime false
			int i = 10;	System.out.println(i == 2 & i++ == 0);// imprime false, soma mesmo assim
			int j = 10;	System.out.println(j == 2 && j++ == 0); // imprime false, não soma
			```
		1.**incremento/decremento**
			1. *pré*: sempre a primeira coisa q é feita é o incrementar/decrementar
			```java
				int i = 10; System.out.println(++i); //imprime 11
				int j =10;	System.out.println(j++); //imprime 10
			```
		1. **operações/atribuições de uma só vez**
			```
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
	1. Test equality between Strings and other objects using == and equals ()
	1. Create if and if/else and ternary constructs 
	1. Use a switch statement 

1. Using Loop Constructs 
	1. Create and use while loops
	1. Create and use for loops including the enhanced for loop
	1. Create and use do/while loops
	1. Compare loop constructs
	1. Use break and continue  

1. Working with Inheritance 
	1. Describe inheritance and its benefits
	1. Develop code that makes use of polymorphism; develop code that overrides methods;  differentiate between the type of a reference and the type of an object
	1. Determine when casting is necessary
	1. Use super and this to access objects and constructors
	1. Use abstract classes and interfaces

1. Working with Selected classes from the Java API 
	1. Manipulate data using the StringBuilder class and its methods
	1. Create and manipulate Strings
	1. Create and manipulate calendar data using classes from java.time.LocalDateTime,  java.time.LocalDate, java.time.LocalTime, java.time.format.DateTimeFormatter, java.time.Period
	1. Declare and use an ArrayList of a given type 
	1. Write a simple Lambda expression that consumes a Lambda Predicate expression

1. Working With Java Data Types 
	1. Declare and initialize variables (including casting of primitive data types)
	1. Differentiate between object reference variables and primitive variables
	1. Know how to read or write to object fields
	1. Explain an Object's Lifecycle (creation, "dereference by reassignment" and garbage collection)
	1. Develop code that uses wrapper classes such as Boolean, Double, and Integer  

1. Creating and Using Arrays 
	1. Declare, instantiate, initialize and use a one-dimensional array
	1. Declare, instantiate, initialize and use multi-dimensional arrays

1. Working with Methods and Encapsulation 
	1. Create methods with arguments and return values; including overloaded methods
	1. Apply the static keyword to methods and fields  
	1. Create and overload constructors; differentiate between default and user defined constructors
	1. Apply access modifiers
	1. Apply encapsulation principles to a class
	1. Determine the effect upon object references and primitive values when they are passed  into methods that change the values

1. Handling Exceptions 
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
abstract
assert
boolean
break
byte
case
catch
char
class
const
continue
default
do
double
else
enum
extends
false
final
finally
float
for
goto
if
implements
import
instanceof
int
interface
long
native
new
null
package
private
protected
public
return
short
static
strictfp
super
switch
synchronized
this
throw
throws
transient
true
try
void
volatile
while
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
* todos menos char podem ser +/-
* não precisa decorar tamanho
* char é compatível com numerico
* double, float: +/-0, +/- infinito, NaN
* short e char tem o mesmo tamanho mas char é apenas >=0
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

