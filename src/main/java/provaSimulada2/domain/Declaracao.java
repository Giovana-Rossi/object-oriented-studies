package provaSimulada2.domain;

import java.util.Objects;

public abstract sealed class Declaracao permits DeclaracaoCompleta, DeclaracaoSimplificada {
    private final long id;
    private double ganhoTributavel;
    private double valorPago;

    public Declaracao(long id, double ganhoTributavel, double valorPago) {
        this.id = id;
        this.ganhoTributavel = ganhoTributavel;
        this.valorPago = valorPago;
    }

    public final double getValorAPagar(){
        return getValorImposto() - valorPago - getGastosDeutiveis();
    }

    public abstract double getValorImposto();

    public double getGastosDeutiveis(){
        return 0;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Declaracao that = (Declaracao) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return String.format("|ID = %d | Ganho Tributavel = R$%.2f | Valor já pago = R$%.2f | Valor do imposto = R$%.2f | Valor a pagar = R$%.2f",
                id, ganhoTributavel, valorPago, getValorImposto(),getValorAPagar());
    }

    public long getId() {
        return id;
    }

    public double getGanhoTributavel() {
        return ganhoTributavel;
    }

    public void setGanhoTributavel(double ganhoTributavel) {
        this.ganhoTributavel = ganhoTributavel;
    }

    public double getValorPago() {
        return valorPago;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }
}
