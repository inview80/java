package Tools;

import com.alibaba.excel.annotation.ExcelProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ReflectUtil {
    private static Logger logger = LoggerFactory.getLogger(ReflectUtil.class);

    public Map<Integer, Field> getPosForFieldToMap(Class<?> tclass) {
        Map<Integer, Field> tmpMap = new HashMap<>();
        logger.info("读取注解及字段");
        int defaultNo = 0;
        for (Field field : tclass.getDeclaredFields()) {
            field.setAccessible(true);
            ExcelProperty ep = field.getAnnotation(ExcelProperty.class);
            if (ep != null) {
                if (ep.index() != -1) {
                    tmpMap.put(ep.index(), field);
                } else {
                    tmpMap.put(defaultNo, field);
                }
                defaultNo++;
            }
        }
        return tmpMap;
    }

    public Map<String, Field> getStringForFieldToMap(Class<?> tclass) {
        var resultMap = new HashMap<String, Field>();
        var fields = tclass.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            var tmp = field.getAnnotation(ExcelProperty.class);
            if (tmp != null) {
                String[] str = tmp.value();
                if (str != null && str[0] != null && !"".equals(str[0])) {
                    resultMap.put(str[0], field);
                }else {
                    resultMap.put(field.getName(), field);
                }
            }
        }
        return resultMap;
    }
}
