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
       return buildPrint(e, "");
    }

    private String buildPrint(Employee e, String spaces){
        StringBuilder sb = new StringBuilder();
        sb.append(spaces).append(e.toString()).append("\n");

        if(e instanceof Consultant consultant)
            for (Employee subordinate : consultant.getEmployees() ) {
                sb.append(buildPrint(subordinate,spaces + "      "));
            }
        return sb.toString();
    }
}
