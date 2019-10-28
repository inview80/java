package boot.mystaic.myweb;

import boot.mystaic.myweb.mapper.BookTypeMapper;
import boot.mystaic.myweb.secret.PowerEnum;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

@SpringBootApplication
@MapperScan(basePackageClasses = {BookTypeMapper.class})
public class MywebApplication extends WebSecurityConfigurerAdapter {
    @Value("${system.user.password.secret}")
    private String secret = null;
    @Autowired
    private UserDetailsService userDetailsService = null;

    public static void main(String[] args) {
        SpringApplication.run(MywebApplication.class, args);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        var pwdEncoder = new Pbkdf2PasswordEncoder(secret);
        auth.userDetailsService(userDetailsService).passwordEncoder(pwdEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/user/**")
                .hasAnyRole(PowerEnum.ADMINISTER.toString(), PowerEnum.EMPLOYEE.toString())
                .antMatchers("/book/**")
                .hasAnyRole(PowerEnum.GENERAL.toString())
                .and().anonymous()
                .and().formLogin()
                .and().httpBasic();
    }
}
