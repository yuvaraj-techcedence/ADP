
package https.sassgateway_adp_com.vendorxml.vendorservice.v1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GVXException complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GVXException">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="reasonCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="reasonDescription" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="invalidCriminalHistoryResults" type="{https://sassgateway.adp.com/vendorxml/VendorService/v1}criminalHistoryResult" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GVXException", propOrder = {
    "reasonCode",
    "reasonDescription",
    "invalidCriminalHistoryResults"
})
public class GVXException {

    @XmlElement(required = true, nillable = true)
    protected String reasonCode;
    @XmlElement(required = true, nillable = true)
    protected String reasonDescription;
    protected List<CriminalHistoryResult> invalidCriminalHistoryResults;

    /**
     * Gets the value of the reasonCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReasonCode() {
        return reasonCode;
    }

    /**
     * Sets the value of the reasonCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReasonCode(String value) {
        this.reasonCode = value;
    }

    /**
     * Gets the value of the reasonDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReasonDescription() {
        return reasonDescription;
    }

    /**
     * Sets the value of the reasonDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReasonDescription(String value) {
        this.reasonDescription = value;
    }

    /**
     * Gets the value of the invalidCriminalHistoryResults property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the invalidCriminalHistoryResults property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInvalidCriminalHistoryResults().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CriminalHistoryResult }
     * 
     * 
     */
    public List<CriminalHistoryResult> getInvalidCriminalHistoryResults() {
        if (invalidCriminalHistoryResults == null) {
            invalidCriminalHistoryResults = new ArrayList<CriminalHistoryResult>();
        }
        return this.invalidCriminalHistoryResults;
    }

}
