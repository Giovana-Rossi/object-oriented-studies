package revisaoProva2.application;

import java.util.Optional;

public interface DeclaracaoRepository <K,T> {
    void save(T type);

    void update(T type);
    Optional<T> findById(K key);
}
