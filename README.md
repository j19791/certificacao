# Repositório de todo material utilizado para certificação OCA Programmer 1Z0-808

1. Java Basics 
	1. Define the scope of variables 
	1. Define the structure of a Java class
	1. Create executable Java applications with a main method; run a Java program from the command line; produce console output
	1. Import other Java packages to make them accessible in your code
	1. Compare and contrast the features and components of Java such as: platform independence, object orientation, encapsulation, etc.

2. Using Operators and Decision Constructs 
	2. Use Java operators; use parentheses to override operator precedence
	2. Test equality between Strings and other objects using == and equals ()
	2. Create if and if/else and ternary constructs 
	2. Use a switch statement 

3. Using Loop Constructs 
3.1 Create and use while loops
3.2 Create and use for loops including the enhanced for loop
3.3 Create and use do/while loops
3.4 Compare loop constructs
3.5 Use break and continue  

4. Working with Inheritance 
4.1 Describe inheritance and its benefits
4.2 Develop code that makes use of polymorphism; develop code that overrides methods;  differentiate between the type of a reference and the type of an object
4.3 Determine when casting is necessary
4.4 Use super and this to access objects and constructors
4.5 Use abstract classes and interfaces

5. Working with Selected classes from the Java API 
5.1 Manipulate data using the StringBuilder class and its methods
5.2 Create and manipulate Strings
5.3 Create and manipulate calendar data using classes from java.time.LocalDateTime,  java.time.LocalDate, java.time.LocalTime, java.time.format.DateTimeFormatter, java.time.Period
5.4 Declare and use an ArrayList of a given type 
5.5 Write a simple Lambda expression that consumes a Lambda Predicate expression

6. Working With Java Data Types 
6.1 Declare and initialize variables (including casting of primitive data types)
6.2 Differentiate between object reference variables and primitive variables
6.3 Know how to read or write to object fields
6.4 Explain an Object's Lifecycle (creation, "dereference by reassignment" and garbage collection)
6.5 Develop code that uses wrapper classes such as Boolean, Double, and Integer  

7. Creating and Using Arrays 
7.1 Declare, instantiate, initialize and use a one-dimensional array
7.2 Declare, instantiate, initialize and use multi-dimensional arrays

8. Working with Methods and Encapsulation 
8.1 Create methods with arguments and return values; including overloaded methods
8.2 Apply the static keyword to methods and fields  
8.3 Create and overload constructors; differentiate between default and user defined constructors
8.4 Apply access modifiers
8.5 Apply encapsulation principles to a class
8.6 Determine the effect upon object references and primitive values when they are passed  into methods that change the values

9. Handling Exceptions 
9.1 Differentiate among checked exceptions, unchecked exceptions, and Errors
9.2 Create a try-catch block and determine how exceptions alter normal program flow
9.3 Describe the advantages of Exception handling 
9.4 Create and invoke a method that throws an exception
9.4 Recognize common exception classes (such as NullPointerException, ArithmeticException, ArrayIndexOutOfBoundsException, ClassCastException)

10. Assume the following:
Missing package and import statements: If sample code do not include package or import statements, and the question does not explicitly refer to these missing statements, then assume that all sample code is in the same package, or import statements exist to support them.
No file or directory path names for classes: If a question does not state the file names or directory locations of classes, then assume one of the following, whichever will enable the code to compile and run:
All classes are in one file
Each class is contained in a separate file, and all files are in one directory
Unintended line breaks: Sample code might have unintended line breaks. If you see a line of code that looks like it has wrapped, and this creates a situation where the wrapping is significant (for example, a quoted String literal has wrapped), assume that the wrapping is an extension of the same line, and the line does not contain a hard carriage return that would cause a compilation failure.
Code fragments: A code fragment is a small section of source code that is presented without its context. Assume that all necessary supporting code exists and that the supporting environment fully supports the correct compilation and execution of the code shown and its omitted environment.
Descriptive comments: Take descriptive comments, such as "setter and getters go here," at face value. Assume that correct code exists, compiles, and runs successfully to create the described effect.






## dicas
* java exam.java.basics.executable.ExecutableTest -Dkey1=abc Dkey2=dfe xpto bar
* static public void main(String args[]) ou public static void main(String args[]) funcionam para transformar a classe em executavel
* contagem de posição sempre começa do 0
* fortemente tipado
* atentar as pequenas regras necessárias para que o código compile
* verifique cada ponto-e-vírgula, visibilidade, escopo de variáveis, nomes e parâmetros de métodos
* Para compilar, estamos trabalhando com arquivos e diretórios, portanto javac b/A.java; enquanto, para rodar, estamos pensando em pacotes e classes: java b.A.
* Podemos ter espaços em branco desde que não quebre uma palavra-chave, nome de método, classe etc. ao meio. Onde pode ter um espaço em branco, pode haver vários.
* Nenhuma palavra-chave em Java possui caractere maiúsculo (são case sensistive)
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
** byte - 1 byte (8 bits, de -128 a 127); (único itervalo cobrado)
** short - 2 bytes (16 bits, de –32.768 a 32.767);
** char - 2 bytes (só positivo), (16 bits, de 0 a 65.535);
** int - 4 bytes (32 bits, de –2.147.483.648 a 2.147.483.647);
** long - 8 bytes (64 bits, de –9.223.372.036.854.775.808 a 9.223.372.036.854.775.807).
* boolean em Java só pode ser false ou true. Não existe 0 para false ou 1 para true
* tipos primitivos: atribuição é por cópia do valor
* octal: int i = 0761; //497 (0 a 7)
* hexadecimal: int i = 0xAB3400; // 11219968
* binário:


## javac 
* digitar nome do arquivo sempre c/ extensão .java
* não precisa ter classe main
 






## java

* não digitar extensão .class
* jar -cf bib.jar scjp  cria o arquivo bib.jar a partir do conteudo do diretorio scjp
* java -cp bib.jar scjp.Prova executar nossa classe Prova.class usando esse bib.jar

