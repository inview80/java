package passwordManage.model;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

@Slf4j
public class DaoTest {

    @Test
    public void formatXml() {
        Database db = new Database();
        db.setValidateString("kdjfsdjfl");
        db.getUsers().add(new User("ji", "11111", "2222", "163.com"));
        Dao dao = new Dao("data");
        var tmp = dao.serializableToBytes(db);
        log.info("{}", tmp);

        Database d1 = null;
        try {
            d1 = dao.serializableToObject(tmp);
        } catch (IOException e) {
            log.error(e.getMessage());
        }
        log.info("{}", d1);
        log.info("{}", d1.getUsers());
    }

    @Test
    public void secretToFile() {
        Database db = new Database();
        db.setValidateString("kdjfsdjfl");
        db.getUsers().add(new User("ji", "11111", "2222", "163.com"));
        Dao dao = new Dao("data");
        boolean b;
        log.info("{}",b= dao.secretToFile(db, "aaaa", "123456"));
        log.info("{}",b= dao.secretToFile(db, "bcs", "123456"));
        Assert.assertTrue(b);
    }

    @Test
    public void secretFromFile() {
        File file = new File("data.dat");
        if(!file.exists()){
            log.error("数据文件:dd.dat不存在");
            throw new RuntimeException("数据文件:data.dat不存在");
        }
        Dao dao = new Dao("data");
        Database db = null;
        try {
            db = dao.secretFromFile("bcs", "123456");
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        Assert.assertNotNull(db);
        Assert.assertNotNull(db.getValidateString());
        if (db.getValidateString().isBlank()) {
            log.info("解压失败");
        } else {
            log.info("{}", db);
        }
    }

}