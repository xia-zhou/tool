# 常用模版代码以及DEMO
## 短链接服务
### 简介
短链服务提供长链接转换为短链接的能力，缩短长链接的长度，主要用于对字数有要求的场景，比如发送短信，一般超过70个字就会拆分为两条短信，使用长链接就会占用较多的字数，带来短信发送成本的提高，再比如微博，有限制微博的长度，使用短链就可以防止占用更多的内容。
### 原理
短链服务的原理是用户通过提供的短链接访问对应的域名，服务端收到对应的请求之后，获取到端链接对应的长链接，然后通过设置HTTP响应状态码为302，并且把长链接放置到HTTP响应头location中，浏览器收到该HTTP请求响应时，自动跳转到长链接，打开长链接的页面。所以短链的工作原理可以简单理解为302跳转。
![image.png](https://cdn.nlark.com/yuque/0/2021/png/253750/1640400298469-f413e46e-0f4d-439c-a87a-2158c189385c.png#clientId=u77f02687-ed17-4&crop=0&crop=0&crop=1&crop=1&from=paste&id=uef284e6b&margin=%5Bobject%20Object%5D&name=image.png&originHeight=602&originWidth=1332&originalType=binary&ratio=1&rotation=0&showTitle=false&size=98456&status=done&style=none&taskId=u2eb20ff3-fb2f-4af7-92dc-b79c50e46be&title=)
### 需求
#### 功能性需求

1. 对给定的长链接，短链服务要生成一个唯一的短链URL。
1. 访问短链URL能够跳转到原始的长URL。
1. 短链接有一定的有效期，过期之后不可访问。提示链接已失效。
1. 对于短链访问次数和访问人数（根据IP）的统计。
#### 非功能性需求
1. 高可用。
   1. 是否需要采用多机部署架构，以及访问量预估，来做容量预测。
2. 高性能。
   1. 对未来两年内短链的数量等做预测，涉及到是否需要考虑分库分表等。
3. 安全
   1. 短链不能被预测。
      1. 我个人认为这个无关紧要，因为只要知道最后的短链是6位62进制的标识，那么遍历即可，都会根据短链判断是否存在，系统资源都是要消耗的。
   2. 防止生成短链被刷
      1. 可以限定ip等方式，或者是调用有鉴权，单个用户有限流等。
###  功能设计
使用Spring Boot+MySQL+Redis实现。
#### 短链生成
##### 短链生成算法
![Untitled Diagram.png](https://cdn.nlark.com/yuque/0/2021/png/253750/1640407960770-d9bec544-ecb8-4d43-90d6-c18c8597fd64.png#clientId=u77f02687-ed17-4&crop=0&crop=0&crop=1&crop=1&from=paste&id=u01115160&margin=%5Bobject%20Object%5D&name=Untitled%20Diagram.png&originHeight=316&originWidth=657&originalType=binary&ratio=1&rotation=0&showTitle=false&size=13656&status=done&style=none&taskId=u76929d04-2b0d-4c6b-8f48-2a5d1ec18d2&title=)
提供三种默认的算法，用户也可以自定义实现算法。
###### 自增ID算法
具体使用什么方式看自己需要，数据库自增等都可以。能够生成分布式ID的算法都可以。
###### 摘要(hash)算法


###### 普通随机算法
###### 自定义算法
#### 让短链更短
短链ID算法生成的ID一般都会比较长，因此需要把这个ID缩短，比较直观的思路就是把10进制转化成更高的进制，比如有A～Z、a～z、0-9组成的62进制，这样只需要6位的62进制就可以表示568亿种组合，已经可以满足大多数的使用场景，现在市面上见到的短码一般都是6位的。
### 短链访问   
访问流程图如下，使用Redis做缓存，然后MySQL做持久化的方式，外加对访问次数、人数的统计。这里注意返回可以使用302或者301的方式，302的状态码方便统计访问次数、人数。
![短链访问流程图-2.png](https://cdn.nlark.com/yuque/0/2021/png/253750/1640421198580-053d637a-f9ae-48b8-8e0d-f4a05ca25996.png#clientId=uaa033922-4e2f-4&crop=0&crop=0&crop=1&crop=1&from=paste&id=u16e62865&margin=%5Bobject%20Object%5D&name=%E7%9F%AD%E9%93%BE%E8%AE%BF%E9%97%AE%E6%B5%81%E7%A8%8B%E5%9B%BE-2.png&originHeight=516&originWidth=1321&originalType=binary&ratio=1&rotation=0&showTitle=false&size=68640&status=done&style=none&taskId=u119326f4-477b-4ed1-aaa1-23006d48dfc&title=)
### 存储方案
使用MySQL存储原始数据，Redis提供缓存，Redis做全量缓存，或者做热缓存，缓存没有则读取数据库的方式。Redis直接使用key-value方式存储，数据库需要创建数据原始表和数据统计表，对于鉴权限流等配置可以单独存储，数据原始表注意针对长链接做hash值之后创建索引，减少索引占用空间。
####  数据库设计
### 使用指南
默认使用302作为响应状态码，可以通过配置的方式设置301作为响应状态码。
#### 相关配置
本地启动项目，默认使用本地缓存替代Redis，使用内存数据库h2替代MySQL，用于本地快速体验，另外本地验证短链的域名可以通过绑定Host的方式来实现，可以通过配置Redis或者MySQL地址的方式正式使用。
#### 接口文档
##### 创建短链接


### 相关依赖
## RPC学习DEMO
## MQ学习DEMO
## 多线程学习DEMO
## 数据库连接池DEMO
## Jedis连接池学习DEMO
## EventBus学习DEMO
## MyBaties学习DEMO
## Faas学习DEMO
## 响应式学习DEMO
