package top.sinfonia.demo.mq.amqp;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.sinfonia.demo.mq.infrastructure.constant.DemoConstants;

/**
 * @author singoasher
 * @date 2018/6/25
 */
@Component
public class DemoAmqpSender {
    private AmqpTemplate amqpTemplate;

    @Autowired
    public DemoAmqpSender(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    public void send(String message) {
        amqpTemplate.convertAndSend(DemoConstants.AMQP_LISTENER_DESTINATION_DEMO, message);
    }
}
