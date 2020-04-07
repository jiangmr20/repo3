```java
List<HistoricActivityInstance> historicActivityInstances=historyService.createHistoricActivityInstanceQuery().processInstanceId(processId).orderByHistoricActivityInstanceEndTime().finished().desc().list();
        if(historicActivityInstances==null || historicActivityInstances.size()==0){
            throw  new ProcessException("不存在该流程");
        }
        List<HistoricActivityInstance> historicActivityInstances1=historicActivityInstances.stream().filter(instance->!instance.getActivityId().contains("CounterSign"))
                .filter(instance->Process.ActivitiType.startEvent.equals(instance.getActivityType())||Process.ActivitiType.userTask.equals(instance.getActivityType())).collect(Collectors.toList());

```

https://blog.csdn.net/qq_33829547/article/details/80279488