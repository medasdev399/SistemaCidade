package infraestrutura;

import interfaces.AcessoViario;

public class Ponte extends Infraestrutura implements AcessoViario {

	private float capacidadeCarga;

	private float comprimento;

	private Estrada ladoA;

	private Estrada ladoB;

	public Ponte(String localizacao, float capacidadeCarga, float comprimento) {
		super(localizacao);
		this.capacidadeCarga = capacidadeCarga;
		this.comprimento = comprimento;
	}

	public boolean liberarPassagem() {
		return capacidadeCarga > 0 && ladoA != null && ladoB != null;
	}

	public void conectarLados(Estrada ladoA, Estrada ladoB) {
		this.ladoA = ladoA;
		this.ladoB = ladoB;
		ladoA.conectar(this);
		ladoB.conectar(this);
		System.out.println("Ponte em " + localizacao + " conectando " + ladoA.getLocalizacao() + " e " + ladoB.getLocalizacao());
	}

	public float getCapacidadeCarga() {
		return capacidadeCarga;
	}

	public float getComprimento() {
		return comprimento;
	}

	@Override
	public boolean permitirAcesso() {
		return liberarPassagem();
	}

	@Override
	public void conectar(Infraestrutura outra) {
		// Ponte conecta estradas, não outras infraestruturas diretamente
	}
}
