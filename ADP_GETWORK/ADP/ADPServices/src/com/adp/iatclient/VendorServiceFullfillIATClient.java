package com.adp.iatclient;

/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

import https.sassgateway_adp_com.vendorxml.vendorservice.v1.VendorServiceImplService;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import com.adp.base.VendorServiceSuperFullfill;

/**
 * This class was generated by Apache CXF 2.2.6 Thu Mar 04 10:13:03 MST 2010
 * Generated source version: 2.2.6
 * 
 */

public final class VendorServiceFullfillIATClient extends VendorServiceSuperFullfill {

		public static void main(String args[]) throws Exception {
		URL wsdlURL = VendorServiceImplService.WSDL_LOCATION;
		if (args.length > 0) {
			File wsdlFile = new File(args[0]);
			try {
				if (wsdlFile.exists()) {
					wsdlURL = wsdlFile.toURI().toURL();
				} else {
					wsdlURL = new URL(args[0]);
				}
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}
		VendorServiceFullfillIATClient client = new VendorServiceFullfillIATClient();
		client.setService(wsdlURL,"IAT");
		client.runTest("IAT");;
		
	}

	
}
