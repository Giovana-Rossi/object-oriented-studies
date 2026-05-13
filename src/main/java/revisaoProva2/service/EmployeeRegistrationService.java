package revisaoProva2.service;

import revisaoProva2.model.Consultant;
import revisaoProva2.model.Employee;
import revisaoProva2.model.Reseller;
import revisaoProva2.persistence.InMemoryEmployeeRepository;
import revisaoProva2.persistence.Repository;

import java.time.LocalDate;

public class EmployeeRegistrationService {
    private Repository<String, Employee> repo;

    public EmployeeRegistrationService(Repository<String, Employee> repo) {
        this.repo = repo;
    }

    public void register(String id, String name, LocalDate birthDate, double soldValue, String idEmployee) {
        Employee responsible = repo.findById(idEmployee)
                .orElseThrow(() -> new IllegalArgumentException("Erro: empregado responsavel não localizado"));

        Consultant consultantResponsible;
        if (responsible instanceof Reseller) {
                    consultantResponsible = new Consultant(responsible.getId(),
                    responsible.getName(),
                    responsible.getBirthDate(),
                    responsible.getSoldValue(),
                    null);
            repo.update(consultantResponsible);

        }
        else consultantResponsible = (Consultant) responsible;

        Reseller newReseller = new Reseller(id,name,birthDate,soldValue, consultantResponsible);
        repo.save(newReseller);

        consultantResponsible.addEmployee(newReseller);

        repo.update(consultantResponsible);
    }
}
