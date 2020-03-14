#简单说明
cloud-api-commons整合项目公共使用的代码和工具类；除了eureka只需引用依赖，zookeeper和consul都需要下载客户端在pc，配置好再更改yml里面的url配置
#
cloud-consumer-order80, server7001, server7002, payment8001, payment8002整合eureka的简单的集群的搭建
#
cloud-consumerzk-order80, payment8004 整合zookeeper的微服务搭建，集群参照eureka的yml进行多服务连接配置
#
cloud-consumerconsul-order80, cloud-providerconsul-payment8006简单整合了consul注册中心的注册流程，同样集群参照eureka的方式
