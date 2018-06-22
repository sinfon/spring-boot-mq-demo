package top.sinfonia.demo.mq.jms;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @author singoasher
 * @date 2018/6/22
 */
@Slf4j
@Component
public class DemoListener {
    private static final Long DEFAULT_SLEEP = 3_000L;

    @JmsListener(destination = DemoJmsConstants.JMS_LISTENER_DESTINATION_DEMO)
    public void demoListener(String message) throws InterruptedException {
        log.info("Demo Sleep");
        Thread.sleep(DEFAULT_SLEEP);
        log.info("Demo Sleep End");
        log.info("Demo listener, receive message: {}", message);
    }
}
