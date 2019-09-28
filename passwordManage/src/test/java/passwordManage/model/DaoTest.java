package passwordManage.model;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class DaoTest {

    @Test
    public void formatXml() {
        Database db=new Database();
        db.setValidateString("kdjfsdjfl");
        db.getUsers().add(new User("ji", "11111", "2222", "163.com"));
        Dao dao=new Dao("dd");
        var tmp = dao.serializableToBytes(db);
        log.info("{}",tmp);

        var d1 = dao.serializableToObject(tmp);
        log.info("{}", d1);
        log.info("{}",d1.getUsers());
    }
}