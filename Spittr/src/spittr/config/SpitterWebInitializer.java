package spittr.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * 扩展了AbstractAnnotationConfigDispatcherServletInitializer的类会自动配置DispatcherServlet和Spring应用上下文
 * @author c00284934
 *
 */
public class SpitterWebInitializer extends
        AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     * 返回带有@Configuration注解的类将会用来配置ContextLoaderListener创建的应用上下文中的bean
     * ContextLoaderListener加载的bean通常是驱动应用后端的中间层和数据层组件
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{RootConfig.class};
    }

    /**
     * 带有@Configuration注解的类会用来定义为DispatcherServlet应用上下文中的bean
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        /**
         * 当DispatcherServlet启动的时候，它会创建Spring应用上下文，并加载配置文件中所声明的bean
         */
        return new Class<?>[]{WebConfig.class};//指定配置类
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};//将DispatcherServlet映射到“/”
    }

}