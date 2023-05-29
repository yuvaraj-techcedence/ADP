
package https.sassgateway_adp_com.vendorxml.vendorservice.v1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for criminalHistoryResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="criminalHistoryResult">
 *   &lt;complexContent>
 *     &lt;extension base="{https://sassgateway.adp.com/vendorxml/VendorService/v1}basePojo">
 *       &lt;sequence>
 *         &lt;element name="cases" type="{https://sassgateway.adp.com/vendorxml/VendorService/v1}case" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="record" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sassRefString" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "criminalHistoryResult", propOrder = {
    "cases",
    "record",
    "sassRefString"
})
public class CriminalHistoryResult
    extends BasePojo
{

    @XmlElement(nillable = true)
    protected List<Case> cases;
    protected String record;
    protected String sassRefString;

    /**
     * Gets the value of the cases property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cases property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCases().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Case }
     * 
     * 
     */
    public List<Case> getCases() {
        if (cases == null) {
            cases = new ArrayList<Case>();
        }
        return this.cases;
    }

    /**
     * Gets the value of the record property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecord() {
        return record;
    }

    /**
     * Sets the value of the record property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecord(String value) {
        this.record = value;
    }

    /**
     * Gets the value of the sassRefString property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSassRefString() {
        return sassRefString;
    }

    /**
     * Sets the value of the sassRefString property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSassRefString(String value) {
        this.sassRefString = value;
    }

		public void setCases(List<Case> cases) {
			this.cases = cases;
		}

}
