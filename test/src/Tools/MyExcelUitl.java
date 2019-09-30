package Tools;

import Model.CombinedSIRfromEISBoral;
import Model.ExcelListener;
import cn.hutool.core.io.FileUtil;
import com.alibaba.excel.EasyExcel;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;

@Slf4j
public class MyExcelUitl {
//    public void WriteExcel(String filepath, List<? extends BaseRowModel> dataLst) {
//        try( OutputStream out = FileUtil.getOutputStream(filepath)) {
//            ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX);
//            //写第一个sheet, sheet1  数据全是List<String> 无模型映射关系
//            Sheet sheet1 = new Sheet(1, 0, CombinedSIRfromEISBoral.class);
//            writer.write(dataLst, sheet1);
//            writer.finish();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    public void ReadExcel(String filepath) {
        var lis = new ExcelListener<CombinedSIRfromEISBoral>();
        log.info("开始读excel文件");
        try( InputStream inputStream = FileUtil.getInputStream(filepath)) {
            EasyExcel.read(inputStream, CombinedSIRfromEISBoral.class, lis).sheet().doRead();
            log.info(lis.getHead());
            log.info(lis.getDataLst().get(0));
            log.info(lis.getDataLst().get(lis.getDataLst().size() - 1));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
