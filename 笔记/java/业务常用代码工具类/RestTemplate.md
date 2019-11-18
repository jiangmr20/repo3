https://www.cnblogs.com/javazhiyin/p/9851775.html

```java
@Test
public void rtPostObject(){
    RestTemplate restTemplate = new RestTemplate();
    String url = "http://47.xxx.xxx.96/register/checkEmail";
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
    MultiValueMap<String, String> map= new LinkedMultiValueMap<>();
    map.add("email", "844072586@qq.com");
 
    HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);
    ResponseEntity<String> response = restTemplate.postForEntity( url, request , String.class );
    System.out.println(response.getBody());
}
```

使用介绍：

https://www.jianshu.com/p/90ec27b3b518

https://www.jianshu.com/p/0fd5f3f64137

https://blog.csdn.net/ONROAD0612/article/details/82258193



（官网）RestTemplate在spring中的完整api：https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/http/ResponseEntity.html

api详解：https://www.cnblogs.com/wangbin2188/p/9204022.html

