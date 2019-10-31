package boot.mystaic.myweb.service;

import boot.mystaic.myweb.mapper.BookTypeMapper;
import boot.mystaic.myweb.pojo.BookType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookTypeService implements BookTypeMapper{
    @Autowired
    private BookTypeMapper bookTypeMapper;

    public List<BookType> getAll(){
        return bookTypeMapper.getAll();
    }

    public int add(String bt) {
        return bookTypeMapper.add(bt);
    }

    @Override
    public int deleteBookTypeByID(int bookTypeID) {
        return bookTypeMapper.deleteBookTypeByID(bookTypeID);
    }
}
