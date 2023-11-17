package persistenciaDados;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class LeitorInstantes {
    private BufferedReader br;

    public LeitorInstantes() {
        try {
            br = new BufferedReader(new FileReader("Dados/Dados.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void lerEImprimirInstantes() {
        List<Integer> instantes;

        instantes = lerProximaLinha(); {
            for (Integer instante : instantes) {
                System.out.print(instante + " ");
            }
            System.out.println();
        }
    }

    public List<Integer> lerProximaLinha() {
        List<Integer> instantes = new ArrayList<>();

        try {
            String linha = br.readLine();

            if(linha != null) {
                String[] unidades = linha.split(";");
                for (int i = 0; i < unidades.length; i++) {
                    // Verifique se a string pode ser convertida em um número inteiro
                    if (unidades[i].matches("\\d+")) {
                        instantes.add(Integer.parseInt(unidades[i]));
                       


                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return instantes;
    }
}
