package randomdata.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data@AllArgsConstructor@NoArgsConstructor
public class BookAttach implements Serializable {
    private static final long serialVersionUID = 4417989758981043409L;
    private String bookAttachName ;

    }
