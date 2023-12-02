package View;



import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import controller.Objetos;
import controller.Sistema;
import controller.planoJavalar;
import model.LeitorInstantes;

public class Janela extends JFrame {
    private Sistema Sistema;
	public Janela() {
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
        setLayout(new BorderLayout());
        planoJavalar plano = new planoJavalar(Sistema);
        LeitorInstantes leitorArq = new LeitorInstantes();
        List<Objetos> planetas = new ArrayList<Objetos>();
        Sistema sistema = new Sistema(); // Crie um objeto Sistema
        Painel painel = new Painel(sistema, planetas, plano); // Passe o objeto Sistema para o construtor
        ButtonPanel buttonPanel = new ButtonPanel(leitorArq, planetas, painel);

        add(painel, BorderLayout.CENTER);
        add(buttonPanel.getPanel(), BorderLayout.EAST);

        setVisible(true);
    }
}


