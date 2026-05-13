package provaSimulada2.domain;

import java.util.Objects;

public abstract sealed class Gasto permits GastoEducacao, GastoSaude {
    private final long id;
    private String CNPJ;
    private String descricao;
    private double valor;

    public Gasto(long id, String CNPJ, String descricao, double valor) {
        this.id = id;
        this.CNPJ = CNPJ;
        this.descricao = descricao;
        this.valor = valor;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Gasto gasto = (Gasto) o;
        return id == gasto.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return String.format("ID = %d | CNPJ = %s | Descrição = %s | Valor = R$%.2f |",
                id, CNPJ, descricao, valor);
    }

    public long getId() {
        return id;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
