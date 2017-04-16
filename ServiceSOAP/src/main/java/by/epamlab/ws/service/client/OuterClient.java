package by.epamlab.ws.service.client;

import static by.epamlab.ws.constant.Constant.ADDRESS_OUTER_SERVICE_WSDL;
import static by.epamlab.ws.constant.Constant.EMPTY_STRING;

import javax.xml.ws.Holder;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import by.epamlab.ws.service.exception.HookNegativeSumException;
import net.webservicex.ArrayOfDouble;
import net.webservicex.GetStatisticsResponse;
import net.webservicex.StatisticsSoap;

public class OuterClient {

	private enum Singleton {
		INSTANCE(new OuterClient());

		private OuterClient clientInstance;

		private Singleton(OuterClient clientInstance) {
			this.clientInstance = clientInstance;
		}

		public OuterClient getClientInstance() {
			return clientInstance;
		}
	}

	private static StatisticsSoap statistic;

	public static OuterClient getInstance() {
		return Singleton.INSTANCE.getClientInstance();
	}

	private OuterClient() {
		super();
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.setServiceClass(StatisticsSoap.class);
		factory.setAddress(ADDRESS_OUTER_SERVICE_WSDL);
		statistic = factory.create(StatisticsSoap.class);
	}

	public GetStatisticsResponse getStatisticResponse(ArrayOfDouble arrayOfDouble)
			throws HookNegativeSumException {
		Holder<Double> sums = new Holder<>(0.0);
		Holder<Double> average = new Holder<>(0.0);
		Holder<Double> standardDeviation = new Holder<>(0.0);
		Holder<Double> skewness = new Holder<>(0.0);
		Holder<Double> kurtosis = new Holder<>(0.0);

		statistic.getStatistics(arrayOfDouble, sums, average, standardDeviation, skewness, kurtosis);

		if (Double.parseDouble(EMPTY_STRING + sums.value) < 0) {
			throw new HookNegativeSumException();
		}
		GetStatisticsResponse response = new GetStatisticsResponse();
		response.setSums(Double.parseDouble(EMPTY_STRING + sums.value));
		response.setAverage(Double.parseDouble(EMPTY_STRING + average.value));
		response.setStandardDeviation(Double.parseDouble(EMPTY_STRING + standardDeviation.value));
		response.setSkewness(Double.parseDouble(EMPTY_STRING + skewness.value));
		response.setKurtosis(Double.parseDouble(EMPTY_STRING + kurtosis.value));
		return response;
	}

}
