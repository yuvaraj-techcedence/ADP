
package https.sassgateway_adp_com.vendorxml.vendorservice.v1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for productInformation complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="productInformation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="productAttributes" type="{https://sassgateway.adp.com/vendorxml/VendorService/v1}productAttribute" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="productGroup" type="{https://sassgateway.adp.com/vendorxml/VendorService/v1}productGroupEnum" minOccurs="0"/>
 *         &lt;element name="productName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "productInformation", propOrder = {
    "productAttributes",
    "productGroup",
    "productName"
})
public class ProductInformation {

    @XmlElement(nillable = true)
    protected List<ProductAttribute> productAttributes;
    protected ProductGroupEnum productGroup;
    protected String productName;

    /**
     * Gets the value of the productAttributes property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the productAttributes property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProductAttributes().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ProductAttribute }
     * 
     * 
     */
    public List<ProductAttribute> getProductAttributes() {
        if (productAttributes == null) {
            productAttributes = new ArrayList<ProductAttribute>();
        }
        return this.productAttributes;
    }

    /**
     * Gets the value of the productGroup property.
     * 
     * @return
     *     possible object is
     *     {@link ProductGroupEnum }
     *     
     */
    public ProductGroupEnum getProductGroup() {
        return productGroup;
    }

    /**
     * Sets the value of the productGroup property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProductGroupEnum }
     *     
     */
    public void setProductGroup(ProductGroupEnum value) {
        this.productGroup = value;
    }

    /**
     * Gets the value of the productName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProductName() {
        return productName;
    }

    /**
     * Sets the value of the productName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProductName(String value) {
        this.productName = value;
    }

}
