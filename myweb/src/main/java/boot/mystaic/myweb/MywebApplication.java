package boot.mystaic.myweb;

import boot.mystaic.myweb.mapper.BookTypeMapper;
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
        http.csrf().disable().anonymous();
//        http.csrf().disable();
//        http.authorizeRequests()
//                //user只允许ADMINISTER访问
//                .antMatchers("/user/**")
//                .hasAuthority(PowerEnum.ADMINISTER.toString())
//                //booktype允许ADMINISTER、EMPLOYEE访问
//                .antMatchers("/booktype/**")
//                .hasAnyAuthority(PowerEnum.ADMINISTER.toString(),PowerEnum.EMPLOYEE.toString())
//                //book允许所有用户访问
//                .antMatchers("/book/**")
//                .hasAnyAuthority(PowerEnum.GENERAL.toString(),PowerEnum.ADMINISTER.toString(),PowerEnum.EMPLOYEE.toString())
//                .anyRequest().authenticated()
//                .and().formLogin()
//                //设置退出登录页面和默认跳转页面
//                .and().logout().logoutUrl("/logout").logoutSuccessUrl("/welcome")
//                .and().httpBasic();
    }
}
