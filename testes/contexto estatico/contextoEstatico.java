class B {
int x = 1;
}
class A extends B {
	static int x = 2;
	int y = 3;
	public static void main(String[] args) {
		System.out.println(x); //imprime 2 qdo x é static
		//System.out.println(y); //y fora do contexto static. Não compila
		new A().z();
	}
	
	void z(){
		
		System.out.println(this.y);//3
		System.out.println(this.x);//2
		System.out.println(x);//2
		System.out.println(y);//3
	}

}