package controller;

import javax.swing.ImageIcon;

class CMaisMais extends Objetos {
	public CMaisMais( planoJavalar plano) {
		super(7, 1,plano);
	this.apelido = "Cmaismais";	
	this.movimento = 2;
	this.superior = 5;
	this.direito = 5;
	this.inferior = 9;
	this.esquerdo = 9;
	this.horasdia = 0.5;
	 this.ImagemPlaneta = new ImageIcon("imagens/Cplusplus.png");
	}

}