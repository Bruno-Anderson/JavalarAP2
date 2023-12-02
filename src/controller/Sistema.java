package controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;

import model.*;

import java.util.InputMismatchException;

public class Sistema {
	public planoJavalar plano;
	public LeitorInstantes leitorArq;
	public List<Objetos> planetas;
	private int rodada;
	private int totalMovimentos;
	private File file;
	private Aluno aluno;
	public List<Bug> bugs;
    public List<Dev> devs;
    private Sistema Sistema;
	public void verificarMovimento() {
		for (Objetos planeta : planetas) {
			if (planeta.movimento <= 0) {
				System.out.println("O planeta " + planeta.apelido + " foi destruido!!!!!!");
			}
		}
	}

	public Sistema() {
		this.plano = new planoJavalar(Sistema);
		this.planetas = new ArrayList<>();
		this.leitorArq = new LeitorInstantes();
		this.bugs = new ArrayList<>();
		this.devs = new ArrayList<>();
		this.rodada = 0;

		// Adicione os planetas aqui
		this.planetas.add(0,new Python(plano));
      this.planetas.add(1,new Javascript(plano));
        this.planetas.add(2,new RubyonRails(plano));
        this.planetas.add(3,new Php(plano));
        this.planetas.add(4,new Csharp(plano));
        this.planetas.add(5,new CMaisMais(plano));
        this.planetas.add(6,new C(plano));
        this.planetas.add(7,new estrelaJava(plano));
        this.bugs.add(new Bug(1, 1, plano));
        List<Integer> instantes = leitorArq.lerLinhaAtual();

        // O último instante é o número de desenvolvedores
        int numeroDevs = instantes.get(instantes.size() - 1);

        // O penúltimo instante é o número de bugs
        int numeroBugs = instantes.get(instantes.size() - 2);

        Random random = new Random();

        // Adicione bugs à lista de bugs
        for (int i = 0; i < numeroBugs; i++) {
            int x = random.nextInt(plano.maximoX);
            int y = random.nextInt(plano.maximoY);
            Bug bug = new Bug(x, y, this.plano);
            this.bugs.add(bug);
        }

        // Adicione desenvolvedores à lista de desenvolvedores
        for (int i = 0; i < numeroDevs; i++) {
            int x = random.nextInt(plano.maximoX);
            int y = random.nextInt(plano.maximoY);
            Dev dev = new Dev(x, y, this.plano);
            this.devs.add(dev);
        }
    }
	
	
	public void gerarRelatorio() {
		System.out.println("Relatorio do Sistema: " + "\n");
		System.out.println("Numero total de movimentos solicitados pelo usuario: " + totalMovimentos + "\n");

		for (Objetos planeta : planetas) {

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
		List<Integer> instantes;
		
		while (continuar.equalsIgnoreCase("S")) {
			try {
				System.out.println("Digite o numero de bugs:");
				int numeroBugs = scanner.nextInt();
				System.out.println("Digite o numero de desenvolvedores:");
				int numeroDevs = scanner.nextInt();
				this.plano.adicionarBugseDevs(numeroBugs, numeroDevs);
				this.plano.printBugDev();
				System.out.println("Rodada " + ++rodada);

				instantes = leitorArq.lerLinhaAtual();
				for (int i = 0; i < this.planetas.size(); i++) {
					planetas.get(i).mover(instantes.get(i));

					System.out.println();

				}
				verificarMovimento();

			} catch (InputMismatchException e) {
				System.out.println("Por favor, insira números inteiros.");
				scanner.next(); // descarta a entrada inválida
			}

		}
	}
	public void relatorio(File file) {
	    this.file = file;
	    
	    
	    aluno = new Aluno("Bruno Anderson", 542050);
	    
	   
	    int bugQ1=0, devQ1=0, bugQ2=0, devQ2=0, bugQ3=0, devQ3=0, bugQ4=0, devQ4=0;
	    
	    
	    String relatorio = aluno.getNome() + "," + aluno.getMatricula() + "," + file.getName();
	    for (Objetos planeta : planetas) {
	        relatorio += "," + planeta.colisaoBug + "," + planeta.colisaoDev + "," + planeta.movimento + "," + planeta.horasdia + "," + planeta.ano;
	    }
	    relatorio += "," + bugQ1 + "," + bugQ2 + "," + bugQ3 + "," + bugQ4 + "," + devQ1 + "," + devQ2 + "," + devQ3 + "," + devQ4;
	    
	    ArrayList<String> relatorioLista = new ArrayList<String>();
	    relatorioLista.add(relatorio);
	    
	    
	    javalarDAO s = new javalarDAO();
	    s.SistemaJavalarDAO(relatorioLista);
	    
	    JOptionPane.showMessageDialog(null, "Relatorio enviado.");
	    System.out.println("Relatorio enviado.");
	}

	public List<Objetos> getListaDePlaneta() {
	    return planetas;
	}

	public planoJavalar getplano(){
	    return plano;
	}

}