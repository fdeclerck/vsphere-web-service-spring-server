// 
// Decompiled by Procyon v0.5.36
// 

package com.rsa.names._2009._12.std_ext.ws_trust1_4.advice;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AdviceSetType", propOrder = { "advice" })
public class AdviceSetType
{
    @XmlElement(name = "Advice", required = true)
    protected List<AdviceType> advice;
    
    public List<AdviceType> getAdvice() {
        if (this.advice == null) {
            this.advice = new ArrayList<AdviceType>();
        }
        return this.advice;
    }
}
