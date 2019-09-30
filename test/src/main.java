import Tools.MyExcelUitl;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class main {
    private static String filepath = "F:\\11月数据-测试用\\Combined SIR from EIS Boral.xlsx";
    private static String filepath2="F:\\11月数据-测试用\\DDMI Sql Extract.xlsx";

    public static void main(String[] args) {
        long start=System.currentTimeMillis();
        new MyExcelUitl().ReadExcel(filepath);
        log.info("共用时："+(System.currentTimeMillis()-start));
    }
}
