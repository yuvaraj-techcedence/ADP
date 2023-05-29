
package https.sassgateway_adp_com.vendorxml.vendorservice.v1;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 2.2.7
 * Tue May 04 10:38:59 MDT 2010
 * Generated source version: 2.2.7
 * 
 */

@WebFault(name = "GVXException", targetNamespace = "https://sassgateway.adp.com/vendorxml/VendorService/v1")
public class GVXException_Exception extends Exception {
    public static final long serialVersionUID = 20100504103859L;
    
    private https.sassgateway_adp_com.vendorxml.vendorservice.v1.GVXException gvxException;

    public GVXException_Exception() {
        super();
    }
    
    public GVXException_Exception(String message) {
        super(message);
    }
    
    public GVXException_Exception(String message, Throwable cause) {
        super(message, cause);
    }

    public GVXException_Exception(String message, https.sassgateway_adp_com.vendorxml.vendorservice.v1.GVXException gvxException) {
        super(message);
        this.gvxException = gvxException;
    }

    public GVXException_Exception(String message, https.sassgateway_adp_com.vendorxml.vendorservice.v1.GVXException gvxException, Throwable cause) {
        super(message, cause);
        this.gvxException = gvxException;
    }

    public https.sassgateway_adp_com.vendorxml.vendorservice.v1.GVXException getFaultInfo() {
        return this.gvxException;
    }
}
