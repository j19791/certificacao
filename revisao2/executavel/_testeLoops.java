package executavel;

import static loops.Loop.*; //importa todos os membros static de Loop

class LoopsTest{

	static public void main(String ... args){

		

		new loops.Loop().testaLoop();
		//loops.Loop.testaLoopExpInf();
		//testaLoopExpInf(true);		
		//testaLoopExpInfComFinal();
		testaCondicaoFalse();
		testaFor(new Boolean[]{true});
		testaInicializacaoFor();
		//testaDoWhile(true);
		testaWhileInfinitoComBreak();

	}


}