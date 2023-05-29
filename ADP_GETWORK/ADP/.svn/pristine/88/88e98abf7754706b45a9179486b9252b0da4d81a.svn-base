/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Hi5Soft.adp.Transaction;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.StringTokenizer;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author admin
 */
public class MailClient {
    
    private String SMTP_HOST = "smtp.gmail.com";  
    private String FROM_ADDRESS = "ganesh@vivensas.com";  
    private String PASSWORD = "vivensasgmailpassword!@#";  
    private String FROM_NAME = "Ganesh";  
    
    private static String SMTP_HOST_NAME = "smtp.gmail.com";
    private static String SMTP_PORT = "587";
    private static String SMTP_AUTH_USER = "hi5appmsg";
    private static String SMTP_AUTH_PWD = "hi5apperrmsg";
//      private static String SMTP_AUTH_USER = "ganesh@vivensas.com";
//    private static String SMTP_AUTH_PWD = "hi5apperrmsg";
    private static String emailMsgTxt = "Test Message <b>From</b> <a href='Java.sun.com'>Java Mail</a>";
    private static String emailSubjectTxt = "Fullfill Request Error";
    private static String emailFromAddress = "ganesh@vivensas.com";
    // Add List of Email address to who email needs to be sent to
   // private static String[] emailList = {"bala@iserveconsultancy.com", "bala@atra.in"};
     private static String[] emailList = {"ganesh@vivensas.com", "annadurai@vivensas.com"};
    private static String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";

    /*static {
        try{
            Properties mailProperties = Hi5Utils.GetMailProperties();
            SMTP_HOST_NAME = mailProperties.getProperty("SMTP_HOST_NAME");
            SMTP_PORT = mailProperties.getProperty("SMTP_PORT");
            SMTP_AUTH_USER = mailProperties.getProperty("SMTP_AUTH_USER");
            SMTP_AUTH_PWD = mailProperties.getProperty("SMTP_AUTH_PWD");
            SSL_FACTORY = mailProperties.getProperty("SSL_FACTORY");
            emailFromAddress = mailProperties.getProperty("emailFromAddress");

            StringTokenizer token = new StringTokenizer(mailProperties.getProperty("emailList"), ", ");
            emailList = new String[token.countTokens()];
            int i = 0;
            while(token.hasMoreTokens()){
                emailList[i] = token.nextToken();
                
                System.out.println("=>" + emailList[i]);
                i++;
            }
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    */
    public boolean SendMail() throws MessagingException {
        return SendMail(emailList, emailSubjectTxt, emailMsgTxt,
                new String[] {"c:\\123.txt", "c:\\CHP_Error.txt", "c:\\boot.ini"});
    }

    public boolean SendFullFillErrorMail(String message, String attachements[ ]) throws MessagingException {
        String starArray[]=null;
        try {
			File file = new File("email_address.txt");
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
        return SendMail(starArray, "Error Occured In Fullfill Request", message, attachements);
    }
    
    public boolean SendMail(String recipients[ ], String subject,
                            String message, String attachements[ ]) throws MessagingException {
        boolean debug = false;
        
        
        String from = emailFromAddress;

        //Set the host smtp address
        Properties props = new Properties();
       /* props.put("mail.smtp.host", SMTP_HOST_NAME);
        props.put("mail.smtp.auth", "true");
        props.put("mail.debug", "true");
        props.put("mail.smtp.port", SMTP_PORT);
        props.put("mail.smtp.socketFactory.port", SMTP_PORT);
        props.put("mail.smtp.socketFactory.class", SSL_FACTORY);
        props.put("mail.smtp.socketFactory.fallback", "false");*/
            props.put("mail.smtp.host", SMTP_HOST);  
            props.put("mail.smtp.auth", "true");  
            props.put("mail.debug", "false");  
            props.put("mail.smtp.ssl.enable", "true");  

        Authenticator auth = new SMTPAuthenticator();
        Session session = Session.getDefaultInstance(props, auth);
        session.setDebug(debug);
        // create a message
        Message msg = new MimeMessage(session);

        // set the from and to address
        InternetAddress addressFrom = new InternetAddress(from);
        msg.setFrom(addressFrom);

        InternetAddress[] addressTo = new InternetAddress[recipients.length];
        for (int i = 0; i < recipients.length; i++) {
            addressTo[i] = new InternetAddress(recipients[i]);
        }
        msg.setRecipients(Message.RecipientType.TO, addressTo);

        // Setting the Subject and Content Type
        msg.setSubject(subject);

        // create the message part
        MimeBodyPart messageBodyPart = new MimeBodyPart();
        //fill message
        messageBodyPart.setContent(message, "text/html");

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);

        for(int i = 0;i < attachements.length;i++){
            // Part two is attachment
            messageBodyPart = new MimeBodyPart();
            DataSource source = new FileDataSource(attachements[i]);
            messageBodyPart.setDataHandler(new DataHandler(source));
            File fi = new File(attachements[i]);
            messageBodyPart.setFileName(fi.getName());
            multipart.addBodyPart(messageBodyPart);
        }
        
        msg.setContent(multipart);
        Transport.send(msg);

        return false;
    }

    private class SMTPAuthenticator extends javax.mail.Authenticator {

        public PasswordAuthentication getPasswordAuthentication() {
            String username = SMTP_AUTH_USER;
            String password = SMTP_AUTH_PWD;
            return new PasswordAuthentication(FROM_ADDRESS, PASSWORD);
        }
    }
}
