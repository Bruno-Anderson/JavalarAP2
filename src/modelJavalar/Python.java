package modelJavalar;

class Python extends Planeta {

	public Python(int x, int y, planoJavalar plano) {
		super(x, y, plano);
	this.apelido = "Python";	
	this.movimento = 4;
	this.superior = 6;
	this.direito = 6;
	this.inferior = 8;
	this.esquerdo = 8;
	this.horasdia = 24;
	this.descricao = "O Python eh uma linguagem de programacao amplamente usada em aplicacoes da Web,\n "
			+ "desenvolvimento de software, ciencia de dados e machine learning (ML).";
	}
   
}