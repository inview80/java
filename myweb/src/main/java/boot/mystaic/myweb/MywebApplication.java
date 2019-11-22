package boot.mystaic.myweb;

import boot.mystaic.myweb.mapper.BookTypeMapper;
import boot.mystaic.myweb.verify.VerifyServlet;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@MapperScan(basePackageClasses = {BookTypeMapper.class})
public class MywebApplication {
    public static void main(String[] args) {
        SpringApplication.run(MywebApplication.class, args);
    }

    /**
     * 注入验证码servlet
     */
    @Bean
    public ServletRegistrationBean<VerifyServlet> indexServletRegistration() {
        ServletRegistrationBean<VerifyServlet> registration = new ServletRegistrationBean<>(new VerifyServlet());
        registration.addUrlMappings("/getVerifyCode");
        return registration;
    }
}
