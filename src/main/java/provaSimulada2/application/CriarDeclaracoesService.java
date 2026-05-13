package provaSimulada2.application;

import provaSimulada2.domain.Declaracao;
import provaSimulada2.domain.DeclaracaoCompleta;
import provaSimulada2.domain.DeclaracaoSimplificada;
import provaSimulada2.domain.FakeDeclaracaoRepository;
import provaSimulada2.persistence.GenericDAO;

public class CriarDeclaracoesService {
    private final GenericDAO<Long, Declaracao> repo;

    public CriarDeclaracoesService(GenericDAO<Long, Declaracao> repo) {
        this.repo = repo;
    }

    public void criarDeclaracoes(double ganhoTributavel, double valorPago){
        if(ganhoTributavel < 0) throw new IllegalArgumentException("Renda tributável inválida" + ganhoTributavel);
        if(valorPago < 0) throw new IllegalArgumentException("Valor pago inválido" + valorPago);

        final DeclaracaoCompleta declaracaoCompleta = new DeclaracaoCompleta(1, ganhoTributavel, valorPago);
        final DeclaracaoSimplificada declaracaoSimplificada = new DeclaracaoSimplificada(2, ganhoTributavel, valorPago);

        repo.salvar(declaracaoCompleta);
        repo.salvar(declaracaoSimplificada);
    }
}
