public class Manager implements Employee {

    private final double salary;
    private static final double SALARY_COEFF = 0.05;

    public Manager(double salary) {
        this.salary = salary + SALARY_COEFF * (115000 + Math.round(Math.random() * 25000));
    }

    @Override
    public double getMonthSalary() {
        return Math.round(salary);
    }
}
