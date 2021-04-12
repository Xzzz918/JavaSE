package functional;

/**
 * @author gemini
 * Created in  2021/4/12 10:56
 * 未绑定的方法引用是指没有关联对象的普通（非静态）方法。
 */
class X {
    String f() { return "X::f()"; }
}

interface MakeString {
    String make();
}

interface TransformX {
    //要解决这个问题，我们需要一个 X 对象，因此我们的接口实际上需要一个额外的参数
    String transform(X x);
}

public class UnboundMethodReference {
    public static void main(String[] args) {
        //MakeString ms = X::f;
        TransformX sp = X::f;
        X x = new X();
        System.out.println(sp.transform(x)); // [2]
        System.out.println(x.f()); // 同等效果
    }
}
