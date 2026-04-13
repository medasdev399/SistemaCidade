package infraestrutura;

public abstract class Infraestrutura {
    protected String localizacao;

    public Infraestrutura(String localizacao) {
        this.localizacao = localizacao;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }
}