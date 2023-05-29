
package https.sassgateway_adp_com.vendorxml.vendorservice.v1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for acknowledgementStatusEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="acknowledgementStatusEnum">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ALL_DATA_RECEIVED"/>
 *     &lt;enumeration value="NO_DATA_RECEIVED"/>
 *     &lt;enumeration value="NO_WORK_AVAILABLE"/>
 *     &lt;enumeration value="PARTIAL_DATA_RECEIVED"/>
 *     &lt;enumeration value="SERVICE_AVAILABLE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "acknowledgementStatusEnum")
@XmlEnum
public enum AcknowledgementStatusEnum {

    ALL_DATA_RECEIVED,
    NO_DATA_RECEIVED,
    NO_WORK_AVAILABLE,
    PARTIAL_DATA_RECEIVED,
    SERVICE_AVAILABLE;

    public String value() {
        return name();
    }

    public static AcknowledgementStatusEnum fromValue(String v) {
        return valueOf(v);
    }

}
