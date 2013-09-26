package course.freedb.service.handlers;

import java.util.Collections;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

public class SoapMessageHandler implements SOAPHandler<SOAPMessageContext>{

    @Override
    public boolean handleMessage(SOAPMessageContext context) {
        System.out.println("------ Handling Message -----");
        try {
            System.out.println("ContentDescription "+context.getMessage().getContentDescription());
            System.out.println("SOAPBody "+context.getMessage().getSOAPBody().getTextContent());
            context.getMessage().getSOAPBody().addNamespaceDeclaration("hello", "namespace" );
            context.getMessage().getSOAPBody().addChildElement("world", "hello").addTextNode("(c) Copyright by crowdcode");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean handleFault(SOAPMessageContext context) {
        System.out.println("------ Handling Fault -----");
        return true;
    }

    @Override
    public void close(MessageContext context) {
        System.out.println("------- Closing Message Context ----------");
    }

    @Override
    public Set<QName> getHeaders() {
        return Collections.emptySet();
    }


}
