package model;



import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;


public class LeitorInstantes {
    private BufferedReader br;
    private int linhaAtual;

    public LeitorInstantes() {
    	this.linhaAtual = 1;
        try {
            br = new BufferedReader(new FileReader("Dados/AE_500.txt"));
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
                String[] unidades = linha.split(",");
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
    
    public List<Integer> lerLinhaAtual(){
    	//Lê uma linha em específico e ignora o primeiro elemento da linha
    	
    	List<Integer> instantes = new ArrayList<>();
    	for(int i=1; i<this.linhaAtual; i++) {
    		this.lerEImprimirInstantes();
    	}
    	
    	instantes = lerProximaLinha();
    	instantes.remove(0);
    	linhaAtual++;
    	
    	return instantes;
    }
}