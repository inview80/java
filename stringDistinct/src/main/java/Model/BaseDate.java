package Model;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.util.Objects;


/**
 * PRMfg PRProduct DeviceSS DeviceHost四项做比较，一样则相同
 */
@Data
public class BaseDate {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BaseDate)) return false;
        BaseDate baseDate = (BaseDate) o;
        return (prMfg+prProduct +deviceSS+deviceHost).equals(baseDate.prMfg+baseDate.prProduct+baseDate.deviceSS+baseDate.deviceHost) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(prMfg+prProduct+deviceSS+deviceHost);
    }

    @ExcelProperty(index = 0, value = "Client")
    private String client;

    @ExcelProperty(index = 1, value = "Mfg")
    private String mfg;

    @ExcelProperty(index = 2, value = "Product")
    private String product;

    @ExcelProperty(index = 3, value = "Version")
    private String version;

    @ExcelProperty(index = 4, value = "PR Mfg")
    private String prMfg;

    @ExcelProperty(index = 5, value = "PR Product")
    private String prProduct;

    @ExcelProperty(index = 6, value = "AAD Tool")
    private String aadTool;

    @ExcelProperty(index = 7, value = "DT Lastscan")
    private String dtLastscan;

    @ExcelProperty(index = 8, value = "dtSoftscan")
    private String dtSoftscan;

    @ExcelProperty(index = 9, value = "pullYqualIfieddoMainName")
    private String pullYqualIfieddoMainName;

    @ExcelProperty(index = 10, value = "operatingSystem")
    private String operatingSystem;

    @ExcelProperty(index = 11, value = "platForm")
    private String platForm;

    @ExcelProperty(index = 12, value = "lastLoggedinUser")
    private String lastLoggedinUser;

    @ExcelProperty(index = 13, value = "lastExecutedDate")
    private String lastExecutedDate;

    @ExcelProperty(index = 14, value = "Suite")
    private String suite;

    @ExcelProperty(index = 15, value = "AAD Cong")
    private String aadCong;

    @ExcelProperty(index = 16, value = "deviceMfg")
    private String deviceMfg;

    @ExcelProperty(index = 17, value = "deviceMake")
    private String deviceMake;

    @ExcelProperty(index = 18, value = "device SS #")
    private String deviceSS;

    @ExcelProperty(index = 19, value = "deviceHost")
    private String deviceHost;

    @ExcelProperty(index = 20, value = "deviceType")
    private String deviceType;

    @ExcelProperty(index = 21, value = "installDate")
    private String installDate;

    @ExcelProperty(index =22, value = "installFolder")
    private String installFolder;
}


