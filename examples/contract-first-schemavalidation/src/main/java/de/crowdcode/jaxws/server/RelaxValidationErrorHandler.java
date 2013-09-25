package de.crowdcode.jaxws.server;

import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import com.sun.xml.ws.developer.ValidationErrorHandler;

public class RelaxValidationErrorHandler extends ValidationErrorHandler{

    @Override
    public void warning(SAXParseException exception) throws SAXException {
        System.out.println(exception.getMessage());
        System.out.println("Found in "+exception.getLineNumber() +" "+exception.getColumnNumber());
    }

    @Override
    public void error(SAXParseException exception) throws SAXException {
        System.out.println(exception.getMessage());
        System.out.println("Found in "+exception.getLineNumber() +" "+exception.getColumnNumber());
    }

    @Override
    public void fatalError(SAXParseException exception) throws SAXException {
        System.out.println(exception.getMessage());
        System.out.println("Found in "+exception.getLineNumber() +" "+exception.getColumnNumber());
    }

    

}
