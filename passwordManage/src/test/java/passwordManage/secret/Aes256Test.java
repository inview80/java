package passwordManage.secret;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

@Slf4j
public class Aes256Test {

    @Test
    public void encrypt() {
        String ss = "123456";
        String pwd="1111111111";
        byte[] t1 = AesUtils.newInstance().encrypt(ss.getBytes(), pwd.getBytes());
        log.info("{}", t1);
        byte[] t2 = new byte[0];
        try {
            t2 = AesUtils.newInstance().decode(t1, pwd.getBytes());
        } catch (Exception e) {
            log.error(e.getLocalizedMessage());
        }
        log.info("{}",new String(t2));
        Assert.assertEquals(ss,new String(t2));
    }
}