
package fr.f74;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
//import org.springframework.ws.soap.client.core.SoapActionCallback;
// import org.springframework.ws.client.*;
// import org.springframework.ws.soap.*;

//import vsphere.wsdl.GetCountryRequest;
//import vsphere.wsdl.GetCountryResponse;

import org.w3c.dom.Element;

public class VsphereClient extends WebServiceGatewaySupport {

    private static final Logger log = LoggerFactory.getLogger(VsphereClient.class);
    
    Element token = null;

	public void setToken(Element token) {
        this.token = token;
    }
    
    public Element getToken() {
        
        Element token = this.token;
        
        return token;
	}

}
