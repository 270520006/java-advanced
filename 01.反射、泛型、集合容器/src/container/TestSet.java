package container;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class TestSet {
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();
        hashSet.add("aaa");
        TreeSet<Object> treeSet = new TreeSet<>();
        treeSet.add("aaa");
        LinkedHashSet<Object> objects = new LinkedHashSet<>();
    }
}
