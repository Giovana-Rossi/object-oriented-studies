package provaSimulada2.application;

import provaSimulada2.domain.Declaracao;
import provaSimulada2.domain.EntityAlreadyExistsException;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

public interface DeclaracaoRepository {
    void salvar(Declaracao declaracao);

    void atualizar(Declaracao declaracao);

    void remover(Declaracao declaracao);

    void remover(long id);

    Optional<Declaracao> buscarPorId(long id);
}
