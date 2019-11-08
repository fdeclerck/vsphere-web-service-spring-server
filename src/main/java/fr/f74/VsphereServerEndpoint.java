
package fr.f74;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import vsphere.wsdl.Beer;
import vsphere.wsdl.GetBeerRequest;
import vsphere.wsdl.GetBeerResponse;

@Endpoint
public class VsphereServerEndpoint {

    public static final String NAMESPACE_URI = "http://f74.fr/beer";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getBeerRequest")
    @ResponsePayload
    public GetBeerResponse getBeer(@RequestPayload GetBeerRequest request)  {
        GetBeerResponse beerResponse = new GetBeerResponse();
        Beer beer = new Beer();
        beer.setId(request.getId());
        beer.setName("Corona");
        beerResponse.setBeer(beer);
        return beerResponse;
    }

}
