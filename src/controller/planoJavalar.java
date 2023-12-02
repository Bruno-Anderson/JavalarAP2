package controller;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;



public class planoJavalar {
	public int NumeroBugs;
	public int NumeroDevs;
	public static ArrayList<celuladoplano> grade;
	public ArrayList<Pecas> pecas; // Lista de todas as peças (incluindo Bugs e Desenvolvedores)
	public int maximoX = 15;
	public int maximoY = 15;
	private Sistema sistema;
	public planoJavalar(Sistema sistema) {
		grade = new ArrayList<>();
		pecas = new ArrayList<>(); // Inicializa a lista de todas as peças
		for (int i = 0; i < maximoY; i++) {
			for (int j = 0; j < maximoX; j++) {
				celuladoplano celula = new celuladoplano(j, i);
				grade.add(celula);
			}
		}
	}

	public void adicionarBugseDevs(int numeroBugs, int numeroDevs) {
        List<Integer> instantes = sistema.leitorArq.lerLinhaAtual();
        int movimentoBug = instantes.get(0);
        int movimentoDev = instantes.get(1);

        Random random = new Random();
        for (int i = 0; i < numeroBugs; i++) {
            int x = random.nextInt(maximoX);
            int y = random.nextInt(maximoY);
            Bug bug = new Bug(x, y, this);
            bug.movimento = movimentoBug;
            grade.get(y * maximoX + x).Bug = bug;
        }

        for (int i = 0; i < numeroDevs; i++) {
            int x = random.nextInt(maximoX);
            int y = random.nextInt(maximoY);
            Dev dev = new Dev(x, y, this);
            dev.movimento = movimentoDev;
            grade.get(y * maximoX + x).Desenvolvedor = dev;
        }
    }

    public void printBugDev() {
        System.out.println("Posicoes dos bugs:");
        for (int i = 0; i < grade.size(); i++) {
            celuladoplano celula = grade.get(i);
            if (celula.Bug != null) {
                System.out.println("(" + celula.X + ", " + celula.Y + ")");
            }
        }

        System.out.println("Posicoes dos desenvolvedores:");
        for (int i = 0; i < grade.size(); i++) {
            celuladoplano celula = grade.get(i);
            if (celula.Desenvolvedor != null) {
                System.out.println("(" + celula.X + ", " + celula.Y + ")");
            }
        }
    }

}