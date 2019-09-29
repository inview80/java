package Model;

import com.alibaba.excel.event.AnalysisEventListener;

import java.util.HashSet;
import java.util.Map;

public abstract class MyEventListener<T> extends AnalysisEventListener<T> {
    public abstract HashSet<T> getSet();
    public abstract Map<Integer,String> getHeadMap();
}
