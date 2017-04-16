package by.epamlab.ws.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.apache.log4j.Logger;

import by.epamlab.ws.service.client.OuterClient;
import by.epamlab.ws.service.exception.HookNegativeSumException;
import net.webservicex.ArrayOfDouble;
import net.webservicex.GetStatisticsResponse;

@WebService(endpointInterface = "by.epamlab.ws.service.ServiceSOAP")
public class ServiceSOAPImpl implements ServiceSOAP {
	private static final Logger LOG = Logger.getLogger(ServiceSOAPImpl.class);

	private OuterClient client = OuterClient.getInstance();

	public ServiceSOAPImpl() {
		super();
	}

	@WebMethod
	public double getSums(@WebParam(name = "arrayOfDouble") ArrayOfDouble arrayOfDouble) throws HookNegativeSumException {
		GetStatisticsResponse response = client.getStatisticResponse(arrayOfDouble);
		LOG.info("getSums");
		return response.getSums();
	}

	@WebMethod
	public double getAverage(@WebParam(name = "arrayOfDouble") ArrayOfDouble arrayOfDouble) throws HookNegativeSumException {
		GetStatisticsResponse response = client.getStatisticResponse(arrayOfDouble);
		LOG.info("getAverage");
		return response.getAverage();
	}

	@WebMethod
	public double getStandardDeviation(@WebParam(name = "arrayOfDouble") ArrayOfDouble arrayOfDouble) throws HookNegativeSumException {
		GetStatisticsResponse response = client.getStatisticResponse(arrayOfDouble);
		LOG.info("getStandardDeviation");
		return response.getStandardDeviation();
	}

	@WebMethod
	public double getSkewness(@WebParam(name = "arrayOfDouble") ArrayOfDouble arrayOfDouble) throws HookNegativeSumException {
		GetStatisticsResponse response = client.getStatisticResponse(arrayOfDouble);
		LOG.info("getSkewness");
		return response.getSkewness();
	}

	@WebMethod
	public double getKurtosis(@WebParam(name = "arrayOfDouble") ArrayOfDouble arrayOfDouble) throws HookNegativeSumException {
		GetStatisticsResponse response = client.getStatisticResponse(arrayOfDouble);
		LOG.info("getKurtosis");
		return response.getKurtosis();
	}

}
