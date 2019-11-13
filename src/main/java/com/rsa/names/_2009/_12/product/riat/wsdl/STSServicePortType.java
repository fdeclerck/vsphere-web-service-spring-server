// 
// Decompiled by Procyon v0.5.36
// 

package com.rsa.names._2009._12.product.riat.wsdl;

import org.oasis_open.docs.ws_sx.ws_trust._200512.RequestSecurityTokenResponseType;
import javax.jws.WebResult;
import javax.jws.WebMethod;
import org.oasis_open.docs.ws_sx.ws_trust._200512.RequestSecurityTokenResponseCollectionType;
import javax.jws.WebParam;
import org.oasis_open.docs.ws_sx.ws_trust._200512.RequestSecurityTokenType;
import com.rsa.names._2009._12.std_ext.saml2.ObjectFactory;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.jws.soap.SOAPBinding;
import javax.jws.WebService;

@WebService(name = "STSService_PortType", targetNamespace = "http://www.rsa.com/names/2009/12/product/riat/wsdl")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({ ObjectFactory.class, com.rsa.names._2009._12.std_ext.ws_trust1_4.advice.ObjectFactory.class, oasis.names.tc.saml._2_0.assertion.ObjectFactory.class, oasis.names.tc.saml._2_0.conditions.delegation.ObjectFactory.class, org.oasis_open.docs.ws_sx.ws_trust._200512.ObjectFactory.class, org.oasis_open.docs.wss._2004._01.oasis_200401_wss_wssecurity_secext_1_0.ObjectFactory.class, org.oasis_open.docs.wss._2004._01.oasis_200401_wss_wssecurity_utility_1_0.ObjectFactory.class, org.w3._2000._09.xmldsig.ObjectFactory.class, org.w3._2005._08.addressing.ObjectFactory.class, com.rsa.names._2010._04.std_prof.saml2.ObjectFactory.class })
public interface STSServicePortType
{
    @WebMethod(operationName = "Issue", action = "http://docs.oasis-open.org/ws-sx/ws-trust/200512/RST/Issue")
    @WebResult(name = "RequestSecurityTokenResponseCollection", targetNamespace = "http://docs.oasis-open.org/ws-sx/ws-trust/200512", partName = "RequestSecurityTokenResponseCollection")
    RequestSecurityTokenResponseCollectionType issue(@WebParam(name = "RequestSecurityToken", targetNamespace = "http://docs.oasis-open.org/ws-sx/ws-trust/200512", partName = "RequestSecurityToken") final RequestSecurityTokenType p0);
    
    @WebMethod(operationName = "Renew", action = "http://docs.oasis-open.org/ws-sx/ws-trust/200512/RST/Renew")
    @WebResult(name = "RequestSecurityTokenResponse", targetNamespace = "http://docs.oasis-open.org/ws-sx/ws-trust/200512", partName = "RequestSecurityTokenResponse")
    RequestSecurityTokenResponseType renew(@WebParam(name = "RequestSecurityToken", targetNamespace = "http://docs.oasis-open.org/ws-sx/ws-trust/200512", partName = "RequestSecurityToken") final RequestSecurityTokenType p0);
    
    @WebMethod(operationName = "Validate", action = "http://docs.oasis-open.org/ws-sx/ws-trust/200512/RST/Validate")
    @WebResult(name = "RequestSecurityTokenResponse", targetNamespace = "http://docs.oasis-open.org/ws-sx/ws-trust/200512", partName = "RequestSecurityTokenResponse")
    RequestSecurityTokenResponseType validate(@WebParam(name = "RequestSecurityToken", targetNamespace = "http://docs.oasis-open.org/ws-sx/ws-trust/200512", partName = "RequestSecurityToken") final RequestSecurityTokenType p0);
    
    @WebMethod(operationName = "Challenge", action = "http://docs.oasis-open.org/ws-sx/ws-trust/200512/RSTR/Issue")
    @WebResult(name = "RequestSecurityTokenResponseCollection", targetNamespace = "http://docs.oasis-open.org/ws-sx/ws-trust/200512", partName = "RequestSecurityTokenResponseCollection")
    RequestSecurityTokenResponseCollectionType challenge(@WebParam(name = "RequestSecurityTokenResponse", targetNamespace = "http://docs.oasis-open.org/ws-sx/ws-trust/200512", partName = "RequestSecurityTokenResponse") final RequestSecurityTokenResponseType p0);
}
