
package fr.f74;

import fr.f74.connection.*;
//import com.vmware.connection.helpers.*;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.support.interceptor.ClientInterceptor;
//import org.springframework.ws.soap.security.wss4j.Wss4jSecurityInterceptor;

@Configuration
//@PropertySource("classpath:/fr/f74/resources/vsphere.properties")
public class VsphereClientConfiguration {

	//@Inject Environment env;

	/* @Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setContextPath("fr.f74.vim25");
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
 */
	@Bean("ssoConnection")
    public Connection getSsoConnectionImpl() {
        return new SsoConnectionImpl();
	}
	
	/* @Bean("userConnect")
    public UserConnect getUserConnect(UserProfile userProfile,AcquireHoKTokenByUserCredential acquireHoKTokenByUserCredential) {
        return new UserConnect(userProfile, acquireHoKTokenByUserCredential);
	} */

	/* @Bean("acquireHoKTokenByUserCredential")
    public AcquireHoKTokenByUserCredential getAcquireHoKTokenByUserCredential() {
        return new AcquireHoKTokenByUserCredential();
    } */

}
