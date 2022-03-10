import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcel {


    public void createExcelFile(List<List<String>> list, int rowCount)
    {

        //Excel Calisma Kitabini Olustur
        XSSFWorkbook workbook = new XSSFWorkbook();

        //Excel Sayfasi Olustur
        XSSFSheet sheet = workbook.createSheet("Sheet1");

        //Basliklari Hazirla
        Row headerRow = sheet.createRow(0);
        Cell hname = headerRow.createCell(0);
        hname.setCellValue("Unit Price");

        Cell hlastName = headerRow.createCell(1);
        hlastName.setCellValue("Manufacturer");

        Cell hage = headerRow.createCell(2);
        hage.setCellValue("Product Name");

        //Listeyi Yaz
        for(int i = 0; i < rowCount-1; i++)
        {

            //Olusturdugumuz sayfa icerisinde yeni bir satir olustur
            //i+1 yazmamizin nedeni 0. satir yani ilk satira basliklari yazdigimizdan 0 dan baslatmadik
            Row row = sheet.createRow(i+1);

            //Ilgili satir icin yeni bir hucre olustur
            Cell name = row.createCell(0);
            name.setCellValue( list.get(i).get(0));

            Cell lastName = row.createCell(1);
            lastName.setCellValue(list.get(i).get(1));

            Cell age = row.createCell(2);
            age.setCellValue(list.get(i).get(2));

        }
        //Olusturulan Excel Nesnesini Dosyaya Yaz
        write(workbook);
    }

    public void write(XSSFWorkbook workbook)
    {
        try
        {
            FileOutputStream out = new FileOutputStream(new File("C:\\Users\\firat.yorulmaz\\Project\\untitled1\\NewDocumation.xlsx"));
            workbook.write(out);
            out.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}