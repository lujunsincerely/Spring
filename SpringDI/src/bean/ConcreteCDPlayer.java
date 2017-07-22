package bean;

import myinterface.CD;
import myinterface.CDPlayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by twx on 2017/5/8.
 */
//@Component
public class ConcreteCDPlayer implements CDPlayer {

    private CD cd;

    @Autowired
    public ConcreteCDPlayer(CD cd) {
        this.cd = cd;
    }

    @Override
    public void play() {
        System.out.println("it is playing "+cd.getPublishYear());
    }
}
