package boot.mystaic.myweb.mapper;

import boot.mystaic.myweb.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserMapper {
    User getUserById(String userID);

    User getUserByName(String userName);

    boolean addUser(User user);

    List<User> getAll();
}
