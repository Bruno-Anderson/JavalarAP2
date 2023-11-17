package modelJavalar;

class RubyonRails extends Planeta {
	public RubyonRails(int x, int y,planoJavalar plano) {
		super(x, y, plano);
	this.apelido = "Ruby on Rails";
	this.movimento = 2;
	this.superior = 4;
	this.direito = 4;
	this.inferior = 10;
	this.esquerdo = 10;
	this.horasdia = 48;
	this.descricao = "O Ruby on Rails foi criado para desenvolver aplicacoes web para startups\n"
			+ " e foi totalmente inspirado no desenvolvimento agil utilizado nesse tipo de empresa.";
	}
}

