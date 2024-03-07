import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Company company = new Company();
        company.setTotalIncome(34_450_000);
        ArrayList<Employee> employeesList = new ArrayList<>();

        int numberOfOperators = 180;
        int numberOfManagers = 80;
        int numberOfTopManagers = 10;

        for (int i = 0; i < numberOfManagers; i++) {
            double salary = 90000;
            employeesList.add(new Manager(salary));
        }

        for (int i = 0; i < numberOfTopManagers; i++) {
            double salary = 110000;
            employeesList.add(new TopManager(salary, company));
        }

        for (int i = 0; i < numberOfOperators; i++) {
            double salary = 80000;
            employeesList.add(new Operator(salary));
        }

        company.hireAll(employeesList);

        System.out.println("Список зарплат по убыванию:");
        company.getTopSalaryStaff(12);
        System.out.println("Список зарплат по возрастанию");
        company.getLowerSalaryStaff(30);

        for (int i = 0; i < employeesList.size() / 2; i++) {
            company.fire(employeesList.get(i * 2));
        }

        System.out.println("После увольнения половины сотрудников:");
        System.out.println("Список зарплат по убыванию:");
        company.getTopSalaryStaff(12);
        System.out.println("Список зарплат по возрастанию:");
        company.getLowerSalaryStaff(30);

        System.out.println("Прибыль компании:");
        System.out.println(company.getIncome() + " руб");
    }
}