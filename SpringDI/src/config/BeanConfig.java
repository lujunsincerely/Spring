package config;

import bean.ConcreteCDPlayer;
import bean.Popular;
import myinterface.CD;
import myinterface.CDPlayer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by twx on 2017/5/8.
 */
@Configuration
//@ComponentScan("bean")
public class BeanConfig {

    @Bean
    public CD getPopular() {
        return new Popular("JayChou", "Hipup");
    }

    @Bean
    public CDPlayer getCDPlayer(CD cd) {
        return new ConcreteCDPlayer(cd);
    }
}
