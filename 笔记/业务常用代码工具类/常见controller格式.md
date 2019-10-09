```java

@RestController
@RequestMapping("/k")
public class KController {
    
    @Autowired
    private KService service;
    
    private static final Logger logger = LoggerFactory.getLogger(KController.class);
    
	@RequestMapping("/getList")
    public Object getList(
        @RequestParam(value = "sortType", required = true) String sortType,
        @RequestParam(value = "keyword", required = false) String keyword,
        @RequestParam(value = "page", required = true) Integer page,
        @RequestParam(value = "pageSize", required = true) Integer pageSize)
    {
        try{
            return service.getList(sortType, keyword, page, pageSize);
        }catch (Exception e){
            e.printStackTrace();
            logger.error("", e);
            return CommonResultUtil.getErrorResult();
        }
    }
}
```

