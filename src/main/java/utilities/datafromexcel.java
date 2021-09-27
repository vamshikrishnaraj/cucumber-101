package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import reusable.base;

public class datafromexcel {
public static  ArrayList<String> al = new ArrayList<String>();
	public static ArrayList<String> listgetter(String r) throws IOException  {
		// TODO Auto-generated method stub
		FileInputStream fis = new FileInputStream(base.prop.getProperty("xcelpath"));
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		
		int sheetcount = workbook.getNumberOfSheets();
		for(int i = 0; i < sheetcount; i++) {
			if(workbook.getSheetName(i).equalsIgnoreCase(base.prop.getProperty("sheetname"))){
				//System.out.println("i am inside");
			XSSFSheet currentsheet =  workbook.getSheetAt(i);//by this we got to the desired sheet.
			Iterator<Row> rows =  currentsheet.iterator();
			//when we type rows.next() it enters into the 1 st row
			Row firstrow = rows.next();
			Iterator<Cell> ce = firstrow.iterator();
			int k = 0;//for col index
			int coloumn = 0;
		//	System.out.println("wefg");
			while(ce.hasNext()) {
				Cell value = ce.next();
				//if(value.getCelltypeEnum == CellType.)
				if(value.getStringCellValue().equalsIgnoreCase("testcases")) {
					//System.out.println("dffdf");
					coloumn = k;
					break;
				}
				k++;
				
				
			}
			//System.out.println(coloumn);
			/*now say we need to get to the row check out, but we do know that its present only in the coloumn testcases. for this scanning
			in this particular row we are doing this*/
			while(rows.hasNext()) {
				Row currow = rows.next();
				if(currow.getCell(coloumn).getStringCellValue().equalsIgnoreCase(r)) {
					//System.out.println("cell");
					Iterator<Cell> cv = currow.iterator();
					cv.next();
					while(cv.hasNext()) {
						//System.out.println("cell1");
						//System.out.println(cv.next().getStringCellValue());
						al.add(cv.next().getStringCellValue());
						
					}
				}
			}
			
			}
			
			
		}
		//return al;
		
		

	//System.out.println(al);
	return(al);
	}}


