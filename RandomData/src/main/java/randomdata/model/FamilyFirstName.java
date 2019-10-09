package randomdata.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data@AllArgsConstructor@NoArgsConstructor
public class FamilyFirstName implements Serializable {
    private static final long serialVersionUID = -752619455760293356L;
    private String familyName;
}
