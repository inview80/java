package Model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(exclude ={"detailsList"} )
@ToString(exclude = {"detailsList"})
public class BookType {
    @Getter @Setter private String bookTypeName;
    @Getter @Setter private List<String> detailsList=new ArrayList<>();

    public BookType(String bookTypeName) {
        this.bookTypeName = bookTypeName;
    }
}
