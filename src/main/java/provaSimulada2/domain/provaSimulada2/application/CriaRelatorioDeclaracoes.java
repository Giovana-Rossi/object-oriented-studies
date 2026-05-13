package provaSimulada2.domain.provaSimulada2.application;

import provaSimulada2.domain.provaSimulada2.domain.Declaracao;
import provaSimulada2.domain.provaSimulada2.domain.FakeDeclaracaoRepository;

public class CriaRelatorioDeclaracoes {

    public String criaRelatorio(){
        final FakeDeclaracaoRepository repo = new FakeDeclaracaoRepository();
        final Declaracao completa = repo.buscarPorId(1).orElseThrow(IllegalStateException::new);
        final Declaracao simplificada = repo.buscarPorId(2).orElseThrow(IllegalStateException::new);
        return simplificada.toString() + "\n\n" + completa.toString();
    }
}
