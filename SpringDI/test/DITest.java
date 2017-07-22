import bean.Popular;
import config.BeanConfig;
import myinterface.CD;
import myinterface.CDPlayer;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by twx on 2017/5/8.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = BeanConfig.class)
public class DITest {

//    @Autowired
//    public CD cd;

    @Autowired
    public CDPlayer cdPlayer;

    @Test
    public void testNotNull(){
        assertNotNull(cdPlayer);
        cdPlayer.play();
    }

//    @Test
//    public void testJavaConfig() {
//        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
//        CDPlayer cdPlayer = context.getBean("getPopular", CDPlayer.class);
//        cdPlayer.play();
//    }

}
