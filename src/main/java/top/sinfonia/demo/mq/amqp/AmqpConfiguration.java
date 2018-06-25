package top.sinfonia.demo.mq.amqp;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import top.sinfonia.demo.mq.infrastructure.constant.DemoConstants;

/**
 * @author singoasher
 * @date 2018/6/25
 */
@Configuration
public class AmqpConfiguration {
    @Bean("demo-amqp-queue")
    public Queue demoRabbitQueue() {
        return new Queue(DemoConstants.AMQP_LISTENER_DESTINATION_DEMO);
    }
}
