/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Hi5Soft.adp.Transaction;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

/**
 *
 * @author ganesh
 */
public class XlsParser {
    private Workbook mWrkBk;
    ArrayList<AttriButes> mData=new ArrayList<AttriButes>();
    XlsParser(String _fileName)
    {
        try {
        mWrkBk=    Workbook.getWorkbook(new File("data.xla"));
            Sheet shet=mWrkBk.getSheet(0);
            for(int j=1;j<=17;j++)            {
                 AttriButes _attri=new AttriButes();          
           _attri.setAttributes1(shet.getCell(0,j).getContents().toString().trim());
            _attri.setAttributes2(shet.getCell(1,j).getContents().toString().trim());
             _attri.setAttributes3(shet.getCell(2,j).getContents().toString().trim());
              _attri.setAttributes4(shet.getCell(3,j).getContents().toString().trim());
               _attri.setAttributes5(shet.getCell(4,j).getContents().toString().trim());
                _attri.setReportID(shet.getCell(5,j).getContents().toString().trim()); 
                _attri.setFullProductID(shet.getCell(6,j).getContents().toString().trim());
                
            
           
           mData.add(_attri);
            }
                   System.out.println("===>"+mData);    
        } catch (IOException ex) {
            Logger.getLogger(XlsParser.class.getName()).log(Level.SEVERE, null, ex);
              System.out.println(ex.getMessage());
        } catch (BiffException ex) {
            Logger.getLogger(XlsParser.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        }
    }
    
    
    public String getID(String attr1,String attr2 ,String attr3, String attr4, String attr5  )
    {
        for(AttriButes _attri : mData)
        {
            if(attr1.equalsIgnoreCase(_attri.getAttributes1()))
                 if(attr2.equalsIgnoreCase(_attri.getAttributes2()))
                      if(attr3.equalsIgnoreCase(_attri.getAttributes3()))
                           //if(attr4.equalsIgnoreCase(_attri.getAttributes1()))
                                if(attr5.equalsIgnoreCase(_attri.getAttributes5()))
                                    if(_attri.getReportID().length()>=1)
                                        return
                                               "R"+ _attri.getReportID();
                                    else
                                        return _attri.getFullProductID();
                
            
        }
        return null;
    }
}
