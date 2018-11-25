package extras;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.junit.Test;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.UseDataProvider;



public class TestRun {

	private Object[][] getData() {

		HSSFWorkbook workbook = null;
		try {
			workbook = new HSSFWorkbook(new FileInputStream(new File("C:\\Users\\somen\\Desktop\\test1.xls")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		HSSFSheet sheet = workbook.getSheetAt(0);

		int lastRow = sheet.getLastRowNum();
		Object[][] array = new Object[lastRow - 1][2];

		for (int i = 1; i < lastRow; i++) {
			for (int j = 1; j < sheet.getRow(i).getLastCellNum(); j++) {
				if ((sheet.getRow(i).getCell(j).getColumnIndex() == 1 || sheet.getRow(i).getCell(j).getColumnIndex() == 2
						|| sheet.getRow(i).getCell(j).getColumnIndex() == 3
						) && (Cell.CELL_TYPE_BLANK != sheet.getRow(i).getCell(j).getCellType())) {
						//System.out.print(sheet.getRow(i).getCell(j).getStringCellValue() + " -- ");
						array[i-1][0]=sheet.getRow(i).getCell(j).getStringCellValue().replace("\"", "");
				} else if (sheet.getRow(i).getCell(j).getColumnIndex() == 4 && Cell.CELL_TYPE_BLANK != sheet.getRow(i).getCell(j).getCellType()) {
						//System.out.print(sheet.getRow(i).getCell(j).getStringCellValue());
						array[i-1][1]=sheet.getRow(i).getCell(j).getStringCellValue().replace("\"", "");
				}

			}
		}
		
		return array;
	}

	@Test
		public void runTest() {
		Object[][] array = getData();
		
		for(int i =0; i<array.length;i++) {
			System.out.println(array[i][0] + " ** " + array[i][1]);
		}
	}

}
