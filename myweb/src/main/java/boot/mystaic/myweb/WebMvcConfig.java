package boot.mystaic.myweb;

import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * 配置类，启动的时候加上静态文件
 * @author BurgessLee *
 * @ClassName: WebMvcConfig
 * @Description: TODO
 * @date 2019年10月31日
 */
//@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {
    //这里配置静态资源文件的路径导包都是默认的直接导入就可以

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX + "/static/");
        super.addResourceHandlers(registry);
    }
}
