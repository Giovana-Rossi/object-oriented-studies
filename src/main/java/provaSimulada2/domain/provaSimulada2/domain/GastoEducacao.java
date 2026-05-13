package provaSimulada2.domain.provaSimulada2.domain;

public final class GastoEducacao extends Gasto {
    public static final double MAX_GASTO_EDUCACAO = 2000.0;
    private String nomeInstituicao;


    public GastoEducacao(long id, String CNPJ, String descricao, double valor, String nomeInstituicao) {
        super(id, CNPJ, descricao, valor);
        this.nomeInstituicao = nomeInstituicao;
    }

    @Override
    public String toString() {
        return "Gasto com Educação | " + "Nome Instituição = " + nomeInstituicao + " " + super.toString();
    }

    public String getNomeInstituicao() {
        return nomeInstituicao;
    }

    public void setNomeInstituicao(String nomeInstituicao) {
        this.nomeInstituicao = nomeInstituicao;
    }

}
