package provaSimulada2.domain.provaSimulada2.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static provaSimulada2.domain.GastoEducacao.MAX_GASTO_EDUCACAO;
import static provaSimulada2.domain.GastoSaude.MAX_GASTO_SAUDE;

public final class DeclaracaoCompleta extends Declaracao {
    private final List<Gasto> gastos;

    public DeclaracaoCompleta(long id, double ganhoTributavel, double valorPago) {
        super(id, ganhoTributavel, valorPago);
        gastos = new ArrayList<>();
    }

    @Override
    public double getGastosDeutiveis() {
        double totalSaude = gastos.stream().filter(e -> e instanceof GastoSaude)
                .mapToDouble(Gasto::getValor)
                .sum();
        double totalEducacao = gastos.stream().filter(e -> e instanceof GastoEducacao)
                .mapToDouble(Gasto::getValor)
                .sum();

        return Math.min(totalEducacao, MAX_GASTO_EDUCACAO) + Math.min(totalSaude, MAX_GASTO_SAUDE);
    }

    @Override
    public double getValorImposto() {
        double valorImposto = 0.0;
        double ganhoTributavelAtual = getGanhoTributavel();

        if(ganhoTributavelAtual>55_976.16){
            valorImposto += (ganhoTributavelAtual - 55_976.16) * 0.275;
            ganhoTributavelAtual = 55_976.16;
        }

        if(ganhoTributavelAtual>45_012.73){
            valorImposto += (ganhoTributavelAtual - 45_012.73) * 0.225;
            ganhoTributavelAtual = 45_012.73;
        }

        if(ganhoTributavelAtual>33_919.93){
            valorImposto += (ganhoTributavelAtual - 33_919.93) * 0.15;
            ganhoTributavelAtual = 33_919.93;
        }

        if(ganhoTributavelAtual>22_847.88){
            valorImposto += (ganhoTributavelAtual - 22_847.88) * 0.075;
        }

        return valorImposto;
    }

    public void addGasto(Gasto gasto){
        gastos.add(gasto);
    }

    public void removeGasto(Gasto gasto){
        gastos.remove(gasto);
    }

    @Override
    public String toString() {
        return "****Declaracao Completa****\n" + super.toString() + "\nGastos dedutíveis:\n" +
                gastos.stream().map(Gasto:: toString).collect(Collectors.joining("\n"));
    }
}
