package View;



import java.awt.BorderLayout;
import javax.swing.JFrame;

public class Janela extends JFrame {
    public Janela() {
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
        setLayout(new BorderLayout());

        Painel painel = new Painel();
        ButtonPanel buttonPanel = new ButtonPanel();

        add(painel, BorderLayout.CENTER);
        add(buttonPanel.getPanel(), BorderLayout.EAST);

        setVisible(true);
    }
}

