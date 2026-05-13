package revisaoProva2.persistence;

import revisaoProva2.exception.EntityAlreadyExistsException;
import revisaoProva2.model.Employee;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

public class InMemoryEmployeeRepository implements Repository <String, Employee>{
    private static final Map<String, Employee> db = new LinkedHashMap<>();

    @Override
    public void save(Employee e) {
        String id = e.getId();
        if(db.containsKey(id))
            throw new EntityAlreadyExistsException("Entidade já cadastrada: " + id);
        db.put(id, e);
    }

    @Override
    public void update(Employee e) {
        String id = e.getId();
        if(!db.containsKey(id))
            throw new NoSuchElementException("Entidade não cadastrada");
        db.replace(id, e);
    }

    @Override
    public Optional<Employee> findById(String id) {
        return Optional.ofNullable(db.get(id));
    }
}