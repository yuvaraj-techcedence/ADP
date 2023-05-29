/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hi5Soft.adp.Transaction;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author GaneshKumar_2
 */
public class ErrorLogCreator {  public  String fName="";
    
   public ErrorLogCreator()
   {

       
       try
       {
       SimpleDateFormat format=new SimpleDateFormat("dd_MM_YYYY_HH_mm_ss");
       Date da=new Date();
    String dateStr=   format.format(da);
    fName="C:\\Zaeplex_ADP_ExitingWork\\fuillFill_error_log\\error_log_"+dateStr+".txt";
   OutputStreamWriter writer = new OutputStreamWriter(
                  new FileOutputStream(fName, true), "UTF-8");
            BufferedWriter fbw = new BufferedWriter(writer);
            fbw.newLine(); 
            fbw.write("*******************************Statr**************************");
            //fbw.newLine();       
            //fbw.write("   "+_ssrefStr);           
            fbw.close();
       }
       catch(Exception e)
       {
           
       }
   }
   
   public void createTitleToErrorLog(String _tit)
   {
        try
        {
         OutputStreamWriter writer = new OutputStreamWriter(
                  new FileOutputStream(fName, true), "UTF-8");
            BufferedWriter fbw = new BufferedWriter(writer);
            fbw.newLine();         
            fbw.write("*********************************************************");
                 fbw.newLine(); 
            fbw.write("   "+_tit);           
            fbw.close();
        }
        catch(Exception e)
        {
            System.out.println("error in writing data to error log"+e.getMessage());
        }
   }
    public  void createErrorLog(String _errorLog)
    {
        try
        {
         OutputStreamWriter writer = new OutputStreamWriter(
                  new FileOutputStream(fName, true), "UTF-8");
            BufferedWriter fbw = new BufferedWriter(writer);
            fbw.newLine();             
            fbw.write("   "+_errorLog);           
            fbw.close();
        }
        catch(Exception e)
        {
            System.out.println("error in writing data to error log"+e.getMessage());
        }
    }
}
