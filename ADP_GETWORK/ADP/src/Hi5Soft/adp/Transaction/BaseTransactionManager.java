/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 * https://gatewayws-bas.adp.com/vendorxml/VendorService/v1
 * https://gatewayws-bas.adp.com:443/vendorxml/VendorService/v1/VendorService
 */
package Hi5Soft.adp.Transaction;

import au.com.bytecode.opencsv.*;
import https.sassgateway_adp_com.vendorxml.vendorservice.v1.*;
import java.io.*;
import java.net.URL;
import java.security.KeyStore;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.net.ssl.*;
import javax.swing.JOptionPane;
import javax.xml.namespace.QName;
import org.apache.cxf.configuration.jsse.TLSClientParameters;
import org.apache.cxf.configuration.security.FiltersType;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;
import org.apache.cxf.ws.security.wss4j.WSS4JOutInterceptor;
import org.apache.ws.security.WSConstants;
import org.apache.ws.security.handler.WSHandlerConstants;

/**
 *
 * @author admin
 */
public class BaseTransactionManager {

    public int currentTotlaRecordCount = 10;
    DataBaseHandler dbHandler;
    protected static final QName SERVICE_NAME = new QName(
            "https://sassgateway.adp.com/vendorxml/VendorService/v1",
            "VendorServiceImplService");
    protected VendorServiceFit portFit;
    protected Properties p = new Properties();
    protected org.apache.cxf.endpoint.Client client = null;
    private DataBaseHandler mDataBaseHandler;

    public void loadValues() throws Exception {
        p.load(ClassLoader.getSystemResourceAsStream("gvxData.properties"));
    }

    protected void setService(URL wsdlURL, String hostlocation)
            throws Exception {
        loadValues();

        if (hostlocation.equals("FIT")) {
            VendorServiceFitImplService serviceFIT = new VendorServiceFitImplService(
                    wsdlURL, SERVICE_NAME);
            portFit = serviceFIT.getVendorServiceFitImplPort();
            client = org.apache.cxf.frontend.ClientProxy.getClient(portFit);
        }

        // ******************************************************//
        client.getInInterceptors().add(new LoggingInInterceptor());
        client.getOutInterceptors().add(new LoggingOutInterceptor());

        org.apache.cxf.endpoint.Endpoint cxfEndpoint = client.getEndpoint();

        Map<String, Object> signatureProps = new HashMap<String, Object>();
        // signatureProps.put(WSHandlerConstants.ACTION,
        // WSHandlerConstants.SIGNATURE);

        signatureProps.put(WSHandlerConstants.ACTION,
                WSHandlerConstants.USERNAME_TOKEN + " "
                + WSHandlerConstants.TIMESTAMP + " "
                + WSHandlerConstants.SIGNATURE);
        if (hostlocation.equals("FIT")) {
            signatureProps.put(WSHandlerConstants.USER, p.getProperty("fit_user"));
            signatureProps.put(WSHandlerConstants.SIG_PROP_FILE,
                    "client_sign_fit.properties");
        }

        signatureProps.put(WSHandlerConstants.PASSWORD_TYPE,
                WSConstants.PW_TEXT);
        signatureProps.put(WSHandlerConstants.PW_CALLBACK_CLASS,
                ClientPasswordCallback.class.getName());
        signatureProps.put(WSHandlerConstants.SIG_KEY_ID, "SKIKeyIdentifier");

        WSS4JOutInterceptor signatureInterceptor = new WSS4JOutInterceptor(
                signatureProps);

        cxfEndpoint.getOutInterceptors().add(signatureInterceptor);
        // cxfEndpoint.getEndpointInfo().setAddress("https://int.adpselect.com:9999");

        TLSClientParameters tlsParams = new TLSClientParameters();

        // REMOVE IN PROD this and the "ditkeystore.jks" to trust invalid cert
        tlsParams.setDisableCNCheck(true);

        KeyStore keyStoreJKS = KeyStore.getInstance("jks");

        // KeyStore keyStorePKCS12 = KeyStore.getInstance("PKCS12");
        String trustpass = "password";
        File truststore = null;
        File truststore2 = null;
        if (hostlocation.equals("FIT")) {

            truststore = new File(p.getProperty("fit_cert_path"));
            truststore2 = new File(p.getProperty("fit_multi_cert_path"));
            keyStoreJKS.load(new FileInputStream(truststore), trustpass.toCharArray());
            TrustManagerFactory trustFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustFactory.init(keyStoreJKS);
            TrustManager[] tm = trustFactory.getTrustManagers();
            tlsParams.setTrustManagers(tm);
        }

        keyStoreJKS.load(new FileInputStream(truststore2), trustpass.toCharArray());
        KeyManagerFactory keyFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        keyFactory.init(keyStoreJKS, trustpass.toCharArray());
        KeyManager[] km = keyFactory.getKeyManagers();
        tlsParams.setKeyManagers(km);
        FiltersType filter = new FiltersType();
        filter.getInclude().add(".*_EXPORT_.*");
        filter.getInclude().add(".*_EXPORT1024_.*");
        filter.getInclude().add(".*_WITH_DES_.*");
        filter.getInclude().add(".*_WITH_NULL_.*");
        /*
         * Anu - Following is a production grade cipher suite that needs to be
         * added.
         */
        filter.getInclude().add(".*_WITH_AES_128_.*");
        filter.getInclude().add(".*_WITH_AES_256_.*");
        filter.getExclude().add(".*_DH_anon_.*");
        tlsParams.setCipherSuitesFilter(filter);
        ((HTTPConduit) client.getConduit()).setTlsClientParameters(tlsParams);
    }

