package ReadCsvUtil.helper;

import ReadCsvUtil.model.CsvLisener;
import cn.hutool.core.util.RandomUtil;
import lombok.extern.log4j.Log4j;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ReadCsvUtil.helper.model.TmpClass;

import java.io.BufferedReader;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

@Log4j
public class ReadCsvUtilTest {
    String filepath = "F:\\11月数据-测试用\\Normalized & UnNormalized Software_BORA_APJ_1.csv";
    CsvLisener<TmpClass> lisener;

    @Before
    public void init() {
        lisener = new CsvLisener<TmpClass>();
    }

    @After
    public void end() {
        lisener = null;
    }

    @Test(expected = NullPointerException.class)
    public void readFilePathError1() {
        ReadCsvUtil.read("", TmpClass.class, lisener);
    }
    @Test(expected = NullPointerException.class)
    public void readFilePathError2() {
        ReadCsvUtil.read(filepath, null, lisener);
    }
    @Test(expected = NullPointerException.class)
    public void readFilePathError3() {
        File file=null;
        ReadCsvUtil.read(file, TmpClass.class, lisener);
    }
    @Test(expected = NullPointerException.class)
    public void readFilePathError4() {
        BufferedReader br=null;
        ReadCsvUtil.read(br,TmpClass.class,lisener);
    }
    @Test(expected = NullPointerException.class)
    public void readFilePathError5() {
        lisener=null;
        ReadCsvUtil.read(filepath,TmpClass.class,lisener);
    }

    @Test
    public void readFilePath() {
        Long start=System.currentTimeMillis();
        ReadCsvUtil.read(filepath, TmpClass.class, lisener);
        Long end =System.currentTimeMillis();
        log.info(String.format("共用时%s毫秒", end - start));
        log.info(lisener.getHeadMap());
        log.info(lisener.getDataList().get(1));
        log.info(RandomUtil.randomEle(lisener.getDataList()));
    }

    @Test
    public void readFile() {
        Long start=System.currentTimeMillis();
        File file = new File(filepath);
        ReadCsvUtil.read(file, TmpClass.class, lisener);
        Long end =System.currentTimeMillis();
        log.info(String.format("共用时%s毫秒", end - start));
        log.info(lisener.getHeadMap());
        log.info(lisener.getDataList().get(1));
        log.info(RandomUtil.randomEle(lisener.getDataList()));
    }
}