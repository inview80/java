package src;

import Tools.MyExcelUitl;
import lombok.extern.slf4j.Slf4j;

public class main {
    private static String filepath = "F:\\11月数据-测试用\\Combined SIR from EIS Boral.xlsx";
    private static String filepath2="F:\\测试数据.xlsx";

    public static void main(String[] args) {
        long start=System.currentTimeMillis();
        new MyExcelUitl().ReadExcel(filepath2);
//        log.info("共用时："+(System.currentTimeMillis()-start));

    }
}
