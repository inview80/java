package randomdata.model;

import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author inview
 * 省
 */
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Province implements Serializable {
    private static final long serialVersionUID = -5825288944078702251L;
    @NonNull
    private String provinceName;
    private List<City> citys = new ArrayList<>();
}
