package randomdata.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data@AllArgsConstructor
public class University {
    @NonNull
    private String university;
}
