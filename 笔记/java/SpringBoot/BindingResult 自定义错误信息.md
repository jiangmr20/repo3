https://blog.csdn.net/zhengun/article/details/84918567

可以在controller方法用于对前端传入参数的校验，如：

```java
 @RequestMapping("/updateItem")
    public Object updateItem( HttpServletRequest request, @ModelAttribute @Valid CoopBusinessRecordVo recordVo, BindingResult bindingResult) {
        //hasErrors用于校验类型是否有错
        if (bindingResult.hasErrors()) {
                return CommonResultUtil.getErrorResult("parameters check fail");
            }
    	...
    }
```

```java
public class CoopBusinessRecordVo {

    @NotBlank
    private String productName;

    @NotBlank
    private String productSortId;

    @Valid
    @NotNull
    private CoopInfoVo coopInfo;

    @NotBlank
    private String startDate;

    @NotBlank
    private String endDate;

    @NotBlank
    private String extend;

    @NotNull
    @Max(2)
    @Min(1)
    private Integer accountTypeId;
```

