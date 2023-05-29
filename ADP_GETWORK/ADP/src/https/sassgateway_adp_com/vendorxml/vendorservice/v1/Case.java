
package https.sassgateway_adp_com.vendorxml.vendorservice.v1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for case complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="case">
 *   &lt;complexContent>
 *     &lt;extension base="{https://sassgateway.adp.com/vendorxml/VendorService/v1}basePojo">
 *       &lt;sequence>
 *         &lt;element name="actions" type="{https://sassgateway.adp.com/vendorxml/VendorService/v1}action" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="agencyName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="alternateId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="arrestDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="caseId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="caseNum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fileDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="offenses" type="{https://sassgateway.adp.com/vendorxml/VendorService/v1}offense" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="personAddress" type="{https://sassgateway.adp.com/vendorxml/VendorService/v1}address" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="personIdentifiers" type="{https://sassgateway.adp.com/vendorxml/VendorService/v1}personIdentifier" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "case", propOrder = {
    "actions",
    "agencyName",
    "alternateId",
    "arrestDate",
    "caseId",
    "caseNum",
    "fileDate",
    "offenses",
    "personAddress",
    "personIdentifiers"
})
public class Case
    extends BasePojo
{

    @XmlElement(nillable = true)
    protected List<Action> actions;
    protected String agencyName;
    protected String alternateId;
    protected String arrestDate;
    protected String caseId;
    protected String caseNum;
    protected String fileDate;
    @XmlElement(nillable = true)
    protected List<Offense> offenses;
    @XmlElement(nillable = true)
    protected List<Address> personAddress;
    @XmlElement(nillable = true)
    protected List<PersonIdentifier> personIdentifiers;

    /**
     * Gets the value of the actions property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the actions property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getActions().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Action }
     * 
     * 
     */
    public List<Action> getActions() {
        if (actions == null) {
            actions = new ArrayList<Action>();
        }
        return this.actions;
    }

    /**
     * Gets the value of the agencyName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAgencyName() {
        return agencyName;
    }

    /**
     * Sets the value of the agencyName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAgencyName(String value) {
        this.agencyName = value;
    }

    /**
     * Gets the value of the alternateId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAlternateId() {
        return alternateId;
    }

    /**
     * Sets the value of the alternateId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAlternateId(String value) {
        this.alternateId = value;
    }

    /**
     * Gets the value of the arrestDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArrestDate() {
        return arrestDate;
    }

    /**
     * Sets the value of the arrestDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArrestDate(String value) {
        this.arrestDate = value;
    }

    /**
     * Gets the value of the caseId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCaseId() {
        return caseId;
    }

    /**
     * Sets the value of the caseId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCaseId(String value) {
        this.caseId = value;
    }

    /**
     * Gets the value of the caseNum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCaseNum() {
        return caseNum;
    }

    /**
     * Sets the value of the caseNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCaseNum(String value) {
        this.caseNum = value;
    }

    /**
     * Gets the value of the fileDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFileDate() {
        return fileDate;
    }

    /**
     * Sets the value of the fileDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFileDate(String value) {
        this.fileDate = value;
    }

    /**
     * Gets the value of the offenses property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the offenses property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOffenses().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Offense }
     * 
     * 
     */
    public List<Offense> getOffenses() {
        if (offenses == null) {
            offenses = new ArrayList<Offense>();
        }
        return this.offenses;
    }

    /**
     * Gets the value of the personAddress property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the personAddress property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPersonAddress().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Address }
     * 
     * 
     */
    public List<Address> getPersonAddress() {
        if (personAddress == null) {
            personAddress = new ArrayList<Address>();
        }
        return this.personAddress;
    }

    /**
     * Gets the value of the personIdentifiers property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the personIdentifiers property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPersonIdentifiers().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PersonIdentifier }
     * 
     * 
     */
    public List<PersonIdentifier> getPersonIdentifiers() {
        if (personIdentifiers == null) {
            personIdentifiers = new ArrayList<PersonIdentifier>();
        }
        return this.personIdentifiers;
    }

		public void setActions(List<Action> actions) {
			this.actions = actions;
		}

		public void setOffenses(List<Offense> offenses) {
			this.offenses = offenses;
		}

		public void setPersonAddress(List<Address> personAddress) {
			this.personAddress = personAddress;
		}

		public void setPersonIdentifiers(List<PersonIdentifier> personIdentifiers) {
			this.personIdentifiers = personIdentifiers;
		}

}
