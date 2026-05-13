package revisaoProva2.persistence;

import java.util.Optional;

public interface Repository <K,T> {
    void save(T type);

    void update(T type);

    Optional<T> findById(K key);
}

