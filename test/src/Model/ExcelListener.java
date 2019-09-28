package Model;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.read.listener.ReadListener;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelListener<T> extends AnalysisEventListener<T> {
    private List<T> dataLst = new ArrayList<T>();
    private Map<Integer, String> head = new HashMap<>();
    private static Logger logger = Logger.getLogger(ExcelListener.class);
private int count=0;

    public List<T> getDataLst() {
        return dataLst;
    }

    public Map<Integer, String> getHead() {
        return head;
    }

    @Override
    public void invoke(T t, AnalysisContext analysisContext) {
        dataLst.add(t);
        count++;
        if(count%10000==0)logger.info("已完成："+count);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        logger.info("读excel文件结束!");
    }

    @Override
    public void invokeHead(Map<Integer, CellData> headMap, AnalysisContext context) {
        super.invokeHead(headMap, context);
        headMap.forEach((i,cell)->head.put(i,cell.getStringValue()));
    }
}
