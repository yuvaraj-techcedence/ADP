
package https.sassgateway_adp_com.vendorxml.vendorservice.v1;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the https.sassgateway_adp_com.vendorxml.vendorservice.v1 package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GVXException_QNAME = new QName("https://sassgateway.adp.com/vendorxml/VendorService/v1", "GVXException");
    private final static QName _FulfillCriminalHistoryResponse_QNAME = new QName("https://sassgateway.adp.com/vendorxml/VendorService/v1", "fulfillCriminalHistoryResponse");
    private final static QName _Ping_QNAME = new QName("https://sassgateway.adp.com/vendorxml/VendorService/v1", "ping");
    private final static QName _PingResponse_QNAME = new QName("https://sassgateway.adp.com/vendorxml/VendorService/v1", "pingResponse");
    private final static QName _FulfillCriminalHistory_QNAME = new QName("https://sassgateway.adp.com/vendorxml/VendorService/v1", "fulfillCriminalHistory");
    private final static QName _GetWorkResponse_QNAME = new QName("https://sassgateway.adp.com/vendorxml/VendorService/v1", "getWorkResponse");
    private final static QName _GetWork_QNAME = new QName("https://sassgateway.adp.com/vendorxml/VendorService/v1", "getWork");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: https.sassgateway_adp_com.vendorxml.vendorservice.v1
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link VendorWork }
     * 
     */
    public VendorWork createVendorWork() {
        return new VendorWork();
    }

    /**
     * Create an instance of {@link GVXException }
     * 
     */
    public GVXException createGVXException() {
        return new GVXException();
    }

    /**
     * Create an instance of {@link Action }
     * 
     */
    public Action createAction() {
        return new Action();
    }

    /**
     * Create an instance of {@link MessageBase }
     * 
     */
    public MessageBase createMessageBase() {
        return new MessageBase();
    }

    /**
     * Create an instance of {@link Ping }
     * 
     */
    public Ping createPing() {
        return new Ping();
    }

    /**
     * Create an instance of {@link BasePojo }
     * 
     */
    public BasePojo createBasePojo() {
        return new BasePojo();
    }

    /**
     * Create an instance of {@link ProductAttribute }
     * 
     */
    public ProductAttribute createProductAttribute() {
        return new ProductAttribute();
    }

    /**
     * Create an instance of {@link MessageVendorGetWork }
     * 
     */
    public MessageVendorGetWork createMessageVendorGetWork() {
        return new MessageVendorGetWork();
    }

    /**
     * Create an instance of {@link MessageVendorFulfillWork }
     * 
     */
    public MessageVendorFulfillWork createMessageVendorFulfillWork() {
        return new MessageVendorFulfillWork();
    }

    /**
     * Create an instance of {@link CriminalHistoryResult }
     * 
     */
    public CriminalHistoryResult createCriminalHistoryResult() {
        return new CriminalHistoryResult();
    }

    /**
     * Create an instance of {@link Offense }
     * 
     */
    public Offense createOffense() {
        return new Offense();
    }

    /**
     * Create an instance of {@link FulfillCriminalHistoryResponse }
     * 
     */
    public FulfillCriminalHistoryResponse createFulfillCriminalHistoryResponse() {
        return new FulfillCriminalHistoryResponse();
    }

    /**
     * Create an instance of {@link OffenseClassification }
     * 
     */
    public OffenseClassification createOffenseClassification() {
        return new OffenseClassification();
    }

    /**
     * Create an instance of {@link CriminalHistoryDuration }
     * 
     */
    public CriminalHistoryDuration createCriminalHistoryDuration() {
        return new CriminalHistoryDuration();
    }

    /**
     * Create an instance of {@link MessageVendorPing }
     * 
     */
    public MessageVendorPing createMessageVendorPing() {
        return new MessageVendorPing();
    }

    /**
     * Create an instance of {@link MessageVendorAcknowledgement }
     * 
     */
    public MessageVendorAcknowledgement createMessageVendorAcknowledgement() {
        return new MessageVendorAcknowledgement();
    }

    /**
     * Create an instance of {@link FulfillCriminalHistory }
     * 
     */
    public FulfillCriminalHistory createFulfillCriminalHistory() {
        return new FulfillCriminalHistory();
    }

    /**
     * Create an instance of {@link PingResponse }
     * 
     */
    public PingResponse createPingResponse() {
        return new PingResponse();
    }

    /**
     * Create an instance of {@link Address }
     * 
     */
    public Address createAddress() {
        return new Address();
    }

    /**
     * Create an instance of {@link PersonIdentifier }
     * 
     */
    public PersonIdentifier createPersonIdentifier() {
        return new PersonIdentifier();
    }

    /**
     * Create an instance of {@link GetWorkResponse }
     * 
     */
    public GetWorkResponse createGetWorkResponse() {
        return new GetWorkResponse();
    }

    /**
     * Create an instance of {@link Case }
     * 
     */
    public Case createCase() {
        return new Case();
    }

    /**
     * Create an instance of {@link GetWork }
     * 
     */
    public GetWork createGetWork() {
        return new GetWork();
    }

    /**
     * Create an instance of {@link ProductInformation }
     * 
     */
    public ProductInformation createProductInformation() {
        return new ProductInformation();
    }

    /**
     * Create an instance of {@link ValidationMessage }
     * 
     */
    public ValidationMessage createValidationMessage() {
        return new ValidationMessage();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GVXException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "https://sassgateway.adp.com/vendorxml/VendorService/v1", name = "GVXException")
    public JAXBElement<GVXException> createGVXException(GVXException value) {
        return new JAXBElement<GVXException>(_GVXException_QNAME, GVXException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FulfillCriminalHistoryResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "https://sassgateway.adp.com/vendorxml/VendorService/v1", name = "fulfillCriminalHistoryResponse")
    public JAXBElement<FulfillCriminalHistoryResponse> createFulfillCriminalHistoryResponse(FulfillCriminalHistoryResponse value) {
        return new JAXBElement<FulfillCriminalHistoryResponse>(_FulfillCriminalHistoryResponse_QNAME, FulfillCriminalHistoryResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Ping }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "https://sassgateway.adp.com/vendorxml/VendorService/v1", name = "ping")
    public JAXBElement<Ping> createPing(Ping value) {
        return new JAXBElement<Ping>(_Ping_QNAME, Ping.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PingResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "https://sassgateway.adp.com/vendorxml/VendorService/v1", name = "pingResponse")
    public JAXBElement<PingResponse> createPingResponse(PingResponse value) {
        return new JAXBElement<PingResponse>(_PingResponse_QNAME, PingResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FulfillCriminalHistory }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "https://sassgateway.adp.com/vendorxml/VendorService/v1", name = "fulfillCriminalHistory")
    public JAXBElement<FulfillCriminalHistory> createFulfillCriminalHistory(FulfillCriminalHistory value) {
        return new JAXBElement<FulfillCriminalHistory>(_FulfillCriminalHistory_QNAME, FulfillCriminalHistory.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetWorkResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "https://sassgateway.adp.com/vendorxml/VendorService/v1", name = "getWorkResponse")
    public JAXBElement<GetWorkResponse> createGetWorkResponse(GetWorkResponse value) {
        return new JAXBElement<GetWorkResponse>(_GetWorkResponse_QNAME, GetWorkResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetWork }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "https://sassgateway.adp.com/vendorxml/VendorService/v1", name = "getWork")
    public JAXBElement<GetWork> createGetWork(GetWork value) {
        return new JAXBElement<GetWork>(_GetWork_QNAME, GetWork.class, null, value);
    }

}
