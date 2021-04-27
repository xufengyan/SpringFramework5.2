package test.observe;

/**
 * @author xf
 * @version 1.0
 * @date 2021/4/27 16:00
 */
public class observeObject {
    private boolean cry = false;

    private observe observe;

    public void dispost(){
        this.cry = true;
        observe.disposeMethod();
    }

    public void setObserve(test.observe.observe observe) {
        this.observe = observe;
    }
    public static void main(String[] args) {

        observe01 o = new observe01();
        observeObject object = new observeObject();
        object.setObserve(o);
        object.dispost();

    }

}
