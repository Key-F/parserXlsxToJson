import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.apache.log4j.BasicConfigurator;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import pojos.*;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws Exception{
        BasicConfigurator.configure(); // для логирования
        getInfoFromExcel(args[0]); // передаем название input файла
    }


    private static void getInfoFromExcel(String filename) throws Exception{

        Workbook workbook = WorkbookFactory.create(new File(
                "./" + filename));


        JSONMain jsonMain = new JSONMain();
        jsonMain.setName(filename);

        Iterator<Sheet> sheetIterator = workbook.iterator();
        while (sheetIterator.hasNext()) {
            Map<String, String> map = new HashMap<>();
            Sheet sheet = sheetIterator.next();

            SubCategory subCategory = new SubCategory();
            subCategory.setSub_category(sheet.getSheetName());

            int columCount = sheet.getRow(0).getLastCellNum();

            for (int j = 2; j < columCount; j++) {
                if (sheet.getRow(3).getCell(j).getStringCellValue().equals("")) break; // закончились непустые столбцы
                Item item = new Item();
                AddonTutorial addonTutorial;
                FilePOJO file_1;
                for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                    if (sheet.getRow(i).getCell(0).getStringCellValue().equals("images")) {
                        item = new Item(map);
                        map.clear();
                    }
                    if (sheet.getRow(i).getCell(0).getStringCellValue().equals("screenshots")){
                        item.setImages(map);
                        map.clear();
                    }
                    if (sheet.getRow(i).getCell(0).getStringCellValue().equals("addonTutorial")){
                        item.setScreenshots(map);
                        map.clear();
                    }
                    if (sheet.getRow(i).getCell(0).getStringCellValue().equals("file_1")){
                        addonTutorial = new AddonTutorial(map);
                        item.setAddonTutorial(addonTutorial);
                        map.clear();
                    }
                    if (sheet.getRow(i).getCell(0).getStringCellValue().equals("file_2")){
                        file_1 = new FilePOJO(map);
                        item.addFile(file_1);
                        map.clear();
                    }
                    map.put(sheet.getRow(i).getCell(0).getStringCellValue(), sheet.getRow(i).getCell(j).getStringCellValue());
                }
                FilePOJO file_2 = new FilePOJO(map);
                item.addFile(file_2);
                subCategory.addItem(item);
            }
            jsonMain.addCategory(subCategory);
        }
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        ow.writeValue(new File( "output.json"), jsonMain);

        workbook.close();
    }
}
