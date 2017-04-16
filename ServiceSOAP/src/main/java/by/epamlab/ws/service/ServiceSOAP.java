package by.epamlab.ws.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import by.epamlab.ws.service.exception.HookNegativeSumException;
import net.webservicex.ArrayOfDouble;

@WebService
public interface ServiceSOAP {

	@WebMethod
	public double getSums(@WebParam(name = "arrayOfDouble") ArrayOfDouble arrayOfDouble)
			throws HookNegativeSumException;

	@WebMethod
	public double getAverage(@WebParam(name = "arrayOfDouble") ArrayOfDouble arrayOfDouble)
			throws HookNegativeSumException;

	@WebMethod
	public double getStandardDeviation(@WebParam(name = "arrayOfDouble") ArrayOfDouble arrayOfDouble)
			throws HookNegativeSumException;

	@WebMethod
	public double getSkewness(@WebParam(name = "arrayOfDouble") ArrayOfDouble arrayOfDouble)
			throws HookNegativeSumException;

	@WebMethod
	public double getKurtosis(@WebParam(name = "arrayOfDouble") ArrayOfDouble arrayOfDouble)
			throws HookNegativeSumException;

}
