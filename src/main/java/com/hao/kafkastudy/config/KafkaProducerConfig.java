package com.hao.kafkastudy.config;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Properties;

/**
 * @author Muggle Lee
 * @Date: 2020/3/30 16:11
 */
@Configuration
@Component
public class KafkaProducerConfig {

    private static HashMap propetiesMap = new HashMap();

    @Value("${spring.kafka.bootstrap-servers}")
    private static String bootstrapServers;
    @Value("${spring.kafka.producer.retries}")
    private static String retries;
    @Value("${spring.kafka.producer.batch-size}")
    private static String batchSize;
    @Value("${spring.kafka.producer.buffer-memory}")
    private static String bufferMemory;
    @Value("${spring.kafka.producer.key-serializer}")
    private static String keySerializer;
    @Value("${spring.kafka.producer.value-serializer}")
    private static String valueSerializer;
    @Value("${spring.kafka.producer.linger.ms}")
    private static String lingerMs;
    @Value("${spring.kafka.producer.acks}")
    private static String acks;

    public static Properties getProducercConfig() {
        Properties properties = new Properties();
        // 指定broker的地址，最少提供2个broker的信息，一旦其中一个宕机，生产者仍能连接到集群上
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        /**
         * 指定了必须要有多少个分区副本收到消息，生产者才会认为写入消息是成功的
         * acks=0 生产者在写入消息之前不会等待任何来自服务器的响应，容易丢消息，但是吞吐量高
         * acks=1 只要集群的首领节点收到消息，生产者会收到来自服务器的成功响应
         * acks=all 只有当所有参与复制的节点都收到消息，生产者才会收到一个来自服务器的成功响应。延迟高，但不会丢消息
         */
        properties.put(ProducerConfig.ACKS_CONFIG, acks);
        // 生产者可以重发消息的次数
        properties.put(ProducerConfig.RETRIES_CONFIG, retries);
        // 指定了一个批次可以使用的内存大小，按照字节数计算。当批次内存被填满后，批次里的所有消息会被发送出去
        properties.put(ProducerConfig.BATCH_SIZE_CONFIG, batchSize);
        // 生产者在发送批次前等待更多消息加入批次的时间
        properties.put(ProducerConfig.LINGER_MS_CONFIG, lingerMs);
        // 设置生产者内存缓冲区的大小，生产者用它缓冲要发送到服务器的消息
        properties.put(ProducerConfig.BUFFER_MEMORY_CONFIG, bufferMemory);
        // 参数化类型
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, keySerializer);
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, valueSerializer);
        return properties;
    }
}
