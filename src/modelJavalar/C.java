package modelJavalar;

class C extends Planeta {
	public C(int x, int y, planoJavalar plano) {
		super(x, y, plano);
		this.apelido = "C";
		this.id = 7;

		this.movimento = 10;
		this.superior = 0;
		this.direito = 0;
		this.inferior = 14;
		this.esquerdo = 14;
		this.horasdia = 0.1;
		this.descricao = "Considerada uma linguagem de alto nivel generica, a C\n "
				+ "pode ser usada em diversos tipos de projeto, como a \n"
				+ "criacao de aplicativos, sistemas operacionais, drivers, entre outros.";
	}
}