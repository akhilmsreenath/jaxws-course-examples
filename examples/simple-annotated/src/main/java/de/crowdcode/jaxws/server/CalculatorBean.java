package de.crowdcode.jaxws.server;

import javax.jws.WebService;

@WebService(targetNamespace="http://crowdcode.de/jaxws",
    endpointInterface = "de.crowdcode.jaxws.server.Calculator", 
    serviceName="CalculatorService")
public class CalculatorBean implements Calculator {

    @Override
    public Integer sum(Integer... numbers) throws CalculatorException {
        int result = 0;
        for (Integer value : numbers)
            if (value != null)
                result += value;
        return result;
    }

    @Override
    public Double div(Double a, Double b) throws CalculatorException {
        if (b == 0.0)
            throw new CalculatorException("Numbers cannot be divided!", "Numbers: " + a + ", " + b);

        return a / b;
    }

}
