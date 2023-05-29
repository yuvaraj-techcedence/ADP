
/*
 * 
 */

package https.sassgateway_adp_com.vendorxml.vendorservice.v1;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;



@WebServiceClient(name = "VendorServiceImplService", 
                  wsdlLocation = "https://stage-sassgateway.adp.com/vendorxml/VendorService/v1?wsdl",
                  targetNamespace = "https://sassgateway.adp.com/vendorxml/VendorService/v1") 
public class VendorServiceIATImplService extends Service {

    public final static URL WSDL_LOCATION;
    public final static QName SERVICE = new QName("https://sassgateway.adp.com/vendorxml/VendorService/v1", "VendorServiceImplService");
    public final static QName VendorServiceIATImplPort = new QName("https://sassgateway.adp.com/vendorxml/VendorService/v1", "VendorServiceImplPort");
  	 public final static String wsdl = "SASSVendorServiceV1.wsdl";
    static {
        URL url = null;
      	url = VendorServiceIATImplService.class.getClassLoader().getResource(wsdl);
    		WSDL_LOCATION = url;
      	
        if (url==null){  
        	System.err.println("Can not initialize the default wsdl" +wsdl);
        }
    }

    public VendorServiceIATImplService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public VendorServiceIATImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public VendorServiceIATImplService() {
        super(WSDL_LOCATION, SERVICE);
    }

    /**
     * 
     * @return
     *     returns VendorServiceFit
     */
    @WebEndpoint(name = "VendorServiceImplPort")
    public VendorServiceIAT getVendorServiceIATImplPort() {
        return super.getPort(VendorServiceIATImplPort, VendorServiceIAT.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns VendorServiceFit
     */
    @WebEndpoint(name = "VendorServiceImplPort")
    public VendorServiceIAT getVendorServiceIATImplPort(WebServiceFeature... features) {
        return super.getPort(VendorServiceIATImplPort, VendorServiceIAT.class, features);
    }

}
