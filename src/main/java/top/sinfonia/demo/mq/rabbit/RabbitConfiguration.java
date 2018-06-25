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
    public Queue rabbitTopicDemoQueue() {
        return new Queue(DemoConstants.RABBIT_TOPIC_DEMO_QUEUE);
    }

    @Bean
    public Queue rabbitTopicDemo2Queue() {
        return new Queue(DemoConstants.RABBIT_TOPIC_DEMO2_QUEUE);
    }

    @Bean
    public TopicExchange rabbitTopicDemoExchange() {
        return new TopicExchange(DemoConstants.RABBIT_TOPIC_DEMO_EXCHANGE);
    }

    @Bean
    public Binding rabbitDemoBinding(Queue rabbitTopicDemoQueue, TopicExchange topicExchange) {
        return BindingBuilder.bind(rabbitTopicDemoQueue).to(topicExchange).with(DemoConstants.RABBIT_TOPIC_DEMO_ROUTING_KEY);
    }

    @Bean
    public Binding rabbitDemo2Binding(Queue rabbitTopicDemo2Queue, TopicExchange topicExchange) {
        return BindingBuilder.bind(rabbitTopicDemo2Queue).to(topicExchange).with(DemoConstants.RABBIT_TOPIC_DEMO_ROUTING_KEY);
    }
}
