package controller;

import java.awt.Image;

import javax.swing.ImageIcon;

import View.CelulaDoPainel;

public class Objetos extends Pecas {

    public Objetos(int x, int y, planoJavalar plano) {
        super(x, y, plano);
        this.ano = 0;
        this.xinicial = x;
        this.yinicial = y;
       
  // Inicialize a célula atual
    }

    protected int id;
    public int movimento;
    protected int superior;
    protected int inferior;
    protected int direito;
    protected int esquerdo;
    protected int yinicial;
    protected int ano;
    protected int xinicial;
    protected double dias;
    protected double horasdia;
    public String apelido;
    protected String descricao;
    protected int colisaoBug = 0;
    protected int colisaoDev = 0;
    protected String imagem;
    public CelulaDoPainel celulaAtual;
    protected ImageIcon ImagemPlaneta;
   


    
    public ImageIcon getImagemPlaneta() {
		return ImagemPlaneta;
	}

	public void setImagemPlaneta(ImageIcon imagemPlaneta) {
		this.ImagemPlaneta = imagemPlaneta;
	}

	public void mover(int tempo) {
    	
    	for (int i = 0; i < tempo * movimento; i++) {

        	
            

            if (y == superior) {
                if (x == direito) {
                    y++;
                } else
                    x--;
            } else {
                if (x == direito) {
                    if (y == inferior) {
                        x++;
                    } else
                        y++;
                } else {
                    if (y == inferior) {
                        if (x == esquerdo) {
                            y--;
                        } else
                            x++;
                    } else {
                        if (x == esquerdo) {
                            if (y == superior) {
                                x--;
                            } else
                                y--;
                        }
                    }
                }
            }
            this.calcularano();
            this.calculardias();
            
        }
    	//System.out.println(x + " " + y + "ano: " + ano + " dias: " + dias );
    	
    	System.out.println("O planeta " + apelido + " Esta em: " + "X,Y(" + x + "," + y  +")");
    	System.out.println("Apos " + ano + " anos" + " " + "e" + " " + dias + " dias!(em horas)");
        System.out.println("Movimento final do planeta apos todos os movimentos: " + movimento);
        celuladoplano celulaAtual = plano.grade.get(y * plano.maximoX + x);
       
        if (celulaAtual.Bug != null) {
            System.out.println("Movimento reduzido por um bug na posicao: (" + x + ", " + y + ")");
            movimento--;
            colisaoBug++;
        }

        if (celulaAtual.Desenvolvedor != null) {
            System.out.println("Movimento aumentado por um desenvolvedor na posicao: (" + x + ", " + y + ")");
            movimento++;
            colisaoDev ++;
        }

    }

    public void calcularano() {
        if (x == xinicial && y == yinicial) {
            ano++;
        }
    }

    public void calculardias() {
        dias = dias + horasdia;
    }
}
