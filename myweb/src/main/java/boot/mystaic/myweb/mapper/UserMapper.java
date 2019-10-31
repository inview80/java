package boot.mystaic.myweb.mapper;

import boot.mystaic.myweb.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Mapper
public interface UserMapper {
    @Select("select UserCode ,UserName,Password,PermissionID as powerDetails,CreateDate from user where UserCode=#{userID}")
    User getUserById(String userID);

    @Select("select UserCode ,UserName,Password,PermissionID as powerDetails,CreateDate from user where userName =#{userName}")
    User getUserByName(String userName);

    @Select("insert  into user(usercode, username, password, permissionid, createdate) values (#{userCode},#{userName},#{password},#{powerDetails},#{createDate})")
    boolean addUser(User user);

    @Select("select UserCode ,UserName,Password,PermissionID as powerDetails,CreateDate from user")
    List<User> getAll();
}
