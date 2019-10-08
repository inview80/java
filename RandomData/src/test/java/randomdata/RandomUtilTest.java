package randomdata;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

@Slf4j
public class RandomUtilTest {
    private final static int COUNT_NUMBER=50;
    @Test
    public void getProvice_City_TownName() {
        var tmp = getList(RandomUtil.getInstance()::getProvinceCityTownName);
        log.info("省、市、县：{}",tmp);
    }

    @Test
    public void getProvice_City_Town_All() {
        var tmp=RandomUtil.getInstance().getProvinceCityTownAll();
        log.info("所有省、市、县:{}",tmp);
        log.info("数量总计：{}",tmp.size());
    }

    @Test
    public void getProvice_CityName() {
        var tmp = getList(RandomUtil.getInstance()::getProvinceCityName);
        log.info("省、市名:{}",tmp);
    }

    @Test
    public void getBookName() {
        var tmp = getList(RandomUtil.getInstance()::getBookName);
        log.info("图书名称：{}",tmp);
    }

    @Test
    public void getBookType_Big() {
        List<String> tmp = getList(RandomUtil.getInstance()::getBookTypeSimple);
        log.info("图书类型，全部：{}",tmp);
    }


    private List<String> getList(Supplier<String> action) {
        var tmp = new ArrayList<String>(COUNT_NUMBER);
        for (int i = 0; i < COUNT_NUMBER; i++) {
            tmp.add(action.get());
        }
        return tmp;
    }

    @Test
    public void getBookType_Small() {

    }
    
}