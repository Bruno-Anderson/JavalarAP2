package modelJavalar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Sistema implements ISistema {
    private planoJavalar plano;
    private List<Planeta> planetas;
    private int rodada;
    private int totalMovimentos;
    public void verificarMovimento() {
        for (Planeta planeta : planetas) {
            if (planeta.movimento <= 0) {
                System.out.println("O planeta " + planeta.apelido + " foi destruido!!!!!!");
            }
        }
    }
    public Sistema() {
    	this.plano = new planoJavalar();
        this.planetas = new ArrayList<>();
        this.rodada = 0;

        // Adicione os planetas aqui
        this.planetas.add(new Python(7, 6, plano));
        this.planetas.add(new Javascript(7,5,plano));
        this.planetas.add(new RubyonRails(7,4,plano));
        this.planetas.add(new Php(7,3,plano));
        this.planetas.add(new Csharp(7,2,plano));
        this.planetas.add(new CMaisMais(7,1,plano));
        this.planetas.add(new C (7,0,plano));  
    }
     
    public void gerarRelatorio() {
        System.out.println("Relatorio do Sistema: " + "\n");
        System.out.println("Numero total de movimentos solicitados pelo usuario: " + totalMovimentos + "\n");
       

        for (Planeta planeta : planetas) {
        	 
            System.out.println("Planeta: " + planeta.apelido);
            System.out.println("Numero total de bugs que coliram com o planeta: " + planeta.colisaoBug);
            System.out.println("Numero total de desenvolvedores que colidiram com o planeta: " + planeta.colisaoDev);
            System.out.println("Velocidade de rotacao: " + (planeta.ano / rodada));
            System.out.println("Velocidade de translacao: " + planeta.movimento); 
            System.out.println("O planeta explodiu? " + (planeta.movimento <= 0 ? "Sim" : "Nao"));
            System.out.println("Dias passados no planeta (em horas): " + planeta.dias);
            System.out.println("Anos passados no JavaLar: " + planeta.ano);
            System.out.println("\n");
        }
    }

  
    
    public void iniciar() {
        Scanner scanner = new Scanner(System.in);
        String continuar = "S";
        while (continuar.equalsIgnoreCase("S")) { 	
            try {
                System.out.println("Digite o numero de bugs:");
                int numeroBugs = scanner.nextInt();
                System.out.println("Digite o numero de desenvolvedores:");
                int numeroDevs = scanner.nextInt();
                System.out.println("Digite o numero de movimentos para cada planeta:");
                int movimentos = scanner.nextInt();
                totalMovimentos += movimentos;
                this.plano.adicionarBugseDevs(numeroBugs, numeroDevs);
                this.plano.printBugDev();

                System.out.println("Rodada " + ++rodada);
                for (Planeta planeta : planetas) {
                    planeta.mover(movimentos);
                  //nomedoarraylist e a posicao que vou usar eh o id do planeta
                    System.out.println();  // Adiciona uma linha em branco

                }
                verificarMovimento();
                System.out.println("Deseja continuar mais um turno? (S/N)");
                continuar = scanner.next();
            } catch (InputMismatchException e) {
                System.out.println("Por favor, insira números inteiros.");
                scanner.next(); // descarta a entrada inválida
            }
             

        }
        gerarRelatorio();
           }
}
