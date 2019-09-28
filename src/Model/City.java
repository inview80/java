package Model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(exclude ={"town"} )
@ToString(exclude = {"town"})
public class City {
   @Getter @Setter private String cityName;
    @Getter @Setter private List<String> town= new ArrayList<>();

    public City(@NonNull String[] city) {
        if (city != null && city.length > 0)
            this.cityName = city[0];
        if (city != null && city.length > 1) {
            for (String item : city[1].split(",")) {
                town.add(item);
            }
        }
        town.remove(null);
        town.remove("");
    }

}
