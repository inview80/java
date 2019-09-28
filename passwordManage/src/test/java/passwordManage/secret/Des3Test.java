package passwordManage.secret;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import java.io.UnsupportedEncodingException;

@Slf4j
public class Des3Test {

    @Test
    public void encrypt() {
        String string = "1111111";
        byte[] bytes = new byte[0];
        try {
            bytes = Des3.getInstance().encrypt(string.getBytes("UTF-8"), "123");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        log.info("{}", bytes);
        var bs2 = Des3.getInstance().decrypt(bytes, "1234");
        log.info("{}",new String(bs2));
        Assert.assertEquals(string, new String(bs2));
    }

}