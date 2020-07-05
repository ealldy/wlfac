# 机理模型微服务说明文档

## 一．背景 Background

​	通过微服务接口，完成对机理模型公式的计算，或是模型的展示



## 二、主要依赖 Dependencies

```java
// 	用于搭建web框架，集成了多个spring组件，spring组件版本为“4.3.9”，如tomcat。
compile group: 'org.springframework.boot', name: 'spring-boot-starter-web', version: '1.5.4.RELEASE'
```



## 三、规范 Norm 

1、接口的请求方式为GET请求；

2、若传入参数为特殊符号，应在取值时转为合乎编程规范的字符串，例如：

`@RequestParam(value = "α")  Object alpha`

3、返回格式为resultful风格，采用 util 包中的 ApiResult 类，将接口数据封装后返回；定义成功为“0”，失败为“1”；

4、若有参数不正确等异常情况，应将相应的提示封装到  ApiResult 的 msg 中，用于在页面中给予用户提示；

5、要处理所有可能的异常，并返回恰当的异常消息；不能将系统产生的异常信息直接传给页面，要对用户隐藏这些系统信息。