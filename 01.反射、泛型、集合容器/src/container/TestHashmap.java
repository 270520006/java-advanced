package container;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class TestHashmap {
    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("","");
        AtomicInteger atomicInteger = new AtomicInteger();
        atomicInteger.getAndIncrement();
        ReentrantLock reentrantLock = new ReentrantLock();
    }
}
