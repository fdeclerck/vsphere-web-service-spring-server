// 
// Decompiled by Procyon v0.5.36
// 

package org.w3._2000._09.xmldsig;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DSAKeyValueType", propOrder = { "p", "q", "g", "y", "j", "seed", "pgenCounter" })
public class DSAKeyValueType
{
    @XmlElement(name = "P")
    protected byte[] p;
    @XmlElement(name = "Q")
    protected byte[] q;
    @XmlElement(name = "G")
    protected byte[] g;
    @XmlElement(name = "Y", required = true)
    protected byte[] y;
    @XmlElement(name = "J")
    protected byte[] j;
    @XmlElement(name = "Seed")
    protected byte[] seed;
    @XmlElement(name = "PgenCounter")
    protected byte[] pgenCounter;
    
    public byte[] getP() {
        return this.p;
    }
    
    public void setP(final byte[] array) {
        this.p = array;
    }
    
    public byte[] getQ() {
        return this.q;
    }
    
    public void setQ(final byte[] array) {
        this.q = array;
    }
    
    public byte[] getG() {
        return this.g;
    }
    
    public void setG(final byte[] array) {
        this.g = array;
    }
    
    public byte[] getY() {
        return this.y;
    }
    
    public void setY(final byte[] array) {
        this.y = array;
    }
    
    public byte[] getJ() {
        return this.j;
    }
    
    public void setJ(final byte[] array) {
        this.j = array;
    }
    
    public byte[] getSeed() {
        return this.seed;
    }
    
    public void setSeed(final byte[] array) {
        this.seed = array;
    }
    
    public byte[] getPgenCounter() {
        return this.pgenCounter;
    }
    
    public void setPgenCounter(final byte[] array) {
        this.pgenCounter = array;
    }
}
