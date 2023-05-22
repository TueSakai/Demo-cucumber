package hellocucumber;

import com.sun.jna.StringArray;
import hellocucumber.action.commons.BaseTest;
import hellocucumber.action.pageObjects.GooglePageObject;
import io.cucumber.java.en.*;

import org.apache.logging.log4j.simple.SimpleLogger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;

import java.io.*;
import java.util.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;


public class StepDefinitions extends BaseTest {

    private WebDriver driver;
    private GooglePageObject googlePage;

//    @Parameters({"browser", "url"})
//    @Given("Get browser {string} with {int}")
//    public void getBrowser(String sheetname, int rownumber)  throws IOException, InvalidFormatException {
//        ExcelReader reader = new ExcelReader();
//        List<Map<String, String>> testdata = reader.getData("D://Testcase folder//hellocucumber//src//test//resources//ExcelData//Login.xlsx", sheetname);
//        String browserName = testdata.get(rownumber).get("browser");
//        String url = testdata.get(rownumber).get("url");
//        driver = getBrowserDriver(browserName,url);
//        googlePage = new GooglePageObject(driver);
//    }
//    @When("Input keyword: {string} and {int}")
//    public void inputKeyword(String sheetname, int rownumber) throws IOException, InvalidFormatException {
//        ExcelReader reader = new ExcelReader();
//        List<Map<String, String>> testdata = reader.getData("D:\\Testcase folder\\hellocucumber\\src\\test\\resources\\ExcelData\\Login.xlsx", sheetname);
//        String keyword = testdata.get(rownumber).get("keyword");
//        googlePage.inputSearchTextBox(keyword);
//    }
//    @When("Then click on search button")
//    public void searchKeywork(){
//        googlePage.clickOnSearchButton();
//    }
//    @Then("Verify search result: {string} and {int} display")
//    public void checkResult(String sheetname, int rownumber) throws IOException, InvalidFormatException {
//        ExcelReader reader = new ExcelReader();
//        List<Map<String, String>> testdata = reader.getData("D:\\Testcase folder\\hellocucumber\\src\\test\\resources\\ExcelData\\Login.xlsx", sheetname);
//        String result = testdata.get(rownumber).get("keyword");
//        verifyTrue(googlePage.checkSearchResult(result));
//    }

    @Then("Close test case")
    public void afterTest(){
        driver.quit();
    }

    public static void main(String[] args) {
        String filePath = "D:\\Testcase folder\\hellocucumber\\src\\test\\resources\\ExcelData\\Login.xlsx"; // đường dẫn của file excel
        String headerName = "username"; // tên của header cần tìm
        String sheetName = "Sheet1";
        int rowIndex = 1;
        System.out.println(readExcel1(filePath, sheetName, headerName, rowIndex)); // gọi phương thức đọc file excel
    }

    public static String readExcel1(String filePath, String sheetName,  String headerName, int rowIndex) {
        ArrayList<String> arr = new ArrayList<>();
        try {
            File file = new File(filePath);
            FileInputStream inputStream = new FileInputStream(file); // tạo một đối tượng FileInputStream từ file
            Workbook workbook = new XSSFWorkbook(inputStream); // tạo một đối tượng Workbook từ FileInputStream
            Sheet sheet = workbook.getSheet(sheetName); // lấy sheet đầu tiên của workbook
            Row headerRow = sheet.getRow(0); // lấy hàng đầu tiên của sheet làm hàng header
            int columnIndex = -1; // khởi tạo chỉ số cột là -1
            for (Cell cell : headerRow) { // duyệt qua các ô của hàng header
                if (cell.getStringCellValue().equals(headerName.trim())) { // nếu giá trị của ô bằng với tên header cần tìm
                    columnIndex = cell.getColumnIndex(); // gán chỉ số cột bằng với chỉ số của ô
                    break; // thoát khỏi vòng lặp
                }
            }

            if (columnIndex == -1) { // nếu không tìm thấy cột nào có tên header cần tìm
                System.out.println("Không có cột nào có tên " + headerName);
            }
            else { // nếu tìm thấy cột có tên header cần tìm
                for (int i = 1; i <= sheet.getLastRowNum(); i++) { // duyệt qua các hàng của sheet từ hàng thứ 2 trở đi
                    Row row = sheet.getRow(i); // lấy hàng thứ i của sheet
                    Cell cell = row.getCell(columnIndex); // lấy ô ở cột có chỉ số đã tìm được
                    arr.add(cell.getStringCellValue());
                }
            }
            return arr.get(rowIndex);
             // đóng luồng đọc file
        } catch (Exception e) { // bắt ngoại lệ nếu có lỗi xảy ra khi đọc file
            return null;
        }
    }
}
