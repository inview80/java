package randomdata;

import lombok.Setter;
import randomdata.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author inview
 * @date 2019-9-19
 * 工具类，可自动生成中文省、市、区地址，以及3、4个字的中文名，以及出版社名，书名
 */
public class RandomUtil implements IGetCity, IGetBookAboat {
    @Setter
    private Random random = new Random();
    private List<BookAttach> bookAttachList;
    private List<BookType> bookTypeList;
    private List<Province> provinceList;
    private List<FamilyFirstName> familynameList;
    private List<Publishment> publishmentList;
    private List<University> universityList;
    private static RandomUtil instance;

    public static RandomUtil getInstance() {
        if (instance == null) {
            instance = new RandomUtil();
        }
        return instance;
    }

    private RandomUtil() {
        loadData();
    }

    private void loadData() {
        ExcelUtil eu=new ExcelUtil();
        var map = eu.readExcel();
        if (map == null || map.size() == 0) {
            throw new NullPointerException("读取数据文件错误。没找到randomData.xlsx文件。");
        }
        for (Object item : map.keySet()) {
            switch (item.toString()) {
                case "出版社":
                    publishmentList = (List<Publishment>) map.get(item.toString());
                    break;
                case "大学":
                    universityList = ((List<University>) map.get(item.toString()));
                    break;
                case "姓":
                    familynameList = ((List<FamilyFirstName>) map.get(item.toString()));
                    break;
                case "书名附加":
                    bookAttachList = ((List<BookAttach>) map.get(item.toString()));
                    break;
                case "省市县":
                    provinceList = ((List<Province>) map.get(item.toString()));
                    break;
                case "书类":
                    bookTypeList = ((List<BookType>) map.get(item.toString()));
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    public String getProvinceCityTownName() {
        Province proTmp = provinceList.get(random.nextInt(provinceList.size()));
        String townStr = null;
        City cityTmp = null;
        if (proTmp.getCitys() != null && proTmp.getCitys().size() > 0) {
            cityTmp = proTmp.getCitys().get(random.nextInt(proTmp.getCitys().size()));
            if (cityTmp.getTown() != null && cityTmp.getTown().size() > 0) {
                townStr = cityTmp.getTown().get(random.nextInt(cityTmp.getTown().size()));
            }
        }
        return proTmp.getProvinceName() + (cityTmp != null ? cityTmp.getCityName() : "") + (townStr!=null? townStr :"");
    }

    @Override
    public List<String> getProvinceCityTownAll() {
        List<String> resultList = new ArrayList<>();
        for (Province pro : provinceList) {
            for (City city : pro.getCitys()) {
                for (String str : city.getTown()) {
                    String strTmp = city.getCityName().startsWith(pro.getProvinceName()) ? city.getCityName() + str :
                            pro.getProvinceName() + city.getCityName() + str;
                    resultList.add(strTmp);
                }
            }
        }
        return resultList;
    }

    @Override
    public String getProvinceCityName() {
        int proNo = random.nextInt(provinceList.size());
        String proStr = provinceList.get(proNo).getProvinceName();
        String cityStr = "";
        if (provinceList.get(proNo).getCitys() != null && provinceList.get(proNo).getCitys().size() > 0) {
            cityStr =
                    provinceList.get(proNo).getCitys().get(random.nextInt(provinceList.get(proNo).getCitys().size())).getCityName();
        }
        return cityStr.startsWith(proStr) ? cityStr : proStr + cityStr;
    }

    @Override
    public String getBookName() {
        String cityName = getProvinceCityTownName();
        return cityName + bookAttachList.get(random.nextInt(bookAttachList.size())).getBookAttachName();
    }

    @Override
    public String getBookTypeSimple() {
        return bookTypeList.get(random.nextInt(bookTypeList.size())).getBookTypeName();
    }

    @Override
    public String getBookTypeDetails() {
        BookType bt = bookTypeList.get(random.nextInt(bookTypeList.size()));
        return bt.getBookTypeName() + "," + bt.getDetailsList().get(random.nextInt(bt.getDetailsList().size()));
    }
}
