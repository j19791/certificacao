# Repositório de todo material utilizado para certificação OCA Programmer

## dicas
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



## javac 
* digitar nome do arquivo sempre c/ extensão .java
* não precisa ter classe main
 






## java

* não digitar extensão .class
* jar -cf bib.jar scjp  cria o arquivo bib.jar a partir do conteudo do diretorio scjp
* java -cp bib.jar scjp.Prova executar nossa classe Prova.class usando esse bib.jar

