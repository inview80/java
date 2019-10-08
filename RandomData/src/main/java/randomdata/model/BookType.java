package randomdata.model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(exclude = {"detailsList"})
@ToString(exclude = {"detailsList"})
@RequiredArgsConstructor
public class BookType {
    @NonNull
    private String bookTypeName;
    private List<String> detailsList = new ArrayList<>();

}
