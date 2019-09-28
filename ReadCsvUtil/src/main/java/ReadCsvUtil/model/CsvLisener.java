package ReadCsvUtil.model;

import ReadCsvUtil.helper.ICsvListener;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Getter
public class CsvLisener<T> implements ICsvListener<T> {
    private Map<Integer, String> headMap;
    private List<T> dataList = new ArrayList<>();

    @Override
    public void invokeHeads(Map<Integer, String> headMap) {
        this.headMap = headMap;
    }

    @Override
    public void invoke(T t) {
        if (t != null) dataList.add(t);
    }

    @Override
    public void doAfterAllAnalysed() {

    }

    @Override
    public void onException(Exception e) {

    }
}
