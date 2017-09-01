package spittr.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * 该配置在《spring action第4版》141页
 */
@Configuration
@EnableWebMvc    //启用SpringMVC 等同于 <mvc:annotation-driven />
@ComponentScan("spittr.web")   //启用组件扫描 等同于 <context:component-scan base-package="" />
public class WebConfig extends WebMvcConfigurerAdapter{

    public ViewResolver viewResolver(){
        InternalResourceViewResolver resolver = new InternalResourceViewResolver(); //配置jsp视图解析器
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        resolver.setExposeContextBeansAsAttributes(true);
        return resolver;
    }

    /**
     * 等同于 <mvc:default-servlet-handler />
     * @param configurer
     */
    @Override
    public void configureDefaultServletHandling(
            DefaultServletHandlerConfigurer configurer) { //配置静态资源的处理
        //我们要求DispatcherServlet将对静态资源的请求转发到Servlet容器中默认的Servlet上，而不是使用DispatcherServlet本身来处理此类请求
        configurer.enable();
    }

}
