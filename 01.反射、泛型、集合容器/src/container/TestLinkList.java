package container;

import java.util.LinkedList;

public class TestLinkList {
    public static void main(String[] args) {
        LinkedList<Object> linkedList = new LinkedList<>();
        linkedList.add("asd");
        linkedList.get(0);
        Object remove = linkedList.remove(0);
        System.out.println(remove);
    }
}
