import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;

import java.util.Random;

public class Member {
    public static void main(String[] args) {

        HazelcastInstance instance = Hazelcast.newHazelcastInstance();
        IMap<Object,Object> map = instance.getMap("mapTest");

        Random rand = new Random();
        long start = System.nanoTime();
        for (int i =0; i < 100000; i++){
            map.put(i,rand.nextInt(100000));
        }
        long elapsedTime = System.nanoTime() - start;
        double seconds = (double)elapsedTime / 1_000_000_000.0;
        System.out.println(seconds);

    }
}
