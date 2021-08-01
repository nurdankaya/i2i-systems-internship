import com.hazelcast.client.HazelcastClient;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;

public class Client {
    public static void main(String[] args) throws InterruptedException {
        HazelcastInstance client = HazelcastClient.newHazelcastClient();
        IMap<Object,Object> map = client.getMap("mapTest");

        int i = 0;
        long start = System.nanoTime();
        Object randNumber = 0;
        while(randNumber!=null){
            randNumber= map.get(i);
            i++;
        }
        long elapsedTime = System.nanoTime() - start;
        double seconds = (double)elapsedTime / 1_000_000_000.0;
        System.out.println(seconds);
    }
}