    public boolean IsWebServiceAvailable() throws Exception {
        String locURL = Hi5Utils.GetApplicationRoot();
        Properties config = Hi5Utils.GetConfigProperties();

        locURL = "file:/" + locURL + "/" + config.getProperty("wsdlFile");
        locURL = locURL.replaceAll(" ", "%20");
        locURL = locURL.replace('\\', '/');
        System.out.println(locURL);

        //setService(new URL("file:/D:/Test/Java/DP%20Prototype/GVXClient-DatapowerV5/src/SASSVendorServiceV1.wsdl"), "FIT");
        //setService(new URL("file:/C:/ADPService/Application/build/classes/SASSVendorServiceV1.wsdl"), "FIT");
        setService(new URL(locURL), "FIT");
        System.out.println("Invoking ping(FIT)...");

        MessageVendorPing _ping_pingRequest = new MessageVendorPing();
        _ping_pingRequest.setUserId(p.getProperty("fit_userid"));

        try {
            MessageVendorAcknowledgement _ping__return = portFit.ping(_ping_pingRequest);
            System.out.println("ping.result=" + _ping__return);
            System.out.println("The status: " + _ping__return.getOverallStatus());
            return (_ping__return.getOverallStatus() == AcknowledgementStatusEnum.SERVICE_AVAILABLE);
            //return true;
        } catch (GVXException_Exception e) {
            System.out.println("Expected exception: GVXException has occurred.");
            System.out.println(e.toString());
        }

        return false;
    }

    public boolean GetWork(String _csvOutputFilePath, String xmlOutputFilePath) throws Exception {

        //  setService(, xmlOutputFilePath);
        //  new DataBaseHandler(null, null);
        MessageVendorGetWork _getwork_getworkRequest = new MessageVendorGetWork();
        _getwork_getworkRequest.setUserId(p.getProperty("fit_userid"));

        _getwork_getworkRequest.setExistingWork(getExistingWorkValue());
        System.out.println("Invoking getwork (FIT)...");

        System.out.println("Invoking TRY BLOCK CALLED...");
        try {
            LoggingInInterceptor inIns = new LoggingInInterceptor();
            java.io.PrintWriter inLog = new java.io.PrintWriter(xmlOutputFilePath);
            inIns.setPrintWriter(inLog);
            HTTPConduit http = (HTTPConduit) client.getConduit();
            http.getClient().setConnectionTimeout(1000 * 120 * 120);

            client.getInInterceptors().clear();
            inIns.setLimit(1024 * 1024 * 1024);
            client.getInInterceptors().add(inIns);
            MessageVendorAcknowledgement _getwork__return = portFit.getWork(_getwork_getworkRequest);
            client.getInInterceptors().remove(inIns);
            inLog.close();

            if (_getwork__return.getVendorWorks().size() > 0) {
                mDataBaseHandler = new DataBaseHandler();
                //  java.io.FileWriter outPut = new java.io.FileWriter(csvOutputFilePath);
                //  CSVWriter csvWriter = new CSVWriter(outPut);
                // outPut.write("batchDate, batchID, searchType, County, State, YrsSearch, ClientCode, Fname, Middle, Lname, SSN, DOB, Gender, Race, Address-1, Address-2, Address-3, City, State, ZIP, ProductName, suffix, productGroup");
                // outPut.write("\r\n");

                for (int i = 0; i < _getwork__return.getVendorWorks().size(); i++) {
                    // System.out.println("GET WORK FOR LOOPING CALLED");
                    ArrayList<HashMap<String, String>> aAlist = new ArrayList<HashMap<String, String>>();
                    VendorWork wrk = _getwork__return.getVendorWorks().get(i);
                    Address adds = wrk.getPersonAddress();
                    PersonIdentifier person = wrk.getPersonIdentifier();
                    ProductInformation prodInfo = wrk.getProductInformation();
                    String att1 = "", att2 = "", att3 = "", att4 = "", att5 = "";
                    for (int attCnt = 0; attCnt < prodInfo.getProductAttributes().size(); attCnt++) {
                        String nm = prodInfo.getProductAttributes().get(attCnt).getName().toUpperCase();
                        HashMap<String, String> map = new HashMap<String, String>();
                        if (nm.startsWith("ATTRI")) {
                            nm = nm.replaceAll("ATTRIBUTE", "");
                            int att = Integer.parseInt(nm);
                            switch (att) {
                                case 1:
                                    att1 = prodInfo.getProductAttributes().get(attCnt).getValue();
                                    map.put("name", "Attribute1");
                                    map.put("value", att1);
                                    aAlist.add(map);
                                    break;
                                case 2:
                                    att2 = prodInfo.getProductAttributes().get(attCnt).getValue();
                                    map.put("name", "Attribute2");
                                    map.put("value", att2);
                                    aAlist.add(map);
                                    break;
                                case 3:
                                    att3 = prodInfo.getProductAttributes().get(attCnt).getValue();
                                    map.put("name", "Attribute3");
                                    map.put("value", att3);
                                    aAlist.add(map);
                                    break;
                                case 4:
                                    att4 = prodInfo.getProductAttributes().get(attCnt).getValue();
                                    map.put("name", "Attribute4");
                                    map.put("value", att4);
                                    aAlist.add(map);
                                    break;
                                case 5:
                                    att5 = prodInfo.getProductAttributes().get(attCnt).getValue();
                                    map.put("name", "Attribute5");
                                    map.put("value", att5);
                                    aAlist.add(map);
                                    break;
                            }
                        }
                    }

                    int cnt = 0;
                    String vals[] = new String[25];
                    vals[cnt++] = wrk.getBatchDate();
                    vals[cnt++] = "N/A";
                    vals[cnt++] = att5;
                    vals[cnt++] = att3;
                    vals[cnt++] = att1;
                    vals[cnt++] = (att4.equals("STANDARD")) ? "7" : "10";
                    vals[cnt++] = wrk.getSassRefString(); //"N/A";
                    vals[cnt++] = person.getFirstName();
                    vals[cnt++] = person.getMiddleName();
                    vals[cnt++] = person.getLastName();
                    vals[cnt++] = "\"" + person.getSsn() + "\"";
                    vals[cnt++] = person.getDateOfBirth();
                    vals[cnt++] = person.getGender();
                    vals[cnt++] = person.getRace();
                    vals[cnt++] = adds.getAddressLine1();
                    vals[cnt++] = adds.getAddressLine2();
                    vals[cnt++] = "N/A";
                    vals[cnt++] = adds.getCity();
                    vals[cnt++] = adds.getState();
                    vals[cnt++] = adds.getZipCode();
                    //vals[cnt++] = wrk.getSassRefString() + "";
                    vals[cnt++] = prodInfo.getProductName();
                    vals[cnt++] = person.getSuffix();

                    // csvWriter.writeNext(vals);
                    try {

                        HashMap<String, String> mMap = new HashMap<String, String>();
                        mMap.put("batchDate", wrk.getBatchDate());
                        mMap.put("addressLine1", adds.getAddressLine1());
                        mMap.put("addressLine2", adds.getAddressLine2());
                        mMap.put("city", adds.getCity());
                        mMap.put("state", adds.getState());
                        mMap.put("zipCode", adds.getZipCode());

                        // persion Info
                        mMap.put("dateOfBirth", person.getDateOfBirth());
                        mMap.put("firstName", person.getFirstName());
                        //  mMap.put("gender", pElement.getElementsByTagName("gender").item(0).getTextContent());
                        mMap.put("lastName", person.getLastName());
                        mMap.put("middleName", person.getMiddleName());
                        mMap.put("race", person.getRace());
                        mMap.put("ssn", person.getSsn());

                        // product name
                        mMap.put("productName", prodInfo.getProductName());
                        //    mMap.put("productGroup", pElement.getElementsByTagName("productGroup").item(0).getTextContent());
                        mMap.put("sassRefString", wrk.getSassRefString());
                        //    mMap.put("sssRefString", wrk.getSassRefString());
                        mDataBaseHandler.statrtDataBaseHandler(mMap, aAlist);
                    } catch (Exception e) {
                        System.out.println("ERROR IN hash amp converstion===>" + e.getMessage());
                    }
                }

                // csvWriter.close();
                // outPut.close();
            }

            return true;
        } catch (GVXException_Exception e) {
            System.out.println("Expected exception: GVXException has occurred.");
            System.out.println(e.toString());

        }

        return false;
    }

