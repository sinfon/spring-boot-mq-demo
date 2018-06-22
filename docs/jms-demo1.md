# Jms Demo 1

- 启动时会发送一次消息
- 之后消息异步发送，同步处理

```java
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
```

```java
@Component
public class DemoCommandLineRunner implements CommandLineRunner {
    private JmsTemplate jmsTemplate;

    @Autowired
    public DemoCommandLineRunner(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    @Override
    public void run(String... args) throws Exception {
        jmsTemplate.send(DemoJmsConstants.JMS_LISTENER_DESTINATION_DEMO, new DemoMessageCreator(args));
    }
}
```

```java
@Slf4j
@Component
public class DemoListener {
    private static final Long DEFAULT_SLEEP = 3_000L;

    @JmsListener(destination = DemoJmsConstants.JMS_LISTENER_DESTINATION_DEMO)
    public void demoListener(String message) throws InterruptedException {
        log.info("Demo Sleep");
        Thread.sleep(DEFAULT_SLEEP);
        log.info("Demo Sleep End");
        log.info("Demo listener, receive message: {}", message);
    }
}
```

```java
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
```