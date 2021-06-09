package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflectionTest {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class clazz = Class.forName("reflection.Person");  //方法1
//        Person person = new Person();  //方法2
//        Class clazz = person.getClass();
//        Class clazz = Person.class; //方法3
        Constructor constructor1 = clazz.getConstructor();
        Constructor constructor2 = clazz.getConstructor(String.class, int.class, int.class);
        Person person1 = (Person) constructor1.newInstance();
        Person person2 = (Person) constructor2.newInstance("zsp",1,23);
        person1.setName("zsp");
        System.out.println(person1);
        System.out.println(person2);
    }
}
