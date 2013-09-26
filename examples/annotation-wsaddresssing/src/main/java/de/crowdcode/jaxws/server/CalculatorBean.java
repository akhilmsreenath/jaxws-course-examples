package de.crowdcode.jaxws.server;

import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.Action;
import javax.xml.ws.FaultAction;
import javax.xml.ws.soap.Addressing;

@Addressing(required = true)
@WebService
public class CalculatorBean implements Calculator{

    @Action(input = "http://crowdcode.de/calculate/sumInput", output = "http://crowdcode.de/calculate/sumOuput", fault = @FaultAction(className = CalculatorException.class, value = "http://crowdcode.de/calculate/sumFault"))
    public Integer sum(@WebParam(name="number") Integer... numbers) throws CalculatorException {
        int result = 0;
        for (Integer value : numbers)
            if (value != null)
                result += value;
        return result;
    }

    @Action(input = "http://crowdcode.de/calculate/divInput", output = "http://crowdcode.de/calculate/divOuput", fault = @FaultAction(className = CalculatorException.class, value = "http://crowdcode.de/calculate/divFault"))
    public Double div(@WebParam(name="dividend") Double a, @WebParam(name="divisor") Double b) throws CalculatorException {
        if (b == 0.0)
            throw new CalculatorException("Numbers cannot be divided!", "Numbers: " + a + ", " + b);

        return a / b;
    }

}
