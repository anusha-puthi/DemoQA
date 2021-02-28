package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileUtil 
{
  //declare global variable
	
  Workbook wb;
  
  //constructor to read excel path
  public ExcelFileUtil(String excelpath) throws Throwable
  {
	  FileInputStream fi=new FileInputStream(excelpath);
	  wb=WorkbookFactory.create(fi);
  }
  
  //method to count number of rows from sheet
  public int rowCount(String sheetname)
  {
	return wb.getSheet(sheetname).getLastRowNum();  
  }
  
  //method for counting number of cells in a row
  public int cellCount(String sheetname)
  {
	  return wb.getSheet(sheetname).getRow(0).getLastCellNum();
  }
  
  //method to get data from cell
  public String getCellData(String sheetname,int row,int column)
  {
	  String data="";
	  
	  //get int type data from cell
	  if(wb.getSheet(sheetname).getRow(row).getCell(column).getCellType()==Cell.CELL_TYPE_NUMERIC)
	  {
		 int celldata=(int) wb.getSheet(sheetname).getRow(row).getCell(column).getNumericCellValue();
		 
		 //convert int type data to string
		 data=String.valueOf(celldata);
	  }
	  //else if(wb.getSheet(sheetname).getRow(row).getCell(column).getCellType()==cell.)
	  else
	  {
		 data=wb.getSheet(sheetname).getRow(row).getCell(column).getStringCellValue();
	  }
	return data;
  }
  
  //method to set cell data result column
  public void setCellData(String sheetname,int row,int column,String status,String writeexcel) throws Throwable
  {
	  //get the sheet
	  Sheet sh=wb.getSheet(sheetname);
	  //get the row from that sheet
	  Row rownum=sh.getRow(row);
	  //get the column  from that row
	  Cell cell=rownum.getCell(column);
	  
	  //write status value into cell
	  cell.setCellValue(status);
	  	if(status.equalsIgnoreCase("Pass"))
	  	{
	  		//defining object for cell style
	  		CellStyle cstyle=wb.createCellStyle();
	  		//create font
	  		Font font=wb.createFont();
	  		//set text color with green
	  		font.setColor(IndexedColors.GREEN.getIndex());
	  		//Bold Text
	  		font.setBold(true);
			    font.setBoldweight(Font.BOLDWEIGHT_BOLD);
			    cstyle.setFont(font);
			    rownum.getCell(column).setCellStyle(cstyle);  
	  	}
	  	else if(status.equalsIgnoreCase("Fail"))
	  	{
	  		//defining object for cell style
	  		CellStyle cstyle=wb.createCellStyle();
	  		//create font
	  		Font font=wb.createFont();
	  		//set text with red color
	  		font.setColor(IndexedColors.RED.getIndex());
	  		//Set text with Bold
	  		font.setBold(true);
	  		font.setBoldweight(Font.BOLDWEIGHT_BOLD);
	  		cstyle.setFont(font);
	  		rownum.getCell(column).setCellStyle(cstyle);
	  	}
	  	else if(status.equalsIgnoreCase("Blocked"))
	  	{
	  		//defining object for cell style
	  		CellStyle cstyle=wb.createCellStyle();
	  		//create font
	  		Font font=wb.createFont();
	  		//set text with red color
	  		font.setColor(IndexedColors.RED.getIndex());
	  		//set text with bold
	  		font.setBold(true);
	  		font.setBoldweight(Font.BOLDWEIGHT_BOLD);
	  		cstyle.setFont(font);
	  		rownum.getCell(column).setCellStyle(cstyle);	
	  	}
	  	FileOutputStream fo=new FileOutputStream(writeexcel);
	  	wb.write(fo);
		  
  }
}
