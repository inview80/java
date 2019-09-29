package Tool;

import Model.MyEventListener;
import Model.excelListener;
import cn.hutool.core.util.StrUtil;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import lombok.Cleanup;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

@Slf4j
public class MyExcelUtil {
    private static MyExcelUtil instance;
    private Map<Integer, String> headMap;

    private MyExcelUtil() {}

    public Map<Integer, String> getHead() {
        if (headMap == null) throw new NullPointerException("请先运行readExcel方法，以读取相应的Excel文件");
        return headMap;
    }

    public static MyExcelUtil newInstance() {
        if (instance == null) instance = new MyExcelUtil();
        return instance;
    }

    public <T> HashSet<T> readExcel(String filepath, Class<T> tClass) throws IOException  {
        MyEventListener<T> excelLis = new excelListener<T>();
        log.info("开始读excel文件。");
        try (BufferedInputStream inputStream =new BufferedInputStream(new FileInputStream(filepath)))  {
            log.info("excel文件读取结束。");
            EasyExcel.read(inputStream, tClass, excelLis).sheet().doRead();
            this.headMap=excelLis.getHeadMap();
        } catch (IOException e) {
            log.error("IO错误，{}",e.toString());
            throw e;
        }
        return excelLis.getSet();
    }

    public boolean writeExcel(@NonNull String filepath, String tableName, List<?> dataLst) {
        try {
            @Cleanup OutputStream out = new FileOutputStream(filepath);
            ExcelWriter excelWriter = EasyExcelFactory.write(out).head(dataLst.get(0).getClass()).build();
            // 写仅有一个 Sheet 的 Excel 文件, 此场景较为通用
            WriteSheet sheet1 = EasyExcel.writerSheet().build();
            // 第一个 sheet 名称
            if (StrUtil.isNotBlank(tableName))
                sheet1.setSheetName(tableName);
            // 写数据到 Writer 上下文中
            // 入参1: 创建要写入的模型数据
            // 入参2: 要写入的目标 sheet
            excelWriter.write(dataLst, sheet1);

            // 将上下文中的最终 outputStream 写入到指定文件中
            excelWriter.finish();
            return true;
        } catch (IOException e) {
            log.error(e.getMessage());
            return false;
        }
    }

}
