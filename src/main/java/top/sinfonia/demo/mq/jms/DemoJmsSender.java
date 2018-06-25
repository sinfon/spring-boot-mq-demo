package top.sinfonia.demo.mq.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import top.sinfonia.demo.mq.infrastructure.constant.DemoConstants;

/**
 * @author singoasher
 * @date 2018/6/22
 */
@Component
public class DemoJmsSender {
    private JmsTemplate jmsTemplate;

    @Autowired
    public DemoJmsSender(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void sendToDemoJmsListener(String... message) {
        jmsTemplate.send(DemoConstants.JMS_LISTENER_DESTINATION_DEMO, new DemoMessageCreator(message));
    }
}
