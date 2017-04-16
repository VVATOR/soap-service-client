package by.epamlab;

import java.util.List;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.log4j.Logger;

import by.epamlab.ws.service.HookNegativeSumException;
import by.epamlab.ws.service.ServiceSOAP;
import net.webservicex.ArrayOfDouble;

public class Runner {
	private static final String ADDRESS_SERVICE_SOAP = "http://localhost:8080/ServiceSOAP?wsdl";
	private static final Logger LOG = Logger.getLogger(Runner.class);

	public static void main(String[] args) {
		LOG.info("START CLIENT");
		String serviceUrl = ADDRESS_SERVICE_SOAP;
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.setServiceClass(ServiceSOAP.class);
		factory.setAddress(serviceUrl);
		ServiceSOAP ms = factory.create(ServiceSOAP.class);

		ArrayOfDouble params = new ArrayOfDouble();
		List<Double> arrayOfDouble = params.getDouble();
		arrayOfDouble.add(70890.0);
		arrayOfDouble.add(1080.8);
		arrayOfDouble.add(73225.9);
		arrayOfDouble.add(33225.1);
		arrayOfDouble.add(125.0);
		LOG.info("Double parameters: \t" + arrayOfDouble);
		try {
			LOG.info("getSums: \t" + ms.getSums(params));
			LOG.info("getAverage: \t" + ms.getAverage(params));
			LOG.info("getStandardDeviation: \t" + ms.getStandardDeviation(params));
			LOG.info("getSkewness: \t" + ms.getSkewness(params));
			LOG.info("getKurtosis: \t" + ms.getKurtosis(params) + "\n\n\n");
		} catch (HookNegativeSumException e) {
			LOG.error(e);
		}
		ArrayOfDouble paramsForThrowError = new ArrayOfDouble();
		List<Double> arrayOfDouble1 = paramsForThrowError.getDouble();
		arrayOfDouble1.add(20.0);
		arrayOfDouble1.add(-100.8);
		arrayOfDouble1.add(-50.9);
		arrayOfDouble1.add(30.1);
		arrayOfDouble1.add(-40.0);
		LOG.info("Double parameters: \t" + arrayOfDouble1);
		try {
			LOG.info("getSums: \t" + ms.getSums(paramsForThrowError));
		} catch (HookNegativeSumException e) {
			LOG.error(e);
		}

	}

}
