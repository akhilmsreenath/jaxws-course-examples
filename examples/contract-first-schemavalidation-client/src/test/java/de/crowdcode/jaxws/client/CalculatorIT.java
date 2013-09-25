package de.crowdcode.jaxws.client;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class CalculatorIT {

    private Calculator calculator;
    
    @Before
    public void before()
    {
        calculator = new CaluclatorService().getCalculatorPort();
    }
    
    @Test
    public void testCalculator() throws CalculatorExceptionException
    {
        assertEquals(21, (int) calculator.sum(Arrays.asList(1,2,3,4,5,6)));
    }
    

}