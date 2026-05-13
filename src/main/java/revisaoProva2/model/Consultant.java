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
        subordinates.stream().mapToDouble(e -> e.getSoldValue() * 0.30).sum();
        return 0.15 * getSoldValue() + subordinates.stream().mapToDouble(e -> e.getSoldValue() * 0.30).sum();
    }

    public Set<Employee> getEmployees() {
        return subordinates;
    }

    public void addEmployee(Employee e ){
        subordinates.remove(e);
        subordinates.add(e);
    }

    @Override
    public String toString() {
        return "Consultant{" +
                "subordinates=" + subordinates +
                "} " + super.toString();
    }
}
