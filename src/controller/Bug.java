package controller;

import javax.swing.ImageIcon;

public class Bug extends Objetos {
    protected ImageIcon imagemBug;

    public Bug(int x, int y, planoJavalar plano) {
        super(x, y, plano);
        this.imagemBug = new ImageIcon("/imagens/bug.png");
    }

    public ImageIcon getImagemBug() {
        return imagemBug;
    }
}
