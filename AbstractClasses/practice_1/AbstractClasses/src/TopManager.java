public class TopManager implements Employee {

    private final double salary;
    private static final double SALARY_COEFF = 1.5;

    public TopManager(double salary, Company company) {
        this.salary = salary + (company.getTotalIncome() > 10_000_000 ? salary * SALARY_COEFF : 0);
    }

    @Override
    public double getMonthSalary() {
        return Math.round(salary);
    }
}
