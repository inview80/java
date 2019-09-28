package passwordManage.secret;

import lombok.extern.slf4j.Slf4j;
import passwordManage.MyInterface.Des3Abstract;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * 3DES加密解密方式
 *
 * @author inview
 * @date 2019/9/20
 */
@Slf4j
public class Des3 extends Des3Abstract {
    private static Des3 instance;
    private Des3() {    }

    public static Des3 getInstance() {
        if(instance==null){
            instance=new Des3();
        }
        return instance;
    }

    @Override
    public byte[] encrypt(byte[] content, String key) {
        try {
            // 使用密钥初始化
            Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);
            // 创建密码器
            cipher.init(Cipher.ENCRYPT_MODE, getSecretKey(key));
            // 初始化为加密模式的密码器,,加密
            byte[] result = cipher.doFinal(content);
            return result;
        } catch (Exception ex) {
            log.error(ex.getLocalizedMessage());
        }
        log.error("加密错误，无数据输出");
        return new byte[0];
    }

    @Override
    public byte[] decrypt(byte[] content, String key) {
        try {
            // 实例化
            // 使用密钥初始化，设置为解密模式
            Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);
            // 执行操作
            cipher.init(Cipher.DECRYPT_MODE, getSecretKey(key));
            byte[] result = cipher.doFinal(content);
            return result;
        } catch (Exception ex) {
            log.error(ex.getLocalizedMessage());
        }
        log.error("解密错误，无数据输出");
        return new byte[0];
    }

    /**
     * 生成加密秘钥
     *
     * @return
     */
    private SecretKeySpec getSecretKey(final String key) {
        //返回生成指定算法密钥生成器的KeyGenerator 对象
        KeyGenerator kg = null;
        try {
            kg = KeyGenerator.getInstance(KEY_ALGORITHM);
            //生成一个128位的随机源,根据传入的字节数组
            SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
            secureRandom.setSeed(key.getBytes());
            kg.init(168, secureRandom);
            //生成一个密钥
            SecretKey secretKey = kg.generateKey();
            return new SecretKeySpec(secretKey.getEncoded(), KEY_ALGORITHM);
            // 转换为DESede专用密钥
        } catch (NoSuchAlgorithmException ex) {
            log.error(ex.getLocalizedMessage());
        }
        log.error("生成密钥错误！");
        return null;
    }
}
