package biblioteca;

public class Geografia{

	public static String capital(String pais){
		
		if(pais.equals("Brasil"))
			return "Brasilia";
		else if (pais.equals("Argentina"))
			return "Buenos Aires";
		else return "não sei";

	}


}