package passwordManage.MyInterface;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.security.Security;

/**
 * @author inview
 * @date 2019/9/21
 * 用于将字节数组用AES256加密、解密
 */
public abstract class Aes256Abstract {
    /***默认向量常量**/
    protected String IV;


    public Aes256Abstract(String IV) {
        this.IV = IV;
        // 使用PKCS7Padding填充必须添加一个支持PKCS7Padding的Provider
        // 类加载的时候就判断是否已经有支持256位的Provider,如果没有则添加进去
        if (Security.getProvider(BouncyCastleProvider.PROVIDER_NAME) == null) {
            Security.addProvider(new BouncyCastleProvider());
        }
    }

    public Aes256Abstract() {
        this("1234567890123456");
    }

    public abstract  byte[] encrypt(byte[] content, byte[] pkey);
    public abstract byte[] decode(byte[] content, byte[] pkey)throws Exception;
}
