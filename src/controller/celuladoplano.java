package controller;

import View.CelulaDoPainel;

public class celuladoplano {
	public int X;
	public int Y;
	public Bug Bug;
    public Dev Desenvolvedor;
	public CelulaDoPainel celulaDoPainel;
	public Objetos planeta;

	public celuladoplano(int coordenadaX, int coordenadaY) {
		this.Desenvolvedor = null;
		this.Bug = null;
		this.X = coordenadaX;
		this.Y = coordenadaY;
	}

	public Objetos getPlaneta() {
		return planeta;
	}

}
