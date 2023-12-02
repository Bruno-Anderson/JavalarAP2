package controller;

public class Aluno {

	private String nome;
	private int matricula;
	
	public Aluno(String nome, int matricula) {
		this.setNome(nome);
		this.setMatricula(matricula);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
}