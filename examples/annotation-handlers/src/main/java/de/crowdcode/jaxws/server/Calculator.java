package de.crowdcode.jaxws.server;


public interface Calculator {
    
    public Integer sum(Integer... numbers) throws CalculatorException;
    
    public Double div(Double dividend, Double divisor) throws CalculatorException;

}
