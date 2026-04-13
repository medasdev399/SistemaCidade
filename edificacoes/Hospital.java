package edificacoes;

import infraestrutura.Estrada;
import interfaces.RequiredInterface;

public class Hospital extends Edificacao implements RequiredInterface {

	private int leitosDisponiveis;

	public Hospital(String endereco, int leitos) {
		super(endereco);
		this.leitosDisponiveis = leitos;
	}

	public void atenderEmergencia(Estrada viaDeAcesso) {
		if (viaDeAcesso.permitirAcesso() && leitosDisponiveis > 0) {
			leitosDisponiveis--;
			System.out.println("Emergência atendida no hospital em " + endereco + ". Leitos restantes: " + leitosDisponiveis);
		} else {
			System.out.println("Não é possível atender emergência: via bloqueada ou sem leitos disponíveis");
		}
	}

	public int getLeitosDisponiveis() {
		return leitosDisponiveis;
	}

	@Override
	public boolean verificarRequisitos() {
		return leitosDisponiveis > 0;
	}
}
