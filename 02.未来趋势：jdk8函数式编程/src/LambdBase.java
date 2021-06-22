import java.util.function.*;

public class LambdBase {



    private static Function<Integer,String> intString_1 =
            (Integer i)->{return String.valueOf(i);};
    private static Function<Integer,String> intString_2 =
            (Integer i)-> String.valueOf(i);
    private static Function<Integer,String> intString_3 =
            (i)-> String.valueOf(i);
    private static Function<Integer,String> intString_4 =
            i-> String.valueOf(i);
    private static BiFunction<Integer,Integer,Integer> sum=
            (a,b)->a+b;
    private static  Consumer consumer= System.out::print;
    private static Supplier<String> supplier =()->{return "I am zsp";};
    private static Consumer<String> consume=(String p)->{ System.out.println(p); };
    private static Predicate<String> predicate =(String str)->
    {if (str.equals("zsp")) return true; return false;};
    private static Runnable run = ()-> System.out.println("hello");
    private static UnaryOperator<Integer> unaryOperator
            =(a)->a;

    private static PSZ<Integer,Integer,Integer>
                   psz=()->123;
    private static Function<String,Integer> integerSupplier= (a)->Integer.valueOf(a);
    private static Supplier<Function<String,Integer>> getSecondS=()->integerSupplier;

    private static ZSP<BiFunction<Integer,Integer,Integer>,Supplier<Function<String,Integer>>,Supplier<Integer>,String>
            zsp= (a,b,c)->String.valueOf(a.apply(123,321)+b.get().apply("213")+c.get());
    //只要代码只有一行，可以有返回值，不会影响编译
    private static Consumer<Integer> integerConsumer= a->a++;
    private static Runnable runnable= ()->Integer.getInteger("123");
    public static void main(String[] args) {




//        Lambda表达式
//        System.out.println(supplier.get());
//        consume.accept("zsp");
//        System.out.println(predicate.test("zp"));
//        consume.accept("zsp");
//        System.out.println(sum.apply(200, 33));  //使用传入两个参数的function
        System.out.println(zsp.apply(sum,getSecondS,TestStaticMethod::getNum));
//        初始化静态方法
        Function<Integer,String> function= TestStaticMethod::testMethod;
//        初始化构造参数
        Function<String,TestStaticMethod> function1 =TestStaticMethod::new;
        Supplier<TestStaticMethod> supplier =TestStaticMethod::new;

//        TestStaticMethod zsp = function1.apply("zsp");
//        TestStaticMethod testStaticMethod = supplier.get();
          BiFunction<LambdBase,Integer,Integer> function2= LambdBase::getA;
          System.out.println(function2.apply(new LambdBase(), 1));
          Consumer<Consumer<String> > consumer= LambdBase::testConsumer2;
          testConsumer1(a-> System.out.println(a));
    }

    private static void  testConsumer1(Consumer<Integer> s){
        s.accept(123);
    }
    private static void  testConsumer2(Consumer<String> s){
        s.accept("abc");
    }
    private Integer getA(Integer a) {
    return a;
    }
}
