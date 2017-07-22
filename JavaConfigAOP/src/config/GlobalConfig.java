package config;

import beans.Audience;
import concert.MusicPerformance;
import concert.Performance;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by twx on 2017/5/9.
 */
@Configuration  //这个bean相当于一个beans.xml
@EnableAspectJAutoProxy  //启用AspectJ
public class GlobalConfig {

    @Bean
    public Performance getMusic() {
        return new MusicPerformance();
    }

    @Bean
    public Audience getAudience() {
        return new Audience();
    }

}
