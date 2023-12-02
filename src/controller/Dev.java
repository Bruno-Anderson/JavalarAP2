package controller;

import javax.swing.ImageIcon;

public class Dev extends Objetos {
    protected ImageIcon imagemBug;

    public Dev(int x, int y, planoJavalar plano) {
        super(x, y, plano);
        this.imagemBug = new ImageIcon("/imagens/dev.png");
    }

    public ImageIcon getImagemBug() {
        return imagemBug;
    }
}
