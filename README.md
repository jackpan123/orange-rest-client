# orange-rest-client REST客户端

还在持续编码中...

## 快速入门

### 初始化客户端

```java
OrangeRestClientConfig config = new OrangeRestClientConfig();
config.setServerHost("http://192.168.102.33:7777");
OrangeRestClient orangeRestClient = new OrangeRestClient(config);
```
### 客户端插件操作（Jwt插件为例）

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

### 选择器操作说明（Jwt插件为例）

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

// 更新选择器
List<Selector> list = orangeRestClient.jwtAuth().selectors().list();
if (list.size() > 0) {
    Selector selector = list.get(0);
    selector.setName("customUpdate");
    selector.setType(SelectorType.CUSTOM_TRAFFIC.getType());

    // create condition
    RuleCondition.RuleConditionBuilder builder = RuleCondition.RuleConditionBuilder.builder();
    List<RuleCondition> ruleConditions = new ArrayList<>();
    RuleCondition condition1 = builder.conditionType(ConditionType.URI).matchType(MatchType.MATCH).paramValue("/custom/api").build();
    RuleCondition condition2 = builder.conditionType(ConditionType.HEADER).paramName("customParam").matchType(MatchType.MATCH).paramValue("/custom/api").build();
    ruleConditions.add(condition1);
    ruleConditions.add(condition2);

    // create rule
    SelectorRule selectorRule = RuleFactory.selectorRule()
      .ruleType(RuleType.AND_MATCH)
      .conditions(ruleConditions).build();

    selector.setJudge(selectorRule);

    AcknowledgedResponse update = orangeRestClient.jwtAuth().selectors().update(selector);
    System.out.println();
}

// 删除选择器
List<Selector> list = orangeRestClient.jwtAuth().selectors().list();
if (list.size() > 0) {
    AcknowledgedResponse delete = orangeRestClient.jwtAuth().selectors().delete(list.get(0).getId());
    System.out.println(delete.getMsg());
}

// 获取选择器列表
List<Selector> list = orangeRestClient.jwtAuth().selectors().list();
```

### 规则操作说明

```java
// 创建选择器下的规则
RuleCondition.RuleConditionBuilder builder = RuleCondition.RuleConditionBuilder.builder();
List<RuleCondition> ruleConditions = new ArrayList<>();
RuleCondition condition1 = builder.conditionType(ConditionType.URI).matchType(MatchType.MATCH).paramValue("/custom/api").build();
RuleCondition condition2 = builder.conditionType(ConditionType.HEADER).paramName("customParam").matchType(MatchType.MATCH).paramValue("/custom/api").build();
ruleConditions.add(condition1);
ruleConditions.add(condition2);

// create rule
SelectorRule selectorRule = RuleFactory.selectorRule()
  .ruleType(RuleType.AND_MATCH)
  .conditions(ruleConditions).build();


Payload build = Payload.builder().key("aaa").target_key("bb").build();
List<Payload> payloads = new ArrayList<>();
payloads.add(build);

JwtCredentials jwtCredentials = JwtCredentials.builder().payload(payloads).secret("ccc").build();

JwtRuleHandle handle = JwtRuleHandle.builder().credentials(jwtCredentials).build();
JwtRule testRule = JwtRule.builder().name("testRule").judge(selectorRule).handle(handle).build();
AcknowledgedResponse response = orangeRestClient.jwtAuth().rules("e2643937-f9be-4ee9-bda3-a931903a252b").create(testRule);
System.out.println();

// 更新选择器下的规则
List<JwtRule> list = orangeRestClient.jwtAuth().rules("e2643937-f9be-4ee9-bda3-a931903a252b").list();
if (list.size() > 0) {
    JwtRule rule = list.get(0);
    rule.setName("updateTest");
    AcknowledgedResponse update = orangeRestClient.jwtAuth().rules("e2643937-f9be-4ee9-bda3-a931903a252b").update(rule);
    System.out.println();

}

// 删除选择器下的规则
List<JwtRule> list = orangeRestClient.jwtAuth().rules("e2643937-f9be-4ee9-bda3-a931903a252b").list();
if (list.size() > 0) {
    AcknowledgedResponse delete = orangeRestClient.jwtAuth()
      .rules("e2643937-f9be-4ee9-bda3-a931903a252b").delete(list.get(0).getId());
    System.out.println(delete.getMsg());
}

// 获取选择器下的列表
List<JwtRule> list = orangeRestClient.jwtAuth().rules("e2643937-f9be-4ee9-bda3-a931903a252b").list();
System.out.println();
```

