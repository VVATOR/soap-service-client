package by.epamlab.ws.service.exception;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NegativeSumException", propOrder = { "message" })
public class NegativeSumException {
	protected String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String value) {
		this.message = value;
	}
}
