package boot.mystaic.myweb.secret;

import cn.hutool.core.util.StrUtil;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Getter
public enum PowerEnum {
    /**
     * GENERAL普通用户,EMPLOYEE内部员工, ADMINISTER管理员
     */
    GENERAL(0, "普通用户"),
    ADMINISTER(2, "管理员"),
    EMPLOYEE(1,"内部员工");

private int id;
private String name;

    PowerEnum(int id, String name) {
        this.id=id;
        this.name=name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static PowerEnum getEnumById(int id) {
        for (PowerEnum power : PowerEnum.values()) {
            if (power.getId() == id) {
                return power;
            }
        }
        return null;
    }

    public static PowerEnum getEnumByName(String name) {
        if (StrUtil.isBlank(name)) {
            return null;
        }
        for (PowerEnum powerEnum : PowerEnum.values()) {
            if (powerEnum.getName().equals(name)) {
                return powerEnum;
            }
        }
        return null;
    }
}
