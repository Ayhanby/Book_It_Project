package excelautomation;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

public class ExcelReadDemo {




        @Test
       public void ReadXLFile()throws Exception{

            //path to the Excel document
            String path="/Users/ahmetjanyusup/Desktop/Country&Capital.xlsx";

            //open file and convert to stream of data and throw Exception
            FileInputStream inputStream=new FileInputStream(path);


            //WORKBOOK>WORKSHEET>ROW>CELL
            //open the WorkBook

            Workbook workbook= WorkbookFactory.create(inputStream);

            //Go to first WorkSheet

            Sheet worksheet=workbook.getSheetAt(0);

            //Go to the First Row

            Row row=worksheet.getRow(0);

            //Go to First Cell




            Cell cell1=row.getCell(0);
            Cell cell2=row.getCell(1);





            int rowCount=worksheet.getLastRowNum();

            System.out.println("Number of rows: "+rowCount);












            //print cell values

            System.out.print(cell1.toString());
            System.out.print("  ");
            System.out.println(cell2.toString());




            String country1=worksheet.getRow(1).getCell(0).toString();
            String capital1=worksheet.getRow(1).getCell(1).toString();

            // or you can declare the country1 variable like this
           //String country1=workbook.getSheetAt(0).getRow(1).getCell(0).toString();


            System.out.println("country1: "+country1);
            System.out.println("capital1: "+capital1);

            for (int i=1;i<=rowCount;i++){



                System.out.println("country #"+i+": "+worksheet.getRow(i).getCell(0)+"   ===> "+
                        worksheet.getRow(i).getCell(1));


            }

            Map<String,String> countryMap=new HashMap<>();

            int countryCol=0;
            int capitalCol=1;

            for (int rowNum=1;rowNum<rowCount;rowNum++){

                String country=worksheet.getRow(rowNum).getCell(countryCol).toString();

                String capital=worksheet.getRow(rowNum).getCell(capitalCol).toString();

                countryMap.put(country,capital);
            }

            System.out.println("Printing using map");
            System.out.println(countryMap);


            workbook.close();

            inputStream.close();









        }




}
