package de.crowdcode.jaxws.server;

public class CalculatorException extends Exception {
    private static final long serialVersionUID = 1L;

    private String info;

    public CalculatorException(String message, String detail) {
      super(message);
        this.info = detail;
    }

    public String getFaultInfo() {
        return info;
    }
}
