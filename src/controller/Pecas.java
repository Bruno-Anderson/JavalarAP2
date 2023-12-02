package controller;

public abstract  class Pecas {
public int x;
public int y;
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
