package com.hao.kafkastudy.service;

import com.hao.kafkastudy.config.KafkaProducerConfig;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.stereotype.Service;

import java.util.Properties;
import java.util.UUID;

/**
 * @author Muggle Lee
 * @Date: 2020/3/30 16:09
 */
@Service
public class ProducerService {

    private Producer producer;

    private String TOPIC = "kafka-topic";

    private Properties properties = KafkaProducerConfig.getProducercConfig();

    public void sendMessage(String message) {
        int key = 1;
        producer = new KafkaProducer(properties);
        producer.send(new ProducerRecord(TOPIC, key, message));
        System.out.println("Key: " + key + " Value: " + message);
        key++;
    }

}
