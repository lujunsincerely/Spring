package bean;

import myinterface.CD;
import myinterface.CDPlayer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created by twx on 2017/5/8.
 */
//@Component
public class Popular implements CD {
    private  String name;
    private String type;

    public Popular() {
    }

    public Popular(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    @Override
    public int getPublishYear() {
        return 2002;
    }
}
