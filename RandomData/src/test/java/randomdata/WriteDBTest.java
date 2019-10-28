package randomdata;

import org.junit.Test;

import static org.junit.Assert.*;

public class WriteDBTest {
    @Test
public void publish(){
        var db=new WriteDB();
        db.publishingHouse();
    }

    @Test
    public void booktype(){
        new WriteDB().bookType();
    }
}