    public boolean FullFillCriminalHistory(String srcPath, String finishedFilesPath) throws Exception {
        // java.io.File file = new java.io.File(srcPath);
        // java.io.File files[] = file.listFiles();
        // if (files.length > 0) {

        MessageVendorFulfillWork _fullfill_fullfillRequest = new MessageVendorFulfillWork();
        _fullfill_fullfillRequest.setUserId(p.getProperty("fit_userid"));

        HTTPConduit http = (HTTPConduit) client.getConduit();
        http.getClient().setConnectionTimeout(1000 * 60 * 30);

        // HTTPClientPolicy policy = http.getClient();
// set time to wait for response in milliseconds. zero means unlimited
        // policy.setReceiveTimeout(0);          
        System.out.println("Invoking Fullfill (FIT)... : " + http.getClient().getConnectionTimeout());
        _fullfill_fullfillRequest.setAmended(getAmmendedVAlue());

//            Scanner in = new Scanner(System.in);
//                  System.out.println("Enter a string for adding data to xml");
//     String ss = in.nextLine();
//      System.out.println("You entered string "+ss);
        dbHandler = new DataBaseHandler();

        String currentSSRef = "";
        List<CriminalHistoryResult> results = new ArrayList<CriminalHistoryResult>();
        java.util.Hashtable<String, CriminalHistoryResult> historyItems
                = new java.util.Hashtable<String, CriminalHistoryResult>();
        java.util.Hashtable<String, Case> caseHistoryItems
                = new java.util.Hashtable<String, Case>();
        ErrorLogCreator _errorLogCreator = null;
        ResultSet rs = null;
        // String reportIDFromtxtFile= getReportIDValueFromTxtFile();
        //if reports is  in txt file
//                  if(reportIDFromtxtFile.length()>=2)
//                  {
//                         rs=  dbHandler.getFuilfillDataUseingRerportID(srcPath);
//                  }
//                  else 
        if (dbHandler.hasClearRecords()) {
            rs = dbHandler.getCriminalHistoryData();
        } else {
            rs = dbHandler.getCriminalHistoryDataContainsHitData(currentTotlaRecordCount);
        }
        while (rs.next()) {
//   System.out.println("in for loop");
//     ss = in.nextLine();

            int orderReportID = rs.getInt(2);
            if (_errorLogCreator == null) {
                _errorLogCreator = new ErrorLogCreator();
            }
            _errorLogCreator.createTitleToErrorLog("orderReportID === > " + orderReportID);
            ArrayList<HashMap<String, String>> criminalCaseReportData = dbHandler.getDataFromCriminalCaseReport("" + orderReportID, _errorLogCreator);
            String responce[] = new String[80];
            for (int ary = 0; ary < 80; ary++) {
                responce[ary] = "";
            }

            for (int k = 0; k < criminalCaseReportData.size(); k++) {
                HashMap<String, String> criminalCaseReportMapData = criminalCaseReportData.get(k);
                responce[0] = rs.getString(3);
                if (rs.getString(4).trim().equals("HIT")) {
                    responce[2] = "Y";
                } else {
                    responce[2] = "N";
                }
                responce[3] = criminalCaseReportMapData.get("Source");
                responce[4] = criminalCaseReportMapData.get("lastName");
                responce[5] = criminalCaseReportMapData.get("firstName");
                responce[6] = criminalCaseReportMapData.get("MiddleName");
                responce[7] = ChangeDateFormat(criminalCaseReportMapData.get("DOB"));
                responce[8] = criminalCaseReportMapData.get("ssn");
                currentSSRef = criminalCaseReportMapData.get("ssn");
                // responce[20]=criminalCaseReportMapData.get("CaseFileDate");  

                responce[21] = ChangeDateFormat(criminalCaseReportMapData.get("CaseFileDate").toString().trim());
                String caseNumberStr = criminalCaseReportMapData.get("CaseNumber");
                // caseNumberStr="123456789012345678901";
                if (caseNumberStr.length() >= 21) {
                    responce[20] = caseNumberStr.substring(0, 20);
                } else {
                    responce[20] = caseNumberStr;
                }

                HashMap<String, String> CriminalCaseAdditionalIdentifierData = dbHandler.getDataFormCriminalCaseAdditionalIdentifiersTable(criminalCaseReportMapData.get("CriminalCaseID"), _errorLogCreator);

                responce[9] = CriminalCaseAdditionalIdentifierData.get("Race");
                // responce[10]= CriminalCaseAdditionalIdentifierData.get("StreetAddress");
                responce[11] = CriminalCaseAdditionalIdentifierData.get("Height");
                responce[12] = CriminalCaseAdditionalIdentifierData.get("Weight");
                responce[13] = CriminalCaseAdditionalIdentifierData.get("HairColor");
                responce[14] = CriminalCaseAdditionalIdentifierData.get("EyeColor");
                //responce[15]= CriminalCaseAdditionalIdentifierData.get("StreetAddress");      
                responce[16] = CriminalCaseAdditionalIdentifierData.get("StreetAddress");
                responce[17] = CriminalCaseAdditionalIdentifierData.get("City");
                responce[18] = CriminalCaseAdditionalIdentifierData.get("State");
                responce[19] = CriminalCaseAdditionalIdentifierData.get("Zip");
                responce[10] = CriminalCaseAdditionalIdentifierData.get("Gender");
                ArrayList<HashMap<String, String>> criminalChragesTableData = dbHandler.getDataFromcriminalChargesTable(criminalCaseReportMapData.get("CriminalCaseID"), _errorLogCreator);
                for (int j = 0; j < criminalChragesTableData.size(); j++) {
                    HashMap<String, String> criminalChargesMapData = criminalChragesTableData.get(j);
                    //responce[33]=criminalChargesMapData.get("ConfinementCreditedMonths");

                    // getting subl table values
                    //  <originalOffenseClassification>OriginalChargeLevel
                    String finalTypeStr = dbHandler.getChargeLevelID(criminalChargesMapData.get("FinalChargeLevel"), _errorLogCreator);
                    System.out.println("finalTypeStr====>" + criminalChargesMapData.get("FinalChargeLevel"));
                    // String  finaloffenseStr=  dbHandler.getChargeLevelID(criminalChargesMapData.get("FinalChargeLevel"));
                    responce[30] = finalTypeStr;
                    responce[29] = criminalChargesMapData.get("FinalChargeDescription");

                    String orginalTypeStr = dbHandler.getChargeLevelID(criminalChargesMapData.get("OriginalChargeLevel"), _errorLogCreator);
                    String orginaloffenseStr = dbHandler.getChargeLevelID(criminalChargesMapData.get("OriginalChargeDescription"), _errorLogCreator);
                    responce[24] = orginalTypeStr;
                    responce[23] = orginaloffenseStr;
                    if (criminalChargesMapData.get("Cost").toString().equalsIgnoreCase("Yes")) {
                        responce[61] = "Y";
                    } else if (criminalChargesMapData.get("Cost").toString().equalsIgnoreCase("No")) {
                        responce[61] = "N";
                    } else {
                        responce[61] = "";
                    }
                    if (criminalChargesMapData.get("Fine").toString().equalsIgnoreCase("Yes")) {
                        responce[62] = "Y";
                    } else if (criminalChargesMapData.get("Fine").toString().equalsIgnoreCase("No")) {
                        responce[62] = "N";
                    } else {
                        responce[62] = "";
                    }

                    responce[59] = criminalChargesMapData.get("CostFineRestitutionAmount");
                    responce[60] = criminalChargesMapData.get("AmountSuspended");

                    //   <finalOffenseClassification>
                    // getting </criminalDispositionPhrase>
                    System.out.println("id===?" + criminalChargesMapData.get("FinalDisposition") + "===");
                    String dispositionDetailsStr = dbHandler.getDisPosiTionDetails(criminalChargesMapData.get("FinalDisposition"), _errorLogCreator);
                    System.out.println("value for id" + dispositionDetailsStr + "===");

                    responce[32] = dispositionDetailsStr;
                    responce[35] = ChangeDateFormat(criminalChargesMapData.get("FinalDispositionDate"));
                    responce[36] = dbHandler.getFacilitiesDetails(criminalChargesMapData.get("ConfinementFacility"), _errorLogCreator);
                    responce[37] = criminalChargesMapData.get("ConfinementFacilityDays");
                    responce[38] = criminalChargesMapData.get("ConfinementFacilityMonths");
                    responce[39] = criminalChargesMapData.get("ConfinementFacilityYears");

                    responce[40] = criminalChargesMapData.get("ConfinementCreditedDays");
                    responce[41] = criminalChargesMapData.get("ConfinementCreditedMonths");
                    responce[42] = criminalChargesMapData.get("ConfinementCreditedYears");

                    responce[43] = criminalChargesMapData.get("ConfinementStayedDays");
                    responce[44] = criminalChargesMapData.get("ConfinementStayedMonths");
                    responce[45] = criminalChargesMapData.get("ConfinementStayedYears");

                    responce[46] = criminalChargesMapData.get("ConfinementSuspendedDays");
                    responce[47] = criminalChargesMapData.get("ConfinementSuspendedMonths");
                    responce[48] = criminalChargesMapData.get("ConfinementSuspendedYears");

                    responce[51] = criminalChargesMapData.get("WarrantStartReason");
                    responce[52] = ChangeDateFormat(criminalChargesMapData.get("WarrantStartDate"));
                    responce[53] = criminalChargesMapData.get("WarrantEndReason");
                    responce[54] = ChangeDateFormat(criminalChargesMapData.get("WarrantEndDate"));

                    responce[33] = criminalChargesMapData.get("DispositionPendingNextDate");
                    responce[48] = criminalChargesMapData.get("ConfinementSuspendedYears");
                    responce[56] = criminalChargesMapData.get("ProBationDays");
                    responce[57] = criminalChargesMapData.get("ProbationsMonths");
                    responce[58] = criminalChargesMapData.get("ProBationYears");
                    responce[64] = criminalChargesMapData.get("AdditionalSentenceInformation");
                    String proType = criminalChargesMapData.get("ProBationType");

                    responce[55] = dbHandler.getProbationDetails(proType, _errorLogCreator);
                    if (criminalChargesMapData.get("Restitution").toString().equalsIgnoreCase("Yes")) {
                        responce[63] = "Y";
                    } else if (criminalChargesMapData.get("Restitution").toString().equalsIgnoreCase("No")) {
                        responce[63] = "N";
                    }

                    // removing NULL value from string array
                    for (int ary = 0; ary < 80; ary++) {
                        try {
                            if (responce[ary].equalsIgnoreCase("NULL")) {
                                responce[ary] = "";
                            }
                        } catch (Exception e) {

                        }

                    }
                    System.out.println(responce[0] + " => " + responce[1] + " => " + responce[0]);

                    if (responce[0].length() <= 2) {
                        continue;
                    }

                    String sassRefString = responce[0].trim();

                    CriminalHistoryResult result = new CriminalHistoryResult();
                    if (historyItems.containsKey(sassRefString)) {
                        result = historyItems.get(sassRefString);
                    } else {
                        result.setRecord(responce[2]);//p.getProperty("record")); //Not Found
                        result.setSassRefString(sassRefString);
                        historyItems.put(sassRefString, result);
                        results.add(result);
                    }
                    //result.setSassRefString("1118427-20372207-4-172705789");

                    if (responce[2].equals("Y")) {
                        String caseNumber = responce[20].trim();
                        String caseSassRefString = sassRefString + "_" + caseNumber;
                        Case historyCase = new Case();
                        List<Offense> offenseList = null;

                        if (caseHistoryItems.containsKey(caseSassRefString)) {
                            historyCase = caseHistoryItems.get(caseSassRefString);
                            offenseList = historyCase.getOffenses();
                        } else {
                            historyCase.setFileDate(responce[21]);
                            //cases.setArrestDate(responce[3]);Not Found-New
                            historyCase.setCaseNum(caseNumber);
                            historyCase.setAgencyName(responce[3]); //Not Found
                            historyCase.setAlternateId(responce[15]); //Not Found-New

                            PersonIdentifier personIdentifier = new PersonIdentifier();
                            personIdentifier = new PersonIdentifier();
                            personIdentifier.setFirstName(responce[5]);
                            personIdentifier.setMiddleName(responce[6]);//Not Found - Only we have name on the file
                            personIdentifier.setLastName(responce[4]);//Not Found - Only we have name on the file
                            //personIdentifier.setSuffix(p.getProperty("suffix"));//Not Found
                            personIdentifier.setDateOfBirth(responce[7]);
                            personIdentifier.setSsn(responce[8]);
                            personIdentifier.setRace(responce[9]);
                            personIdentifier.setGender(responce[10]);
                            personIdentifier.setHeight(responce[11]);
                            personIdentifier.setWeight(responce[12]);
                            personIdentifier.setHairColor(responce[13]);
                            personIdentifier.setEyeColor(responce[14]);
                            //personIdentifier.setScars(responce[10]);

                            List<PersonIdentifier> personIdentifiers = new ArrayList<PersonIdentifier>();
                            personIdentifiers.add(personIdentifier);

                            Address address = new Address();
                            address.setAddressLine1(responce[16]); //Address on File
                            //address.setAddressLine2(responce[18]);
                            address.setCity(responce[17]);
                            address.setState(responce[18]);
                            address.setZipCode(responce[19]);

                            List<Address> addresss = new ArrayList<Address>();
                            addresss.add(address);

                            historyCase.setPersonIdentifiers(personIdentifiers);
                            historyCase.setPersonAddress(addresss);

                            List<Case> historyCaseList = null;

                            historyCaseList = result.getCases();
                            if (historyCaseList == null) {
                                historyCaseList = new ArrayList<Case>();
                                //Add the case list into result list
                                result.setCases(historyCaseList);
                            }
                            historyCaseList.add(historyCase);

                            //Add the case information into history collection
                            caseHistoryItems.put(caseSassRefString, historyCase);

                            offenseList = new ArrayList<Offense>();
                            historyCase.setOffenses(offenseList);
                        }

                        /*
                                 * Offence data
                         */
                        Offense offense = new Offense();

                        //offense.setOffenseDate(responce[10]);
                        try {
                            offense.setOffenseCount(Integer.parseInt(responce[22]));
                        } catch (NumberFormatException ex) {
                            offense.setOffenseCount(1);
                        }

                        OffenseClassification oc = new OffenseClassification();
                        oc.setOffense(responce[23]);
                        oc.setType(responce[24]);
                        oc.setClassLevel(responce[25]);

                        OffenseClassification filingOffence = new OffenseClassification();
                        filingOffence.setOffense(responce[26]);
                        filingOffence.setType(responce[27]);
                        filingOffence.setClassLevel(responce[28]);

                        OffenseClassification fc1 = new OffenseClassification();
                        fc1.setOffense(responce[29]);
                        fc1.setType(responce[30]);
                        fc1.setClassLevel(responce[31]);

                        offense.setOriginalOffenseClassification(oc);
                        offense.setFilingOffenseClassification(filingOffence);
                        offense.setFinalOffenseClassification(fc1);

                        Action offAction = new Action();

                        offAction.setCriminalDispositionPhrase(responce[32]);
                        offAction.setNextCourtDate(responce[33]);
                        offAction.setPlea(responce[34]);
                        offAction.setActionDate(responce[35]);
                        offAction.setConfinement(responce[36]);

                        offAction.setReleaseType(responce[49]);
                        offAction.setReleaseDate(responce[50]);
                        offAction.setWarrantStartReason(responce[51]);
                        offAction.setWarrantStartDate(responce[52]);
                        offAction.setWarrantEndReason(responce[53]);
                        offAction.setWarrantEndDate(responce[54]);
                        offAction.setSupervision(responce[55]);//ProbationType

                        offAction.setAssessmentAmount(responce[59]);
                        offAction.setAssessmentAmountSuspended(responce[60]);
                        offAction.setAssessmentCosts(responce[61]);
                        offAction.setAssessmentFine(responce[62]);
                        offAction.setAssessmentRestitution(responce[63]);
                        offAction.setAdditionalInfo(responce[64]);

                        CriminalHistoryDuration cd = new CriminalHistoryDuration();//ConfinementDuration
                        CriminalHistoryDuration ccd = new CriminalHistoryDuration();//ConfinementCredited
                        CriminalHistoryDuration csd = new CriminalHistoryDuration();//ConfinementStayed
                        CriminalHistoryDuration csud = new CriminalHistoryDuration();//ConfinementSuspended
                        CriminalHistoryDuration sd = new CriminalHistoryDuration();//SupervisionDuration - ProbationDuration

                        //ConfinementDuration
                        cd.setDays(responce[37]);
                        cd.setMonths(responce[38]);
                        cd.setYears(responce[39]);

                        //ConfinementCredited
                        ccd.setDays(responce[40]);
                        ccd.setMonths(responce[41]);
                        ccd.setYears(responce[42]);

                        //ConfinementStayed
                        csd.setDays(responce[43]);
                        csd.setMonths(responce[44]);
                        csd.setYears(responce[45]);

                        //ConfinementSuspended
                        csud.setDays(responce[46]);
                        csud.setMonths(responce[47]);
                        csud.setYears(responce[48]);

                        //SupervisionDuration - ProbationDuration
                        sd.setDays(responce[56]);
                        sd.setMonths(responce[57]);
                        sd.setYears(responce[58]);

                        offAction.setConfinementDuration(cd);
                        offAction.setConfinementCreditedDuration(ccd);
                        offAction.setConfinementStayedDuration(csd);
                        offAction.setConfinementSuspendedDuration(csud);
                        //if(responce[36].length() > 0)
                        offAction.setSupervisionDuration(sd);

                        List<Action> offActionList = new ArrayList<Action>();
                        offActionList.add(offAction);
                        offense.setActions(offActionList);

                        offenseList.add(offense);

                    }

                }

            }

        }
        if (_errorLogCreator != null) {

            _fullfill_fullfillRequest.setCriminalHistoryResults(results);
            String datStr = "";
            try {
                MessageVendorAcknowledgement _fullfill__return = null;
                // String fileNamePhysical = files[filesCnt].getName();

                SimpleDateFormat dateFomr = new SimpleDateFormat("MMDDYYYHHMMSS");
                datStr = dateFomr.format(new Date());

                String responceXMLFile = finishedFilesPath + "\\responce." + datStr + ".xml";
                String requestXMLFile = finishedFilesPath + "\\request." + datStr + ".xml";
//                                 String responceXMLFile =   "D:\\"  + ".responce.xml";
//                           String requestXMLFile =  "D:\\"  + ".request.xml";
                java.io.PrintWriter inLog = new java.io.PrintWriter(responceXMLFile);
                java.io.PrintWriter outLog = new java.io.PrintWriter(requestXMLFile);

                LoggingInInterceptor inIns = new LoggingInInterceptor(inLog);
                LoggingOutInterceptor outIns = new LoggingOutInterceptor(outLog);
                outIns.setLimit(1024 * 1024 * 1024);

                client.getInInterceptors().clear();
                client.getOutInterceptors().clear();

                client.getInInterceptors().add(inIns);
                client.getOutInterceptors().add(outIns);

                Date dt1 = new Date();
                SimpleDateFormat ft1 = new SimpleDateFormat("dd-MM-yyyy kk-mm-ss");
                System.out.println("Start Time : " + ft1.format(dt1));

//                           if( _fullfill_fullfillRequest!=null)
//                           {
//                                 System.out.println("in null checking");
//     ss = in.nextLine();
                _fullfill__return = portFit.fulfillCriminalHistory(_fullfill_fullfillRequest);
                // }

                client.getInInterceptors().remove(inIns);
                client.getOutInterceptors().remove(outIns);
                inLog.close();
                outLog.close();
                System.out.println("fullfill.result=" + _fullfill__return);
                System.out.println("Status=: " + _fullfill__return.getOverallStatus().value());
                int invalidCount = _fullfill__return.getInvalidCriminalHistoryResults().size();

                if (invalidCount > 0) {
                    Date dt = new Date();
                    SimpleDateFormat ft = new SimpleDateFormat("dd-MM-yyyy kk-mm-ss");
                    String fileNameDT = ft.format(dt);

                    String outputFilePath = srcPath + "\\Invalid\\invalid_" + fileNameDT + ".csv";
                    java.io.FileWriter outPut = new java.io.FileWriter(outputFilePath);

                    outPut.write("sassRefString, Error1-Reason, Error1-Desc., Error2-Reason, Error2-Desc.");

                    for (int i = 0; i < invalidCount; i++) {
                        CriminalHistoryResult invalidRes = _fullfill__return.getInvalidCriminalHistoryResults().get(i);
                        outPut.write("\r\n" + invalidRes.getSassRefString() + ",");
                        String ssref = invalidRes.getSassRefString();

                        if (SaveValidationMessage(invalidRes.getValidationMessages(), outPut)) {
                            dbHandler.upDateReportStatusID(ssref, ssref, _errorLogCreator);
                        } else {
                            dbHandler.upDateReportStatusIDForFailure(ssref, datStr, _errorLogCreator);
                        }

                        for (int cnt = 0; cnt < invalidRes.getCases().size(); cnt++) {
                            Case cse = invalidRes.getCases().get(cnt);
                            SaveValidationMessage(cse.getValidationMessages(), outPut);
                            SaveActionValidationMessage(cse.getActions(), outPut);

                            for (int cnt1 = 0; cnt1 < cse.getOffenses().size(); cnt1++) {
                                Offense off = cse.getOffenses().get(cnt1);

                                SaveValidationMessage(off.getValidationMessages(), outPut);
                                SaveActionValidationMessage(off.getActions(), outPut);

                                if (off.getFilingOffenseClassification() != null) {
                                    SaveValidationMessage(off.getFilingOffenseClassification().getValidationMessages(), outPut);
                                }
                                if (off.getFinalOffenseClassification() != null) {
                                    SaveValidationMessage(off.getFinalOffenseClassification().getValidationMessages(), outPut);
                                }
                                if (off.getOriginalOffenseClassification() != null) {
                                    SaveValidationMessage(off.getOriginalOffenseClassification().getValidationMessages(), outPut);
                                }
                            }

                            for (int cnt1 = 0; cnt1 < cse.getPersonIdentifiers().size(); cnt1++) {
                                PersonIdentifier pi = cse.getPersonIdentifiers().get(cnt1);
                                SaveValidationMessage(pi.getValidationMessages(), outPut);
                            }

                            for (int cnt1 = 0; cnt1 < cse.getPersonAddress().size(); cnt1++) {
                                Address adds = cse.getPersonAddress().get(cnt1);

                                SaveValidationMessage(adds.getValidationMessages(), outPut);
                            }
                        }
                    }

                    outPut.close();
                    // form content for mail
                    String errorMessageHtmlStr = "<!DOCTYPE html>\n"
                            + "<html>\n"
                            + "<body><table style=\"width:100%\" border=\"1\">";
                    errorMessageHtmlStr += "<tr>\n"
                            + "    <th>sassRefString</th>\n"
                            + "    <th>Error1-Reason</th>		\n"
                            + "    <th>Error1-Desc.</th>\n" + "    <th>Error2-Reason</th>		\n"
                            + "    <th>Error2-Desc.</th>\n"
                            + "  </tr>";
                    CSVReader errorCsv = new CSVReader(new FileReader(outputFilePath), CSVParser.DEFAULT_SEPARATOR,
                            CSVParser.DEFAULT_QUOTE_CHARACTER, CSVParser.DEFAULT_ESCAPE_CHARACTER, 1);
                    List<String[]> errorresponceStrings = errorCsv.readAll();
                    errorCsv.close();
                    for (int listCnt = 0; listCnt < errorresponceStrings.size(); listCnt++) {
                        String errorResponce[] = errorresponceStrings.get(listCnt);
                        //System.out.println("THIS IS TEST STR====>"+errorResponce[0] + " => " + errorResponce[1] + " => " + errorResponce[0]);
                        errorMessageHtmlStr += "<tr>";
                        for (int j = 0; j < errorResponce.length; j++) {
                            errorMessageHtmlStr += "<td>" + errorResponce[j] + "</td>";
                        }

                        errorMessageHtmlStr += "<td>";

                    }
                    //send the Mail to all receipiants
                    MailClient mail = new MailClient();

                    errorMessageHtmlStr += "</table></body><html>";
                    mail.SendFullFillErrorMail(
                            //  "An error occured at <b>Fullfillment</b> of the file "+
                            errorMessageHtmlStr,
                            new String[]{requestXMLFile, responceXMLFile, outputFilePath});

                } else {
                    System.out.println("There is no invalid criminal history result");
                }

                if (_fullfill__return.getValidCriminalHistoryResults().size() > 0) {

                    for (int i = 0; i < _fullfill__return.getValidCriminalHistoryResults().size(); i++) {

                        CriminalHistoryResult vali = _fullfill__return.getValidCriminalHistoryResults().get(i);
                        String ssref = vali.getSassRefString();
                        dbHandler.upDateReportStatusID(ssref, datStr, _errorLogCreator);
                        /* for (int k = 0; k < _fullfill__return.getValidCriminalHistoryResults().get(i).getValidationMessages().size(); k++) {
                                        System.out.println("Reason type: "
                                                + _fullfill__return.getValidCriminalHistoryResults().get(i).getValidationMessages().get(k).getReasonType());
                                        System.out.println("Reason Descritpion: "
                                                + _fullfill__return.getValidCriminalHistoryResults().get(i).getValidationMessages().get(k).getReasonDescription());
                                    }*/
                    }
                } else {
                    System.out.println("There is no valid criminal history result");
                }

//                            System.out.println("Renaming File : " + files[filesCnt].getName());
//                            File movedFile = new File(finishedFilesPath + "\\" + files[filesCnt].getName());
//                            boolean val = files[filesCnt].renameTo(movedFile);
//                            System.out.println("Rename To : " + movedFile.getAbsolutePath() + "\nStatus: " + val);
            } catch (Exception e) {

                System.out.println("Expected exception: GVXException has occurred.");
                System.out.println(e.toString());
                if (_errorLogCreator != null);
                {
                    if (currentTotlaRecordCount == 10) {
                        currentTotlaRecordCount = 5;
                    } else if (currentTotlaRecordCount == 5) {
                        currentTotlaRecordCount = 1;
                    } else if (currentTotlaRecordCount == 0) {

                        dbHandler.upDateReportStatusIDForFailureInReadTimeOut(currentSSRef, datStr, _errorLogCreator);
                    }

                    StringWriter errors = new StringWriter();
                    e.printStackTrace(new PrintWriter(errors));

                    System.out.println("error ==>" + errors.toString());
                    _errorLogCreator.createErrorLog(errors.toString());
                }
                e.printStackTrace();
            }

            //}
            // }
            //  }
        }

        return false;
    }

