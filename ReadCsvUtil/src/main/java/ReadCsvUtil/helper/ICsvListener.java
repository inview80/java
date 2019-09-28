package ReadCsvUtil.helper;

import java.util.Map;

public  interface ICsvListener<T> {
    void invokeHeads(Map<Integer, String> headMap);
    void invoke(T t);
    void doAfterAllAnalysed();
    void onException(Exception e);
}
