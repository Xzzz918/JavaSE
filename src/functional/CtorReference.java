package functional;

/**
 * @author gemini
 * Created in  2021/4/12 11:07
 * 你还可以捕获构造函数的引用，然后通过引用调用该构造函数。
 */
class Dog {
    String name;
    int age = -1; // For "unknown"
    Dog() { name = "stray"; }
    Dog(String nm) { name = nm; }
    Dog(String nm, int yrs) { name = nm; age = yrs; }
}

interface MakeNoArgs {
    Dog make();
}

interface Make1Arg {
    Dog make(String nm);
}

interface Make2Args {
    Dog make(String nm, int age);
}

public class CtorReference {
    public static void main(String[] args) {
        //这三个构造函数只有一个相同名称：new
        //但在每种情况下赋值给不同的接口，编译器可以从中知道具体使用哪个构造函数。
        MakeNoArgs mna = Dog::new;
        Make1Arg m1a = Dog::new;
        Make2Args m2a = Dog::new;
        //编译器知道调用函数式方法（本例中为 make()）就相当于调用构造函数
        Dog dn = mna.make();
        Dog d1 = m1a.make("Comet");
        Dog d2 = m2a.make("Ralph", 4);
    }
}
