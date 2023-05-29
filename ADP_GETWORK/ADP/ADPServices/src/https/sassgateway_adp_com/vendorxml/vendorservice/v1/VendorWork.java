
package https.sassgateway_adp_com.vendorxml.vendorservice.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for vendorWork complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="vendorWork">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="batchDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="personAddress" type="{https://sassgateway.adp.com/vendorxml/VendorService/v1}address" minOccurs="0"/>
 *         &lt;element name="personIdentifier" type="{https://sassgateway.adp.com/vendorxml/VendorService/v1}personIdentifier" minOccurs="0"/>
 *         &lt;element name="productInformation" type="{https://sassgateway.adp.com/vendorxml/VendorService/v1}productInformation" minOccurs="0"/>
 *         &lt;element name="sassRefString" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "vendorWork", propOrder = {
    "batchDate",
    "personAddress",
    "personIdentifier",
    "productInformation",
    "sassRefString"
})
public class VendorWork {

    protected String batchDate;
    protected Address personAddress;
    protected PersonIdentifier personIdentifier;
    protected ProductInformation productInformation;
    protected String sassRefString;

    /**
     * Gets the value of the batchDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBatchDate() {
        return batchDate;
    }

    /**
     * Sets the value of the batchDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBatchDate(String value) {
        this.batchDate = value;
    }

    /**
     * Gets the value of the personAddress property.
     * 
     * @return
     *     possible object is
     *     {@link Address }
     *     
     */
    public Address getPersonAddress() {
        return personAddress;
    }

    /**
     * Sets the value of the personAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link Address }
     *     
     */
    public void setPersonAddress(Address value) {
        this.personAddress = value;
    }

    /**
     * Gets the value of the personIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link PersonIdentifier }
     *     
     */
    public PersonIdentifier getPersonIdentifier() {
        return personIdentifier;
    }

    /**
     * Sets the value of the personIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link PersonIdentifier }
     *     
     */
    public void setPersonIdentifier(PersonIdentifier value) {
        this.personIdentifier = value;
    }

    /**
     * Gets the value of the productInformation property.
     * 
     * @return
     *     possible object is
     *     {@link ProductInformation }
     *     
     */
    public ProductInformation getProductInformation() {
        return productInformation;
    }

    /**
     * Sets the value of the productInformation property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProductInformation }
     *     
     */
    public void setProductInformation(ProductInformation value) {
        this.productInformation = value;
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

}
