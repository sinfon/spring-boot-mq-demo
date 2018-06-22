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
    @JmsListener(destination = DemoJmsConstants.JMS_LISTENER_DESTINATION_DEMO)
    public void demoListener(String message) {
        log.info("Demo listener, receive message: {}", message);
    }
}
