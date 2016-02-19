package ru.ncedu.java.tasks;

/**
 * Created by Alimantu on 22/10/15.
 */
public class EmployeeImpl implements Employee {
    private int salary;
    private String firstName;
    private String lastName;
    private Employee manager;

    public EmployeeImpl() {
        salary = 1000;
    }

    @Override
    public int getSalary() {
        return salary;
    }

    @Override
    public void increaseSalary(int value) {
        salary += value;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String getFullName() {
        return firstName + " " + lastName;
    }

    @Override
    public void setManager(Employee manager) {
        this.manager = manager;
    }

    @Override
    public String getManagerName() {
        if (manager != null) {
            return manager.getFullName();
        }
        return "No manager";
    }

    @Override
    public Employee getTopManager() {
        if (manager == null) {
            return this;
        }
        return manager.getTopManager();
    }
}
