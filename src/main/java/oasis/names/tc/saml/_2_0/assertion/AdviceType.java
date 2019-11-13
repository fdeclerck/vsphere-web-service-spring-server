// 
// Decompiled by Procyon v0.5.36
// 

package oasis.names.tc.saml._2_0.assertion;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import com.rsa.names._2009._12.std_ext.saml2.RSAAdviceType;
import java.util.List;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AdviceType", propOrder = { "rsaAdvice" })
public class AdviceType
{
    @XmlElement(name = "RSAAdvice", namespace = "http://www.rsa.com/names/2009/12/std-ext/SAML2.0", required = true)
    protected List<RSAAdviceType> rsaAdvice;
    
    public List<RSAAdviceType> getRSAAdvice() {
        if (this.rsaAdvice == null) {
            this.rsaAdvice = new ArrayList<RSAAdviceType>();
        }
        return this.rsaAdvice;
    }
}
