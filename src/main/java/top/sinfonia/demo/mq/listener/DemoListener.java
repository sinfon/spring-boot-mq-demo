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
        log.info("DemoListener ... ... rabbitUserQueueListener, User: {}", JsonUtil.stringify(user));
    }

    @RabbitListener(queues = DemoConstants.RABBIT_TOPIC_DEMO1_QUEUE1)
    public void rabbitTopicDemo1Queue1Listener(User user) {
        log.info("DemoListener ... ... rabbitTopicDemo1Queue1Listener, User: {}", JsonUtil.stringify(user));
    }

    @RabbitListener(queues = DemoConstants.RABBIT_TOPIC_DEMO1_QUEUE2)
    public void rabbitTopicDemo1Queue2Listener(User user) {
        log.info("DemoListener ... ... rabbitTopicDemo1Queue2Listener, User: {}", JsonUtil.stringify(user));
    }

    @RabbitListener(queues = DemoConstants.RABBIT_TOPIC_DEMO2_QUEUE1)
    public void rabbitTopicDemo2Queue1Listener(User user) {
        log.info("DemoListener ... ... rabbitTopicDemo2Queue1Listener, User: {}", JsonUtil.stringify(user));
    }

    @RabbitListener(queues = DemoConstants.RABBIT_TOPIC_DEMO2_QUEUE2)
    public void rabbitTopicDemo2Queue2Listener(User user) {
        log.info("DemoListener ... ... rabbitTopicDemo2Queue2Listener, User: {}", JsonUtil.stringify(user));
    }

    @RabbitListener(queues = DemoConstants.RABBIT_FANOUT_DEMO1_QUEUE1)
    public void rabbitFanoutDemo1Queue1Listener(User user) {
        log.info("DemoListener ... ... rabbitFanoutDemo1Queue1Listener, User: {}", JsonUtil.stringify(user));
    }

    @RabbitListener(queues = DemoConstants.RABBIT_FANOUT_DEMO1_QUEUE2)
    public void rabbitFanoutDemo1Queue2Listener(User user) {
        log.info("DemoListener ... ... rabbitFanoutDemo1Queue2Listener, User: {}", JsonUtil.stringify(user));
    }

    @RabbitListener(queues = DemoConstants.RABBIT_FANOUT_DEMO2_QUEUE1)
    public void rabbitFanoutDemo2Queue1Listener(User user) {
        log.info("DemoListener ... ... rabbitFanoutDemo2Queue1Listener, User: {}", JsonUtil.stringify(user));
    }

    @RabbitListener(queues = DemoConstants.RABBIT_FANOUT_DEMO2_QUEUE2)
    public void rabbitFanoutDemo2Queue2Listener(User user) {
        log.info("DemoListener ... ... rabbitFanoutDemo2Queue2Listener, User: {}", JsonUtil.stringify(user));
    }
}
