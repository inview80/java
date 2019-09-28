package passwordManage.MyInterface;

/**
 * 3DES加密解密方式
 *
 * @author inview
 * @date 2019/9/20
 */
public abstract class Des3Abstract {
    protected final String KEY_ALGORITHM = "DESede";
    /**
     * 默认的加密算法
     */
    protected final String DEFAULT_CIPHER_ALGORITHM = "DESede/ECB/PKCS5Padding";

    /**
     * DESede 加密操作
     *
     * @param content 待加密内容
     * @param key     加密密钥
     * @return 返回Base64转码后的加密数据
     */
    public abstract byte[] encrypt(byte[] content, String key);

    /**
     * DESede 解密操作
     *
     * @param content
     * @param key
     * @return
     */
    public abstract byte[] decrypt(byte[] content, String key);
}
