
package https.sassgateway_adp_com.vendorxml.vendorservice.v1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for productGroupEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="productGroupEnum">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="CH"/>
 *     &lt;enumeration value="RE"/>
 *     &lt;enumeration value="ADV"/>
 *     &lt;enumeration value="AT"/>
 *     &lt;enumeration value="FC"/>
 *     &lt;enumeration value="WC"/>
 *     &lt;enumeration value="LO"/>
 *     &lt;enumeration value="NL"/>
 *     &lt;enumeration value="MV"/>
 *     &lt;enumeration value="CL"/>
 *     &lt;enumeration value="CV"/>
 *     &lt;enumeration value="RC"/>
 *     &lt;enumeration value="BK"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "productGroupEnum")
@XmlEnum
public enum ProductGroupEnum {

    CH,
    RE,
    ADV,
    AT,
    FC,
    WC,
    LO,
    NL,
    MV,
    CL,
    CV,
    RC,
    BK;

    public String value() {
        return name();
    }

    public static ProductGroupEnum fromValue(String v) {
        return valueOf(v);
    }

}
