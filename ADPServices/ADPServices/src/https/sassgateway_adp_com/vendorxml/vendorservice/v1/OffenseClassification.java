
package https.sassgateway_adp_com.vendorxml.vendorservice.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for offenseClassification complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="offenseClassification">
 *   &lt;complexContent>
 *     &lt;extension base="{https://sassgateway.adp.com/vendorxml/VendorService/v1}basePojo">
 *       &lt;sequence>
 *         &lt;element name="classLevel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="offense" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "offenseClassification", propOrder = {
    "classLevel",
    "offense",
    "type"
})
public class OffenseClassification
    extends BasePojo
{

    protected String classLevel;
    protected String offense;
    protected String type;

    /**
     * Gets the value of the classLevel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClassLevel() {
        return classLevel;
    }

    /**
     * Sets the value of the classLevel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClassLevel(String value) {
        this.classLevel = value;
    }

    /**
     * Gets the value of the offense property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOffense() {
        return offense;
    }

    /**
     * Sets the value of the offense property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOffense(String value) {
        this.offense = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

}
