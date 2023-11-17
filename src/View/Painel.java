package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.util.ArrayList;

class Painel extends JPanel {
    ArrayList<CelulaDoPainel> celulas = new ArrayList<>();

    public Painel() {
        setPreferredSize(new Dimension(600, 600));
        setLayout(new GridLayout(15, 15));

        // Array com os nomes das imagens
        String[] imagens = {"iconeJava.png", "iconePython.png", "IconeJavascript.png", "iconeRubyonRails.png", "IconePhp.png", "iconeCsharp.png", "iconeCPlusPlus.png", "iconeC.png"};

        for (int y = 0; y < 15; y++) {
            for (int x = 0; x < 15; x++) {
                CelulaDoPainel celula = new CelulaDoPainel(x, y);
                celulas.add(celula);
                JPanel panel = new JPanel();
                panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                panel.setBackground(Color.GRAY); // define a cor de fundo aqui

                // Adicionando as coordenadas a cada painel
                JLabel label = new JLabel(x + "," + y);
                panel.add(label);

                // Adicionando as imagens diretamente às células correspondentes
                if (x == 7 && y <= 7) {
                    ImageIcon icon = new ImageIcon(getClass().getResource("/View/imagens/" + imagens[7 - y]));
                    Image image = icon.getImage();
                    Image newimg = image.getScaledInstance(30, 30,  java.awt.Image.SCALE_SMOOTH); // redimensiona aqui
                    icon = new ImageIcon(newimg);
                    JLabel imageLabel = new JLabel();
                    imageLabel.setIcon(icon);
                    panel.add(imageLabel);
                }

                add(panel);
            }
        }
    }
}