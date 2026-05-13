package provaSimulada2.domain.provaSimulada2.domain;

public final class GastoSaude extends Gasto {
    public static final double MAX_GASTO_SAUDE = 1_500.0;
    private String registroConselho;

    public GastoSaude(long id, String CNPJ, String descricao, double valor, String registroConselho) {
        super(id, CNPJ, descricao, valor);
        this.registroConselho = registroConselho;
    }

    @Override
    public String toString() {
        return "Gasto com Saude | " + "Registro = " + registroConselho + " " + super.toString();
    }

    public String getRegistroConselho() {
        return registroConselho;
    }

    public void setRegistroConselho(String registroConselho) {
        this.registroConselho = registroConselho;
    }
}
