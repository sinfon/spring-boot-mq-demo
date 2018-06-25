package top.sinfonia.demo.mq.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import top.sinfonia.demo.mq.amqp.DemoAmqpSender;
import top.sinfonia.demo.mq.domain.model.User;
import top.sinfonia.demo.mq.infrastructure.constant.DemoConstants;
import top.sinfonia.demo.mq.jms.DemoJmsSender;
import top.sinfonia.demo.mq.rabbit.DemoRabbitSender;

/**
 * @author singoasher
 * @date 2018/6/22
 */
@Slf4j
@RestController
@RequestMapping("/demo")
public class DemoController {
    private DemoJmsSender demoJmsSender;
    private DemoRabbitSender demoRabbitSender;
    private DemoAmqpSender demoAmqpSender;

    @Autowired
    public DemoController(DemoJmsSender demoJmsSender, DemoRabbitSender demoRabbitSender, DemoAmqpSender demoAmqpSender) {
        this.demoJmsSender = demoJmsSender;
        this.demoRabbitSender = demoRabbitSender;
        this.demoAmqpSender = demoAmqpSender;
    }

    @GetMapping
    public ResponseEntity<String> sendToDemoListener(@RequestParam(required = false) String message) throws Exception {
        log.info("message: {}", message);
        if (!StringUtils.hasText(message)) {
            message = DemoConstants.DEFAULT_MESSAGE;
        }
        log.info("message to be sent: {}", message);
        demoJmsSender.sendToDemoJmsListener(message);
        demoRabbitSender.sendToDemoRabbitListener(message);
        demoAmqpSender.send(message);
        log.info("message sent: {}", message);
        return ResponseEntity.accepted().body(message);
    }

    @GetMapping("/user/{number}")
    public ResponseEntity<User> user(@PathVariable Integer number, User user) {
        demoRabbitSender.send(user);
        if (number != null) {
            switch (number) {
                case 1:
                    demoRabbitSender.sendToTopicDemo1(user);
                    break;
                case 2:
                    demoRabbitSender.sendToTopicDemo2(user);
                    break;
                default:
            }
        }
        demoRabbitSender.sentToFanoutDemo(user);
        return ResponseEntity.accepted().body(user);
    }
}
