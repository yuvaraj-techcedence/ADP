
package https.sassgateway_adp_com.vendorxml.vendorservice.v1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for messageVendorFulfillWork complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="messageVendorFulfillWork">
 *   &lt;complexContent>
 *     &lt;extension base="{https://sassgateway.adp.com/vendorxml/VendorService/v1}messageBase">
 *       &lt;sequence>
 *         &lt;element name="amended" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="criminalHistoryResults" type="{https://sassgateway.adp.com/vendorxml/VendorService/v1}criminalHistoryResult" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "messageVendorFulfillWork", propOrder = {
    "amended",
    "criminalHistoryResults"
})
public class MessageVendorFulfillWork
    extends MessageBase
{

    protected String amended;
    @XmlElement(nillable = true)
    protected List<CriminalHistoryResult> criminalHistoryResults;

    /**
     * Gets the value of the amended property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAmended() {
        return amended;
    }

    /**
     * Sets the value of the amended property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAmended(String value) {
        this.amended = value;
    }

    /**
     * Gets the value of the criminalHistoryResults property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the criminalHistoryResults property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCriminalHistoryResults().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CriminalHistoryResult }
     * 
     * 
     */
    public List<CriminalHistoryResult> getCriminalHistoryResults() {
        if (criminalHistoryResults == null) {
            criminalHistoryResults = new ArrayList<CriminalHistoryResult>();
        }
        return this.criminalHistoryResults;
    }

		public void setCriminalHistoryResults(List<CriminalHistoryResult> criminalHistoryResults) {
			this.criminalHistoryResults = criminalHistoryResults;
		}

}
