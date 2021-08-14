import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.IntegerDeserializer;
import org.apache.kafka.common.serialization.IntegerSerializer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Arrays;
import java.util.Properties;

public class Producer {
    public static void main(String[] args) throws InterruptedException {
        final String bootstrapServers = "34.141.15.250:9092";
        final String consumerGroupId = "SampleConsumer";
        final String topic = "testTopic";


        Properties properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,bootstrapServers);
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, IntegerSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());


        final KafkaProducer<Integer, String> producer = new KafkaProducer<>(properties);

        for(int i = 0; i < 20; i++){
            producer.send(new ProducerRecord<>(topic,i,"messageStr"+ i));
            Thread.sleep(3000);
        }
    }
}
