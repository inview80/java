package boot.mystaic.myweb.secret;

import boot.mystaic.myweb.pojo.User;
import boot.mystaic.myweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserService userService=null;

    /**
     * 从数据库中读取用户名及密码、权限，存入到UserDetails类中
     * @param s 用户名
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user=Optional.ofNullable(userService.getUserByName(s)).orElseThrow(()->new UsernameNotFoundException("没有此用户名！"));
        var authorityList=new ArrayList<GrantedAuthority>();
            authorityList.add(  new SimpleGrantedAuthority(user.getPowerDetails().toString()));

        UserDetails userDetails=new org.springframework.security.core.userdetails.User(user.getUserName(),user.getPassword(),authorityList);
        return  userDetails;
    }
}
