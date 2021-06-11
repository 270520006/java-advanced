package reflection;


import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class GetFieldTest {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException {
        //获得class对象
        Class personClass=Person.class;
        //获取构造器
        Constructor constructor = personClass.getConstructor();
        //获取类
        Person person = (Person) constructor.newInstance();
        //获得filed对象， Person[类]的name属性
        //Field nameFild = personClass.getField("name");
        //这两个方法都可以，但推荐第二个，因为第一个如果不是public就报空指针
        Field nameFild = personClass.getDeclaredField("name");
        //通过filed获取对应对象里的属性值
        System.out.println(nameFild.get(person));
    }
}
