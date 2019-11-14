activiti:assignee="${owner}" 

activiti:candidateUsers="${owner}"

activiti:candidateGroups="applyer"

这三个属性,activiti:assignee="${owner}"与 activiti:candidateUsers="${owner}"不能同时使用；

activiti:candidateUsers="${owner}"与activiti:candidateGroups="applyer"可以同时使用;

activiti:assignee="${owner}" 属性是直接把任务分配给某一用户，用户无需签收

activiti:candidateUsers="user1,user2"属性是把任务分配给若干用户（任务的候选者），一旦某一用户签收这个任务，其他人将不能看到此任务

activiti:candidateGroups="group1,group2"属性是把任务分配给若干组用户（任务的候选者），一旦某一组的某个用户签收这个任务，其他人将不能看到此任务。


例：

```xml
<userTask activiti:assignee="${officeDept}" activiti:exclusive="true" id="officeDeptApproval" name="a单位审批">
      <extensionElements>
        <activiti:formProperty id="officeDeptAdvice" name="a单位意见" type="string"/>
        <activiti:formProperty id="officeDeptApprove" name="a单位审批" type="long"/>
      </extensionElements>
    </userTask>
```

