package passwordManage.MyInterface;

import lombok.NonNull;
import passwordManage.model.Database;

/**
 * 将对象序列化并加密，保存至文件，或从文件中读取对象
 *
 * @author inview
 * @date 2019/9/22
 */
public interface ISerializableForFile {
    /**
     * 将Database类序列化并加密后保存至文件
     *
     * @param datas    Database类的实例
     * @param userName 用户名
     * @param pwd      密码
     */
    boolean secretToFile(@NonNull Database datas, @NonNull String userName,
                         @NonNull String pwd);

    /**
     * 从文件中读取数据，解密后反序列化，转化为Database类的实例
     *
     * @param userName 用户名
     * @param pwd      用户密码
     * @return Database类的实例
     */
    Database secretFromFile(@NonNull String userName, @NonNull String pwd) throws Exception;
}
