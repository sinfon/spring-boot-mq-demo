package top.sinfonia.demo.mq.infrastructure.constant;

/**
 * @author singoasher
 * @date 2018/6/22
 */
public class DemoConstants {
    public static final String DEFAULT_MESSAGE = "This is the default message to be sent";
    public static final String AMQP_LISTENER_DESTINATION_DEMO = "demo-amqp-listener";
    public static final String JMS_LISTENER_DESTINATION_APP_START = "app-start-jms-listener";
    public static final String JMS_LISTENER_DESTINATION_DEMO = "demo-jms-listener";
    public static final String RABBIT_LISTENER_DESTINATION_DEMO = "demo-rabbit-listener";
    public static final String RABBIT_USER_QUEUE = "rabbit-user-queue";

    public static final String RABBIT_TOPIC_DEMO_EXCHANGE = "rabbit.topic.demo.exchange";
    public static final String RABBIT_TOPIC_DEMO_ROUTING_KEY = "rabbit.topic.demo.route";
    public static final String RABBIT_TOPIC_DEMO_QUEUE = "rabbit.topic.demo.queue";
    public static final String RABBIT_TOPIC_DEMO2_QUEUE = "rabbit.topic.demo2.queue";
}
