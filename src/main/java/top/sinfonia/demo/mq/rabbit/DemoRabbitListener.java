package top.sinfonia.demo.mq.rabbit;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author singoasher
 * @date 2018/6/22
 */
@Slf4j
@Component
public class DemoRabbitListener {
    private static final Long DEFAULT_SLEEP = 4_000L;

    @RabbitListener(queues = DemoRabbitConstants.RABBIT_LISTENER_DESTINATION_DEMO)
    public void demoListener(String message) throws InterruptedException {
        log.info("Demo Rabbit Sleep");
        Thread.sleep(DEFAULT_SLEEP);
        log.info("Demo Rabbit Listener, receive message: {}", message);
    }
}
