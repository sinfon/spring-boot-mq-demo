# RabbitMQ

## Install & Start

```
$ brew install rabbitmq
$ brew services start rabbitmq
$ brew services stop rabbitmq
```

- 访问 `http://localhost:15672`
- 默认用户名 `guest`
- 默认密码 `guest`

## application.yml

```yaml
spring:
  rabbitmq:
    host: localhost
    port: 5672
    username: guest
    password: guest
```

以上配置都是默认配置，如果没有改动，不进行配置亦可。

## Exchange

- Direct
- Topic
- Headers
- Fanout


## 参考链接

- [Spring Boot 学习笔记 6 - Spring Boot 整合 RabbitMQ](https://www.cnblogs.com/hlhdidi/p/6535677.html) 
