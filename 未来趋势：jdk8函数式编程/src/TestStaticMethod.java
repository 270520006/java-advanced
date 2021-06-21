import java.util.function.Function;

public class TestStaticMethod {
    public String name;
    public TestStaticMethod(String name) {
        this.name = name;
        System.out.println("有参构造初始化了TestStaticMethod");
    }


    public TestStaticMethod() {
        System.out.println("无参构造初始化了TestStaticMethod");
    }

    public static String testMethod(Integer i){
        return String.valueOf(i);
    }
}
