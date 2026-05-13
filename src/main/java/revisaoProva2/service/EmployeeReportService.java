package revisaoProva2.service;

import revisaoProva2.model.Consultant;
import revisaoProva2.model.Employee;
import revisaoProva2.persistence.Repository;

import java.util.stream.Collectors;

public class EmployeeReportService {
    private Repository<String, Employee> repo;

    public EmployeeReportService(Repository<String, Employee> repo) {
        this.repo = repo;
    }

    public String reportOf(String id){
        Employee e = repo.findById(id).orElseThrow(()->  new IllegalArgumentException("Erro: não foi possivel localizar empregado"));
       if(e instanceof Consultant)
           return ((Consultant) e).getEmployees().stream().map((Employee::toString)).collect(Collectors.joining("\n"));
       return e.toString();
    }
}
