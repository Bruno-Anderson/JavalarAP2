package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.Bug;
import controller.Dev;
import controller.Objetos;
import controller.Sistema;
import controller.celuladoplano;
import controller.planoJavalar;

import java.util.ArrayList;
import java.util.List;

public class Painel extends JPanel {
    ArrayList<CelulaDoPainel> celulas = new ArrayList<>();
    private List<Objetos> planetas;
    List<celuladoplano> grade; 
    private planoJavalar planoJavalar;
    private Sistema sistema;

    public Painel(Sistema sistema,List<Objetos> planetas, planoJavalar plano) {
        this.sistema = sistema;
        this.planetas = sistema.planetas;
        this.planoJavalar = sistema.plano;
        setPreferredSize(new Dimension(600, 600));
        setLayout(new GridLayout(15, 15)); 
        for (int y = 0; y < 15; y++) {
            for (int x = 0; x < 15; x++) {
                celuladoplano celulaDoPlano = planoJavalar.grade.get(y * planoJavalar.maximoX + x);
                CelulaDoPainel celula = new CelulaDoPainel(x, y, celulaDoPlano, null);
    
                for (Objetos planeta : planetas) {
	                if (planeta.x == celula.x && planeta.y == celula.y) {
	                    celula.planeta = planeta;}
                }
                
                celulas.add(celula);
                JPanel panel = new JPanel();
                celula.setBorder(BorderFactory.createLineBorder(Color.red));
                add(celula);
            }
        }

        this.associarPlanetas();
        // Atualiza o Painel após adicionar todos os componentes
        repaint();  
    }

    public void associarPlanetas() {
        for (CelulaDoPainel celulaDoPainel : celulas) {
            celulaDoPainel.label.setIcon(null); // Inicialmente, definimos o ícone como null

            for (Objetos planeta : planetas) {
                if (planeta.x == celulaDoPainel.x && planeta.y == celulaDoPainel.y) {
                    celulaDoPainel.planeta = planeta;
                    if (planeta.movimento != 0) {
                        // Se o planeta estiver em movimento, definimos o ícone da célula
                        celulaDoPainel.label.setIcon(planeta.getImagemPlaneta());
                    }
                }
            }

            // Atualize a imagem do bug na célula correspondente
            for (Bug bug : sistema.bugs) {
                if (bug.x == celulaDoPainel.x && bug.y == celulaDoPainel.y) {
                    celulaDoPainel.label.setIcon(bug.getImagemBug());
                }
            }

            // Atualize a imagem do desenvolvedor na célula correspondente
            for (Dev dev : sistema.devs) {
                if (dev.x == celulaDoPainel.x && dev.y == celulaDoPainel.y) {
                    celulaDoPainel.label.setIcon(dev.getImagemBug());
                }
            }
        }
    }



    public void girar() {
        // Obtenha os instantes do arquivo
        List<Integer> instantes = sistema.leitorArq.lerLinhaAtual();

        // Limpe o ícone de cada célula
        for (CelulaDoPainel celulaDoPainel : celulas) {
            celulaDoPainel.label.setIcon(null);
        }

        // Verifique se há instantes suficientes para todos os planetas
        if (instantes.size() >= sistema.planetas.size()) {
            for (int i = 0; i < sistema.planetas.size(); i++) {
                Objetos planeta = sistema.planetas.get(i);
                int instante = instantes.get(i);
                planeta.mover(instante); // Mova o planeta com o instante

                // Atualize a imagem do planeta na célula correspondente
                for (CelulaDoPainel celulaDoPainel : celulas) {
                    if (planeta.x == celulaDoPainel.x && planeta.y == celulaDoPainel.y) {
                        celulaDoPainel.label.setIcon(planeta.getImagemPlaneta());
                    }
                }
            }

            // Mova cada bug e atualize a imagem na célula correspondente
            for (Bug bug : sistema.bugs) {
                bug.mover(instantes.get(instantes.size() - 2)); // Supondo que o movimento do bug seja o penúltimo instante
                for (CelulaDoPainel celulaDoPainel : celulas) {
                    if (bug.x == celulaDoPainel.x && bug.y == celulaDoPainel.y) {
                        celulaDoPainel.label.setIcon(bug.getImagemBug());
                    }
                }
            }

            // Mova cada desenvolvedor e atualize a imagem na célula correspondente
            for (Dev dev : sistema.devs) {
                dev.mover(instantes.get(instantes.size() - 1)); // Supondo que o movimento do desenvolvedor seja o último instante
                for (CelulaDoPainel celulaDoPainel : celulas) {
                    if (dev.x == celulaDoPainel.x && dev.y == celulaDoPainel.y) {
                        celulaDoPainel.label.setIcon(dev.getImagemBug());
                    }
                }
            }
        } else {
            System.out.println("Não há instantes suficientes no arquivo para todos os planetas.");
        }
    }

      
    
    public void resetarPlano() {
        for (CelulaDoPainel celula : celulas) {
            this.remove(celula);
        }

        celulas.clear();
    }
}