import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class ReduceToOthers {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);list.add(12);list.add(3);list.add(4);list.add(5);list.add(6);
//        reduce转换list
        List<Integer> integers = toList(list.stream());
        System.out.println(integers);
        //          reuce充当filter
        List<Integer> filter = filter(list, (i) -> i > 3);
        System.out.println(filter);
//        reduce充当map
        List<Integer> listMap = map(list, (i) -> i * 2);
        System.out.println(listMap);

    }
//    reduce充当map使用
    public static <T,R> List <R> map(List<T> list, Function<T,R> mapFn){
        List<R> arrayList = new ArrayList<>();
        return list.stream().reduce(arrayList,
                (acc,curr)->{acc.add(mapFn.apply(curr));
                return acc;},
                (list1,list2)->{list1.addAll(list2);
                    return list2;});
    }
    public static <T> List<T> toList(Stream<T> stream){
        List<T> list = new ArrayList<>();
        return stream.reduce(list,(acc,curr)->{acc.add(curr);return acc;}
                            ,(list1,list2)->{list1.addAll(list2);
                            return list1;});
    }
    public static <T,R> List <T> filter(List<T> list, Predicate<T> predicate){
        List<T> arrayList = new ArrayList<>();
        return list.stream().reduce(arrayList,
                (acc,curr)->{
                    if (predicate.test(curr))
                    {acc.add(curr);}
                    return acc;},
                (list1,list2)->{list1.addAll(list2);
                    return list2;});
    }

}
