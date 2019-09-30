package src;

import Tools.MyExcelUitl;
import com.github.javafaker.Faker;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Locale;

public class main {
    private static String filepath = "F:\\11月数据-测试用\\Combined SIR from EIS Boral.xlsx";
    private static String filepath2="F:\\测试数据.xlsx";
    private static Logger log = LoggerFactory.getLogger(main.class);

    public static void main(String[] args) {
//        long start=System.currentTimeMillis();
//        new MyExcelUitl().ReadExcel(filepath2);
//        log.info("共用时："+(System.currentTimeMillis()-start));
        Faker faker=new Faker(new Locale("zh-CN"));
        for (int i = 0; i < 100; i++) {
            log.info("名称：{}",faker.yoda().quote());
        }
    }
}
