package boot.mystaic.myweb.pojo;

import boot.mystaic.myweb.secret.PowerEnum;
import lombok.Data;

import java.util.Date;

@Data
public class User {
    private String userCode;
    private String userName;
    private String password;
    private PowerEnum powerDetails;
    private Date createDate;
}
