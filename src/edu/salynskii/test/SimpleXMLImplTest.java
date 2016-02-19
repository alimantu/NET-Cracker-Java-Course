package edu.salynskii.test;

import org.xml.sax.SAXException;
import ru.ncedu.java.tasks.SimpleXMLImpl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by Alimantu on 12/11/15.
 */
public class SimpleXMLImplTest {

    public static void main(String[] args) throws FileNotFoundException, SAXException {
        SimpleXMLImpl simpleXML = new SimpleXMLImpl();

        // createXML test
        System.out.println(simpleXML.createXML("root", "<R&D>"));

        //
        System.out.println(simpleXML.parseRootElement(new FileInputStream("files/test.xml")));
    }
}
