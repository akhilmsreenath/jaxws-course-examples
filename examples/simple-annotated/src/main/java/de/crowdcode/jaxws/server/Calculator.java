package de.crowdcode.jaxws.server;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService(targetNamespace = "http://crowdcode.de/jaxws", name="Calculator")
@SOAPBinding(style=Style.DOCUMENT, use=SOAPBinding.Use.LITERAL)
public interface Calculator {
    
    @WebMethod(operationName="sum", action="urn:sumNumbers")
    @WebResult(name="return")
    public Integer sum(@WebParam(name="value") Integer... numbers) throws CalculatorException;
    
    @WebMethod(operationName="divide", action="urn:divideNumbers")
    @WebResult(name="result")
    public Double div(@WebParam(name="dividend") Double a, @WebParam(name="divisor") Double b) throws CalculatorException;

}
