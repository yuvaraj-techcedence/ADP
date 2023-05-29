
package https.sassgateway_adp_com.vendorxml.vendorservice.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for pingResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="pingResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="acknowledgement" type="{https://sassgateway.adp.com/vendorxml/VendorService/v1}messageVendorAcknowledgement" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "pingResponse", propOrder = {
    "acknowledgement"
})
public class PingResponse {

    protected MessageVendorAcknowledgement acknowledgement;

    /**
     * Gets the value of the acknowledgement property.
     * 
     * @return
     *     possible object is
     *     {@link MessageVendorAcknowledgement }
     *     
     */
    public MessageVendorAcknowledgement getAcknowledgement() {
        return acknowledgement;
    }

    /**
     * Sets the value of the acknowledgement property.
     * 
     * @param value
     *     allowed object is
     *     {@link MessageVendorAcknowledgement }
     *     
     */
    public void setAcknowledgement(MessageVendorAcknowledgement value) {
        this.acknowledgement = value;
    }

}
