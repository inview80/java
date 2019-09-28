package passwordManage.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author inview
 * @date 2019/9/20
 */
@Data @AllArgsConstructor@NoArgsConstructor
public class User implements Serializable {
    /**
     * 固定写法，值可以是任意的long型值
     * 显示指定class文件的版本id。显示指定后，此class文件的所有版本都使用此版本id，不再由JVM指定
     */
    private static final long serialVersionUID=512L;

    private String userName;
    private String password;
    private String item;
    private String ipAddress;
}
