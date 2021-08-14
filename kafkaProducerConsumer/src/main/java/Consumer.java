import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.IntegerDeserializer;
import org.apache.kafka.common.serialization.StringDeserializer;

public class Consumer {
    public static void main(String[] args) {
        final String bootstrapServers = "34.141.15.250:9092";
        final String consumerGroupId = "SampleConsumer";

        Properties properties = new Properties();
        properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,bootstrapServers);
        properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, IntegerDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG,consumerGroupId);
        //properties.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG,"earliest");

        final KafkaConsumer<Integer, String> consumer = new KafkaConsumer<>(properties);

        consumer.subscribe(Arrays.asList("testTopic"));

        while(true){
            ConsumerRecords<Integer,String> records = consumer.poll(Duration.ofMillis(1000));
            for(ConsumerRecord record : records){
                System.out.println("received  -- Key :"+ record.key()+" value:"+ record.value() + "topic: " +record.topic() );
            }
        }
    }
}
