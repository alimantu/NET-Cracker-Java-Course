package ru.ncedu.java.tasks;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Alimantu on 05/11/15.
 */
public class BusinessCardImpl implements BusinessCard {
    private String name;
    private String lastName;
    private String department;
    private long age;
    private String gender;
    private int salary;
    private String phoneNumber = "+7 ";

    @Override
    public BusinessCard getBusinessCard(Scanner scanner) {
        List<String> values = new LinkedList<String>(
                Arrays.asList(scanner.nextLine().split(";"))
        );
        if (values.size() != 7) {
            throw new NoSuchElementException();
        }
        name = values.get(0);
        lastName = values.get(1);
        department = values.get(2);
        try {
            Date date = new SimpleDateFormat("dd-MM-yyyy")
                    .parse(values.get(3));
            age = (System.currentTimeMillis() - date.getTime())
                    / 1000 / 60 / 60 / 24 / 365;
            // WTF? But if you'll try to div with (1000 * 60 * 60 * 24 * 365)
            // you'll get unreal result (1620 instead of 75 for example)
            if (!values.get(4).equals("F") && !values.get(4).equals("M")
                    || (salary = Integer.parseInt(values.get(5))) < 100
                    || salary > 100000
                    || values.get(6).length() != 10) {
                throw new InputMismatchException();
            }
        } catch (NumberFormatException
                | ParseException e) {
            throw new InputMismatchException();
        }
        gender = values.get(4).equals("F") ? "Female" : "Male";
        String tmp = values.get(6);
        phoneNumber += tmp.substring(0, 3) + "-"
                + tmp.substring(3, 6) + "-"
                + tmp.substring(6, 8) + "-"
                + tmp.substring(8);
        return this;
    }

    @Override
    public String getEmployee() {
        return name + " " + lastName;
    }

    @Override
    public String getDepartment() {
        return department;
    }

    @Override
    public int getSalary() {
        return salary;
    }

    @Override
    public int getAge() {
        return (int) age;
    }

    @Override
    public String getGender() {
        return gender;
    }

    @Override
    public String getPhoneNumber() {
        return phoneNumber;
    }
}