    private void SaveActionValidationMessage(List<Action> actions, java.io.FileWriter outPut)
            throws java.io.IOException {
        if (actions == null) {
            return;
        }

        for (int cnt1 = 0; cnt1 < actions.size(); cnt1++) {
            Action act = actions.get(cnt1);

            SaveValidationMessage(act.getValidationMessages(), outPut);

            if (act.getConfinementCreditedDuration() != null) {
                SaveValidationMessage(act.getConfinementCreditedDuration().getValidationMessages(), outPut);
            }
            if (act.getConfinementDuration() != null) {
                SaveValidationMessage(act.getConfinementDuration().getValidationMessages(), outPut);
            }
            if (act.getConfinementStayedDuration() != null) {
                SaveValidationMessage(act.getConfinementStayedDuration().getValidationMessages(), outPut);
            }
            if (act.getConfinementSuspendedDuration() != null) {
                SaveValidationMessage(act.getConfinementSuspendedDuration().getValidationMessages(), outPut);
            }
            if (act.getSupervisionDuration() != null) {
                SaveValidationMessage(act.getSupervisionDuration().getValidationMessages(), outPut);
            }
        }
    }

    private boolean SaveValidationMessage(List<ValidationMessage> msg, java.io.FileWriter outPut)
            throws java.io.IOException {
        boolean status = false;
        if (msg == null) {
            return false;
        }

        for (int k = 0; k < msg.size(); k++) {
            ValidationMessage m = msg.get(k);

            outPut.write(m.getReasonType() + ",");
            outPut.write(m.getReasonDescription() + ",");

            System.out.println("Reason type: " + m.getReasonType());
            System.out.println("Reason Descritpion: " + m.getReasonDescription());
            if (m.getReasonDescription().contains("The record for the supplied sassRefString cannot be found. Please correct the sassRefString and retry")) {
                status = true;
            }

        }
        return status;
    }

