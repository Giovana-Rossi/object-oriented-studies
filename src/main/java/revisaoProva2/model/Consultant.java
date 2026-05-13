package revisaoProva2.model;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

public final class Consultant extends Employee {

    private Set<Employee> subordinates = new LinkedHashSet<>();

    public Consultant(String id, String name, LocalDate birthDate, double soldValue, Consultant consultantInCharge) {
        super(id, name, birthDate, soldValue, consultantInCharge);
    }

    @Override
    public double getComission() {
        return 0.15 * getSoldValue() + subordinates.stream().mapToDouble(e -> e.getComission() * 0.30).sum();
    }

    public Set<Employee> getEmployees() {
        return subordinates;
    }

    public void addEmployee(Employee e ){
        subordinates.removeIf(sub -> sub.getId().equals(e.getId()));
        subordinates.add(e);
    }

}
