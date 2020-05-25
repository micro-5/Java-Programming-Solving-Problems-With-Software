
/**
 * Write a description of Exports here.
 * 
 * @author (micro-5) 
 * @version (16 May 2020)
 */

import edu.duke.*;
import org.apache.commons.csv.*;

public class Exports {
    //create a String method countryInfo
    public String countryInfo(CSVParser parser, String country){
        for(CSVRecord record : parser){
            String countryName = record.get("Country");
            if(countryName.contains(country)){
                return countryName + ": " + record.get("Exports") + ": " + record.get("Value (dollars)");
            }
        }
        return "NOT FOUND";
    }
    
    //create a void method listExportsTwoProducts
    public void listExportsTwoProducts(CSVParser parser, String exportItem1, String exportItem2){
        for(CSVRecord record: parser){
            String item = record.get("Exports");
            if(item.contains(exportItem1) && item.contains(exportItem2)){
                System.out.println(record.get("Country"));
            }
        }
    }
    
    //create int method numberOfExporters
    public int numberOfExports(CSVParser parser, String exportItem){
        int count = 0;
        for(CSVRecord record : parser){
            String item = record.get("Exports");
            if(item.contains(exportItem)){
                count++;
            }
        }
        return count;
        
    }
    
    //void method bigExporters
    public void bigExporters(CSVParser parser, String amount){
        int len = amount.length();
        for(CSVRecord record : parser)
        {
            String val = record.get("Value (dollars)");
            int valLength = val.length();
            if(valLength > len){
                System.out.println(record.get("Country") + " " + val);
            }
        }
    }
    
    public void tester(){
        //create a csv parser
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        
        String information = countryInfo(parser, "Nauru");
        System.out.println("Country Info = " + information);
        
        parser = fr.getCSVParser();
        System.out.println("List of Exporters of two products");
        listExportsTwoProducts(parser, "cotton", "flowers");
        
        parser = fr.getCSVParser();
        System.out.println("No of Exporters : " + numberOfExports(parser, "cocoa"));
        
        parser = fr.getCSVParser();
        System.out.println("List of big Exporters");
        bigExporters(parser, "$999,999,999,999");
        
        
    }
}
