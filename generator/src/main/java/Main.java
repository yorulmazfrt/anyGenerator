import com.zaxxer.sparsebits.SparseBitSet;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws IOException, JSONException {

        Scanner scanner = new Scanner(System.in);

        String excelName ;
        System.out.println("Whats your excel name?");
        excelName = scanner.next();
        String sheetName;
        System.out.println("Whats your sheet name?");
        sheetName = scanner.next();

        System.out.println("Whats your start column? // Row is default value 2 (this value should be int)");
        int startColumn = scanner.nextInt();

//        System.out.println("Whats your start row?");
//        int startRow = scanner.nextInt();


        String projectPath = System.getProperty("user.dir");
        ExcelUtilTest excel = new ExcelUtilTest(projectPath + "/" + excelName + ".xlsx", sheetName);

        RestClient restClient = new RestClient();
        int rowCount = excel.getRowCount();

        WriteExcel writeExcel = new WriteExcel();

        List<List<String>> lastList = new ArrayList();
        List<String> emptyList = new ArrayList();
        emptyList.add("-");
        emptyList.add("-");
        emptyList.add("-");


        System.out.println(rowCount);
        for (int i = 1; i < rowCount; i++) {
            String link = excel.GetCellDataString(i, startColumn-1);
            if (link.contains("ozdisan")) {
                lastList.add(restClient.getJsonEmployee(link));
                System.out.println(restClient.getJsonEmployee(link));
            } else {
                System.out.println("------------");
                lastList.add(emptyList);

            }
        }
        writeExcel.createExcelFile(lastList, rowCount);

    }
}