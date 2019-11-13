// 
// Decompiled by Procyon v0.5.36
// 

package org.oasis_open.docs.ws_sx.ws_trust._200512;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ParticipantsType", propOrder = { "primary", "participant" })
public class ParticipantsType
{
    @XmlElement(name = "Primary")
    protected ParticipantType primary;
    @XmlElement(name = "Participant")
    protected List<ParticipantType> participant;
    
    public ParticipantType getPrimary() {
        return this.primary;
    }
    
    public void setPrimary(final ParticipantType primary) {
        this.primary = primary;
    }
    
    public List<ParticipantType> getParticipant() {
        if (this.participant == null) {
            this.participant = new ArrayList<ParticipantType>();
        }
        return this.participant;
    }
}
