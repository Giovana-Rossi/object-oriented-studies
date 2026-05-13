package revisaoProva2.model;

import java.time.LocalDate;
import java.util.Objects;

public abstract sealed class Employee permits Consultant, Reseller {
    private String id;
    private String name;
    private LocalDate birthDate;
    private double soldValue;
    private Consultant consultantInCharge;

    public abstract double getComission();

    public Employee(String id, String name, LocalDate birthDate, double soldValue, Consultant consultantInCharge) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.soldValue = soldValue;
        this.consultantInCharge = consultantInCharge;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public double getSoldValue() {
        return soldValue;
    }

    public void setSoldValue(double soldValue) {
        this.soldValue = soldValue;
    }

    public Consultant getConsultantInCharge() {
        return consultantInCharge;
    }

    @Override
    public String toString() {
        return String.format("[%s] %s | Birthday: %s | Amount in Sales: %.2f | Comission: %.2f",
                id,name, birthDate, soldValue, getComission());
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Employee employee)) return false;
        return Objects.equals(id, employee.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
