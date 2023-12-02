package View;

//Classe ButtonPanel
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;
import java.util.List;
import java.awt.Button;
import java.awt.GridLayout;
import java.awt.Panel;
import View.Painel;
import controller.Objetos;
import model.LeitorInstantes;

class ButtonPanel {
    private Panel panel;
    private final LeitorInstantes leitorArq;
    private List<Objetos> planetas;
    private Painel painel;

    public ButtonPanel(LeitorInstantes leitorArq, List<Objetos> planetas, Painel painel) {
        this.leitorArq = leitorArq;
        this.planetas = planetas;
        this.painel = painel;

        panel = new Panel(new GridLayout(5, 1));

        Button lerArquivoButton = new Button("Ler arquivo de entrada");
        lerArquivoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    // leitorArq = new LeitorInstantes(selectedFile); // Não é possível alterar a variável leitorArq
                }
            }
        });
        panel.add(lerArquivoButton);

        Button processarInstanteButton = new Button("Processar próximo instante");
        processarInstanteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                painel.girar();
                painel.repaint();
            }
        });
        panel.add(processarInstanteButton);

        panel.add(new Button("Gravar relatório"));
        panel.add(new Button("Ler dados de outros participantes"));
        panel.add(new Button("Gravar arquivo de saída"));
    }

    public Panel getPanel() {
        return panel;
    }
}
