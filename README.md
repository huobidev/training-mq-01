# 消息队列培训-第一课时(ActiveMQ&amp;JMS示例)

通过如下步骤演示消息队列的应用，以及ActiveMQ&JMS的基本用法。

## 1. 安装ActiveMQ

### 1.1 准备条件

系统需要预先安装JDK8+，Maven3+，git工具(git命令行或tortoiseGit，IDE自带工具等)，并已经配置好环境变量。

### 1.2 下载Zookeeper

可以通过下列链接手动下载：

http://ftp.jaist.ac.jp/pub/apache/zookeeper/zookeeper-3.4.14/zookeeper-3.4.14.tar.gz

Linux/Mac也可以通过如下命令下载：

> wget http://ftp.jaist.ac.jp/pub/apache/zookeeper/zookeeper-3.4.14/zookeeper-3.4.14.tar.gz



### 1.3 下载ActiveMQ

Linux/Mac也可以通过如下命令下载：

> wget http://ftp.jaist.ac.jp/pub/apache/activemq/5.15.9/apache-activemq-5.15.9-bin.tar.gz



## 2. 启动ActiveMQ broker

### 2.1 启动Zookeeper

Window上直接解压zip文件。

Linux/Mac上使用：

> $ tar xvzf zookeeper-3.4.14.tar.gz
>
> $ cd zookeeper-3.4.14
>
> $ mv conf/zoo_sample.cfg  conf/zoo.cfg
>
> $ $ ./bin/zkServer.sh start
>
> ZooKeeper JMX enabled by default
>
> Using config: /Users/kimmking/kk/huobidev/zookeeper-3.4.14/bin/../conf/zoo.cfg
>
> Starting zookeeper ... STARTED

出现“*Starting zookeeper ... STARTED*”就说明启动成功了。

### 2.2 启动ActiveMQ

Window上直接解压zip文件。

Linux/Mac上使用：

> $ tar xvzf apache-activemq-5.15.9-bin.tar.gz
>
> $ cd apache-activemq-5.15.9/
>
> $ ./bin/activemq start
>
> ... ... 
>
> INFO: pidfile created : '/Users/kimmking/kk/huobidev/apache-activemq-5.15.9//data/activemq.pid' (pid '89168')

看到提示“*pidfile created*”就说明启动成功了。

此时可以在浏览器输入：http://localhost:8161/admin/

![image-20190402180442364](./images/image-20190402180442364.png)



## 3. 下载demo代码

在命令行或IDE工具里：

> git clone git@github.com:huobidev/training-mq-01.git
>
> cd training-mq-01

然后，可以把代码导入到IDE里，比如IntelliJ IDEA。



## 4. 发送消息



## 5. 接收消息




