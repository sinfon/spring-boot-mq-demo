package top.sinfonia.demo.mq.rabbit;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author singoasher
 * @date 2018/6/22
 */
@Configuration
public class RabbitConfiguration {
    @Bean("demo-rabbit-queue")
    public Queue demoRabbitQueue() {
        return new Queue(DemoRabbitConstants.RABBIT_LISTENER_DESTINATION_DEMO);
    }
}
