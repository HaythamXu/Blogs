## Wireshark
#### 常用filter
* 目的地址: `ip.dst==192.168.101.8`
* 源地址: `ip.src==1.1.1.1`
* 端口: `tcp.port==80` 等效 `tcp.dstport==80 and tcp.srcport==80`
* 协议: `http`
* 方法过滤: `http.request.method=="GET"`
* 多条件过滤: and

#### 网卡含义
* https://blog.csdn.net/renwotao2009/article/details/49329713


## middlewareeLight
nginx?
tomcat?
redis?
rebitMQ?
DataHub?

---

* https://jmeter.apache.org/download_jmeter.cgi


## 工具
* ab: apache benchmark
* wrk
* go 程序(需要多喝多线程)
* jmeter+badboy再外加一个自己写的monitor监控
* 分布式 open stack
* 要钱的有loadrunner, testcomplete
* http_load;

## SaaS产品
* 阿里云PTS
*




>
```
在测试高并发的场景下，也要注意修改linux的open files limit:
ulimit -n
命令可以显示file descriptors的值，这值默认是1024；也就是说，最多只能开1024个并发连接；一般情况下够用。
```






## 现有工作流引擎
* Activiti
* JBoss JBPM 6.5
* JFlow 6.0
* FixFlow 5.0

* Camunda BPM
* camunda.bpm.springboot
* 






## EFK
#### Fluentd
* https://docs.fluentd.org/deployment/plugin-management#if-using-td-agent-use-usr-sbin-td-agent-gem
* /Library/LaunchDaemons/td-agent.plist
* /var/log/td-agent/td-agent.log
* /etc/td-agent/td-agent.conf
* localhost:8888
```
curl -X POST -d 'json={"json":"message2020.12.13 11:30"}' http://localhost:8888/debug.test
tail -n 1 /var/log/td-agent/td-agent.log
```

#### ElasticSearch
* https://www.elastic.co/downloads/elasticsearch
* http://localhost:9200
```
bin/elasticsearch
curl http://localhost:9200
```

#### Kibana
* https://www.elastic.co/downloads/kibana
* config/kibana.yml
* http://localhost:5601
```
bin/kibana 
```

#### GET /<logstash-{now/d-2d}>,<logstash-{now/d-1d}>,<logstash-{now/d}>/_search
curl -X GET "localhost:9200/%3Clogstash-%7Bnow%2Fd-2d%7D%3E%2C%3Clogstash-%7Bnow%2Fd-1d%7D%3E%2C%3Clogstash-%7Bnow%2Fd%7D%3E/_search?pretty" -H 'Content-Type: application/json' -d'
{
"query" : {
"match": {
"query": "cpu"
}
}
}
'



## Jenkins
Jenkins CI/CD



#### Port
* 8080 默认访问端口
* 50000



Jenkins 提供有各种差劲供自定义Jenkins pipline job

* Jenkins DSL
* 声明式 与 ？
* Groovy
* jenkinsfile


Jenkins -> Job -> Deploy

使用DSL可以定义一个Jenkins？jenkinsfile
使用Groovy可以定义一下Job




#### Jenkins 官网与插件
* [Jenkins And DSL](https://www.jianshu.com/p/3d75f78156f3?hmsr=toutiao.io&utm_medium=toutiao.io&utm_source=toutiao.io)
* [Job DSL to create “Pipeline” type job](https://stackoverflow.com/questions/35898020/job-dsl-to-create-pipeline-type-job)
* [Jenkins之必备groovy基础](https://cloud.tencent.com/developer/article/1590645)
* [Jenkins Job DSL Plugin - piplineJob](https://jenkinsci.github.io/job-dsl-plugin/#path/pipelineJob)
* [Jenkins之声明式pipeline基础](https://cloud.tencent.com/developer/article/1590648?from=article.detail.1590645)
* [jenkins pipeline job实战](https://www.cnblogs.com/weiyiming007/p/12716086.html)
* [Pipeline Syntax](https://www.jenkins.io/doc/book/pipeline/syntax/#agent)
* [Jenkins Pipeline 概述](https://www.jianshu.com/p/0ce155d9d893)
* [Pipeline Steps Reference](https://www.jenkins.io/zh/doc/pipeline/steps/)
* [Job DSL](https://plugins.jenkins.io/job-dsl/)
* [Pipeline: Multibranch](https://www.jenkins.io/doc/pipeline/steps/workflow-multibranch/)
* [Pipeline: Basic Steps](https://www.jenkins.io/doc/pipeline/steps/workflow-basic-steps/#withenv-set-environment-variables)
* []()
* []()
* []()
