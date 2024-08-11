package util;

import java.io.IOException;

public class CreateExcelData {

	public static String[][] get2DarrayData(String path) throws IOException {

		ExcelGetter excel = new ExcelGetter(path);
		int rows = excel.getRowCount("Sheet1");
		int coll = excel.getCellCount("Sheet1", 1);
		String[][] data = new String[rows][coll];

		for (int a = 1; a <= rows; a++) {
			for (int b = 0; b < coll; b++) {
				data[a - 1][b] = excel.getCelldata("Sheet1", a, b);
			}
		}
		return data;
	}

}
