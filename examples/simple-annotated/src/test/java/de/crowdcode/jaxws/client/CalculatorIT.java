package de.crowdcode.jaxws.client;

import static org.junit.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import de.crowdcode.jaxws.client.stub.Calculator;
import de.crowdcode.jaxws.client.stub.CalculatorException_Exception;
import de.crowdcode.jaxws.client.stub.CalculatorService;

public class CalculatorIT {
    
    private Calculator calculator;

    @Before
    public void before() throws MalformedURLException
    {
        URL wsdlLocation = new URL("http://localhost:8080/simple-annotated/calculator?wsdl");
        // QName qnameService = new QName("http://crowdcode.de/jaxws", "CalculatorService");
        // QName qnamePort = new QName("http://crowdcode.de/jaxws", "CalculatorBeanPort");

        // calculator = new CalculatorService(wsdlLocation,
        // qnameService).getPort(qnamePort,Calculator.class);
        calculator = new CalculatorService(wsdlLocation).getCalculatorBeanPort();
    }
    
    @Test
    public void testSummary() throws CalculatorException_Exception
    {
        int sum = calculator.sum(Arrays.asList(1,2,3,4,5,6));
        assertEquals(1+2+3+4+5+6, sum);
    }

    @Test(expected=CalculatorException_Exception.class)
    public void testDivide() throws CalculatorException_Exception
    {
        calculator.divide(0.0, 0.0);
    }
    
}