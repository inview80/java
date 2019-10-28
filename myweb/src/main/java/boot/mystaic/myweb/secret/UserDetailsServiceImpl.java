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

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserService userService=null;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userService.getUserByName(s);
        var authorityList=new ArrayList<GrantedAuthority>();
          authorityList.add(  new SimpleGrantedAuthority(user.getPowerDetails().getName()));

        UserDetails userDetails=new org.springframework.security.core.userdetails.User(user.getUserName(),user.getPassword(),authorityList);
        return  userDetails;
    }
}
