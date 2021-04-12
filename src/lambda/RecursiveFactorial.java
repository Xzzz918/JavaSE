package lambda;

/**
 * @author gemini
 * Created in  2021/4/12 10:14
 */
//常规编程实现
class RecursiveFactorial1{
    static Call result = new Call(){
        @Override
        public int call(int n) {
            return n == 0 ? 1:n* call(n - 1);
        }
    };

    public static void main(String[] args) {
        for (int i = 0; i < 11; i++) {
            System.out.println(result.call(i));
        }
    }
}
//函数式编程
public class RecursiveFactorial {
    //此处fact是静态变量，否则在main函数里将不能通过上下文引用
    static Call fact;

    public static void main(String[] args) {
        fact = n -> n == 0 ? 1:n* fact.call(n - 1);
        for (int i = 0; i < 11; i++) {
            System.out.println((fact.call(i)));
        }
    }
}
