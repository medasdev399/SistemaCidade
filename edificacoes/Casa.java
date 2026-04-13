package edificacoes;

import interfaces.RequiredInterface;

public class Casa extends Edificacao implements RequiredInterface {

	private int numMoradores;

	public Casa(String endereco) {
		super(endereco);
		this.numMoradores = 0;
	}

	public void registrarMorador() {
		numMoradores++;
		System.out.println("Morador registrado na casa em " + endereco + ". Total: " + numMoradores);
	}

	public int getNumMoradores() {
		return numMoradores;
	}

	@Override
	public boolean verificarRequisitos() {
		return numMoradores >= 0; // Sempre verdadeiro para casas
	}
}
