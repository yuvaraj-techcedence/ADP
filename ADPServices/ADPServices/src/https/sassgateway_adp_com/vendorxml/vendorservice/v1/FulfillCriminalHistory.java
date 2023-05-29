
package https.sassgateway_adp_com.vendorxml.vendorservice.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for fulfillCriminalHistory complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="fulfillCriminalHistory">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="fulfillCriminalHistoryRequest" type="{https://sassgateway.adp.com/vendorxml/VendorService/v1}messageVendorFulfillWork" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "fulfillCriminalHistory", propOrder = {
    "fulfillCriminalHistoryRequest"
})
public class FulfillCriminalHistory {

    protected MessageVendorFulfillWork fulfillCriminalHistoryRequest;

    /**
     * Gets the value of the fulfillCriminalHistoryRequest property.
     * 
     * @return
     *     possible object is
     *     {@link MessageVendorFulfillWork }
     *     
     */
    public MessageVendorFulfillWork getFulfillCriminalHistoryRequest() {
        return fulfillCriminalHistoryRequest;
    }

    /**
     * Sets the value of the fulfillCriminalHistoryRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link MessageVendorFulfillWork }
     *     
     */
    public void setFulfillCriminalHistoryRequest(MessageVendorFulfillWork value) {
        this.fulfillCriminalHistoryRequest = value;
    }

}
