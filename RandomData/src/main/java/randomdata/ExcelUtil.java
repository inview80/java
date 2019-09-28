package randomdata;

import randomdata.model.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ExcelUtil {
    private static ExcelUtil fragment;

     <T> List<T> readExcel(Class<T> tClass) {
        File file = new File("randomData.xlsx");
        if (!file.exists()) return null;
        try (InputStream inputStream = new FileInputStream(file)) {
            Workbook workbook = WorkbookFactory.create(inputStream);
            for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
                var sheet = workbook.getSheetAt(i);
                if (sheet == null) continue;
                if (tClass.getName().equals(Publishment.class.getName()) && sheet.getSheetName().equals("出版社"))
                    return ReadPublishment(sheet);
                if (tClass.equals(University.class) && sheet.getSheetName().equals("大学"))
                    return ReadUniversity(sheet);
                if (tClass.equals(FamilyFirstName.class) && sheet.getSheetName().equals("姓"))
                    return ReadFamilyName(sheet);
                if (tClass.equals(BookAttach.class) && sheet.getSheetName().equals("书名附加"))
                    return ReadAttach(sheet);
                if (tClass.equals(Provice.class) && sheet.getSheetName().equals("省市县"))
                    return ReadCity(sheet);
                if (tClass.equals(BookType.class) && sheet.getSheetName().equals("书类"))
                    return ReadBookType(sheet);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
         return null;
    }

    private List ReadBookType(Sheet sheet) {
        var booktypeList = new HashSet<BookType>();
        var tmp = sheet.iterator();
        BookType bt = null;
        while (tmp.hasNext()) {
            Cell cell = tmp.next().getCell(0);
            if (cell == null) continue;
            String strTmp = cell.getStringCellValue();
            if (!strTmp.isBlank()) {
                if (!strTmp.contains(",")) {
                    if (bt != null)
                        booktypeList.add(bt);
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
            booktypeList.add( bt );
        return new ArrayList<>(booktypeList);

    }

    private List ReadCity(Sheet sheet) {
        var provinceList = new HashSet<Provice>();
        var tmp = sheet.iterator();
        Provice p = null;
        while (tmp.hasNext()) {
            Cell cell = tmp.next().getCell(0);
            if (cell == null) continue;
            String strTmp = cell.getStringCellValue();
            if (!strTmp.isBlank()) {
                if (!strTmp.contains("：")) {
                    if (p != null)
                        provinceList.add(p);
                    p = new Provice(strTmp);
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
            if (!"".equals(strTmp) && strTmp != null) publishLst.add(new Publishment(strTmp));
        }
        return new ArrayList<>(publishLst);
    }

     static ExcelUtil newInstance() {
        if (fragment == null) fragment = new ExcelUtil();
        return fragment;
    }

}
