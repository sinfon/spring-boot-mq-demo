package top.sinfonia.demo.mq.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.sinfonia.demo.mq.jms.DemoCommandLineRunner;
import top.sinfonia.demo.mq.jms.DemoJmsConstants;

/**
 * @author singoasher
 * @date 2018/6/22
 */
@Slf4j
@RestController
@RequestMapping("/demo")
public class DemoController {
    private DemoCommandLineRunner demoCommandLineRunner;

    @Autowired
    public DemoController(DemoCommandLineRunner demoCommandLineRunner) {
        this.demoCommandLineRunner = demoCommandLineRunner;
    }

    @GetMapping("/jms")
    public ResponseEntity<String> sendToJmsListener(@RequestParam(required = false) String message) throws Exception {
        log.info("message: {}", message);
        if (!StringUtils.hasText(message)) {
            message = DemoJmsConstants.JMS_LISTENER_DEFAULT_MESSAGE;
        }
        log.info("message to be sent: {}", message);
        demoCommandLineRunner.run(message);
        log.info("message sent: {}", message);
        return ResponseEntity.accepted().body(message);
    }
}