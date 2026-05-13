package revisaoProva2.domain;

import java.time.LocalDate;

public final class Reseller extends Employee {
    public Reseller(String id, String name, LocalDate birthDate, double soldValue, Consultant consultantInCharge) {
        super(id, name, birthDate, soldValue, consultantInCharge);
    }

    @Override
    public double getComission() {
        return 0.15 * getSoldValue();
    }

    @Override
    public String toString() {
        return "Reseller{} " + super.toString();
    }
}
