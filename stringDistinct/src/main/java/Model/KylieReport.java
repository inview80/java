package Model;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor@AllArgsConstructor
@Builder
/**
 * PRMfg PRProduct DeviceSS DeviceHost四项做比较，一样则相同
 */
public class KylieReport {
    @ExcelProperty(index = 0,value = "Client")
    private String client;

    @ExcelProperty(index = 1)
    private String assetTag;

    @ExcelProperty(index = 2)
    private String serialAsset;

    @ExcelProperty(index = 3)
    private String subModel;

    @ExcelProperty(index = 4)
    private String nameBrand;

    @ExcelProperty(index = 5)
    private String nameModel;

    @ExcelProperty(index = 6)
    private String statusAsset;

    @ExcelProperty(index = 7)
    private String assignment;

    @ExcelProperty(index = 8)
    private String location;

    @ExcelProperty(index = 9)
    private String addressLocation;

    @ExcelProperty(index = 10)
    private String firstUser;

    @ExcelProperty(index = 11)
    private String nameUser;

    @ExcelProperty(index = 12)
    private String emailUser;

    @ExcelProperty(index = 13)
    private String idUser;
    @ExcelProperty(index = 14)
    private String user;
    @ExcelProperty(index = 15)
    private String costCode;
    @ExcelProperty(index = 16)
    private String accountingDivision;
    @ExcelProperty(index = 17)
    private String cityLocation;
    @ExcelProperty(index = 18)
    private String stateLocation;
    @ExcelProperty(index = 19)
    private String zipLocation;
    @ExcelProperty(index = 20)
    private String system;
    @ExcelProperty(index = 21)
    private String nameITequipent;
    @ExcelProperty(index = 22)
    private String nonDiscoverableReason;
}

