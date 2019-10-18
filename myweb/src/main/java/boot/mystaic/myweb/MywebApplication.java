package boot.mystaic.myweb;

import boot.mystaic.myweb.mapper.BookMapper;
import boot.mystaic.myweb.mapper.BookTypeMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@SpringBootApplication
@MapperScan(basePackageClasses = {BookTypeMapper.class})
public class MywebApplication  {
    public static void main(String[] args) {
        SpringApplication.run(MywebApplication.class, args);
    }
}
