package edu.salynskii.test;

import ru.ncedu.java.tasks.Employee;
import ru.ncedu.java.tasks.EmployeeImpl;

/**
 * Created by Alimantu on 22/10/15.
 */
public class TestEmployeeImpl {
    public static void main(String[] args) {
        Employee employee = new EmployeeImpl();
        employee.increaseSalary(100);
        employee.setFirstName("Aren");
        employee.setLastName("Arenovich");
        Employee employee1 = new EmployeeImpl();
        employee1.setFirstName("Vasya");
        employee1.setLastName("Vasiliev");
        employee1.increaseSalary(1000000);
        employee1.setManager(employee);
        Employee employee2 = new EmployeeImpl();
        employee2.setFirstName("Vasya");
        employee2.setLastName("Vasin");
        employee2.increaseSalary(2000000);
        employee.setManager(employee2);
        System.out.println(employee.getFirstName());
        System.out.println(employee.getLastName());
        System.out.println(employee.getFullName());
        System.out.println(employee.getSalary());
        System.out.println(employee1.getManagerName());
        System.out.println(employee1.getTopManager().getFullName());
    }
}
