package top.sinfonia.demo.mq.jms;

import org.springframework.jms.core.MessageCreator;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import java.util.Arrays;
import java.util.List;

/**
 * @author singoasher
 * @date 2018/6/22
 */
public class DemoMessageCreator implements MessageCreator {
    private List<String> message;

    public DemoMessageCreator(String... message) {
        this.message = Arrays.asList(message);
    }

    @Override
    public Message createMessage(Session session) throws JMSException {
        return session.createTextMessage(message.toString());
    }
}
