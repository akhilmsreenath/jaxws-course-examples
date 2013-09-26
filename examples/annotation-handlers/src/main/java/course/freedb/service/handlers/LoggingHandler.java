package course.freedb.service.handlers;

import java.io.PrintStream;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

public class LoggingHandler implements SOAPHandler<SOAPMessageContext> {
    
    private static PrintStream out = System.out;
    
    public Set<QName> getHeaders() {
        return null;
    }
    
    public boolean handleMessage(SOAPMessageContext smc) {
        logToSystemOut(smc);
        return true;
    }
    
    public boolean handleFault(SOAPMessageContext smc) {
        logToSystemOut(smc);
        return true;
    }
    
    public void close(MessageContext messageContext) {
    }
    
    private void logToSystemOut(SOAPMessageContext smc) {
        Boolean outboundProperty = (Boolean)
            smc.get (MessageContext.MESSAGE_OUTBOUND_PROPERTY);
        
        if (outboundProperty.booleanValue()) {
            out.println("\nHandler Log -> Outbound message:");
        } else {
            out.println("\nHandler Log -> Inbound message:");
        }
    }
}
