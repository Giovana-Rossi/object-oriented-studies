package provaSimulada2;

import provaSimulada2.application.*;
import provaSimulada2.domain.Declaracao;
import provaSimulada2.domain.FakeDeclaracaoRepository;
import provaSimulada2.persistence.GenericDAO;

public class Main {
    void main(){
        GenericDAO<Long, Declaracao> repo = new GenericDAO<Long, Declaracao>();
        final AdicionarGastoTributavelService addGastoService = new AdicionarGastoTributavelService(repo);
        final CriarDeclaracoesService criarDeclaracoesService = new CriarDeclaracoesService(repo);
        final CriaRelatorioDeclaracoes criaRelatorioDeclaracoes = new CriaRelatorioDeclaracoes(repo);

        criarDeclaracoesService.criarDeclaracoes(50_000.0, 5_000.0);

        addGastoService.adicionarGasto(1, "Corote", "123", 3.59, TipoGasto.EDUCACAO, "IFSP");
        addGastoService.adicionarGasto(2, "UNIMED", "321", 1000.0, TipoGasto.SAUDE, "12321");

        System.out.printf(criaRelatorioDeclaracoes.criaRelatorio());
    }
}
