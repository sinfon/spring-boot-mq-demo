package top.sinfonia.demo.mq.jms;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import top.sinfonia.demo.mq.infrastructure.constant.DemoConstants;

/**
 * @author singoasher
 * @date 2018/6/22
 */
@Slf4j
@Component
public class DemoJmsListener {
    private static final Long DEFAULT_SLEEP = 3_000L;

    @JmsListener(destination = DemoConstants.JMS_LISTENER_DESTINATION_DEMO)
    public void demoListener(String message) throws InterruptedException {
        log.info("Demo Jms Sleep");
        Thread.sleep(DEFAULT_SLEEP);
        log.info("Demo Jms Listener, receive message: {}", message);
    }

    @JmsListener(destination = DemoConstants.JMS_LISTENER_DESTINATION_APP_START)
    public void appStartListener(String message) throws InterruptedException {
        log.info("App Start listener, receive message (app main args): {}", message);
    }
}
