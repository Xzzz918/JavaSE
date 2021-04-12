package functional;

/**
 * @author gemini
 * Created in  2021/4/12 10:50
 * 方法引用与 Runnable 接口的结合使用
 */

class Go { static void go() { System.out.println("Go::go()"); }}

public class RunnableMethodReference {
    public static void main(String[] args) {
        //只有匿名内部类才要求显式声明 run() 方法
        new Thread(new Runnable() {public void run() { System.out.println("Anonymous"); }}).start();

        new Thread(() -> System.out.println("lambda")).start();
        //方法引用
        new Thread(Go::go).start();
    }
}

