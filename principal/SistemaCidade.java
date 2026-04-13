package principal;

import edificacoes.Casa;
import edificacoes.Escola;
import edificacoes.Hospital;
import infraestrutura.Estrada;
import infraestrutura.Ponte;

public class SistemaCidade {

	private Casa[] bairro;

	private Escola escolaMunicipal;

	private Ponte[] pontes;

	private Estrada[] malhaViaria;

	private Hospital hospitalCentral;

	public SistemaCidade() {
		// Inicializar infraestrutura
		malhaViaria = new Estrada[3];
		malhaViaria[0] = new Estrada("Centro", 5.0f, "Asfalto");
		malhaViaria[1] = new Estrada("Bairro Norte", 3.0f, "Concreto");
		malhaViaria[2] = new Estrada("Bairro Sul", 4.0f, "Paralelepípedo");

		// Inicializar pontes
		pontes = new Ponte[1];
		pontes[0] = new Ponte("Rio Central", 100.0f, 50.0f);

		// Inicializar edificações
		bairro = new Casa[2];
		bairro[0] = new Casa("Rua A, 123");
		bairro[1] = new Casa("Rua B, 456");

		escolaMunicipal = new Escola("Praça Central", 200, "Ensino Fundamental");

		hospitalCentral = new Hospital("Avenida Principal", 50);
	}

	public void iniciarMapeamento() {
		System.out.println("Iniciando mapeamento da cidade...");

		// Conectar estradas
		malhaViaria[0].conectar(malhaViaria[1]);
		malhaViaria[0].conectar(malhaViaria[2]);

		// Conectar ponte
		pontes[0].conectarLados(malhaViaria[1], malhaViaria[2]);

		// Verificar requisitos das edificações
		for (Casa casa : bairro) {
			if (casa.verificarRequisitos()) {
				System.out.println("Casa em " + casa.getEndereco() + " está operacional");
			}
		}

		if (escolaMunicipal.verificarRequisitos()) {
			System.out.println("Escola municipal está operacional");
		}

		if (hospitalCentral.verificarRequisitos()) {
			System.out.println("Hospital central está operacional");
		}

		System.out.println("Mapeamento concluído!");
	}

	public static void main(String[] args) {
		SistemaCidade cidade = new SistemaCidade();
		cidade.iniciarMapeamento();

		// Demonstração de funcionalidades
		cidade.bairro[0].registrarMorador();
		cidade.bairro[0].registrarMorador();

		cidade.escolaMunicipal.iniciarAulas(cidade.malhaViaria[0]);

		cidade.hospitalCentral.atenderEmergencia(cidade.malhaViaria[0]);
	}

	// Getters para acesso aos componentes
	public Casa[] getBairro() {
		return bairro;
	}

	public Escola getEscolaMunicipal() {
		return escolaMunicipal;
	}

	public Hospital getHospitalCentral() {
		return hospitalCentral;
	}

	public Estrada[] getMalhaViaria() {
		return malhaViaria;
	}

	public Ponte[] getPontes() {
		return pontes;
	}
}
