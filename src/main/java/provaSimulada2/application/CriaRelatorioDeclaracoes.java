package provaSimulada2.application;

import provaSimulada2.domain.Declaracao;
import provaSimulada2.domain.FakeDeclaracaoRepository;
import provaSimulada2.persistence.GenericDAO;

public class CriaRelatorioDeclaracoes {
    private GenericDAO<Long, Declaracao> repo;

    public CriaRelatorioDeclaracoes(GenericDAO<Long, Declaracao> repo) {
        this.repo = repo;
    }

    public String criaRelatorio(){

        final Declaracao completa = repo.buscarPorId(1).orElseThrow(IllegalStateException::new);
        final Declaracao simplificada = repo.buscarPorId(2).orElseThrow(IllegalStateException::new);
        return simplificada.toString() + "\n\n" + completa.toString();
    }
}
