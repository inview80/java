package randomdata.model;

import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(exclude = {"detailsList"})
@ToString(exclude = {"detailsList"})
@RequiredArgsConstructor
@NoArgsConstructor
public class BookType implements Serializable {
    private static final long serialVersionUID = -8113645547696318154L;
    @NonNull
    private String bookTypeName;
    private List<String> detailsList = new ArrayList<>();

}
