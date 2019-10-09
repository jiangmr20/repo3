```java
private static Gson gson = new Gson();



    public static List<Integer> fromJsonToListInteger(String tmp)throws Exception{
        if (tmp == null) throw new NullPointerException("parameter is not null!");
        Type IntegerListType = new TypeToken<List<Integer>>(){}.getType();
        return gson.fromJson(tmp, IntegerListType);

    }
    public static List<String> fromJsonToListString(String tmp)throws Exception{
        if (tmp == null) throw new NullPointerException("parameter is not null!");
        Type StringListType = new TypeToken<List<String>>(){}.getType();
        return gson.fromJson(tmp, StringListType);

    }

    public static List<Map<String, Object>> fromJsonToListMap(String tmp) throws Exception{
        if(tmp == null ) throw new NullPointerException("parameter is not null");
        Type MapListType = new TypeToken<List<Map<String, Object>>>(){}.getType();
        return listMapGson.fromJson(tmp, MapListType);
    }

    public static Map<String, Object> fromJsonToMap(String tmp) throws Exception{
        if(tmp == null ) throw new NullPointerException("parameter is not null");
        Type MapType = new TypeToken<Map<String, Object>>(){}.getType();
        return mapGson.fromJson(tmp, MapType);
    }
    //该部分处理  Object整型变成double型 情况----适用于（Map<String, Object>）
    private static Gson mapGson = new GsonBuilder().registerTypeAdapter(
            new TypeToken<Map<String, Object>>(){}.getType(),
            new ListTypeAdapter()
    ).create();

    private static Gson listMapGson = new GsonBuilder().registerTypeAdapter(
            new TypeToken<List<Map<String, Object>>>(){}.getType(),
            new ListTypeAdapter()
    ).create();
```

