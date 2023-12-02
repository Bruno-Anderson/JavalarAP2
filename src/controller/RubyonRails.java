package controller;

import javax.swing.ImageIcon;

class RubyonRails extends Objetos {
	public RubyonRails(planoJavalar plano) {
		super(7, 4, plano);
	this.apelido = "RubyonRails";
	this.movimento = 2;
	this.superior = 4;
	this.direito = 4;
	this.inferior = 10;
	this.esquerdo = 10;
	this.horasdia = 48;
	 this.ImagemPlaneta = new ImageIcon("imagens/ruby.png");
	}
}

