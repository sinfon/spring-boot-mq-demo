package top.sinfonia.demo.mq.rabbit;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author singoasher
 * @date 2018/6/22
 */
@Component
public class DemoRabbitSender {
    private RabbitTemplate rabbitTemplate;

    @Autowired
    public DemoRabbitSender(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendToDemoRabbitListener(String message) {
        rabbitTemplate.convertAndSend(DemoRabbitConstants.RABBIT_LISTENER_DESTINATION_DEMO, message);
    }
}
