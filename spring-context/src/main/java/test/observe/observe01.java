package test.observe;

/**
 * @author xf
 * @version 1.0
 * @date 2021/4/27 15:57
 */
public class observe01 implements observe{
    @Override
    public void disposeMethod() {
        System.out.println("observe01--------我观察到了执行方法，我要去执行了----------");
    }
}
