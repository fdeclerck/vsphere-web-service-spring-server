// 
// Decompiled by Procyon v0.5.36
// 

package com.rsa.names._2009._12.product.riat.wsdl;

import java.net.MalformedURLException;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceFeature;
import javax.xml.namespace.QName;
import javax.xml.ws.WebServiceException;
import java.net.URL;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.Service;

@WebServiceClient(name = "STSService", targetNamespace = "http://www.rsa.com/names/2009/12/product/riat/wsdl", wsdlLocation = "file:/D:/build/ob/bora-14379537/bora/build/sdk/ssoclient/wsdl/STSService.wsdl")
public class STSService extends Service
{
    private static final URL STSSERVICE_WSDL_LOCATION;
    private static final WebServiceException STSSERVICE_EXCEPTION;
    private static final QName STSSERVICE_QNAME;
    
    public STSService() {
        super(__getWsdlLocation(), STSService.STSSERVICE_QNAME);
    }
    
    public STSService(final WebServiceFeature... array) {
        super(__getWsdlLocation(), STSService.STSSERVICE_QNAME, array);
    }
    
    public STSService(final URL url) {
        super(url, STSService.STSSERVICE_QNAME);
    }
    
    public STSService(final URL url, final WebServiceFeature... array) {
        super(url, STSService.STSSERVICE_QNAME, array);
    }
    
    public STSService(final URL url, final QName qName) {
        super(url, qName);
    }
    
    public STSService(final URL url, final QName qName, final WebServiceFeature... array) {
        super(url, qName, array);
    }
    
    @WebEndpoint(name = "STSService_Port")
    public STSServicePortType getSTSServicePort() {
        return super.getPort(new QName("http://www.rsa.com/names/2009/12/product/riat/wsdl", "STSService_Port"), STSServicePortType.class);
    }
    
    @WebEndpoint(name = "STSService_Port")
    public STSServicePortType getSTSServicePort(final WebServiceFeature... array) {
        return super.getPort(new QName("http://www.rsa.com/names/2009/12/product/riat/wsdl", "STSService_Port"), STSServicePortType.class, array);
    }
    
    private static URL __getWsdlLocation() {
        if (STSService.STSSERVICE_EXCEPTION != null) {
            throw STSService.STSSERVICE_EXCEPTION;
        }
        return STSService.STSSERVICE_WSDL_LOCATION;
    }
    
    static {
        STSSERVICE_QNAME = new QName("http://www.rsa.com/names/2009/12/product/riat/wsdl", "STSService");
        URL stsservice_WSDL_LOCATION = null;
        WebServiceException stsservice_EXCEPTION = null;
        try {
            stsservice_WSDL_LOCATION = new URL(STSService.class.getResource(STSService.class.getSimpleName() + ".class"), "STSService.wsdl");
        }
        catch (MalformedURLException ex) {
            stsservice_EXCEPTION = new WebServiceException(ex);
        }
        STSSERVICE_WSDL_LOCATION = stsservice_WSDL_LOCATION;
        STSSERVICE_EXCEPTION = stsservice_EXCEPTION;
    }
}
