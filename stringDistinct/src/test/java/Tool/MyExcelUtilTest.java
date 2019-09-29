package Tool;

import Model.BaseDate;
import Model.KylieReport;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

@Slf4j
public class MyExcelUtilTest {
    @Test
    public void writeExcel() {
        String filepath = "f:\\test.xlsx";
        String tablename = "表格1";
        var kylie = KylieReport.builder().accountingDivision("aaaa").addressLocation("bbbb")
                .assetTag("4233j").assignment("9goi").cityLocation("jdsfjewo").client("joifjewij")
                .costCode("dfgi4hjihj").build();
        var lst = new ArrayList<KylieReport>();
        lst.add(kylie);
        boolean isOk = MyExcelUtil.newInstance().writeExcel(filepath, "", lst);
        assert isOk;
        log.info("写入成功");
    }

    @Test
    public void readExcel() {
//        String filepath = "f:\\Normalized Software_Downer_apj_1.xlsx";
        String filepath="";
        HashSet<BaseDate> lst = null;
        try {
            lst = MyExcelUtil.newInstance().readExcel(filepath, BaseDate.class);
        } catch (IOException e) {
            e.getLocalizedMessage();
            return;
        }
        log.info("表头内容：{}",MyExcelUtil.newInstance().getHead());
        log.info("列表长度：{}",lst.size());
        var it=lst.iterator();
        log.info("第一项的值:{}",it.next());
        assert lst!=null;
        assert lst.size()>1000;
//        MyExcelUtil mu = Mockito.mock(MyExcelUtil.class);
        log.info("djfe:{}:oiji",filepath);
        log.warn("1111:{}:2222");
    }

}