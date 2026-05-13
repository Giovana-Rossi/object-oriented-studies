package provaSimulada2.application;

import provaSimulada2.domain.*;
import provaSimulada2.persistence.GenericDAO;

public class AdicionarGastoTributavelService {
    private final GenericDAO<Long, Declaracao> repo;

    public AdicionarGastoTributavelService(GenericDAO<Long, Declaracao> repo) {
        this.repo = repo;
    }

    public void adicionarGasto(long id, String descricao, String CNPJ, double valor, TipoGasto tipo, String adicional){
        if(id < 0) throw new IllegalArgumentException("Id não pode ser negativo"); //vale a mesma ideia para todos

        final DeclaracaoCompleta declaracao = (DeclaracaoCompleta) repo.buscarPorId(1).orElseThrow(IllegalStateException::new);

        Gasto gasto = switch (tipo){
            case EDUCACAO -> new GastoEducacao(id, CNPJ, descricao, valor, adicional);
            case SAUDE -> new GastoSaude(id, CNPJ, descricao, valor, adicional);
        };

        declaracao.addGasto(gasto);
        repo.atualizar(declaracao);
    }
}
