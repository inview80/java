package boot.mystaic.myweb.mapper;

import boot.mystaic.myweb.pojo.BookType;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface BookTypeMapper {
    @Select("select * from booktype where 1=1")
    List<BookType> getAll();

    @Insert("insert into bookType values(null,#{bookTypeName})")
    int add(String bookTypeName);

    @Delete("delete from booktype where booktypeID=#{bookTypeID}")
    int deleteBookTypeByID(int bookTypeID);
}
