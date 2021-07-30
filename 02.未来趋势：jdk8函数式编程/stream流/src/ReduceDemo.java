import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.stream.Stream;

public class ReduceDemo {
    public static void main(String[] args) {
//        1、简单的用lambda测试下
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);list.add(12);list.add(3);list.add(4);list.add(5);list.add(6);
//        Integer integer = list.stream().reduce((a, b) -> a + b).get();
//        System.out.println(integer);
//          求和
//        int sum = sum(list);
//        求最大值
//        int max = max(list);
//          使用reduce将其转换为list
//        List<Integer> integers = toList(list.stream());
//        System.out.println(integers);
//        使用join拼串
        ArrayList<String> strs = new ArrayList<>();
        strs.add("I ");strs.add("am ");strs.add("sad");
        String asd = join(strs, "asd");
        System.out.println(asd);
    }
//          2、手写一个迭代模仿reduce
    public static <T,R> R reduce(BiFunction<R,T,R> accumulator, Collection<T> datas,R initValue){
        R  ret =initValue;
        for (T data : datas) {
            ret=accumulator.apply(ret,data);
        }
        return ret;
    }
//          3、对list进行求和
    public static int sum(Collection<Integer>list){
        return list.stream().reduce(0,(acc,curr)->acc+curr);
    }
//            4、求最大值
    public static int max(Collection<Integer>list){
//        return list.stream().reduce(0,(max,curr)->max>curr?max:curr);
        return list.stream().reduce(Math::max).orElse(null);
    }
//            5、拼串
    public static String join(Collection<String>list,String str){

        return list.stream().reduce(str,(acc,curr)->{acc=acc+curr;return acc;});

    }
    public static <T> List<T> toList(Stream<T> stream){
//        return list.stream().reduce(0,(max,curr)->max>curr?max:curr);
//    return list.stream().reduce(0,(acc,curr)->acc+curr);
        List<T> ret =new ArrayList<>();

        return stream.reduce(ret,(acc,curr)->{acc.add(curr);return acc;},(list1,list2)->{list1.addAll(list2);return list2;});
    }



}
