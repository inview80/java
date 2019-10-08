package randomdata;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import randomdata.model.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.*;

public class ExcelUtil {
    Map<String, List> readExcel() {
        File file = new File("src/main/resource/randomData.xlsx");
        if (!file.exists()) return null;
        Map<String, List> result = new HashMap<>(6);

        try (InputStream inputStream = new FileInputStream(file)) {
            Workbook workbook = WorkbookFactory.create(inputStream);
            List tmp = null;
            for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
                var sheet = workbook.getSheetAt(i);
                if (sheet == null) continue;
                switch (sheet.getSheetName()) {
                    case "出版社":
                        tmp = ReadPublishment(sheet);
                        break;
                    case "大学":
                        tmp = ReadUniversity(sheet);
                        break;
                    case "姓":
                        tmp = ReadFamilyName(sheet);
                        break;
                    case "书名附加":
                        tmp = ReadAttach(sheet);
                        break;
                    case "省市县":
                        tmp = ReadCity(sheet);
                        break;
                    case "书类":
                        tmp =ReadBookType(sheet);
                        break;
                    default:
                        break;
                }
                result.put(sheet.getSheetName(), tmp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

//    public void readExcel() {
//        File file = new File("src/main/resource/randomData.xlsx");
//        if (!file.exists()) return;
//        try (InputStream inputStream = new FileInputStream(file)) {
//            Workbook workbook = WorkbookFactory.create(inputStream);
//            for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
//                var sheet = workbook.getSheetAt(i);
//                if (sheet == null) continue;
//                if (sheet.getSheetName().equals("出版社"))
//                    Database.data.put(sheet.getSheetName(), ReadPublishment(sheet));
//                if (sheet.getSheetName().equals("大学"))
//                    Database.data.put(sheet.getSheetName(), ReadUniversity(sheet));
//                if (sheet.getSheetName().equals("姓"))
//                    Database.data.put(sheet.getSheetName(), ReadFamilyName(sheet));
//                if (sheet.getSheetName().equals("书名附加"))
//                    Database.data.put(sheet.getSheetName(), ReadAttach(sheet));
//                if (sheet.getSheetName().equals("省市县"))
//                    Database.data.put(sheet.getSheetName(), ReadCity(sheet));
//                if (sheet.getSheetName().equals("书类"))
//                    Database.data.put(sheet.getSheetName(), ReadBookType(sheet));
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    private List ReadBookType(Sheet sheet) {
        var bookTypeSet = new HashSet<BookType>();
        var tmp = sheet.iterator();
        BookType bt = null;
        while (tmp.hasNext()) {
            Cell cell = tmp.next().getCell(0);
            if (cell == null) continue;
            String strTmp = cell.getStringCellValue();
            if (!strTmp.isBlank()) {
                if (!strTmp.contains(",")) {
                    if (bt != null) {
                        bookTypeSet.add(bt);
                    }
                    bt = new BookType(strTmp);
                } else {
                    String[] detail = strTmp.split(",");
                    if (detail.length > 0) {
                        var tmpSet = new ArrayList<String>(detail.length);
                        tmpSet.addAll(Arrays.asList(detail));
                        tmpSet.remove(null);
                        tmpSet.remove("");
                        bt.setDetailsList(tmpSet);
                    }
                }
            }
        }
        if (bt != null)
            bookTypeSet.add(bt);
        return new ArrayList<>(bookTypeSet);
    }

    private List ReadCity(Sheet sheet) {
        var provinceList = new HashSet<Province>();
        var tmp = sheet.iterator();
        Province p = null;
        while (tmp.hasNext()) {
            Cell cell = tmp.next().getCell(0);
            if (cell == null) continue;
            String strTmp = cell.getStringCellValue();
            if (!strTmp.isBlank()) {
                if (!strTmp.contains("：")) {
                    if (p != null)
                        provinceList.add(p);
                    p = new Province(strTmp);
                } else {
                    String[] city = strTmp.split("：");
                    if (city.length > 0) {
                        City c = new City(city);
                        p.getCitys().add(c);
                    }
                }
            }
        }
        if (p != null)
            provinceList.add(p);
        return new ArrayList<>(provinceList);
    }

    private List ReadAttach(Sheet sheet) {
        var bookAttachList = new HashSet<BookAttach>();
        var tmp = sheet.rowIterator();
        while (tmp.hasNext()) {
            Cell cell = tmp.next().getCell(0);
            if (cell == null) continue;
            String strTmp = cell.getStringCellValue();
            if (!strTmp.isBlank())
                bookAttachList.add(new BookAttach(strTmp));
        }
        return new ArrayList<>(bookAttachList);
    }

    private List ReadFamilyName(Sheet sheet) {
        var famiLst = new ArrayList<FamilyFirstName>();
        var tmp = sheet.rowIterator();
        while (tmp.hasNext()) {
            var row = tmp.next();
            if (row.getCell(0) == null) continue;
            String str = row.getCell(0).getStringCellValue();
            if (!str.isBlank()) {
                for (Character c : str.toCharArray()) {
                    if (c == 0) continue;
                    famiLst.add(new FamilyFirstName(c.toString()));
                }
            }
            if (row.getCell(1) == null) continue;
            String str1 = row.getCell(1).getStringCellValue();
            if (!str1.isBlank()) {
                famiLst.add(new FamilyFirstName(str1));
            }
        }
        return famiLst;
    }

    private List ReadUniversity(Sheet sheet) {
        var uniLst = new HashSet<University>();
        var tmp = sheet.rowIterator();
        while (tmp.hasNext()) {
            var cellIterator = tmp.next().cellIterator();
            while (cellIterator.hasNext()) {
                String str = cellIterator.next().getStringCellValue();
                if (!str.isBlank()) uniLst.add(new University(str));
            }
        }
        return new ArrayList<>(uniLst);
    }

    private List ReadPublishment(Sheet sheet) {
        var publishLst = new HashSet<Publishment>();
        for (int row = sheet.getFirstRowNum(); row <= sheet.getLastRowNum(); row++) {
            var cell = sheet.getRow(row).getCell(0);
            if (cell == null) continue;
            String strTmp = cell.toString();
            if (strTmp != null && !"".equals(strTmp)) publishLst.add(new Publishment(strTmp));
        }
        return new ArrayList<>(publishLst);
    }

}
