package ReadCsvUtil.helper;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.text.csv.CsvData;
import cn.hutool.core.text.csv.CsvReader;
import cn.hutool.core.text.csv.CsvRow;
import cn.hutool.core.text.csv.CsvUtil;
import lombok.extern.log4j.Log4j;
import java.io.BufferedReader;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Log4j
public class ReadCsvUtil {

    public static <T extends Object> void read(String filePath, Class<T> tClass, ICsvListener<T> listener) {
        if (!FileUtil.exist(filePath)) throw new NullPointerException("请输入有效的Csv文件");
        BufferedReader fis = FileUtil.getUtf8Reader(filePath);
        priRead(fis, tClass, listener);
    }

    public static <T extends Object> void read(File file, Class<T> tClass, ICsvListener<T> listener) {
        if (file == null || !file.exists()) throw new NullPointerException("请输入有效的Csv文件");
        BufferedReader fis = FileUtil.getUtf8Reader(file);
        priRead(fis, tClass, listener);
    }

    public static <T extends Object> void read(BufferedReader is, Class<T> tclass, ICsvListener<T> listener) {
        if (is == null) throw new NullPointerException("请输入有效的Csv文件");
        priRead(is, tclass, listener);
    }

    private static <T extends Object> void priRead(BufferedReader fis, Class<T> tClass, ICsvListener<T> listener) {
        if (tClass == null) throw new NullPointerException("要转换的类不能为空");
        if (listener == null) throw new NullPointerException("实现ICsvListener接口的类不能为空");
        try {
            Field[] fields = getFields(tClass);
            CsvReader reader = CsvUtil.getReader();
//从文件中读取CSV数据
            CsvData data = reader.read(fis);
            readBody(listener, data, fields, tClass);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
            e.printStackTrace();
        }
        //读完所有行，调用doAfterAllAnalysed函数
        listener.doAfterAllAnalysed();
    }

    private static <T extends Object> void readBody(ICsvListener<T> listener, CsvData data, Field[] fields, Class<T> tClass) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        var iterator = data.iterator();
        //读第一行，头
        if (iterator.hasNext()) {
            readHead(listener, iterator.next());
            iterator.remove();
        }
        T t=null;
        while (iterator.hasNext()) {
            t = tClass.getConstructor().newInstance();
            List<String> row = iterator.next();
            int rowLeng = row.size();
            for (int i1 = 0; i1 < fields.length; i1++) {
                if (i1 == rowLeng) break;
                Field field = fields[i1];
                if (field != null) {
                    if (row.get(i1) == null) continue;
                    field.set(t, row.get(i1));
                }
            }
            listener.invoke(t);
            iterator.remove();
        }
    }

    private static void readHead(ICsvListener<?> listener, CsvRow strings) {
        Map<Integer, String> headMap = new HashMap<>();
        var heads = strings.getRawList();
        for (int i = 0; i < heads.size(); i++) {
            headMap.put(i, heads.get(i));
        }
        listener.invokeHeads(headMap);
    }

    private static Field[] getFields(Class<?> tClass) {
        var tmpMap = new HashMap<Integer, Field>();
        var fields = tClass.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            fields[i].setAccessible(true);
            var target = fields[i].getAnnotation(CsvProperty.class);
            if (target == null || target.index() == -1) {
                tmpMap.put(i, fields[i]);
            } else {
                tmpMap.put(target.index(), fields[i]);
            }
        }
        if (tmpMap.isEmpty()) log.error("提取类的属性时错误，未能提取到值！");
        var maxNo = tmpMap.keySet().stream().max(Integer::compare).get();
        Field[] fs = new Field[maxNo + 1];
        for (Integer i1 : tmpMap.keySet()) {
            fs[i1] = tmpMap.get(i1);
        }
        return fs;
    }
}
