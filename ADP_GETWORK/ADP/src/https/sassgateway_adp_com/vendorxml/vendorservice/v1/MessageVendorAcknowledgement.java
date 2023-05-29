
package https.sassgateway_adp_com.vendorxml.vendorservice.v1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for messageVendorAcknowledgement complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="messageVendorAcknowledgement">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="invalidCriminalHistoryResults" type="{https://sassgateway.adp.com/vendorxml/VendorService/v1}criminalHistoryResult" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="overallStatus" type="{https://sassgateway.adp.com/vendorxml/VendorService/v1}acknowledgementStatusEnum" minOccurs="0"/>
 *         &lt;element name="validCriminalHistoryResults" type="{https://sassgateway.adp.com/vendorxml/VendorService/v1}criminalHistoryResult" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="vendorWorks" type="{https://sassgateway.adp.com/vendorxml/VendorService/v1}vendorWork" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "messageVendorAcknowledgement", propOrder = {
    "invalidCriminalHistoryResults",
    "overallStatus",
    "validCriminalHistoryResults",
    "vendorWorks"
})
public class MessageVendorAcknowledgement {

    @XmlElement(nillable = true)
    protected List<CriminalHistoryResult> invalidCriminalHistoryResults;
    protected AcknowledgementStatusEnum overallStatus;
    @XmlElement(nillable = true)
    protected List<CriminalHistoryResult> validCriminalHistoryResults;
    @XmlElement(nillable = true)
    protected List<VendorWork> vendorWorks;

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

    /**
     * Gets the value of the overallStatus property.
     * 
     * @return
     *     possible object is
     *     {@link AcknowledgementStatusEnum }
     *     
     */
    public AcknowledgementStatusEnum getOverallStatus() {
        return overallStatus;
    }

    /**
     * Sets the value of the overallStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link AcknowledgementStatusEnum }
     *     
     */
    public void setOverallStatus(AcknowledgementStatusEnum value) {
        this.overallStatus = value;
    }

    /**
     * Gets the value of the validCriminalHistoryResults property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the validCriminalHistoryResults property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getValidCriminalHistoryResults().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CriminalHistoryResult }
     * 
     * 
     */
    public List<CriminalHistoryResult> getValidCriminalHistoryResults() {
        if (validCriminalHistoryResults == null) {
            validCriminalHistoryResults = new ArrayList<CriminalHistoryResult>();
        }
        return this.validCriminalHistoryResults;
    }

    /**
     * Gets the value of the vendorWorks property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the vendorWorks property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVendorWorks().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VendorWork }
     * 
     * 
     */
    public List<VendorWork> getVendorWorks() {
        if (vendorWorks == null) {
            vendorWorks = new ArrayList<VendorWork>();
        }
        return this.vendorWorks;
    }

}
