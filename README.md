# soap-service-client
# Task 4

# Web Service

Implement Web Service for getting average of double array.

The service accepts array of double numbers and returns its average. For calculating average it’s needed to:

1. Create a client for the service http://www.webservicex.net/Statistics.asmx?WSDL

2. Call the client&#39;s method GetStatistics

3. Parse GetStatistics response and take value from field &quot;Average&quot;

In case of value of field “Sums” of GetStatistics response is less than 0 – SOAP response must have Fault

section.

WSDL must have meaningful parameters’ names (not like arg0).

# Client (OPTIONAL)

Implement a client application for the Web Service above.

Demonstrate work of the Web Service in it.
