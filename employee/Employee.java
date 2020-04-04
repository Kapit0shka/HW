package horstmann3chapter.employee;

import horstmann3chapter.measurable.Measurable;

public class Employee implements Measurable {
    public int salary;

    public Employee(int salary) {
        this.salary = salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public double getMeasurable() {
        return this.salary;
    }
}
