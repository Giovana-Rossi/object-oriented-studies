package provaSimulada2.domain.provaSimulada2.application;

import provaSimulada2.domain.provaSimulada2.domain.*;

public class AdicionarGastoTributavelService {
    public void adicionarGasto(long id, String descricao, String CNPJ, double valor, TipoGasto tipo, String adicional){
        if(id < 0) throw new IllegalArgumentException("Id não pode ser negativo"); //vale a mesma ideia para todos

        final FakeDeclaracaoRepository repo = new FakeDeclaracaoRepository();
        final DeclaracaoCompleta declaracao = (DeclaracaoCompleta) repo.buscarPorId(1).orElseThrow(IllegalStateException::new);

        Gasto gasto = switch (tipo){
            case EDUCACAO -> new GastoEducacao(id, CNPJ, descricao, valor, adicional);
            case SAUDE -> new GastoSaude(id, CNPJ, descricao, valor, adicional);
        };

        declaracao.addGasto(gasto);
        repo.atualizar(declaracao);
    }
}
