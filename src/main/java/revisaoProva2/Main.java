package revisaoProva2;

import revisaoProva2.model.Consultant;
import revisaoProva2.model.Employee;
import revisaoProva2.persistence.InMemoryEmployeeRepository;
import revisaoProva2.persistence.Repository;
import revisaoProva2.service.EmployeeRegistrationService;
import revisaoProva2.service.EmployeeReportService;

import java.time.LocalDate;

public class Main {
    void main(){
        Repository<String, Employee> repo = new InMemoryEmployeeRepository();

        EmployeeRegistrationService employeeRegistrationService = new EmployeeRegistrationService(repo);
        EmployeeReportService employeeReportService = new EmployeeReportService(repo);

        Employee e1 = new Consultant("12312312312", "David A. Huffman",
                LocalDate.parse("1925-08-09"), 7000.0, null);
        repo.save(e1);
        employeeRegistrationService.register( "32132132131", "Augusta Ada Byron", LocalDate.parse("1852-11-27"), 3000.0, "12312312312");
        employeeRegistrationService.register("21321321313", "Edsger Wybe Dijkstra", LocalDate.parse("1930-05-11"), 1520.0, "12312312312");
        employeeRegistrationService.register("45645645646", "Alan Mathison Turing", LocalDate.parse("1912-06-23"), 780.0, "32132132131");
        employeeRegistrationService.register("90219021902", "Donald Ervin Knuth", LocalDate.parse("1938-01-10"), 432.0, "45645645646");
        employeeRegistrationService.register("54654654654", "Grace Murray Hopper", LocalDate.parse("1906-12-09"), 432.0, "21321321313");
        employeeRegistrationService.register("65465465464", "John von Neumann", LocalDate.parse("1903-12-28"), 300.00, "45645645646");

        System.out.println(employeeReportService.reportOf("12312312312"));
    }
}
