package passwordManage.model;

import lombok.Data;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author inview
 * @date 2019/9/20
 */
@Data
public class Database implements Externalizable {
    /**
     * 固定写法，值可以是任意的long型值
     * 显示指定class文件的版本id。显示指定后，此class文件的所有版本都使用此版本id，不再由JVM指定
     */
    private static final long serialVersionUID = 512L;
    private String validateString;
    private List<User> users = new ArrayList<>();

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(validateString);
        User[] us = new User[users.size()];
        us = users.toArray(us);
        out.writeObject(us);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.validateString = String.valueOf(in.readObject());
        User[] us = (User[]) in.readObject();
        users = Arrays.asList(us);
    }
}
