package randomdata.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author inview
 * 省
 */
@Data
public class Province {
    private String provinceName;
    private List<City> citys = new ArrayList<>();

    public Province(String provinceName) {
        this.provinceName = provinceName;
    }
}
