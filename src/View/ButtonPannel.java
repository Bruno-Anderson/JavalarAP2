package View;

import java.awt.Button;
import java.awt.GridLayout;
import java.awt.Panel;

class ButtonPanel {
    private Panel panel;

    public ButtonPanel() {
        panel = new Panel(new GridLayout(5, 1));
        panel.add(new Button("Processar próximo instante"));
        panel.add(new Button("Ler arquivo de entrada"));
        panel.add(new Button("Gravar relatório"));
        panel.add(new Button("Ler dados de outros participantes"));
        panel.add(new Button("Gravar arquivo de saída"));
    }

    public Panel getPanel() {
        return panel;
    }
}
