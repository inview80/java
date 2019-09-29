package passwordManage.MyInterface;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.util.Arrays;

/**
 * @author inview
 * @date 2019/9/21
 * 用于将字节数组用AES256加密、解密
 */
@Slf4j
public abstract class Aes256Abstract {
    /***默认向量常量**/
    protected byte[] IV;


    public Aes256Abstract(byte[] IV) {
        this.IV =tohash256Deal(IV) ;
        // 使用PKCS7Padding填充必须添加一个支持PKCS7Padding的Provider
        // 类加载的时候就判断是否已经有支持256位的Provider,如果没有则添加进去
        if (Security.getProvider(BouncyCastleProvider.PROVIDER_NAME) == null) {
            Security.addProvider(new BouncyCastleProvider());
        }
    }

    public Aes256Abstract() {
        this("1234567890123456".getBytes());
    }

    public abstract  byte[] encrypt(byte[] content, byte[] pkey);
    public abstract byte[] decode(byte[] content, byte[] pkey)throws Exception;

    private  byte[] tohash256Deal(@NonNull byte[] keyBytes) {
        try {
            MessageDigest digester = MessageDigest.getInstance("SHA-256");
            digester.update(keyBytes);
            byte[] hex = digester.digest();
            byte[] result = Arrays.copyOf(hex, 16);
            return result;
        } catch (NoSuchAlgorithmException e) {
            log.error(e.getLocalizedMessage());
        }
        return "1234567890123456".getBytes();
    }
}
