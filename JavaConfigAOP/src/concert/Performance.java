package concert;

/**
 * Created by twx on 2017/5/9.
 */
public interface Performance {
    /**
     * 在执行这个方法前后，会先后执行 切面里 定义的方法
     */
    void perform();
}
