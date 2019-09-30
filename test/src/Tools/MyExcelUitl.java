package Tools;

import Model.CombinedSIRfromEISBoral;
import Model.ExcelListener;
import com.alibaba.excel.EasyExcel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class MyExcelUitl {
    private static Logger log = LoggerFactory.getLogger(MyExcelUitl.class);
    public void ReadExcel(String filepath) {
        var lis = new ExcelListener<CombinedSIRfromEISBoral>();
        log.info("开始读excel文件");
        try( InputStream inputStream =new BufferedInputStream(new FileInputStream(filepath))) {
            EasyExcel.read(inputStream, CombinedSIRfromEISBoral.class, lis).sheet().doRead();
            log.info("{}",lis.getHead());
            log.info("{}",lis.getDataLst().get(0));
            log.info("{}",lis.getDataLst().get(lis.getDataLst().size() - 1));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
