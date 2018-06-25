package top.sinfonia.demo.mq.rabbit;

import org.springframework.amqp.core.Queue;
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
}
