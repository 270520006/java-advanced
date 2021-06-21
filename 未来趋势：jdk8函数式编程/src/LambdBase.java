import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LambdBase {



    private static Function<Integer,String> intString_1 =
            (Integer i)->{return String.valueOf(i);};
    private static Function<Integer,String> intString_2 =
            (Integer i)-> String.valueOf(i);
    private static Function<Integer,String> intString_3 =
            (i)-> String.valueOf(i);
    private static Function<Integer,String> intString_4 =
            i-> String.valueOf(i);

    private static Supplier<String> supplier =()->{return "I am zsp";};
    private static Consumer<String> consume=(String p)->{ System.out.println(p); };
    private static Predicate<String> predicate =(String str)->
    {if (str.equals("zsp")) return true; return false;};
    private static Runnable run = ()-> System.out.println("hello");

    public static void main(String[] args) {
//        Lambda表达式
//        System.out.println(supplier.get());
//        consume.accept("zsp");
//        System.out.println(predicate.test("zp"));
//        初始化静态方法
        Function<Integer,String> function= TestStaticMethod::testMethod;
//        初始化构造参数
        Function<String,TestStaticMethod> function1 =TestStaticMethod::new;
        Supplier<TestStaticMethod> supplier =TestStaticMethod::new;
//        TestStaticMethod zsp = function1.apply("zsp");
//        TestStaticMethod testStaticMethod = supplier.get();

    }
    public void getTest(){
        Supplier<Integer> supplier1 =this::getA;
    }

    private Integer getA() {
    return 123;
    }
}
