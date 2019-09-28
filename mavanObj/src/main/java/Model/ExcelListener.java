package Model;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

import java.util.ArrayList;
import java.util.List;

public class ExcelListener<T> extends AnalysisEventListener {
    private List<T> dataLst=new ArrayList<>();
    @Override
    public void invoke(Object object, AnalysisContext context) {
        System.out.println("当前行："+context.getCurrentRowNum());
        System.out.println(object);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
