package randomdata.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.io.Serializable;

@Data@AllArgsConstructor@NoArgsConstructor
public class University implements Serializable {
    private static final long serialVersionUID = 8929646122498061203L;
    @NonNull
    private String university;
}
