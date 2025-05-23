import Page_Objects.Login;
import Utils.ExcelUtils;
import Utils.CommonUtil;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import java.io.IOException;

public class SwiftMessage_Parser
{
    WebDriver driver;
    //  Shopping_Cart Shopping_Cart;
    String url;
    public ExtentTest test;
    public ExtentReports report;
    public Login Login;
    ExcelUtils ExcelUtils;
    CommonUtil CommonUtil;
    String [][] Excel_Values;
    public String Username1;
    public String Username2;

    @Test
    public void Launch() throws InterruptedException, IOException {
        ExcelUtils = new ExcelUtils();
        Excel_Values = ExcelUtils.readExcelDataFileToArray("C:\\Users\\Ashwin\\Desktop\\MTSwift Message.xlsx", "Sheet1");
        String swift = Excel_Values[1][0];
        //  String[] result = swift.split(":20:");
        String[] lines = swift.split("\n");
        System.out.println("Total Lines:" + lines.length);
       // for (Integer i = 1; i <= lines.length; i++)
      //  {
            System.out.println(lines[1]);
            System.out.println(lines[1].length());
      //  }
        System.out.println("Contains Value:"+lines[1].contains(":20:"));
      if (lines[1].contains(":20:")==true)
        {
            long first12 = (long) (Math.random() * 1000000000000L);
            String InstID = ":20:" + first12;
            lines[1] = InstID;
            System.out.println("InstrID:" + InstID);
        }
      //  System.out.println("Total Lines:" + lines.length);
        // for (Integer i = 1; i <= lines.length; i++)
        //  {
       // System.out.println(lines[1]);
       // System.out.println(lines[1].length());
        //  }
       // System.out.println("Instruction ID:" + InstID);
        System.out.println("Updated Value is:");
        for (Integer i = 1; i <= lines.length; i++)
        {
            System.out.println(lines[i-1]);
        }
    }
}
