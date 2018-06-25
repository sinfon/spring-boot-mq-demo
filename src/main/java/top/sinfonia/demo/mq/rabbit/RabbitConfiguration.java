package top.sinfonia.demo.mq.rabbit;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import top.sinfonia.demo.mq.infrastructure.constant.DemoConstants;

/**
 * @author singoasher
 * @date 2018/6/22
 */
@Configuration
public class RabbitConfiguration {
    @Bean
    public Queue demoRabbitQueue() {
        return new Queue(DemoConstants.RABBIT_LISTENER_DESTINATION_DEMO);
    }

    @Bean
    public Queue rabbitUserQueue() {
        return new Queue(DemoConstants.RABBIT_USER_QUEUE);
    }

    @Bean
    public Queue rabbitTopicDemo1Queue1() {
        return new Queue(DemoConstants.RABBIT_TOPIC_DEMO1_QUEUE1);
    }

    @Bean
    public Queue rabbitTopicDemo1Queue2() {
        return new Queue(DemoConstants.RABBIT_TOPIC_DEMO1_QUEUE2);
    }

    @Bean
    public Queue rabbitTopicDemo2Queue1() {
        return new Queue(DemoConstants.RABBIT_TOPIC_DEMO2_QUEUE1);
    }

    @Bean
    public Queue rabbitTopicDemo2Queue2() {
        return new Queue(DemoConstants.RABBIT_TOPIC_DEMO2_QUEUE2);
    }

    @Bean
    public TopicExchange rabbitTopicDemoExchange() {
        return new TopicExchange(DemoConstants.RABBIT_TOPIC_DEMO_EXCHANGE);
    }

    @Bean
    public Binding rabbitDemo1Queue1Binding(Queue rabbitTopicDemo1Queue1, TopicExchange topicExchange) {
        return BindingBuilder.bind(rabbitTopicDemo1Queue1).to(topicExchange).with(DemoConstants.RABBIT_TOPIC_DEMO1_ROUTING_KEY);
    }

    @Bean
    public Binding rabbitDemo1Queue2Binding(Queue rabbitTopicDemo1Queue2, TopicExchange topicExchange) {
        return BindingBuilder.bind(rabbitTopicDemo1Queue2).to(topicExchange).with(DemoConstants.RABBIT_TOPIC_DEMO1_ROUTING_KEY);
    }

    @Bean
    public Binding rabbitDemo2Queue1Binding(Queue rabbitTopicDemo2Queue1, TopicExchange topicExchange) {
        return BindingBuilder.bind(rabbitTopicDemo2Queue1).to(topicExchange).with(DemoConstants.RABBIT_TOPIC_DEMO2_ROUTING_KEY);
    }

    @Bean
    public Binding rabbitDemo2Queue2Binding(Queue rabbitTopicDemo2Queue2, TopicExchange topicExchange) {
        return BindingBuilder.bind(rabbitTopicDemo2Queue2).to(topicExchange).with(DemoConstants.RABBIT_TOPIC_DEMO2_ROUTING_KEY);
    }
}
