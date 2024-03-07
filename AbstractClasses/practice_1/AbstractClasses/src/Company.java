import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Company {

    ArrayList<Employee> employees = new ArrayList<>();
    private double totalIncome;

    public void setTotalIncome(double totalIncome) {
        this.totalIncome = totalIncome;
    }

    public double getTotalIncome() {
        return Math.round(totalIncome);
    }

    public void hire(Employee employee) {
        employees.add(employee);
    }

    public void hireAll(Collection<Employee> newEmployees) {
        employees.addAll(newEmployees);
    }


    public void fire(Employee employee) {
        employees.remove(employee);
    }

    public double getIncome() {
        double income = totalIncome;
        for(Employee employee : employees) {
            income -= employee.getMonthSalary();
        }
        return Math.round(income);
    }

    public List<Employee> getTopSalaryStaff(int count) {
        Collections.sort(employees, new SalaryComparator());
        if (count >= 0) {
            for (int i = employees.size() - 1; i > Math.max(employees.size() - count - 1, 0); i--) {
                System.out.println((int ) (employees.get(i).getMonthSalary()) + " руб.");
            }
        }
        return employees;
    }

    public List<Employee> getLowerSalaryStaff(int count) {
        Collections.sort(employees, new SalaryComparator());
        if (count >= 0) {
            for (int i = 0; i < Math.min(employees.size(), count); i++) {
                System.out.println((int ) (employees.get(i).getMonthSalary()) + " руб.");
            }
        }
        return employees;
    }
}
