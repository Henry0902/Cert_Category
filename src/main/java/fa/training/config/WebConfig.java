package fa.training.config;

import fa.training.interceptors.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.charset.StandardCharsets;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Bean
    MessageSource messageSource(){
        ReloadableResourceBundleMessageSource source = new ReloadableResourceBundleMessageSource();
        source.setDefaultEncoding(StandardCharsets.UTF_8.name());
        source.setBasename("classpath:/i18n/message");
        return source;
    }

    @Autowired
    LoginInterceptor interceptor;
@Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(interceptor)
                .addPathPatterns("/profile", "/admin/**")
                .excludePathPatterns("/admin/dashboard");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/css/**", "/js/**")
                .addResourceLocations("classpath:/assets/css/", "classpath:/assets/js/");
    }

//    @Bean("dataSource")
//    public DriverManagerDataSource dataSource(){
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName("com.mir.....");
//        dataSource.setUrl("....");
//        dataSource.setUsername();
//        dataSource.setPassword();
//    }
}
