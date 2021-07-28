import java.util.ArrayList;
import java.util.Optional;

public class ReduceDemo {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);list.add(2);list.add(3);list.add(4);list.add(5);list.add(6);
        Integer integer = list.stream().reduce((a, b) -> a + b).get();
        System.out.println(integer);
    }
}
