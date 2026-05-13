package provaSimulada2.domain.provaSimulada2;

import provaSimulada2.domain.provaSimulada2.application.AdicionarGastoTributavelService;
import provaSimulada2.domain.provaSimulada2.application.CriaRelatorioDeclaracoes;
import provaSimulada2.domain.provaSimulada2.application.CriarDeclaracoesService;
import provaSimulada2.domain.provaSimulada2.application.TipoGasto;

public class Main {
    void main(){
        final AdicionarGastoTributavelService addGastoService = new AdicionarGastoTributavelService();
        final CriarDeclaracoesService criarDeclaracoesService = new CriarDeclaracoesService();
        final CriaRelatorioDeclaracoes criaRelatorioDeclaracoes = new CriaRelatorioDeclaracoes();

        criarDeclaracoesService.criarDeclaracoes(50_000.0, 5_000.0);

        addGastoService.adicionarGasto(1, "Corote", "123", 3.59, TipoGasto.EDUCACAO, "IFSP");
        addGastoService.adicionarGasto(2, "UNIMED", "321", 1000.0, TipoGasto.SAUDE, "12321");

        System.out.printf(criaRelatorioDeclaracoes.criaRelatorio());
    }
}
