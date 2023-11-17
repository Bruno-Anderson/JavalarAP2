package modelJavalar;

class CMaisMais extends Planeta {
	public CMaisMais(int x, int y, planoJavalar plano) {
		super(x, y,plano);
	this.apelido = "C++";	
	this.movimento = 2;
	this.superior = 5;
	this.direito = 5;
	this.inferior = 9;
	this.esquerdo = 9;
	this.horasdia = 0.5;
	this.descricao = "C++ eh uma das linguagens mais versateis que existem,\n "
			+ "permitindo desenvolver desde tarefas simples como aplicacoes\n"
			+ " na linha de comando ou web, ate sistemas complexos de tempo real.";
	}

}