
import Model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomUtil implements IGetCity, IGetBookAboat {
    private Random random;
    private List<BookAttach> bookAttachList;
    private List<BookType> bookTypeList;
    private List<Provice> proviceList;
    private List<FamilyFirstName> familynameList;
    private List<Publishment> publishmentList;
    private List<University> universityList;
    private static RandomUtil grd;

    public static RandomUtil newInstance() {
        if (grd == null) grd = new RandomUtil();
        return grd;
    }

    private RandomUtil() {
        random = new Random();
    }

    @Override
    public String getProvice_City_TownName() {
        if (proviceList == null)
            proviceList = ExcelUtil.newInstance().readExcel(Provice.class);
        Provice proTmp = proviceList.get(random.nextInt(proviceList.size()));
        String townStr = null;
        City cityTmp = null;
        if (proTmp.getCitys() != null && proTmp.getCitys().size() > 0) {
            cityTmp = proTmp.getCitys().get(random.nextInt(proTmp.getCitys().size()));
            if (cityTmp.getTown() != null && cityTmp.getTown().size() > 0)
                townStr = cityTmp.getTown().get(random.nextInt(cityTmp.getTown().size()));
        }
        return proTmp.getProviceName() + (cityTmp != null ? cityTmp.getCityName() : "") + townStr;
    }

    @Override
    public List<String> getProvice_City_Town_All() {
        if (proviceList == null)
            proviceList = ExcelUtil.newInstance().readExcel(Provice.class);
        List<String> resultList = new ArrayList<>();
        for (Provice pro : proviceList) {
            for (City city : pro.getCitys()) {
                for (String str : city.getTown()) {
                    String strTmp =city.getCityName().startsWith(pro.getProviceName())  ? city.getCityName() + str : pro.getProviceName() + city.getCityName() + str;
                    resultList.add(strTmp);
                }
            }
        }
        return resultList;
    }

    @Override
    public String GetProvice_CityName() {
        if (proviceList == null)
            proviceList = ExcelUtil.newInstance().readExcel(Provice.class);
        int proNo = random.nextInt(proviceList.size());
        String proStr = proviceList.get(proNo).getProviceName();
        String cityStr = null;
        if (proviceList.get(proNo).getCitys() != null && proviceList.get(proNo).getCitys().size() > 0)
            cityStr = proviceList.get(proNo).getCitys().get(random.nextInt(proviceList.get(proNo).getCitys().size())).getCityName();
        return cityStr.startsWith(proStr) ? cityStr : proStr + cityStr;
    }

    @Override
    public String GetBookName() {
        String cityName =getProvice_City_TownName();
        if (bookAttachList == null)
            bookAttachList = ExcelUtil.newInstance().readExcel(BookAttach.class);
        return cityName + bookAttachList.get(random.nextInt(bookAttachList.size())).getBookAttachName();
    }

    @Override
    public String GetBookType_Big() {
        if (bookTypeList == null)
            bookTypeList = ExcelUtil.newInstance().readExcel(BookType.class);
        return bookTypeList.get(random.nextInt(bookTypeList.size())).getBookTypeName();
    }

    @Override
    public String GetBookType_Small() {
        if (bookTypeList == null)
            bookTypeList = ExcelUtil.newInstance().readExcel(BookType.class);
        BookType bt = bookTypeList.get(random.nextInt(bookTypeList.size()));
        return bt.getBookTypeName() + "," + bt.getDetailsList().get(random.nextInt(bt.getDetailsList().size()));
    }
}
