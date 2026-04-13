package edificacoes;

import infraestrutura.Estrada;
import interfaces.RequiredInterface;

public class Escola extends Edificacao implements RequiredInterface {

	private int capacidadeAlunos;

	private String nivelEnsino;

	public Escola(String endereco, int capacidadeAlunos, String nivelEnsino) {
		super(endereco);
		this.capacidadeAlunos = capacidadeAlunos;
		this.nivelEnsino = nivelEnsino;
	}

	public void iniciarAulas(Estrada viaAcesso) {
		if (viaAcesso.permitirAcesso()) {
			System.out.println("Aulas iniciadas na escola " + nivelEnsino + " em " + endereco);
		} else {
			System.out.println("Não é possível iniciar aulas: via de acesso bloqueada");
		}
	}

	public int getCapacidadeAlunos() {
		return capacidadeAlunos;
	}

	public String getNivelEnsino() {
		return nivelEnsino;
	}

	@Override
	public boolean verificarRequisitos() {
		return capacidadeAlunos > 0;
	}
}
