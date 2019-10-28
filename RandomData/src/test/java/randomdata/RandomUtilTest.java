package randomdata;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@Slf4j
public class RandomUtilTest {
    private final static int COUNT_NUMBER=50000;
    @Test
    public void getProvice_City_TownName()  throws IOException{
        var tmp = getList(RandomUtil.getInstance()::getProvinceCityTownName);
        log.info("省、市、县：{}",tmp);
    }

    @Test
    public void getProvice_City_Town_All() throws IOException {
        var tmp=RandomUtil.getInstance().getProvinceCityTownAll();
        log.info("所有省、市、县:{}",tmp);
        log.info("数量总计：{}",tmp.size());
    }

    @Test
    public void getProvice_CityName() throws IOException {
        var tmp = getList(RandomUtil.getInstance()::getProvinceCityName);
        log.info("省、市名:{}",tmp);
    }

    @Test
    public void getBookName() throws IOException {
        var tmp = getList(RandomUtil.getInstance()::getBookName);
        log.info("图书名称：{}",tmp);
    }

    @Test
    public void getBookType_Big() throws IOException {
        List<String> tmp = getList(RandomUtil.getInstance()::getBookTypeSimple);
        log.info("图书类型，简略：{}",tmp);
    }


    private List<String> getList(Supplier<String> action) {
        var tmp = new HashSet<String> (COUNT_NUMBER);
        for (int i = 0; i < COUNT_NUMBER; i++) {
            tmp.add(action.get());
        }
        return new ArrayList<>(tmp);
    }

    @Test
    public void getBookType_Small()  throws IOException{
        List<String> tmp = getList(RandomUtil.getInstance()::getBookTypeDetails);
        log.info("图书类型，详细：{}",tmp);
    }

    @Test
    public void getPublishment() throws IOException {
        var tmp = getList(RandomUtil.getInstance()::getPublisher);
        log.info("出版社：{}",tmp);
    }

    @Test
    public  void getChineseName() throws IOException{
        var tmp = getList(RandomUtil.getInstance()::getChineseName);
        log.info("名：{}",tmp);
    }

    @Test
    public void getFullChineseName() throws IOException {
        var tmp = getList(RandomUtil.getInstance()::getFullChineseName);
        log.info("姓名：{}",tmp);
    }
}