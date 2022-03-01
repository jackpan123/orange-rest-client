# orange-rest-client REST客户端

还在持续编码中...

## 快速入门

初始化客户端
```java
OrangeRestClientConfig config = new OrangeRestClientConfig();
config.setServerHost("http://192.168.102.33:7777");
OrangeRestClient orangeRestClient = new OrangeRestClient(config);
```
Jwt客户端插件操作

```java
// 停止Jwt插件
AcknowledgedResponse stop = orangeRestClient.jwtAuth().plugin().stop();
if (stop.isAcknowledged()) {
  System.out.println(stop.getMsg());
}

// 启动Jwt插件
AcknowledgedResponse start = orangeRestClient.jwtAuth().plugin().start();
if (stop.isAcknowledged()) {
  System.out.println(stop.getMsg());
}
```

创建Jwt选择器

```java
// 创建自定义流量的条件
RuleCondition.RuleConditionBuilder builder = RuleCondition.RuleConditionBuilder.builder();
List<RuleCondition> ruleConditions = new ArrayList<>();
RuleCondition build = builder.conditionType(ConditionType.URI).matchType(MatchType.MATCH).paramValue("/some/api").build();
ruleConditions.add(build);

// 创建规则
SelectorRule selectorRule = RuleFactory.selectorRule()
.ruleType(RuleType.SINGLE_CONDITION_MATCH)
.conditions(ruleConditions).build();

// 创建后续处理对象
SelectorHandle handle = SelectorHandle.SelectorHandleBuilder.builder()
.continueOperation(SelectorHandleType.OMIT_SUBSEQUENT_SELECTORS).log(LogType.LOG).build();

// 创建选择器
Selector test3 = Selector.SelectorBuilder.builder().name("test4")
.type(SelectorType.CUSTOM_TRAFFIC).selectorRule(selectorRule).handle(handle).build();

// 获取响应值
AcknowledgedResponse response = orangeRestClient.jwtAuth().selectors().create(test3);
System.out.println(response.getMsg());
```

