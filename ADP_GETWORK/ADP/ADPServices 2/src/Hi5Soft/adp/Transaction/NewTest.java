/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Hi5Soft.adp.Transaction;

import https.sassgateway_adp_com.vendorxml.vendorservice.v1.MessageVendorAcknowledgement;
import java.beans.XMLDecoder;
import java.io.FileInputStream;

/**
 *
 * @author admin
 */
public class NewTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
                try
        {
            FileInputStream os = new FileInputStream("D:\\31-01-2011 16-47-49.xml");
            XMLDecoder decoder = new XMLDecoder(os, null, null, MessageVendorAcknowledgement.class.getClassLoader());
            Object obj = decoder.readObject();
            System.out.println(obj.toString());
            //Person p = (Person)decoder.readObject();
            decoder.close();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }

    }

}
