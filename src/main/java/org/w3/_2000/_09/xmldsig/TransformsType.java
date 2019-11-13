// 
// Decompiled by Procyon v0.5.36
// 

package org.w3._2000._09.xmldsig;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TransformsType", propOrder = { "transform" })
public class TransformsType
{
    @XmlElement(name = "Transform", required = true)
    protected List<TransformType> transform;
    
    public List<TransformType> getTransform() {
        if (this.transform == null) {
            this.transform = new ArrayList<TransformType>();
        }
        return this.transform;
    }
}
