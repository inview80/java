package boot.mystaic.myweb.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

@Alias("booktype")
@Data@NoArgsConstructor@AllArgsConstructor
public class BookType {
    private int bookTypeID;
    private String bookTypeName;
}
