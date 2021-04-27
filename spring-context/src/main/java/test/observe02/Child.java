package test.observe02;
import java.util.ArrayList;
import java.util.List;

/**
 * 事件本身也可以形成继承体系
 */
public class Child {
    private boolean type = false;
    List<Observe> observes = new ArrayList<>();
    {
        observes.add(new Mam());
        observes.add(new Dad());

    }
    public void regain(String nameEvent){
        type = true;
        WorkEvent workEvent = new WorkEvent(nameEvent,"在床底下",this);
        for (Observe observe : observes) {
            observe.ObserveEvent(workEvent);
        }
    }
    public static void main(String[] args) {
        Child child = new Child();
        child.regain("大哭");
        System.out.println(child);
    }
}

/**
 * 源事件继承体，通过实现该类来返回源事件-----被观察的事件
 * @param <T>
 */
abstract class Event<T>{
   abstract T getSource(T t);
}



class WorkEvent extends Event{
    String name;
    String loc;
    Child source;
    public WorkEvent(String name,String loc,Child source){
        this.name= name;
        this.loc = loc;
        //事件源对象----被观察者
        this.source = source;
        System.out.println(source);
    }

    @Override
    Object getSource(Object o) {
        return source;
    }
}


class Mam implements Observe{

    @Override
    public void ObserveEvent(WorkEvent workEvent) {
        if ("大哭".equals(workEvent.name)){
            System.out.println("那 我 把 他 放 床 上");
        }else {
            return;
        }
    }
}

class Dad implements Observe{
    @Override
    public void ObserveEvent(WorkEvent workEvent) {
        if ("小哭".equals(workEvent.name)){
            System.out.println("直 接 丢 掉");
        }else {
            return;
        }
    }
}


interface Observe {
    public void ObserveEvent(WorkEvent workEvent);
}