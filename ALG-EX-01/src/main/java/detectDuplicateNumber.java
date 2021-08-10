import java.util.HashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class detectDuplicateNumber {
    static HashMap<Integer,Integer> map;
    static Logger logger = LogManager.getLogger();

    //Space Complexity of hashmap in big-O notation is O(n)
    //time Complexity of hashmap O(1)
    public static void detectDuplicateNumbersM1(int[] numbersToDetect){
        map = new HashMap<Integer,Integer>();
        logger.info("hashmap is created");
        for (int j : numbersToDetect) {
            if (map.get(j) == null) {
                logger.info(j + " is added map");
                map.put(j, 1);
            } else {
                logger.info(j + " detected second time");
                System.out.println("duplicated number: " + j);
                break;
            }
        }
    }

    public static void main(String[] args) {

        int[] test1 = new int[]{ 1,2,4,8,3 };
        int[] test2 = new int[]{ 4,6,12,5,5,89 };
        int[] test3 = new int[]{ 4,3,8,8,35,35,12 };
        int[] test4 = new int[]{ 5,6,78,5 };

        System.out.println("result fot tes1");
        detectDuplicateNumbersM1(test1);
        System.out.println("result fot tes2");
        detectDuplicateNumbersM1(test2);
        System.out.println("result fot tes3");
        detectDuplicateNumbersM1(test3);
        System.out.println("result fot tes3");
        detectDuplicateNumbersM1(test4);

    }
}
