/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Hi5Soft.adp.Transaction;

import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.Properties;

/**
 *
 * @author admin
 */
public class Hi5Utils {
    private static Properties mailProperties = null;
    private static Properties configProperties = null;

    public static Properties GetMailProperties() throws Exception{
        if(mailProperties == null){
            mailProperties = new Properties();

            mailProperties.load(ClassLoader.getSystemResourceAsStream("mail.properties"));
        }

        return mailProperties;
    }

    public static Properties GetConfigProperties() throws Exception{
        if(configProperties == null){
            configProperties = new Properties();

            configProperties.load(ClassLoader.getSystemResourceAsStream("config.properties"));
        }

        return configProperties;
    }

    public static boolean SaveConfigProperties() throws Exception{
        if(configProperties != null){
            configProperties.store(new FileOutputStream(GetApplicationRoot() + "\\config.properties"),
                    "Changed Config Properties");
            return true;
        }

        return false;
    }
    
    public static String GetApplicationRoot() {
        try {
            Hi5Utils utils = new Hi5Utils();
            URL u = utils.getClass().getProtectionDomain().getCodeSource().getLocation();
            
            File f = new File(u.toURI());
            return f.getAbsolutePath();
            
        } catch (Exception ex) {
            
        }
        
        return "";
    }
}
