package randomdata.base;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import randomdata.ExcelUtil;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Database {
    public static Map<String, List> data=new HashMap<>();
    private static final String filename = "src/main/resource/cn.json";

    public static void save(){
        String str = JSON.toJSONString(data);
        try (var out = new BufferedOutputStream(new FileOutputStream(filename))) {
            out.write(str.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        var excel = new ExcelUtil();
//        excel.readExcel();
//        save();
        readData();
    }

    public static void readData(){
        try (var in = new BufferedInputStream(new FileInputStream(filename))) {
            data=  JSON.parseObject(new String(in.readAllBytes()),HashMap.class);
//            System.out.println(data.keySet());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
