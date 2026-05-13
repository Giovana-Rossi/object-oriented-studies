package provaSimulada2.domain.provaSimulada2.domain;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

public class FakeDeclaracaoRepository {

    private static final Map<Long, Declaracao> db = new LinkedHashMap<>();

    public void salvar(Declaracao declaracao){
        final long id = declaracao.getId();
        if(db.containsKey(id))
            throw new EntityAlreadyExistsException("Entidade já cadastrada" + id);
        db.put(id, declaracao);
    }

    public void atualizar(Declaracao declaracao){
        final long id = declaracao.getId();
        if(!db.containsKey(id)) throw new NoSuchElementException("Entidade não cadastrada" + id);
        db.replace(id, declaracao);
    }

    public void remover(Declaracao declaracao){
        remover(declaracao.getId());
    }

    public void remover(long id){
        if(!db.containsKey(id)) throw new NoSuchElementException("Entidade não cadastrada" + id);
        db.remove(id);
    }

    public Optional<Declaracao> buscarPorId(long id){
        return Optional.ofNullable(db.get(id));
    }
}
