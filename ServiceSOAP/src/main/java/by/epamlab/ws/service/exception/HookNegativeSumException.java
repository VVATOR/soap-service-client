package by.epamlab.ws.service.exception;

import javax.xml.ws.WebFault;

@WebFault(name="NegativeSumException",
targetNamespace="http://www.example.com")
public class HookNegativeSumException extends Exception {
	private static final long serialVersionUID = 1L;

	public static final String TEXT_NEGATIVE_SUM_EXCEPTION="Negative sum statistic...";

	private NegativeSumException info;

    public HookNegativeSumException(String message, NegativeSumException faultInfo) {
        super(message);
        this.info = faultInfo;
    }

    public HookNegativeSumException(String message, NegativeSumException faultInfo, 
           Throwable cause) {
        super(message, cause);
        this.info = faultInfo;
    }

    public HookNegativeSumException() {
		super(TEXT_NEGATIVE_SUM_EXCEPTION) ;
	}

	public NegativeSumException getFaultInfo() {
        return this.info;
    }
	@Override
	public String toString() {
		return "ExceptionNegativeSumException [getMessage()=" + getMessage() + "]";
	}

}
