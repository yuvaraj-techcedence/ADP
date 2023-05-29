
package https.sassgateway_adp_com.vendorxml.vendorservice.v1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for basePojo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="basePojo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="validationMessages" type="{https://sassgateway.adp.com/vendorxml/VendorService/v1}validationMessage" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "basePojo", propOrder = {
    "validationMessages"
})
@XmlSeeAlso({
    OffenseClassification.class,
    CriminalHistoryDuration.class,
    Action.class,
    Offense.class,
    PersonIdentifier.class,
    CriminalHistoryResult.class,
    Address.class,
    Case.class
})
public class BasePojo {

    @XmlElement(nillable = true)
    protected List<ValidationMessage> validationMessages;

    /**
     * Gets the value of the validationMessages property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the validationMessages property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getValidationMessages().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ValidationMessage }
     * 
     * 
     */
    public List<ValidationMessage> getValidationMessages() {
        if (validationMessages == null) {
            validationMessages = new ArrayList<ValidationMessage>();
        }
        return this.validationMessages;
    }

}
