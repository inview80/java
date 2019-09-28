package Model;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.BaseRowModel;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.xiaoleilu.hutool.io.FileUtil;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

public class MyExcelUitl {
    public void WriteExcel(String filepath, List<? extends BaseRowModel> dataLst) {
        try( OutputStream out = FileUtil.getOutputStream(filepath)) {
            ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX);
            //写第一个sheet, sheet1  数据全是List<String> 无模型映射关系
            Sheet sheet1 = new Sheet(1, 0, CombinedSIRfromEISBoral.class);
            writer.write(dataLst, sheet1);
            writer.finish();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void ReadExcel(String filepath) {
        var lis=new ExcelListener();
        try( InputStream inputStream = FileUtil.getInputStream(filepath)) {

            ExcelListener excelListener = new ExcelListener();
//            EasyExcelFactory.readBySax(inputStream, new Sheet(2, 1,CombinedSIRfromEISBoral.class), excelListener);
            EasyExcel.read(inputStream, CombinedSIRfromEISBoral.class, lis).sheet().doRead();
            System.out.println("jjj");
            // 解析每行结果在listener中处理
//            AnalysisEventListener listener = new ExcelListener<CombinedSIRfromEISBoral>();
//
//            ExcelReader excelReader = new ExcelReader(inputStream, ExcelTypeEnum.XLSX, null, listener);
//
//            excelReader.read(new ReadSheet(1));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
