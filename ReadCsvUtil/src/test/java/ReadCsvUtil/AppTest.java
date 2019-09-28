package ReadCsvUtil;

import static org.junit.Assert.assertTrue;

import ReadCsvUtil.helper.ReadCsvUtil;
import ReadCsvUtil.helper.model.TmpClass;
import ReadCsvUtil.model.CsvLisener;
import lombok.extern.log4j.Log4j;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
@Log4j
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void readCsvTest() {
        String filepath = "F:\\11月数据-测试用\\Normalized & UnNormalized Software_BORA_APJ_1.csv";
        long start=System.currentTimeMillis();
        CsvLisener lisener = new CsvLisener<TmpClass>();
        ReadCsvUtil.read(filepath, TmpClass.class, lisener);
        long end =System.currentTimeMillis();

        assertTrue(!lisener.getDataList().isEmpty());
        log.info(lisener.getHeadMap());
        log.info("列表总项数:" + lisener.getDataList().size());
        log.info(String.format("总用时%s毫秒", end-start));
        log.info(lisener.getDataList().get(0));
    }

}
