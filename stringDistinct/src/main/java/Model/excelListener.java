package Model;

import com.alibaba.excel.context.AnalysisContext;
import lombok.extern.slf4j.Slf4j;
import java.util.HashSet;
import java.util.Map;

@Slf4j
public  class excelListener<T>  extends MyEventListener<T>{
    private HashSet<T> tmpLst = new HashSet<>();
    private  Map<Integer, String> headMap ;
    private int count=0;

    @Override
    public Map<Integer, String> getHeadMap() {
        return headMap;
    }

    @Override
    public void invoke(T t, AnalysisContext analysisContext) {
        if(t!=null) tmpLst.add(t);
        if(++count % 50_000==0) log.info("已读取{}项数据",count);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
//        log.info("读excel文件结束");
    }

    @Override
    public HashSet<T> getSet() {
        return tmpLst;
    }

    @Override
    public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
        super.invokeHeadMap(headMap, context);
        this.headMap=headMap;
    }
}
