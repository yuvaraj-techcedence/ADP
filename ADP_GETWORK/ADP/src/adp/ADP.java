/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adp;

import Hi5Soft.adp.Transaction.ADPVendorService;
import java.io.UnsupportedEncodingException;  
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;  
import java.util.logging.Level;  
import java.util.logging.Logger;  
import javax.mail.Authenticator;  
import javax.mail.Message;  
import javax.mail.MessagingException;  
import javax.mail.PasswordAuthentication;  
import javax.mail.Session;  
import javax.mail.Transport;  
import javax.mail.internet.InternetAddress;  
import javax.mail.internet.MimeMessage;  
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import static java.lang.System.err;
import java.util.Calendar;
/**
 *
 * @author GaneshKumar_2
 */
public class ADP {
    private static Object ex;
 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws UnsupportedEncodingException {
Calendar calendar = Calendar.getInstance();
calendar.setTime(new Date());
int hours = calendar.get(Calendar.HOUR_OF_DAY);
int minutes = calendar.get(Calendar.MINUTE);
int seconds = calendar.get(Calendar.SECOND);
        System.out.println(""+hours);
     //  new ADPVendorService();
       // new MailUtil().sendMail(new String[]{"ganesh@vivensas.com"}, new String[]{"ganesh@vivensas.com"},"test","test");
      
        
        /* String[] starArray=null;
                      Date d=new Date();
             SimpleDateFormat fomat=new SimpleDateFormat("yyyy-mm-dd HH:mm");
            String strDate= fomat.format(d);
              System.out.println("Error: " + strDate);

         String[] starArray=null;
                      Date d=new Date();
             SimpleDateFormat fomat=new SimpleDateFormat("yyyy-mm-dd HH:mm");
            String strDate= fomat.format(d);
              System.out.println("Error: " + strDate);

         try{
        File f=new File("x.txt");
                if(f.exists())
                    f.delete();
            OutputStreamWriter writer = new OutputStreamWriter(
                  new FileOutputStream("x.txt", true), "UTF-8");
            BufferedWriter fbw = new BufferedWriter(writer);
            fbw.write("append txt...  this line 2 \\n this line 3");
            fbw.newLine();       
            fbw.write("append txt...  this line 2 \\n this line 3");
            
            fbw.close();
        }catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }*/
        // TODO code application logic here
        /*  SimpleDateFormat dateFomr=new SimpleDateFormat("MMddYYYHHMMss");
                        String datStr=  dateFomr.format(new Date());
                        System.out.print(""+datStr);
                        
                        try {
			File file = new File("test.txt");
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
           starArray = stringBuffer.toString().split(";");
		} catch (IOException e) {
			e.printStackTrace();
		}
                        // Recipient's email ID needs to be mentioned.
    final String username = "ganesh@vivensas.com";
		final String password = "ganesh123!@#";
 
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
 
		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });
 
		try {
 for(int i=0;i<starArray.length;i++)
 {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("from-ganesh@vivensas.com"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(starArray[i]));
			message.setSubject("Testing Subject");
			message.setText("This is test mail for ADP,"
				+ "\n\n No spam to my email, please!");
 
			Transport.send(message);
 
			System.out.println("Done");
 }
 
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}*/
  
    }
}
  class MailUtil {  
  
    private String SMTP_HOST = "smtp.gmail.com";  
    private String FROM_ADDRESS = "icandothiseasily@gmail.com";  
    private String PASSWORD = "insecurepassword";  
    private String FROM_NAME = "Ganesh";  
  
    public boolean sendMail(String[] recipients, String[] bccRecipients, String subject, String message) {  
        try {  
            Properties props = new Properties();  
            props.put("mail.smtp.host", SMTP_HOST);  
            props.put("mail.smtp.auth", "true");  
            props.put("mail.debug", "false");  
            props.put("mail.smtp.ssl.enable", "true");  
  
            Session session = Session.getInstance(props, new SocialAuth());  
            Message msg = new MimeMessage(session);  
  
            InternetAddress from = new InternetAddress(FROM_ADDRESS, FROM_NAME);  
            msg.setFrom(from);  
  
            InternetAddress[] toAddresses = new InternetAddress[recipients.length];  
            for (int i = 0; i < recipients.length; i++) {  
                toAddresses[i] = new InternetAddress(recipients[i]);  
            }  
            msg.setRecipients(Message.RecipientType.TO, toAddresses);  
  
  
            InternetAddress[] bccAddresses = new InternetAddress[bccRecipients.length];  
            for (int j = 0; j < bccRecipients.length; j++) {  
                bccAddresses[j] = new InternetAddress(bccRecipients[j]);  
            }  
            msg.setRecipients(Message.RecipientType.BCC, bccAddresses);  
  
            msg.setSubject(subject);  
            msg.setContent(message, "text/plain");  
            Transport.send(msg);  
            return true;  
        } catch (UnsupportedEncodingException ex) {  
            Logger.getLogger(MailUtil.class.getName()).log(Level.SEVERE, null, ex);  
            return false;  
  
        } catch (MessagingException ex) {  
            Logger.getLogger(MailUtil.class.getName()).log(Level.SEVERE, null, ex);  
            return false;  
        }  
    }  
  
    class SocialAuth extends Authenticator {  
  
        @Override  
        protected PasswordAuthentication getPasswordAuthentication() {  
  
            return new PasswordAuthentication(FROM_ADDRESS, PASSWORD);  
  
        }  
    }  

}