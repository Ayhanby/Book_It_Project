package excelautomation;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ExcelWriteDemo  {

    @Test
    public void writeExcel()throws Exception{

        String filePath="./src/test/resources/Country&Capital.xlsx";

        FileInputStream in=new FileInputStream(filePath);

        Workbook workbook= WorkbookFactory.create(in);

        Sheet worksheet=workbook.getSheetAt(0);

        //Write column name

        Cell column=worksheet.getRow(0).createCell(2);
        if (column==null){
            column=worksheet.getRow(0).createCell(2);
        }
             column.setCellValue("Continent");


        Cell con1=worksheet.getRow(1).createCell(2);
        if (con1==null) {
            con1 = worksheet.getRow(1).createCell(2);
        }
            con1.setCellValue("North America");



        Cell con2=worksheet.getRow(2).createCell(2);
        if (con2==null) {
            con2 = worksheet.getRow(2).createCell(2);
        }
        con2.setCellValue("Asia");




        Cell con3=worksheet.getRow(3).createCell(2);
        if (con3==null) {
            con3 = worksheet.getRow(3).createCell(2);
        }
        con3.setCellValue("Europe");




        Cell con4=worksheet.getRow(4).createCell(2);
        if (con1==null) {
            con4 = worksheet.getRow(4).createCell(2);
        }
        con4.setCellValue("Europe");



        Cell con5=worksheet.getRow(5).createCell(2);
        if (con5==null) {
            con5 = worksheet.getRow(5).createCell(2);
        }
        con5.setCellValue("Europe");



        Cell con6=worksheet.getRow(6).createCell(2);
        if (con6==null) {
            con6 = worksheet.getRow(6).createCell(2);
        }
        con6.setCellValue("Asia");



        Cell con7=worksheet.getRow(7).createCell(2);
        if (con7==null) {
            con7 = worksheet.getRow(7).createCell(2);
        }
        con7.setCellValue("Asia");


        Cell con8=worksheet.getRow(8).createCell(2);
        if (con8==null) {
            con8 = worksheet.getRow(8).createCell(2);
        }
        con8.setCellValue("Asia");



        Cell con9=worksheet.getRow(9).createCell(2);
        if (con9==null) {
            con9 = worksheet.getRow(9).createCell(2);
        }
        con9.setCellValue("Asia");



        Cell con10=worksheet.getRow(10).createCell(2);
        if (con10==null) {
            con10 = worksheet.getRow(10).createCell(2);
        }
        con10.setCellValue("Asia");



        Cell con11=worksheet.getRow(11).createCell(2);
        if (con11==null) {
            con11 = worksheet.getRow(11).createCell(2);
        }
        con11.setCellValue("North America");



        Cell con12=worksheet.getRow(12).createCell(2);
        if (con12==null) {
            con12 = worksheet.getRow(12).createCell(2);
        }
        con12.setCellValue("Oceania");


        Cell con13=worksheet.getRow(13).createCell(2);
        if (con13==null) {
            con13 = worksheet.getRow(13).createCell(2);
        }
        con13.setCellValue("Asia");



        //Save changes
        //Open the file to write into it

        FileOutputStream out=new FileOutputStream(filePath);

        //Write and save the changes

        workbook.write(out);

        out.close();
        workbook.close();
        in.close();;

    }
}