    public String ChangeDateFormat(String _dateStr) {
        SimpleDateFormat fileDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            String dateStr = _dateStr;
            if (dateStr.length() >= 5) {
                SimpleDateFormat fom = new SimpleDateFormat("MM/dd/yyyy");
                Date fileDate1 = fom.parse(dateStr);
                String fileDateStr = fileDateFormat.format(fileDate1);
                return fileDateStr;
            } else {
                return dateStr;
            }
        } catch (Exception e) {
            System.out.println("Error in DAte form changing" + e.getMessage());
            return _dateStr;
        }
    }

    public String getAmmendedVAlue() {
        String s = "";
        try {
            File file = new File("amended.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            StringBuffer stringBuffer = new StringBuffer();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuffer.append(line);
                //stringBuffer.append("\n");
            }
            fileReader.close();
            System.out.println("Contents of file:");
            System.out.println(stringBuffer.toString());
            s = stringBuffer.toString().trim();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s;
    }

    public String getExistingWorkValue() {
        String s = "";
        try {
            File file = new File("ExistingWorkFlag.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            StringBuffer stringBuffer = new StringBuffer();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuffer.append(line);
                //stringBuffer.append("\n");
            }
            fileReader.close();
            System.out.println("Contents of file:");
            System.out.println(stringBuffer.toString());
            s = stringBuffer.toString().trim();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s;
    }

    public String getReportIDValueFromTxtFilee() {
        String s = "";
        try {
            File file = new File("report_id.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            StringBuffer stringBuffer = new StringBuffer();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuffer.append(line);
                //stringBuffer.append("\n");
            }
            fileReader.close();
            System.out.println("Contents of file:");
            System.out.println(stringBuffer.toString());
            s = stringBuffer.toString().trim();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s;
    }
}
