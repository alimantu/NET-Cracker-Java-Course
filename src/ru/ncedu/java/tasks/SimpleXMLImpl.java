package ru.ncedu.java.tasks;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.Attributes;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alimantu on 12/11/15.
 */
public class SimpleXMLImpl implements SimpleXML {
    @Override
    public String createXML(String tagName, String textNode) {
        String stringResult = null;
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = factory.newDocumentBuilder();
            Document document = documentBuilder.newDocument();
            Element root = document.createElement(tagName);
            root.appendChild(document.createTextNode(textNode));
            document.appendChild(root);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
            StringWriter writer = new StringWriter();
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(writer);
            transformer.transform(source, result);
            stringResult = writer.toString();
        } catch (ParserConfigurationException | TransformerException e) {
            e.printStackTrace();
        }
        return stringResult;
    }

    @Override
    public String parseRootElement(InputStream xmlStream) throws SAXException {
        String res = null;

        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        saxParserFactory.setValidating(true);
        try {
            SAXParser parser = saxParserFactory.newSAXParser();
            InputSource source = new InputSource(xmlStream);
            MyHandler handler = new MyHandler();

            parser.parse(source, handler);
            res = handler.getRoot();
        } catch (ParserConfigurationException | IOException e) {
            e.printStackTrace();
        }
        return res;
    }

    public class MyHandler extends DefaultHandler{
        private List<String> tagNames;

        MyHandler() {
            tagNames = new ArrayList<>();
        }

        @Override
        public void startElement (String uri, String localName,
                                  String qName, Attributes attributes)
                throws SAXException {
            tagNames.add(qName);
        }

        public String getRoot() {
            return !tagNames.isEmpty() ? tagNames.get(0) : null;
        }
    }
}
