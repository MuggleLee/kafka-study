package com.hao.kafkastudy;

import com.hao.kafkastudy.service.ProducerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class KafkaStudyApplicationTests {
    @Autowired
    private ProducerService producerService;

    @Test
    public void producerSendMessage() {
        for (int i = 0; i < 100; i++) {
            producerService.sendMessage("消息内容：" + i);
        }
    }

}
