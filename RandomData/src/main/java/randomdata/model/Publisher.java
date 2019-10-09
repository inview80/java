package randomdata.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Publisher implements Serializable {
    private static final long serialVersionUID = -841963147193974171L;
    private String publisher;
}
