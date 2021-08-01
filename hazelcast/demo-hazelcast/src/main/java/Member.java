import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;

public class Member {
    public static void main(String[] args) {

        HazelcastInstance instance = Hazelcast.newHazelcastInstance();

        IMap<Object,Object> map = instance.getMap("map");

        for (int i =0; i < 1000; i++){
            map.put(i,i);
        }
    }
}
