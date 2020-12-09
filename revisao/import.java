

/*nao compila : conflito com Date
import java.util.Date;
import java.sql.Date; 
*/

//import java.util.Date; //importar normalmente

/*compila e executa
import java.util.*;
import java.sql.*;
*/

//compila e executa
import java.util.*;
import java.sql.Date;


class ImportTest{

	//java.sql.Date d; //importar com fqn: não há conflito

	//Date d1; //nao compila: conflito. Ambiguo: é de util ou sql ??

	java.util.Date d; //nao há conflito com fqn

	java.sql.Date d2;

	Date d3; //sera usado o Date de sql (mais especifico)

	public static void main(String [] args){

	}


}