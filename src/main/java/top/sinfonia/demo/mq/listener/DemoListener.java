package top.sinfonia.demo.mq.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import top.sinfonia.demo.mq.domain.model.User;
import top.sinfonia.demo.mq.infrastructure.constant.DemoConstants;
import top.sinfonia.demo.mq.infrastructure.util.JsonUtil;

/**
 * @author singoasher
 * @date 2018/6/25
 */
@Slf4j
@Component
public class DemoListener {
    private static final Long DEFAULT_SLEEP = 4_000L;

    @JmsListener(destination = DemoConstants.JMS_LISTENER_DESTINATION_DEMO)
    public void jmsDemoListener(String message) throws InterruptedException {
        log.info("DemoListener ... ... jmsDemoListener sleep start");
        Thread.sleep(DEFAULT_SLEEP);
        log.info("DemoListener ... ... jmsDemoListener sleep end, receive message: {}", message);
    }

    @JmsListener(destination = DemoConstants.JMS_LISTENER_DESTINATION_APP_START)
    public void jmsAppStartListener(String message) throws InterruptedException {
        log.info("DemoListener ... ... jmsAppStartListener, receive message (app main args): {}", message);
    }

    @RabbitListener(queues = DemoConstants.RABBIT_LISTENER_DESTINATION_DEMO)
    public void rabbitDemoLister(String message) throws InterruptedException {
        log.info("DemoListener ... ... rabbitDemoLister sleep start");
        Thread.sleep(DEFAULT_SLEEP);
        log.info("DemoListener ... ... rabbitDemoLister sleep end, receive message: {}", message);
    }

    @RabbitListener(queues = DemoConstants.AMQP_LISTENER_DESTINATION_DEMO)
    public void amqpDemoLister(String message) throws InterruptedException {
        log.info("DemoListener ... ... amqpDemoLister sleep start");
        Thread.sleep(DEFAULT_SLEEP);
        log.info("DemoListener ... ... amqpDemoLister sleep end, receive message: {}", message);
    }

    @RabbitListener(queues = DemoConstants.RABBIT_USER_QUEUE)
    public void rabbitUserQueueListener(User user) {
        log.info("DemoListener ... ... rabbitUserQueueListener, User: {}", JsonUtil.stringfy(user));
    }

    @RabbitListener(queues = DemoConstants.RABBIT_TOPIC_DEMO_QUEUE)
    public void rabbitTopicDemoQueueListener(User user) {
        log.info("DemoListener ... ... rabbitTopicDemoQueueListener, User: {}", JsonUtil.stringfy(user));
    }

    @RabbitListener(queues = DemoConstants.RABBIT_TOPIC_DEMO2_QUEUE)
    public void rabbitTopicDemo2QueueListener(User user) {
        log.info("DemoListener ... ... rabbitTopicDemo2QueueListener, User: {}", JsonUtil.stringfy(user));
    }
}
