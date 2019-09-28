package Model;

import java.util.ArrayList;
import java.util.List;

public class Provice {
    private String proviceName;
    private List<City> citys=new ArrayList<>();

    public String getProviceName() {
        return proviceName;
    }

    public void setProviceName(String proviceName) {
        this.proviceName = proviceName;
    }

    public List<City> getCitys() {
        return citys;
    }

    public void setCitys(List<City> citys) {
        this.citys = citys;
    }

    public Provice(String proviceName) {
        this.proviceName = proviceName;
    }
}
