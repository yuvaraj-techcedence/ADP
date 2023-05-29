
package https.sassgateway_adp_com.vendorxml.vendorservice.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for messageVendorGetWork complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="messageVendorGetWork">
 *   &lt;complexContent>
 *     &lt;extension base="{https://sassgateway.adp.com/vendorxml/VendorService/v1}messageBase">
 *       &lt;sequence>
 *         &lt;element name="existingWork" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "messageVendorGetWork", propOrder = {
    "existingWork"
})
public class MessageVendorGetWork
    extends MessageBase
{

    protected String existingWork;

    /**
     * Gets the value of the existingWork property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExistingWork() {
        return existingWork;
    }

    /**
     * Sets the value of the existingWork property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExistingWork(String value) {
        this.existingWork = value;
    }

}
