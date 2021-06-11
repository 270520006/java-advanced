package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class GetPrivateFieldTest {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        //获得class对象
        Class personClass=Person.class;
        //获取构造器
        Constructor constructor = personClass.getConstructor();
        //获取类
        Person person = (Person) constructor.newInstance();
        //获得filed对象， Person[类]的name属性
        Field genderFild = personClass.getDeclaredField("gender");
        //允许访问private属性
        genderFild.setAccessible(true);
        //通过filed获取对应对象里的属性值
        System.out.println(genderFild.get(person));
    }
}
