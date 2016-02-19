package ru.ncedu.java.tasks;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.xpath.*;

/**
 * Created by Alimantu on 13/11/15.
 */
public class XPathCallerImpl implements XPathCaller {

    @Override
    public Element[] getEmployees(Document src, String deptno, String docType) {
        String pattern = getPatternPrefix(docType)
                + "[@deptno='" + deptno + "']";
        return getElementsByNodeList(getNodeList(src, pattern));
    }

    private NodeList getNodeList(Document src, String pattern) {
        XPath xPath = XPathFactory.newInstance().newXPath();
        NodeList nodeList = null;
        try {
            XPathExpression expression = xPath.compile(pattern);
            nodeList = (NodeList) expression.evaluate(src, XPathConstants.NODESET);
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
        return nodeList;
    }

    private String getPatternPrefix(String docType) {
        return docType.equals("emp")
                ? "/content/emp/employee"
                : "//employee";
    }

    private void printNodes(XPath xPath, NodeList nodeList) {
        for (int i = 0; i < nodeList.getLength(); i++) {
            try {
                System.out.println("EName: " +
                        xPath.compile("./ename").evaluate(nodeList.item(i)));
            } catch (XPathExpressionException e) {
                e.printStackTrace();
            }
        }
    }

    private Element[] getElementsByNodeList(NodeList nodeList) {
        Element[] elements = new Element[nodeList.getLength()];
        for (int i = 0; i < nodeList.getLength(); i++) {
            elements[i] = (Element) nodeList.item(i);
        }
        return elements;
    }

    @Override
    public String getHighestPayed(Document src, String docType) {
        String pattern = getPatternPrefix(docType);
        return getHighestPayed(getNodeList(src, pattern));
    }

    private String getHighestPayed(NodeList nodeList) {
        XPath xPath = XPathFactory.newInstance().newXPath();
        int max = 0;
        int maxInd = 0;
        String eName = null;
        try {
            for (int i = 0; i < nodeList.getLength(); i++) {
                    int salary = ((Number) xPath.evaluate("./sal",
                            nodeList.item(i), XPathConstants.NUMBER)).intValue()
                            + ((Number) xPath.evaluate("./sal",
                            nodeList.item(i), XPathConstants.NUMBER)).intValue();
                    if (salary > max) {
                        max = salary;
                        maxInd = i;
                    }
            }
            eName = (String) xPath.evaluate("./ename",
                    nodeList.item(maxInd), XPathConstants.STRING);
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
        return eName;
    }

    @Override
    public String getHighestPayed(Document src, String deptno, String docType) {
        String pattern = getPatternPrefix(docType)
                + "[@deptno='" + deptno + "']";
        return getHighestPayed(getNodeList(src, pattern));
    }

    @Override
    public Element[] getTopManagement(Document src, String docType) {
        String pattern = docType.equals("emp")
                ? "/content/emp/employee[not(@mgr)]"
                : "/employee";
        return getElementsByNodeList(getNodeList(src, pattern));
    }

    @Override
    public Element[] getOrdinaryEmployees(Document src, String docType) {
        String pattern = docType.equals("emp")
                ? "/content/emp/employee[not(@empno = (/content/emp/employee/@mgr))]"
                : "//employee[not(./employee)]";
        return getElementsByNodeList(getNodeList(src, pattern));
    }

    @Override
    public Element[] getCoworkers(Document src, String empno, String docType) {
        String pattern = docType.equals("emp")
                ? "/content/emp/employee[" +
                "not(@empno='" + empno + "') " +
                "and @mgr = (/content/emp/employee[@empno='" + empno + "']/@mgr)" +
                "]"
                : "//employee[@empno='" + empno + "']" +
                "/../" +
                "employee[not(@empno='" + empno + "')]";
        return getElementsByNodeList(getNodeList(src, pattern));
    }
}
