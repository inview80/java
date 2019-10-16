package boot.mystaic.myweb.service;

import boot.mystaic.myweb.mapper.BookTypeMapper;
import boot.mystaic.myweb.pojo.BookType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookTypeService {
    @Autowired
    private BookTypeMapper bookTypeMapper;

    public List<BookType> getAll(){
        return bookTypeMapper.getAll();
    }

    public int add(BookType bt) {
        return bookTypeMapper.add(bt);
    }
}
