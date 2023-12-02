package controller;

import javax.swing.ImageIcon;

class C extends Objetos {
	public C( planoJavalar plano) {
		super(7, 0, plano);
		this.apelido = "C";
		this.movimento = 10;
		this.superior = 0;
		this.direito = 0;
		this.inferior = 14;
		this.esquerdo = 14;
		this.horasdia = 0.1;
		 this.ImagemPlaneta = new ImageIcon("imagens/C.png");
	}
}