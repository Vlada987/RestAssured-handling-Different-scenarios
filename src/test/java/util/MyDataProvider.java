package util;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class MyDataProvider {

	@DataProvider(name = "scenarios")
	public String[][] getData() throws IOException {

		String path = "C:\\Users\\zikaz\\OneDrive\\Desktop\\projects\\AirplaneDiffScenarios\\types.xlsx";

		return CreateExcelData.get2DarrayData(path);

	}

}
