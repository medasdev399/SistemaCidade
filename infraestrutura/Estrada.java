package infraestrutura;

import interfaces.AcessoViario;
import java.util.ArrayList;
import java.util.List;

public class Estrada extends Infraestrutura implements AcessoViario {

	private float extensaoKm;

	private String tipoPavimento;

	private List<Estrada> conexoes;

	public Estrada(String localizacao, float extensaoKm, String tipoPavimento) {
		super(localizacao);
		this.extensaoKm = extensaoKm;
		this.tipoPavimento = tipoPavimento;
		this.conexoes = new ArrayList<>();
	}

	public void conectar(Estrada outraVia) {
		if (!conexoes.contains(outraVia)) {
			conexoes.add(outraVia);
			outraVia.conexoes.add(this);
			System.out.println("Estrada em " + localizacao + " conectada à estrada em " + outraVia.localizacao);
		}
	}

	public boolean permitirTrafego() {
		return extensaoKm > 0 && tipoPavimento != null && !tipoPavimento.isEmpty();
	}

	public float getExtensaoKm() {
		return extensaoKm;
	}

	public String getTipoPavimento() {
		return tipoPavimento;
	}

	public List<Estrada> getConexoes() {
		return conexoes;
	}

	@Override
	public boolean permitirAcesso() {
		return permitirTrafego();
	}

	@Override
	public void conectar(Infraestrutura outra) {
		if (outra instanceof Estrada) {
			conectar((Estrada) outra);
		}
	}
}
