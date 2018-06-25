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
    public static final String RABBIT_TOPIC_DEMO1_ROUTING_KEY = "rabbit.topic.demo1.route";
    public static final String RABBIT_TOPIC_DEMO1_QUEUE1 = "rabbit.topic.demo1.queue1";
    public static final String RABBIT_TOPIC_DEMO1_QUEUE2 = "rabbit.topic.demo1.queue2";
    public static final String RABBIT_TOPIC_DEMO2_ROUTING_KEY = "rabbit.topic.demo2.route";
    public static final String RABBIT_TOPIC_DEMO2_QUEUE1 = "rabbit.topic.demo2.queue1";
    public static final String RABBIT_TOPIC_DEMO2_QUEUE2 = "rabbit.topic.demo2.queue2";

    public static final String RABBIT_FANOUT_DEMO_EXCHANGE = "rabbit.fanout.demo.exchange";
    public static final String RABBIT_FANOUT_DEMO1_ROUTING_KEY = "rabbit.fanout.demo1.route";
    public static final String RABBIT_FANOUT_DEMO1_QUEUE1 = "rabbit.fanout.demo1.queue1";
    public static final String RABBIT_FANOUT_DEMO1_QUEUE2 = "rabbit.fanout.demo1.queue2";
    public static final String RABBIT_FANOUT_DEMO2_ROUTING_KEY = "rabbit.fanout.demo2.route";
    public static final String RABBIT_FANOUT_DEMO2_QUEUE1 = "rabbit.fanout.demo2.queue1";
    public static final String RABBIT_FANOUT_DEMO2_QUEUE2 = "rabbit.fanout.demo2.queue2";
}
