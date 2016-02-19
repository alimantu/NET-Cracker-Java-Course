package edu.salynskii.test;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import ru.ncedu.java.tasks.XPathCallerImpl;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.Arrays;

/**
 * Created by Alimantu on 14/11/15.
 */
public class XPathCallerImplTest {

    public static void main(String[] args) {
        XPathCallerImpl xPathCaller = new XPathCallerImpl();
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory
                .newInstance();
        Document documentEmp = null;
        Document documentEmpHier = null;
        try {
            DocumentBuilder documentBuilder = builderFactory.newDocumentBuilder();
            documentEmp = documentBuilder.parse("files/emp.xml");
            documentEmpHier = documentBuilder.parse("files/emp-hier.xml");
        } catch (ParserConfigurationException
                | SAXException
                | IOException e) {
            e.printStackTrace();
        }

        // test getEmployees
        System.out.println();
        System.out.println("Test getEmployees");
        System.out.println(Arrays.toString(
                xPathCaller.getEmployees(documentEmp, "10", "emp")));
        System.out.println();
        System.out.println(Arrays.toString(
                xPathCaller.getEmployees(documentEmpHier, "10", "emp-hier")));

        // test getHighestPayed
        System.out.println();
        System.out.println("Test getHighestPayed");
        System.out.println(
                xPathCaller.getHighestPayed(documentEmp, "emp"));
        System.out.println(
                xPathCaller.getHighestPayed(documentEmpHier, "emp-hier"));

        // test getHighestPayed
        System.out.println();
        System.out.println("Test getHighestPayed");
        System.out.println(
                xPathCaller.getHighestPayed(documentEmp, "30", "emp"));
        System.out.println(
                xPathCaller.getHighestPayed(documentEmpHier, "30", "emp-hier"));

        // test getTopManagment
        System.out.println();
        System.out.println("Test getTopManagment");
        System.out.println(Arrays.toString(
                xPathCaller.getTopManagement(documentEmp, "emp")));
        System.out.println();
        System.out.println(Arrays.toString(
                xPathCaller.getTopManagement(documentEmpHier, "emp-hier")));

        // test getOrdinaryEmployees
        System.out.println();
        System.out.println("Test getOrdinaryEmployees");
        System.out.println(Arrays.toString(
                xPathCaller.getOrdinaryEmployees(documentEmp, "emp")));
        System.out.println();
        System.out.println(Arrays.toString(
                xPathCaller.getOrdinaryEmployees(documentEmpHier, "emp-hier")));

        // test getCoworkers
        System.out.println();
        System.out.println("Test getCoworkers");
        System.out.println(Arrays.toString(
                xPathCaller.getCoworkers(documentEmp, "7499", "emp")));
        System.out.println();
        System.out.println(Arrays.toString(
                xPathCaller.getCoworkers(documentEmpHier, "7499", "emp-hier")));

    }
}
