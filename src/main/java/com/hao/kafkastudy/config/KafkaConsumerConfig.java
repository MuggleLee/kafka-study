package com.hao.kafkastudy.config;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.springframework.beans.factory.annotation.Value;

import java.util.Properties;

/**
 * @author Muggle Lee
 * @Date: 2020/3/30 16:30
 */
public class KafkaConsumerConfig {
    @Value("${spring.kafka.bootstrap-servers}")
    private static String bootstrapServers;
    @Value("${spring.kafka.consumer.enable-auto-commit}")
    private static String enableAutoCommit;
    @Value("${spring.kafka.consumer.auto-commit-interval}")
    private static String autoCommitInterval;
    @Value("${spring.kafka.consumer.key-deserializer}")
    private static String keyDeserializer;
    @Value("${spring.kafka.consumer.value-deserializer}")
    private static String valueDeserializer;
    @Value("${spring.kafka.consumer.session.timeout}")
    private static String timeout;
    @Value("${kafka.topic.group-id}")
    private static String groupId;

    private static Properties getProducercConfig() {
        Properties properties = new Properties();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        properties.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, enableAutoCommit);
        properties.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, autoCommitInterval);
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, keyDeserializer);
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, valueDeserializer);
        return properties;
    }
}
