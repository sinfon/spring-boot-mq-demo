# ActiveMQ

## Install

```
$ brew install activemq
$ activemq -v
```

## Start & Stop

```
$ activemq start
$ activemq status
$ ps aux | grep activemq
$ activemq stop
```

或者通过 Homebrew 的 `brew services start activemq` 命令也可启动，但是启动偶有失效。
而且，通过 Homebrew 关闭 ActiveMQ 的几次尝试均以失败告终了。所以，嗯。

## Manage

浏览器访问 `http://localhost:8161` 选择 `Manage ActiveMQ broker`（或者直接访问 `http://localhost:8161/admin/`）。
使用默认用户名和密码（均为 `admin`）即可登录，查看并管理 ActiveMQ 的相关信息。

## 异常

因为之前安装并启动了 RabbitMQ 造成端口冲突，无法启动。

- 修改 ActiveMQ 使用的端口号

在 `/usr/local/Cellar/activemq/5.15.4/libexec/conf` 下可以找到 ActiveMQ 的配置文件 `activemq.xml` 有如下配置

```
<transportConnectors>
    <!-- DOS protection, limit concurrent connections to 1000 and frame size to 100MB -->
    <transportConnector name="openwire" uri="tcp://0.0.0.0:61616?maximumConnections=1000&amp;wireFormat.maxFrameSize=104857600"/>
    <transportConnector name="amqp" uri="amqp://0.0.0.0:5672?maximumConnections=1000&amp;wireFormat.maxFrameSize=104857600"/>
    <transportConnector name="stomp" uri="stomp://0.0.0.0:61613?maximumConnections=1000&amp;wireFormat.maxFrameSize=104857600"/>
    <transportConnector name="mqtt" uri="mqtt://0.0.0.0:1883?maximumConnections=1000&amp;wireFormat.maxFrameSize=104857600"/>
    <transportConnector name="ws" uri="ws://0.0.0.0:61614?maximumConnections=1000&amp;wireFormat.maxFrameSize=104857600"/>
</transportConnectors>
```

查看这几个端口的占用情况。

```
$ lsof -i:61616

$ lsof -i:5672 
COMMAND    PID     USER   FD   TYPE             DEVICE SIZE/OFF NODE NAME
beam.smp 52773 sinfonia   89u  IPv4 0x6da39ef1aed490d7      0t0  TCP localhost:amqp (LISTEN)

$ lsof -i:61613
COMMAND    PID     USER   FD   TYPE             DEVICE SIZE/OFF NODE NAME
beam.smp 52773 sinfonia   91u  IPv6 0x6da39ef1db39f5ef      0t0  TCP *:61613 (LISTEN)
 
$ lsof -i:1883 
COMMAND    PID     USER   FD   TYPE             DEVICE SIZE/OFF NODE NAME
beam.smp 52773 sinfonia   90u  IPv6 0x6da39ef1db3885ef      0t0  TCP *:ibm-mqisdp (LISTEN)

$ lsof -i:61614
```

通过查看端口占用情况，可以发现 `5672, 61613, 1883` 三个端口均被 PID 为 52773 进程占用，
通过 `ps aux | grep 52773` 可以看到该进程为 RabbitMQ

- 修改配置文件中的这几个端口号，并重新尝试启动 ActiveMQ 启动成功。
    - 修改时注意不要和已被占用的端口号冲突，也不要和自身冲突。（一个把 `61613` 该成 `61614/61616` 后发现冲突的人如是说）

```
<transportConnectors>
    <!-- DOS protection, limit concurrent connections to 1000 and frame size to 100MB -->
    <transportConnector name="openwire" uri="tcp://0.0.0.0:61616?maximumConnections=1000&amp;wireFormat.maxFrameSize=104857600"/>
    <transportConnector name="amqp" uri="amqp://0.0.0.0:5673?maximumConnections=1000&amp;wireFormat.maxFrameSize=104857600"/>
    <transportConnector name="stomp" uri="stomp://0.0.0.0:61615?maximumConnections=1000&amp;wireFormat.maxFrameSize=104857600"/>
    <transportConnector name="mqtt" uri="mqtt://0.0.0.0:1884?maximumConnections=1000&amp;wireFormat.maxFrameSize=104857600"/>
    <transportConnector name="ws" uri="ws://0.0.0.0:61614?maximumConnections=1000&amp;wireFormat.maxFrameSize=104857600"/>
</transportConnectors>
```

