package reflection;

public class TestUtils {
    public static void main(String[] args) throws IllegalAccessException {
        PersonPO personPO =new PersonPO();
        PersonVO personVO =new PersonVO();

        personPO.setName("朱少鹏");
        personPO.setAge(23);

        BeanUtils.convertor(personPO,personVO);
        System.out.println(personVO);
    }
}
