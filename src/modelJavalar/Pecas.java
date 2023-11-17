package modelJavalar;

public abstract  class Pecas {
protected int x;
protected int y;
protected char caractere;
protected int ano;
public planoJavalar plano;

public Pecas(int x, int y, planoJavalar plano) {
	this.plano = plano;
	this.x = x;
	this.y= y;
	


	
}
public abstract void mover(int tempo);



}
