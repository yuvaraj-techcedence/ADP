
package https.sassgateway_adp_com.vendorxml.vendorservice.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ping complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ping">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="pingRequest" type="{https://sassgateway.adp.com/vendorxml/VendorService/v1}messageVendorPing" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ping", propOrder = {
    "pingRequest"
})
public class Ping {

    protected MessageVendorPing pingRequest;

    /**
     * Gets the value of the pingRequest property.
     * 
     * @return
     *     possible object is
     *     {@link MessageVendorPing }
     *     
     */
    public MessageVendorPing getPingRequest() {
        return pingRequest;
    }

    /**
     * Sets the value of the pingRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link MessageVendorPing }
     *     
     */
    public void setPingRequest(MessageVendorPing value) {
        this.pingRequest = value;
    }

}
