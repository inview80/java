import Model.DataClass;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.lang.Console;
import cn.hutool.core.text.csv.CsvRow;
import cn.hutool.core.text.csv.CsvUtil;
import cn.hutool.core.util.RandomUtil;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class CsvUtils {
    public void ReadCsv(String filepath) {
        long start = System.currentTimeMillis();
        var read = CsvUtil.getReader();
        var data = read.read(FileUtil.getUtf8Reader(filepath));
        var lst = new ArrayList<DataClass>();
        int i = 1;

        List<Method> setPropertyMethod = getSetMethod(DataClass.class);
        var rows = data.getRows();
        CsvRow activeRow = null;
        int rowCount = rows.size();
        try {
            for (int i1 = 0; i1 < rowCount; i1++) {
                activeRow = rows.get(0);
                lst.add(getDataClass(activeRow, new DataClass(), setPropertyMethod));
                rows.remove(0);
                i++;
                if (i % 20000 == 0)
                    Console.log(i);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();
        Console.log(lst.size());
        Console.log(lst.get(0));
        Console.log(RandomUtil.randomEle(lst));
        Console.log((end - start));
    }

    private List<Method> getSetMethod(Class<?> dataClassClass) {
        List<Method> resultLst = new ArrayList<>();
        var m = dataClassClass.getDeclaredMethods();
        for (Method method : m) {
            if (method.getName().startsWith("set")) {
                resultLst.add(method);
            }
        }
        return resultLst;
    }

    private DataClass getDataClass(List<String> rawList, DataClass dataClass, List<Method> methods) throws InvocationTargetException, IllegalAccessException {
        int methodleng = methods.size();
        int dataLeng = rawList.size();
        for (int i = 0; i < methodleng; i++) {
            if (i == dataLeng) break;
            String strTmp = rawList.get(i);
            if (!strTmp.isEmpty()) {
                methods.get(i).invoke(dataClass, strTmp);
            }
        }
        rawList = null;
        return dataClass;
    }
}
