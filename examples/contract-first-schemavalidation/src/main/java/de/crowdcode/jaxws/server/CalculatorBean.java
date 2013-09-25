package de.crowdcode.jaxws.server;

import java.util.List;

import javax.jws.WebService;

import com.sun.xml.ws.developer.SchemaValidation;

@WebService(endpointInterface = "de.crowdcode.jaxws.server.Calculator")
@SchemaValidation(handler=RelaxValidationErrorHandler.class)
public class CalculatorBean implements Calculator{

    public Integer sum(List<Integer> numbers) {
        int result = 0;
        for (Integer value : numbers)
            if (value != null)
                result += value;
        return result;
    }

    public Double divide(Double a, Double b) throws CalculatorException_Exception {
        if (b == 0.0) {
            CalculatorException fault = new CalculatorException();
            String msg = "Numbers cannot be divided!";
            fault.setMessage(msg);
            fault.setFaultInfo("Numbers: " + a + ", " + b);
            throw new CalculatorException_Exception(msg, fault);
        }

        return a / b;
    }

}
