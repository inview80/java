package passwordManage.secret;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import passwordManage.MyInterface.Aes256Abstract;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author inview
 * @date 2019/9/21
 * 用于将字节数组用AES256加密、解密
 */
@Slf4j
public class AesUtils extends Aes256Abstract {
    private static AesUtils fragment;

    private AesUtils() {
        super();
    }

    private AesUtils(String IV) {
        super(IV.getBytes());
    }

    public static AesUtils newInstance() {
        if (fragment == null) {
            fragment = new AesUtils();
        }
        return fragment;
    }

    public static AesUtils newInstance(@NonNull String IV) {
        if (fragment == null) {
            if (IV.isBlank()) {
                fragment = new AesUtils();
            } else {
                fragment = new AesUtils(IV);
            }
        }
        return fragment;
    }

    /**
     * 加密 256位
     *
     * @param content 需要加密的原内容
     * @param pkey    密匙
     */
    @Override
    public byte[] encrypt(@NonNull byte[] content, @NonNull byte[] pkey) {
        try {
            SecretKeySpec skey = new SecretKeySpec(tohash256Deal(pkey), "AES");
            // "算法/加密/填充"
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
            IvParameterSpec iv = new IvParameterSpec(IV);
            //初始化加密器
            cipher.init(Cipher.ENCRYPT_MODE, skey, iv);
            // 加密
            byte[] encrypted = cipher.doFinal(content);
            return encrypted;
        } catch (Exception e) {
            log.info("encrypt() method error:", e);
        }
        return new byte[0];
    }


    /**
     * 解密 256位
     *
     * @param content 解密前的byte数组
     * @param pkey    密匙
     * @return result  解密后的byte数组
     * @throws Exception
     * @Description: 解密 失败将返回NULL
     */
    @Override
    public byte[] decode(@NonNull byte[] content, @NonNull byte[] pkey) throws Exception {
        SecretKeySpec skey = new SecretKeySpec(tohash256Deal(pkey), "AES");
        IvParameterSpec iv = new IvParameterSpec(IV);
        // 创建密码器
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
        // 初始化解密器
        cipher.init(Cipher.DECRYPT_MODE, skey, iv);
        byte[] result = new byte[0];
        try {
            result = cipher.doFinal(content);
        } catch (IllegalBlockSizeException | BadPaddingException e) {
            log.error("AES解密异常", e.getMessage());
            throw new Exception("解密异常");
        }
        return result;
    }

    private byte[] tohash256Deal(@NonNull byte[] keyBytes) {
        try {
            MessageDigest digester = MessageDigest.getInstance("SHA-256");
            digester.update(keyBytes);
            byte[] hex = digester.digest();
            return hex;
        } catch (NoSuchAlgorithmException e) {
            log.error(e.getLocalizedMessage());
        }
        return new byte[0];
    }
}
