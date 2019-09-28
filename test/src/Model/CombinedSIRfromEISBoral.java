package Model;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;


/**
 * Client	Mfg	Product	VERSION	PR Mfg	PR Product	AAD Tool	Dtlastscan	Dtsoftscan	FULLYQUALIFIEDDOMAINNAME	OPERATINGSYSTEM	PLATFORM	LASTLOGGEDINUSER	LASTEXECUTEDDATE	Suite	AAD Cong	Device Mfg	Device Make	Device SS #	Device Host	Device Type	Install Date	Install Folder
 */
@Data
public class CombinedSIRfromEISBoral {
    @ExcelProperty(index = 0, value = "Client")
    private String client;

    @ExcelProperty(index = 1, value = "mfg")
    private String mfg;

    @ExcelProperty(index = 2, value = "product")
    private String product;

    @ExcelProperty(index = 3, value = "version")
    private String version;

    @ExcelProperty(index = 4, value = "PR Mfg")
    private String prMfg;

    @ExcelProperty(index = 5, value = "PR Product")
    private String prProduct;

    @ExcelProperty(index = 6, value = "AAD Tool")
    private String aadTool;

    @ExcelProperty(index = 7, value = "Dtlastscan")
    private String dtlastscan;

    @ExcelProperty(index = 8, value = "Dtsoftscan")
    private String dtSoftscan;

    @ExcelProperty(index = 9, value = "FULLYQUALIFIEDDOMAINNAME")
    private String fullYqualifieddomainname;

    @ExcelProperty(index = 10, value = "OPERATINGSYSTEM")
    private String operationgSystem;

    @ExcelProperty(index = 11, value = "PLATFORM")
    private String platform;

    @ExcelProperty(index = 12, value = "LASTLOGGEDINUSER")
    private String lastLoggedinUser;

    @ExcelProperty(index = 13, value = "LASTEXECUTEDDATE")
    private String lastExecutedDate;

    @ExcelProperty(index = 14, value = "Suite")
    private String suite;

    @ExcelProperty(index = 15, value = "AAD Cong")
    private String aadCong;

    @ExcelProperty(index = 16, value = "Device Mfg")
    private String deviceMfg;

    @ExcelProperty(index = 17, value = "Device Make")
    private String deviceMake;

    @ExcelProperty(index = 18, value = "Device SS #")
    private String deviceSS;

    @ExcelProperty(index = 19, value = "Device Host")
    private String deviceHost;

    @ExcelProperty(index = 20, value = "Device Type")
    private String deviceType;

    @ExcelProperty(index = 21, value = "Install Date")
    private String installDate;

    @ExcelProperty(index = 22, value = "Install Folder")
    private String installFolder;


}