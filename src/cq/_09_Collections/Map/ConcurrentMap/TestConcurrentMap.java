package cq._09_Collections.Map.ConcurrentMap;

import org.junit.Test;
import sun.plugin.cache.CacheUpdateHelper;

import java.util.concurrent.ConcurrentHashMap;

public class TestConcurrentMap {

    @Test
    public void testConcurrentMap(){

        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        concurrentHashMap.put("a", "aaa");
        concurrentHashMap.put("b", "bbb");
        concurrentHashMap.put("a", "aaa");

        System.out.println(concurrentHashMap);
    }
}
