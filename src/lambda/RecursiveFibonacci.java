package lambda;

/**
 * @author gemini
 * Created in  2021/4/12 10:23
 */
public class RecursiveFibonacci {
    //也可以设置为实例变量
    Call fib;
    //将递推过程置于构造器中
    RecursiveFibonacci() {
        fib = n -> n == 0 ? 0 :
                n == 1 ? 1 :
                        fib.call(n - 1) + fib.call(n - 2);
    }
    //设置一方法包装Call(int)方法
    int fibonacci(int i){
        return fib.call(i);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(new RecursiveFibonacci().fibonacci(i));
        }
    }
}
