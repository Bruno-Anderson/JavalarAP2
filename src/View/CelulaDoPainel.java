package View;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.Objetos;
import controller.Sistema;
import controller.celuladoplano;

public class CelulaDoPainel extends JPanel{
    int x;
    int y;
    public Objetos planeta;
	public celuladoplano celulaDoPlano;
	public JLabel label;
	 public Sistema sistema;
    public CelulaDoPainel(int x, int y, celuladoplano celulaDoPlano,Sistema sistema) {
        this.x = x;
        this.y = y;
        this.planeta = null;
        this.celulaDoPlano = celulaDoPlano;
        this.label = new JLabel();
        this.sistema = sistema; 
        this.add(label);
        this.setBackground(Color.black);
        this.setVisible(true);
        
    }
	public Objetos getPlaneta() {
		// TODO Auto-generated method stub
		return planeta;
	}
}
