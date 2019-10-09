package randomdata;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import randomdata.model.*;

import java.beans.Transient;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.*;

/**
 * @author inview
 * @date 2019-9-19
 * 工具类，可自动生成中文省、市、区地址，以及3、4个字的中文名，以及出版社名，书名
 */
public class RandomUtil extends AbstractMyList implements IGetCity, IGetBookAboat, Serializable {
    private static final long serialVersionUID = -3449408073979439084L;
    private Random random = new Random();
    private static RandomUtil instance;

    public static RandomUtil getInstance()  {
        if (instance == null) {
            instance = new RandomUtil();
        }
        return instance;
    }

    private RandomUtil()  {
        loadData();
        var set = new HashSet<>(publisherList);
        universityList.forEach(item -> set.add(new Publisher(item.getUniversity() + "出版社")));
        publisherList = new ArrayList<>(set);
    }

    private void loadData() {
        ExcelUtil eu = new ExcelUtil();
        var map = eu.readExcel();
        if (map == null || map.size() == 0) {
            throw new NullPointerException("读取数据文件错误。没找到randomData.xlsx文件。");
        }
        for (Object item : map.keySet()) {
            switch (item.toString()) {
                case "出版社":
                    publisherList = (List<Publisher>) map.get(item.toString());
                    break;
                case "大学":
                    universityList = ((List<University>) map.get(item.toString()));
                    break;
                case "姓":
                    familyNameList = ((List<FamilyFirstName>) map.get(item.toString()));
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
        if (bookAttachList.isEmpty() || bookTypeList.isEmpty() || provinceList.isEmpty() || familyNameList.isEmpty() || publisherList.isEmpty() || universityList.isEmpty()) {
            throw new NullPointerException("读配置文件错误，请检查数据文件。");
        }
    }

    @Override
    @Transient
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
        return proTmp.getProvinceName() + (cityTmp != null ? cityTmp.getCityName() : "") + (townStr != null ?
                townStr : "");
    }

    @Override
    @Transient
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
    @Transient
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
    @Transient
    public String getBookName() {
        String cityName = getProvinceCityTownName();
        return cityName + bookAttachList.get(random.nextInt(bookAttachList.size())).getBookAttachName();
    }

    @Override
    @Transient
    public String getBookTypeSimple() {
        return bookTypeList.get(random.nextInt(bookTypeList.size())).getBookTypeName();
    }

    @Override
    @Transient
    public String getBookTypeDetails() {
        BookType bt = bookTypeList.get(random.nextInt(bookTypeList.size()));
        return bt.getBookTypeName() + "," + bt.getDetailsList().get(random.nextInt(bt.getDetailsList().size()));
    }

    @Transient
    public String getPublisher() {
        return publisherList.get(random.nextInt(publisherList.size())).getPublisher();
    }

    @Transient
    public String getChineseName() {
        int num = random.nextInt(2) + 1;
        String tmp = "";
        for (int i = 0; i < num; i++) {
            int hightPos, lowPos; // 定义高低位
            //获取高位值
            hightPos = (176 + Math.abs(random.nextInt(39)));
            //获取低位值
            lowPos = (161 + Math.abs(random.nextInt(93)));
            byte[] b = new byte[2];
            b[0] = (byte) (hightPos & 0xff);
            b[1] = (byte) (lowPos & 0xff);
            //转成中文
            try {
                tmp += new String(b, "gb2312");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return tmp;
    }

    @Transient
    public String getFullChineseName() {
        String tmp = familyNameList.get(random.nextInt(familyNameList.size())).getFamilyName();
        tmp += getChineseName();
        return tmp;
    }
}
