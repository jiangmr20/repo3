例如在T001中

```xml

<multiInstanceLoopCharacteristics activiti:elementVariable="approver" isSequential="false" activiti:collection="${approverList_2}">
              <completionCondition>${withSignComplete.isComplete(execution) }</completionCondition>
          </multiInstanceLoopCharacteristics>
          
          。。。
<extensionElements>
      <activiti:executionListener event="end" delegateExpression="${processEndExecutionListener}" />
    </extensionElements>
    <startEvent activiti:initiator="user_1" id="start" name="集团产品主管部门项目经理"/>
    <userTask activiti:assignee="${user_1}" activiti:exclusive="true" id="userTask_1" name="集团产品主管部门项目经理"/>
```

${xxx}，里面是spring注入的管理bean，通常使用@component