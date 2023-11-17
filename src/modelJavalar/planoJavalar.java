package modelJavalar;
import java.util.Random;
import java.util.ArrayList;



class planoJavalar {
	public int NumeroBugs;
	public int NumeroDevs;
	public ArrayList<celuladoplano> grade;
	public ArrayList<Pecas> pecas; // Lista de todas as peças (incluindo Bugs e Desenvolvedores)
	public int maximoX = 15;
	public int maximoY = 15;

	public planoJavalar() {
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
        Random random = new Random();
        for (int i = 0; i < numeroBugs; i++) {
            int x = random.nextInt(maximoX);
            int y = random.nextInt(maximoY);
            grade.get(y * maximoX + x).Bug = true;
            
        }

        for (int i = 0; i < numeroDevs; i++) {
            int x = random.nextInt(maximoX);
            int y = random.nextInt(maximoY);
            grade.get(y * maximoX + x).Desenvolvedor = true;
        }
    }
    public void printBugDev() {
        System.out.println("Posicoes dos bugs:");
        for (int i = 0; i < grade.size(); i++) {
            celuladoplano celula = grade.get(i);
            if (celula.Bug) {
                System.out.println("(" + celula.X + ", " + celula.Y + ")");
            }
        }

        System.out.println("Posicoes dos desenvolvedores:");
        for (int i = 0; i < grade.size(); i++) {
            celuladoplano celula = grade.get(i);
            if (celula.Desenvolvedor) {
                System.out.println("(" + celula.X + ", " + celula.Y + ")");
            }
        }
    }

}