package randomdata.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author inview
 * 省
 */
@Data
@RequiredArgsConstructor
public class Province {
    @NonNull
    private String provinceName;
    private List<City> citys = new ArrayList<>();
}
