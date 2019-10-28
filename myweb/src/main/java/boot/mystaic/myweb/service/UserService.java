package boot.mystaic.myweb.service;

import boot.mystaic.myweb.mapper.UserMapper;
import boot.mystaic.myweb.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public User getUserById(String userID) {
        return userMapper.getUserById(userID);
    }

    public User getUserByName(String userName) {
        return userMapper.getUserByName(userName);
    }

    public boolean addUser(User user) {
        return userMapper.addUser(user);
    }
    public List<User> getAll(){
        var tmp=userMapper.getAll();
        log.info("{}",tmp);
        return tmp;
    }
}
