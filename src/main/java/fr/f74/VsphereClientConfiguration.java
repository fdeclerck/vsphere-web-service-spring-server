
package fr.f74;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.support.interceptor.ClientInterceptor;
//import org.springframework.ws.soap.security.wss4j.Wss4jSecurityInterceptor;

@Configuration
public class VsphereClientConfiguration {

	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		// this package must match the package in the <generatePackage> specified in
		// pom.xml
		marshaller.setContextPath("com.vmware.vim25");
		return marshaller;
	}

	@Bean
	public VsphereClient VsphereClient(Jaxb2Marshaller marshaller) {
		VsphereClient client = new VsphereClient();
		client.setDefaultUri("https://10.200.19.122/sdk");
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}

}
