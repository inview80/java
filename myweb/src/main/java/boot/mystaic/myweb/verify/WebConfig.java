package boot.mystaic.myweb.verify;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("page/login");
        registry.addViewController("/logout").setViewName("page/logout");
        registry.addViewController("/logout/page").setViewName("page/welcome");
        registry.addViewController("/login/error").setViewName("page/error");
    }
}
