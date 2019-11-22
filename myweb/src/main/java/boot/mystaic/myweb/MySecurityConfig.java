package boot.mystaic.myweb;

import boot.mystaic.myweb.secret.PowerEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
    @Value("${system.user.password.secret}")
    private String secret = null;
    @Autowired
    private UserDetailsService userDetailsService = null;

    /**
     * 设置加密规则为Pbkdf2PasswordEncoder
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        var pwdEncoder = new Pbkdf2PasswordEncoder(secret);
        auth.userDetailsService(userDetailsService).passwordEncoder(pwdEncoder);
    }

    /**
     * 定制请求的授权规则
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable().anonymous();
        http .formLogin().loginPage("/login")
                .and().authorizeRequests()
//        http.authorizeRequests()
//                user只允许ADMINISTER访问
                .antMatchers("/user/**")
                .hasAuthority(PowerEnum.ADMINISTER.toString())
                .anyRequest().anonymous()
//                //booktype允许ADMINISTER、EMPLOYEE访问
//                .antMatchers("/booktype/**")
//                .hasAnyAuthority(PowerEnum.ADMINISTER.toString(),PowerEnum.EMPLOYEE.toString())
//                //book允许所有用户访问
//                .antMatchers("/book/**")
//                .hasAnyAuthority(PowerEnum.GENERAL.toString(),PowerEnum.ADMINISTER.toString(),PowerEnum.EMPLOYEE.toString())
//                .anyRequest().authenticated()
        // 1.1自定义登录的页面，loginPage("/login")：post提交 ->处理登录；get提交 ->跳转到登录界面
        // 1.2一点修改默认规则，loginPage("/userlogin")。则 /userlogin post提交 ->处理登录；get提交 ->跳转到登录界面
//                .and().formLogin().usernameParameter("name").passwordParameter("password").loginPage("/userlogin");
                //设置退出登录页面和默认跳转页面
//                .and().logout().logoutUrl("/logout").logoutSuccessUrl("/welcome")
//                .and().httpBasic()
                .and().csrf().disable();
        // 3.开启记住我功能
        http.rememberMe().rememberMeParameter("remember");
    }
}
