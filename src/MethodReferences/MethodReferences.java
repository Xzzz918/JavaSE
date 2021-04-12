package MethodReferences;

import lambda.Call;

/**
 * @author gemini
 * Created in  2021/4/12 10:32
 * Lambda表达式应用于方法引用
 */
interface Callable {
    void call(String s);
}

class Describe {
    //show() 的参数类型和返回类型符合 Callable 的 call() 的参数类型和返回类型。
    void show(String msg) {
        System.out.println(msg);
    }
}

public class MethodReferences {
    //hello() 也符合 call() 的参数类型和返回类型。
    static void hello(String name) {
        System.out.println("Hello, " + name);
    }

    static class Description {
        String about;

        public Description(String about) {
            this.about = about;
        }

        //help() 也符合，它是静态内部类中的非静态方法。
        void help(String msg) {
            System.out.println(about + " " + msg);
        }
    }

    static class Helper {
        // assist() 是静态内部类中的静态方法
        static void assist(String msg) {
            System.out.println(msg);
        }
    }

    public static void main(String[] args) {
        //非静态方法引用
        Callable c = new Describe()::show;
        c.call("call()");
        //静态方法引用
        c = MethodReferences::hello;
        c.call("Bob");
        //静态内部类中的非静态方法引用
        c = new Description("valuable")::help;
        c.call("info");
        //静态内部类中的静态方法引用
        c = Helper::assist;
        c.call("Help!");
    }
}
/*
* outputs:
* call()
Hello, Bob
valuable info
Help!*/