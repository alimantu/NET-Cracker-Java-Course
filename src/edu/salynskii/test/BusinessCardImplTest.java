package edu.salynskii.test;

import ru.ncedu.java.tasks.BusinessCard;
import ru.ncedu.java.tasks.BusinessCardImpl;

import java.util.Scanner;

/**
 * Created by Alimantu on 05/11/15.
 */
public class BusinessCardImplTest {

    public static void main(String[] args) {
        BusinessCard card = new BusinessCardImpl();
        card = card.getBusinessCard(new Scanner(System.in));

        System.out.println(card.getEmployee());
        System.out.println(card.getDepartment());
        System.out.println(card.getSalary());
        System.out.println(card.getAge());
        System.out.println(card.getGender());
        System.out.println(card.getPhoneNumber());
    }
}
